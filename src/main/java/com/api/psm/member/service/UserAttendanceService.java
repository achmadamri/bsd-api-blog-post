package com.api.psm.member.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.api.psm.member.model.userattendance.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.api.psm.member.db.entity.TbProject;
import com.api.psm.member.db.entity.TbUser;
import com.api.psm.member.db.entity.TbUserAttendance;
import com.api.psm.member.db.entity.TbUserOvertime;
import com.api.psm.member.db.entity.TbUserProject;
import com.api.psm.member.db.entity.ViewHierarchyUser;
import com.api.psm.member.db.entity.ViewUserAttendance;
import com.api.psm.member.db.entity.ViewUserOvertime;
import com.api.psm.member.db.repository.TbProjectRepository;
import com.api.psm.member.db.repository.TbUserAttendanceRepository;
import com.api.psm.member.db.repository.TbUserOvertimeRepository;
import com.api.psm.member.db.repository.TbUserProjectRepository;
import com.api.psm.member.db.repository.TbUserRepository;
import com.api.psm.member.db.repository.ViewHierarchyUserRepository;
import com.api.psm.member.db.repository.ViewUserAttendanceRepository;
import com.api.psm.member.db.repository.ViewUserOvertimeRepository;
import com.api.psm.member.util.SimpleMapper;
import com.api.psm.member.util.StringUtil;
import com.api.psm.member.util.TokenUtil;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;

@Service
public class UserAttendanceService {
	
	private TokenUtil tokenUtil = new TokenUtil();
	
	@Autowired
	private Environment env;

	@Autowired
	private TbUserRepository tbUserRepository;

	@Autowired
	private ViewUserAttendanceRepository viewUserAttendanceRepository;
	
	@Autowired
	private TbUserAttendanceRepository tbUserAttendanceRepository;
	
	@Autowired
	private ViewHierarchyUserRepository viewHierarchyUserRepository;
	
	@Autowired
	private TbUserOvertimeRepository tbUserOvertimeRepository;
	
	@Autowired
	private ViewUserOvertimeRepository viewUserOvertimeRepository;
	
	@Autowired
	private TbUserProjectRepository tbUserProjectRepository;
	
	@Autowired
	private TbProjectRepository tbProjectRepository;
	
	public GetUserOvertimeResponseModel getUserOvertime(GetUserOvertimeRequestModel requestModel, String tbbId, String tbpId, String period) throws Exception {
		GetUserOvertimeResponseModel responseModel = new GetUserOvertimeResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		StringUtil stringUtil = new StringUtil();
		Calendar cal = Calendar.getInstance();
		
		ViewUserOvertime exampleViewUserOvertime = new ViewUserOvertime();
		exampleViewUserOvertime.setTbuoStatus(ViewUserOvertime.StatusApproved);
		
		if (Integer.valueOf(stringUtil.stringToInteger(tbbId)) != 0 || Integer.valueOf(stringUtil.stringToInteger(tbpId)) != 0 || Integer.valueOf(stringUtil.stringToInteger(period)) != 0) {
			if (Integer.valueOf(stringUtil.stringToInteger(tbbId)) != 0) {
				exampleViewUserOvertime.setTbbId(Integer.valueOf(stringUtil.stringToInteger(tbbId)));
			}
			if (Integer.valueOf(stringUtil.stringToInteger(tbpId)) != 0) {
				exampleViewUserOvertime.setTbpId(Integer.valueOf(stringUtil.stringToInteger(tbpId)));
			}
			if (Integer.valueOf(stringUtil.stringToInteger(period)) != 0) {
				exampleViewUserOvertime.setTbuoOutDate(cal.get(Calendar.YEAR) + "-" + period);
			}
		}
		
		ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher.matching()
			    .withMatcher("tbuoOutDate", ExampleMatcher.GenericPropertyMatchers.contains().contains());
		
		List<ViewUserOvertime> lstViewUserOvertime = viewUserOvertimeRepository.findAll(Example.of(exampleViewUserOvertime, caseInsensitiveExampleMatcher), Sort.by("tbuId", "tbuoId").ascending());
		
		if (lstViewUserOvertime.size() > 0) {
			responseModel.setLstViewUserOvertime(lstViewUserOvertime);
			
			responseModel.setStatus("200");
			responseModel.setMessage("Get User Overtime ok");	
		} else {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		}
		
		return responseModel;
	}
	
	public GetAttendanceDetailResponseModel getAttendanceDetail(GetAttendanceDetailRequestModel requestModel, String tbuaId) throws Exception {
		GetAttendanceDetailResponseModel responseModel = new GetAttendanceDetailResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUser.StatusActive);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		optTbUser.ifPresentOrElse(tbUser -> {
			responseModel.setTbUser(tbUser);
			
			ViewUserAttendance exampleViewUserAttendance = new ViewUserAttendance();
			exampleViewUserAttendance.setTbuaId(Integer.valueOf(tbuaId));
			
			Optional<ViewUserAttendance> optViewUserAttendance = viewUserAttendanceRepository.findOne(Example.of(exampleViewUserAttendance));
			
			optViewUserAttendance.ifPresentOrElse(viewUserAttendance -> {
				if (viewUserAttendance.getTbuId().equals(tbUser.getTbuId())) {
					responseModel.setViewUserAttendance(viewUserAttendance);
					
					responseModel.setStatus("200");
					responseModel.setMessage("Get attendance ok");
				} else {
					ViewHierarchyUser exampleViewHierarchyUserSub = new ViewHierarchyUser();
					exampleViewHierarchyUserSub.setTbuIdSupervisor(tbUser.getTbuId());
					exampleViewHierarchyUserSub.setTbuIdSubordinate(viewUserAttendance.getTbuId());
					
					if (viewHierarchyUserRepository.count(Example.of(exampleViewHierarchyUserSub)) > 0) {
						responseModel.setViewUserAttendance(viewUserAttendance);
						
						responseModel.setStatus("200");
						responseModel.setMessage("Get attendance ok");					
					} else {
						responseModel.setStatus("404");
						responseModel.setMessage("Not found");
					}					
				}
			}, () -> {
				responseModel.setStatus("404");
				responseModel.setMessage("Not found");
			});
		}, () -> {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		});
		
		return responseModel;
	}
	
	public ByteArrayInputStream getAttendanceReportExcel(GetAttendanceReportRequestModel requestModel, String tbuId, String tbpId, String tbbId, String tbdId, String tbuaDate) throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		Workbook workbook = new XSSFWorkbook();
		
		Sheet sheet = workbook.createSheet("Raw");
		int intRow = 0;
		Row row = sheet.createRow(intRow);
		
		Cell cell = null;
		
		int intCell = 0;
		
		cell = row.createCell(intCell++);
		cell.setCellValue("Nama");
		
		cell = row.createCell(intCell++);
		cell.setCellValue("Email");
		
		cell = row.createCell(intCell++);
		cell.setCellValue("Tanggal");

		cell = row.createCell(intCell++);
		cell.setCellValue("Punch In");
		
		cell = row.createCell(intCell++);
		cell.setCellValue("Punch Out");

		cell = row.createCell(intCell++);
		cell.setCellValue("Remark In");
		
		cell = row.createCell(intCell++);
		cell.setCellValue("Remark Out");
		
		cell = row.createCell(intCell++);
		cell.setCellValue("Long Lat In");
		
		cell = row.createCell(intCell++);
		cell.setCellValue("Long Lat In");
		
		cell = row.createCell(intCell++);
		cell.setCellValue("Attach In");
		
		cell = row.createCell(intCell++);
		cell.setCellValue("Attach Out");
		
		intRow++;
        
		List<TbUserAttendanceModel> lstTbUserAttendanceModelRaw = getAttendanceReport(requestModel, tbuId, tbpId, tbbId, tbdId, tbuaDate).getLstTbUserAttendanceModel();
		for (TbUserAttendanceModel tbUserAttendanceModel : lstTbUserAttendanceModelRaw) {
			
			List<ViewUserAttendance> lstViewUserAttendance = tbUserAttendanceModel.getLstViewUserAttendance();
			for (ViewUserAttendance viewUserAttendance : lstViewUserAttendance) {
				
				row = sheet.createRow(intRow);
				
				intCell = 0;
				
				cell = row.createCell(intCell++);
				cell.setCellValue(tbUserAttendanceModel.getTbUser().getTbuFirstname());
				
				cell = row.createCell(intCell++);
				cell.setCellValue(tbUserAttendanceModel.getTbUser().getTbuEmail());
				
				cell = row.createCell(intCell++);
				cell.setCellValue(viewUserAttendance.getTbuaDate());
				
				cell = row.createCell(intCell++);
				cell.setCellValue(viewUserAttendance.getTbuaInTime());
				
				cell = row.createCell(intCell++);
				cell.setCellValue(viewUserAttendance.getTbuaOutTime());
				
				cell = row.createCell(intCell++);
				cell.setCellValue(viewUserAttendance.getTbuaInNote());
				
				cell = row.createCell(intCell++);
				cell.setCellValue(viewUserAttendance.getTbuaOutNote());
				
				cell = row.createCell(intCell++);
				cell.setCellValue(viewUserAttendance.getTbuaInLatitude() + "," + viewUserAttendance.getTbuaInLongitude());
				
				cell = row.createCell(intCell++);
				cell.setCellValue(viewUserAttendance.getTbuaOutLatitude() + "," + viewUserAttendance.getTbuaOutLongitude());
				
				cell = row.createCell(intCell++);
				cell.setCellValue("http://37.44.244.174:8080/upload/" + viewUserAttendance.getTbuaInPhoto());
				
				cell = row.createCell(intCell++);
				cell.setCellValue("http://37.44.244.174:8080/upload/" + viewUserAttendance.getTbuaOutPhoto());
				
				intRow++;
			}
		}
		
		intRow = 0;
		
		sheet = workbook.createSheet("Report");
		Row row1 = null;
		Row row2 = null;
		
		List<TbUserAttendanceModel> lstTbUserAttendanceModelReport = getAttendanceReport(requestModel, tbuId, tbpId, tbbId, tbdId, tbuaDate).getLstTbUserAttendanceModel();
		for (TbUserAttendanceModel tbUserAttendanceModel : lstTbUserAttendanceModelReport) {
			//-----------------------------NAMA
			row1 = sheet.createRow(intRow);
			intRow++;
			row2 = sheet.createRow(intRow);
			
			intCell = 0;
			
			cell = row1.createCell(intCell++);
			cell.setCellValue(tbUserAttendanceModel.getTbUser().getTbuFirstname());
			
			sheet.addMergedRegion(new CellRangeAddress(intRow - 1, intRow, intCell - 1, intCell - 1));
			//-----------------------------NAMA
			
			List<ViewUserAttendance> lstViewUserAttendance = tbUserAttendanceModel.getLstViewUserAttendance();
			for (ViewUserAttendance viewUserAttendance : lstViewUserAttendance) {
				//-----------------------------ABSEN
				cell = row1.createCell(intCell++);
				cell.setCellValue(viewUserAttendance.getTbuaDate());
				
				sheet.addMergedRegion(new CellRangeAddress(intRow - 1, intRow - 1, intCell - 1, intCell));
				
				intCell--;
				
				cell = row2.createCell(intCell++);
				cell.setCellValue(viewUserAttendance.getTbuaInTime());
				
				cell = row2.createCell(intCell++);
				cell.setCellValue(viewUserAttendance.getTbuaOutTime());
				//-----------------------------ABSEN
			}
			
			intRow++;
		}
		
		workbook.write(out);
		workbook.close();
		
		return new ByteArrayInputStream(out.toByteArray());
	}
	
	public GetAttendanceReportResponseModel getAttendanceReport(GetAttendanceReportRequestModel requestModel, String tbuId, String tbpId, String tbbId, String tbdId, String tbuaDate) throws Exception {
		GetAttendanceReportResponseModel responseModel = new GetAttendanceReportResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		
		if (tbuId.equals("") || tbuId.equals("0")) {
			exampleTbUser.setTbuEmail(requestModel.getEmail());
		} else {
			exampleTbUser.setTbuId(Integer.valueOf(tbuId));
		}
		
		exampleTbUser.setTbuStatus(TbUser.StatusActive);
		
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		optTbUser.ifPresentOrElse(tbUser -> {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
			
			responseModel.setTbUser(tbUser);
			
			List<TbUserAttendanceModel> lstTbUserAttendanceModel = new ArrayList<TbUserAttendanceModel>();
			responseModel.setLstTbUserAttendanceModel(lstTbUserAttendanceModel);
			
			ViewUserAttendance exampleViewUserAttendanceParent = new ViewUserAttendance();
			exampleViewUserAttendanceParent.setTbuId(tbUser.getTbuId());
			if (!"".equals(tbpId)) {
				if (!"0".equals(tbpId)) {
					exampleViewUserAttendanceParent.setTbpId(Integer.valueOf(tbpId));
				}
			}
			if (!"".equals(tbbId)) {
				if (!"0".equals(tbbId)) {
					exampleViewUserAttendanceParent.setTbbId(Integer.valueOf(tbbId));
				}
			}
			if (!"".equals(tbdId)) {
				if (!"0".equals(tbdId)) {
					exampleViewUserAttendanceParent.setTbdId(Integer.valueOf(tbdId));
				}
			}
			if (!"".equals(tbuaDate)) {
				if (!"0".equals(tbuaDate)) {
					exampleViewUserAttendanceParent.setTbuaDate(simpleDateFormat.format(cal.getTime()) + "-" + tbuaDate);
				}
			}
			
			ExampleMatcher caseInsensitiveExampleMatcherParent = ExampleMatcher.matching()
				    .withMatcher("tbuId", ExampleMatcher.GenericPropertyMatchers.contains().exact())
				    .withMatcher("tbpId", ExampleMatcher.GenericPropertyMatchers.contains().exact())
				    .withMatcher("tbbId", ExampleMatcher.GenericPropertyMatchers.contains().exact())
				    .withMatcher("tbdId", ExampleMatcher.GenericPropertyMatchers.contains().exact())
				    .withMatcher("tbuaDate", ExampleMatcher.GenericPropertyMatchers.contains().contains());
			
			Page<ViewUserAttendance> pgViewUserAttendanceParent = viewUserAttendanceRepository.findAll(Example.of(exampleViewUserAttendanceParent, caseInsensitiveExampleMatcherParent), PageRequest.of(0, 1000, Sort.by("tbuaId").ascending()));

			if (pgViewUserAttendanceParent.getTotalElements() > 0) {
				TbUserAttendanceModel tbUserAttendanceModelParent = new TbUserAttendanceModel();
				tbUserAttendanceModelParent.setTbUser(tbUser);
				tbUserAttendanceModelParent.setLstViewUserAttendance(pgViewUserAttendanceParent.toList());
				responseModel.getLstTbUserAttendanceModel().add(tbUserAttendanceModelParent);				
			}
			
			ViewHierarchyUser exampleViewHierarchyUserSub = new ViewHierarchyUser();
			exampleViewHierarchyUserSub.setTbuIdSupervisor(tbUser.getTbuId());
			
			List<ViewHierarchyUser> lstViewHierarchyUser = viewHierarchyUserRepository.findAll(Example.of(exampleViewHierarchyUserSub));
			
			if (lstViewHierarchyUser.size() > 0) {
				for (ViewHierarchyUser viewHierarchyUser : lstViewHierarchyUser) {
					TbUser exampleTbUserSub = new TbUser();
					exampleTbUserSub.setTbuId(viewHierarchyUser.getTbuIdSubordinate());
					Optional<TbUser> optTbUserSub = tbUserRepository.findOne(Example.of(exampleTbUserSub));
					
					optTbUserSub.ifPresentOrElse(tbUserSub -> {
						ViewUserAttendance exampleViewUserAttendance = new ViewUserAttendance();
						exampleViewUserAttendance.setTbuId(tbUserSub.getTbuId());
						if (!"".equals(tbpId)) {
							if (!"0".equals(tbpId)) {
								exampleViewUserAttendance.setTbpId(Integer.valueOf(tbpId));
							}
						}
						if (!"".equals(tbbId)) {
							if (!"0".equals(tbbId)) {
								exampleViewUserAttendance.setTbbId(Integer.valueOf(tbbId));
							}
						}
						if (!"".equals(tbdId)) {
							if (!"0".equals(tbdId)) {
								exampleViewUserAttendance.setTbdId(Integer.valueOf(tbdId));
							}
						}
						if (!"".equals(tbuaDate)) {
							if (!"0".equals(tbuaDate)) {
								exampleViewUserAttendance.setTbuaDate(simpleDateFormat.format(cal.getTime()) + "-" + tbuaDate);
							}
						}
						
						ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher.matching()
							    .withMatcher("tbuId", ExampleMatcher.GenericPropertyMatchers.contains().exact())
							    .withMatcher("tbpId", ExampleMatcher.GenericPropertyMatchers.contains().exact())
							    .withMatcher("tbbId", ExampleMatcher.GenericPropertyMatchers.contains().exact())
							    .withMatcher("tbdId", ExampleMatcher.GenericPropertyMatchers.contains().exact())
							    .withMatcher("tbuaDate", ExampleMatcher.GenericPropertyMatchers.contains().contains());
						
						Page<ViewUserAttendance> pgViewUserAttendance = viewUserAttendanceRepository.findAll(Example.of(exampleViewUserAttendance, caseInsensitiveExampleMatcher), PageRequest.of(0, 1000, Sort.by("tbuaId").ascending()));
						if (pgViewUserAttendance.getTotalElements() > 0) {
							TbUserAttendanceModel tbUserAttendanceModel = new TbUserAttendanceModel();
							tbUserAttendanceModel.setTbUser(tbUserSub);
							tbUserAttendanceModel.setLstViewUserAttendance(pgViewUserAttendance.toList());
							responseModel.getLstTbUserAttendanceModel().add(tbUserAttendanceModel);
						}
					}, () -> {});
				}
			}

			responseModel.setStatus("200");
			responseModel.setMessage("Get attendance ok");
		}, () -> {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		});
		
		return responseModel;
	}
	
	public GetAttendanceResponseModel getAttendance(GetAttendanceRequestModel requestModel, String tbuId) throws Exception {
		GetAttendanceResponseModel responseModel = new GetAttendanceResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUser.StatusActive);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		optTbUser.ifPresentOrElse(tbUser -> {
			responseModel.setTbUser(tbUser);
			
			if (tbuId.isEmpty() || tbuId.equals("null")) {
				ViewUserAttendance exampleViewUserAttendance = new ViewUserAttendance();
				exampleViewUserAttendance.setTbuId(tbUser.getTbuId());
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
				exampleViewUserAttendance.setTbuaDate(simpleDateFormat.format(cal.getTime()));
				
				Page<ViewUserAttendance> pgViewUserAttendance = viewUserAttendanceRepository.findAll(Example.of(exampleViewUserAttendance, ExampleMatcher.matchingAny()), PageRequest.of(0, 1000, Sort.by("tbuaId").descending()));

				responseModel.setLstViewUserAttendance(pgViewUserAttendance.toList());
				
				responseModel.setStatus("200");
				responseModel.setMessage("Get attendance ok");
			} else {
				ViewHierarchyUser exampleViewHierarchyUserSub = new ViewHierarchyUser();
				exampleViewHierarchyUserSub.setTbuIdSupervisor(tbUser.getTbuId());
				exampleViewHierarchyUserSub.setTbuIdSubordinate(Integer.valueOf(tbuId));
				
				if (viewHierarchyUserRepository.count(Example.of(exampleViewHierarchyUserSub)) > 0) {
					TbUser exampleTbUserSub = new TbUser();
					exampleTbUserSub.setTbuId(exampleViewHierarchyUserSub.getTbuIdSubordinate());
					Optional<TbUser> optTbUserSub = tbUserRepository.findOne(Example.of(exampleTbUserSub));
					
					optTbUserSub.ifPresentOrElse(tbUserSub -> {
						responseModel.setTbUser(tbUserSub);
						
						ViewUserAttendance exampleViewUserAttendance = new ViewUserAttendance();
						exampleViewUserAttendance.setTbuId(Integer.valueOf(tbuId));
						
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
						exampleViewUserAttendance.setTbuaDate(simpleDateFormat.format(cal.getTime()));
						
						Page<ViewUserAttendance> pgViewUserAttendance = viewUserAttendanceRepository.findAll(Example.of(exampleViewUserAttendance, ExampleMatcher.matchingAny()), PageRequest.of(0, 1000, Sort.by("tbuaId").descending()));

						responseModel.setLstViewUserAttendance(pgViewUserAttendance.toList());
						
						responseModel.setStatus("200");
						responseModel.setMessage("Get attendance ok");
					}, () -> {
						responseModel.setStatus("404");
						responseModel.setMessage("Not found");
					});
				} else {
					responseModel.setStatus("404");
					responseModel.setMessage("Not found");
				}
			}
		}, () -> {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		});
		
		return responseModel;
	}
	
	public GetPunchStatusResponseModel getPunchStatus(GetPunchStatusRequestModel requestModel) throws Exception {
		GetPunchStatusResponseModel responseModel = new GetPunchStatusResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUser.StatusActive);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		optTbUser.ifPresentOrElse(tbUser -> {
			responseModel.setTbUser(tbUser);
			
			TbUserAttendance exampleTbUserAttendance = new TbUserAttendance();
			exampleTbUserAttendance.setTbuId(tbUser.getTbuId());
			
			Page<TbUserAttendance> pgTbUserAttendance = tbUserAttendanceRepository.findAll(Example.of(exampleTbUserAttendance), PageRequest.of(0, 10, Sort.by("tbuaId").descending()));
			
			if (pgTbUserAttendance.toList().size() == 0) {
				responseModel.setPunchStatus("Punch In");
				
				responseModel.setStatus("200");
				responseModel.setMessage("Punch status ok");
			} else {
				List<TbUserAttendance> lstTbUserAttendance = pgTbUserAttendance.toList();
				TbUserAttendance tbUserAttendance = lstTbUserAttendance.get(0);
				
				if (tbUserAttendance.getTbuaInTime() != null && tbUserAttendance.getTbuaOutTime() != null) {
					// in ada, out ada. punch in
					responseModel.setPunchStatus("Punch In");
					responseModel.setLstTbUserAttendance(lstTbUserAttendance);
					
					responseModel.setStatus("200");
					responseModel.setMessage("Punch status ok");
				} else if (tbUserAttendance.getTbuaInTime() != null && tbUserAttendance.getTbuaOutTime() == null) {
					// in ada, out gak ada. punch out
					responseModel.setPunchStatus("Punch Out");
					responseModel.setLstTbUserAttendance(lstTbUserAttendance);
					
					responseModel.setStatus("200");
					responseModel.setMessage("Punch status ok");
				} else if (tbUserAttendance.getTbuaInTime() == null && tbUserAttendance.getTbuaOutTime() != null) {
					// in gak ada, out ada. punch in setelah punch out beda hari
					responseModel.setPunchStatus("Punch In");
					responseModel.setLstTbUserAttendance(lstTbUserAttendance);
					
					responseModel.setStatus("200");
					responseModel.setMessage("Punch status ok");
				} else {
					// error
					responseModel.setPunchStatus("Error");
					responseModel.setLstTbUserAttendance(lstTbUserAttendance);
					
					responseModel.setStatus("404");
					responseModel.setMessage("Data error");
				}
			}
		}, () -> {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		});
		
		return responseModel;
	}
	
	private TbUserAttendance punchIn(PostPunchInRequestModel requestModel, TbUser tbUser) {
		TbUserAttendance tbUserAttendanceIn = new TbUserAttendance();
		SimpleMapper simpleMapper = new SimpleMapper();
		tbUserAttendanceIn = (TbUserAttendance) simpleMapper.assign(requestModel, tbUserAttendanceIn);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		tbUserAttendanceIn.setTbuaDate(simpleDateFormat.format(cal.getTime()));
		
		simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
		tbUserAttendanceIn.setTbuaInTime(simpleDateFormat.format(cal.getTime()));
		
		tbUserAttendanceIn.setTbuId(tbUser.getTbuId());
		tbUserAttendanceIn.setTbuaCreateDate(new Date());
		tbUserAttendanceIn.setTbuaCreateId(0);
		
		tbUserAttendanceRepository.save(tbUserAttendanceIn);
		
		return tbUserAttendanceIn;
	}
	
	public PostPunchInResponseModel postPunchIn(PostPunchInRequestModel requestModel) throws Exception {
		PostPunchInResponseModel responseModel = new PostPunchInResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUser.StatusActive);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));

		optTbUser.ifPresentOrElse(tbUser -> {
			TbUserAttendance exampleTbUserAttendance = new TbUserAttendance();
			exampleTbUserAttendance.setTbuId(tbUser.getTbuId());
			
			Page<TbUserAttendance> pgTbUserAttendance = tbUserAttendanceRepository.findAll(Example.of(exampleTbUserAttendance), PageRequest.of(0, 10, Sort.by("tbuaId").descending()));
			
			if (pgTbUserAttendance.toList().size() == 0) {
				TbUserAttendance tbUserAttendanceIn = punchIn(requestModel, tbUser);
				responseModel.setTbUserAttendance(tbUserAttendanceIn);
				
				responseModel.setStatus("200");
				responseModel.setMessage("Punch in ok");
			} else {
				List<TbUserAttendance> lstTbUserAttendance = pgTbUserAttendance.toList();
				TbUserAttendance tbUserAttendance = lstTbUserAttendance.get(0);
				
				if (tbUserAttendance.getTbuaInTime() != null && tbUserAttendance.getTbuaOutTime() != null) {
					// in ada, out ada. proses punch in
					TbUserAttendance tbUserAttendanceIn = punchIn(requestModel, tbUser);
					responseModel.setTbUserAttendance(tbUserAttendanceIn);
					
					responseModel.setStatus("200");
					responseModel.setMessage("Punch in ok");
				} else if (tbUserAttendance.getTbuaInTime() == null && tbUserAttendance.getTbuaOutTime() != null) {
					// in gak ada, out ada. karena punch out lewat hari. proses punch in
					TbUserAttendance tbUserAttendanceIn = punchIn(requestModel, tbUser);
					responseModel.setTbUserAttendance(tbUserAttendanceIn);
					
					responseModel.setStatus("200");
					responseModel.setMessage("Punch in ok");
				} else if (tbUserAttendance.getTbuaInTime() != null && tbUserAttendance.getTbuaOutTime() == null) {
					// in ada, out gak ada. error karena sudah punch in
					responseModel.setStatus("404");
					responseModel.setMessage("Already punch in");
				} else {
					// selain itu. error
					responseModel.setStatus("404");
					responseModel.setMessage("Data error");	
				}
			}
		}, () -> {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		});
		
		return responseModel;
	}
	
	public PostPunchOutResponseModel postPunchOut(PostPunchOutRequestModel requestModel) throws Exception {
		PostPunchOutResponseModel responseModel = new PostPunchOutResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUser.StatusActive);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));

		optTbUser.ifPresentOrElse(tbUser -> {
			TbUserAttendance exampleTbUserAttendance = new TbUserAttendance();
			exampleTbUserAttendance.setTbuId(tbUser.getTbuId());
			
			Page<TbUserAttendance> pgTbUserAttendance = tbUserAttendanceRepository.findAll(Example.of(exampleTbUserAttendance), PageRequest.of(0, 10, Sort.by("tbuaId").descending()));
			
			if (pgTbUserAttendance.toList().size() == 0) {
				responseModel.setStatus("404");
				responseModel.setMessage("Not found punch in");
			} else {
				List<TbUserAttendance> lstTbUserAttendance = pgTbUserAttendance.toList();
				TbUserAttendance tbUserAttendance = lstTbUserAttendance.get(0);
				
				if (tbUserAttendance.getTbuaInTime() != null && tbUserAttendance.getTbuaOutTime() != null) {
					// in ada, out ada. harus punch in dulu
					responseModel.setStatus("404");
					responseModel.setMessage("Punch in first");
				} else if (tbUserAttendance.getTbuaInTime() != null && tbUserAttendance.getTbuaOutTime() == null) {
					// in ada, out gak ada. proses out
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					
					if (simpleDateFormat.format(cal.getTime()).equals(tbUserAttendance.getTbuaDate())) {
						// hari yang sama
						SimpleMapper simpleMapper = new SimpleMapper();
						tbUserAttendance = (TbUserAttendance) simpleMapper.assign(requestModel, tbUserAttendance);
						
						cal = Calendar.getInstance();
						cal.setTime(new Date());
						simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
						
						tbUserAttendance.setTbuaOutTime(simpleDateFormat.format(cal.getTime()));
						
						tbUserAttendance.setTbuaUpdateDate(new Date());
						tbUserAttendance.setTbuaUpdateId(0);
						
						tbUserAttendanceRepository.save(tbUserAttendance);
						
						int intDurationOvertime = calcDuration(tbUser, tbUserAttendance, tbUserAttendance);
						
						if (intDurationOvertime > 0) {
							TbUserOvertime tbUserOvertime = new TbUserOvertime();
						    tbUserOvertime.setTbuoCreateDate(new Date());
						    tbUserOvertime.setTbuoCreateId(0);
						    tbUserOvertime.setTbuId(tbUser.getTbuId());
						    tbUserOvertime.setTbuaIdIn(tbUserAttendance.getTbuaId());
						    tbUserOvertime.setTbuaIdOut(tbUserAttendance.getTbuaId());
						    tbUserOvertime.setTbuoInDate(tbUserAttendance.getTbuaDate());
						    tbUserOvertime.setTbuoInTime(tbUserAttendance.getTbuaInTime());
						    tbUserOvertime.setTbuoOutDate(tbUserAttendance.getTbuaDate());
						    tbUserOvertime.setTbuoOutTime(tbUserAttendance.getTbuaOutTime());
						    tbUserOvertime.setTbuoDuration(intDurationOvertime);
						    tbUserOvertime.setTbuoStatus(TbUserOvertime.statusNotApproved);
						    
						    tbUserOvertimeRepository.save(tbUserOvertime);
						}
						
						responseModel.setTbUserAttendance(tbUserAttendance);
						
						responseModel.setStatus("200");
						responseModel.setMessage("Punch out ok");
					} else {
						// lewat hari
						TbUserAttendance tbUserAttendanceOut = new TbUserAttendance();
						SimpleMapper simpleMapper = new SimpleMapper();
						tbUserAttendanceOut = (TbUserAttendance) simpleMapper.assign(requestModel, tbUserAttendanceOut);
						
						cal = Calendar.getInstance();
						cal.setTime(new Date());
						simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
						tbUserAttendanceOut.setTbuaDate(simpleDateFormat.format(cal.getTime()));
						
						simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
						tbUserAttendanceOut.setTbuaOutTime(simpleDateFormat.format(cal.getTime()));
						
						tbUserAttendanceOut.setTbuId(tbUser.getTbuId());
						tbUserAttendanceOut.setTbuaCreateDate(new Date());
						tbUserAttendanceOut.setTbuaCreateId(0);
						
						tbUserAttendanceRepository.save(tbUserAttendanceOut);
						
						int intDurationOvertime = calcDuration(tbUser, tbUserAttendance, tbUserAttendanceOut);
						
						if (intDurationOvertime > 0) {
							TbUserOvertime tbUserOvertime = new TbUserOvertime();
						    tbUserOvertime.setTbuoCreateDate(new Date());
						    tbUserOvertime.setTbuoCreateId(0);
						    tbUserOvertime.setTbuId(tbUser.getTbuId());
						    tbUserOvertime.setTbuaIdIn(tbUserAttendance.getTbuaId());
						    tbUserOvertime.setTbuaIdOut(tbUserAttendanceOut.getTbuaId());
						    tbUserOvertime.setTbuoInDate(tbUserAttendance.getTbuaDate());
						    tbUserOvertime.setTbuoInTime(tbUserAttendance.getTbuaInTime());
						    tbUserOvertime.setTbuoOutDate(tbUserAttendanceOut.getTbuaDate());
						    tbUserOvertime.setTbuoOutTime(tbUserAttendanceOut.getTbuaOutTime());
						    tbUserOvertime.setTbuoDuration(intDurationOvertime);
						    tbUserOvertime.setTbuoStatus(TbUserOvertime.statusNotApproved);
						    
						    tbUserOvertimeRepository.save(tbUserOvertime);
						}
					    
						responseModel.setTbUserAttendance(tbUserAttendanceOut);
						
						responseModel.setStatus("200");
						responseModel.setMessage("Punch out ok");
					}
				} else {
					// selain itu. error
					responseModel.setStatus("404");
					responseModel.setMessage("Data error");	
				}
			}
		}, () -> {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		});
		
		return responseModel;
	}
	
	public PostUploadPhotoResponseModel postUploadPhoto(PostUploadPhotoRequestModel requestModel, MultipartFile file) throws Exception {
		PostUploadPhotoResponseModel responseModel = new PostUploadPhotoResponseModel(requestModel);

		tokenUtil.claims(requestModel);

		String fileName = responseModel.getResponseId() + "-" + StringUtils.cleanPath(file.getOriginalFilename());
		Files.copy(file.getInputStream(), Paths.get(env.getProperty("file.upload-dir") + fileName), StandardCopyOption.REPLACE_EXISTING);
		
		File destinationDir = new File(env.getProperty("file.upload-dir"));
		Thumbnails.of(env.getProperty("file.upload-dir") + fileName)
		        .size(1600, 1600)
		        .toFiles(destinationDir, Rename.PREFIX_DOT_THUMBNAIL);

		responseModel.setFileName("thumbnail." + fileName);
		
		responseModel.setStatus("200");
		responseModel.setMessage(fileName + " saved");

		return responseModel;
	}
	
	public int calcDuration(TbUser tbUser, TbUserAttendance tbUserAttendance, TbUserAttendance tbUserAttendanceOut) {
		TbUserProject exampleTbUserProject = new TbUserProject();
		exampleTbUserProject.setTbuMemberId(Integer.parseInt(tbUser.getTbuMemberId()));
		Optional<TbUserProject> optTbUserProject = tbUserProjectRepository.findOne(Example.of(exampleTbUserProject));

		TbProject exampleTbProject = new TbProject();
		exampleTbProject.setTbpId(optTbUserProject.get().getTbpId());
		Optional<TbProject> optTbProject = tbProjectRepository.findOne(Example.of(exampleTbProject));

		StringUtil stringUtil = new StringUtil();

		String strStart = tbUserAttendance.getTbuaDate() + " " + optTbProject.get().getTbpShiftStart();
		Date dateStart = stringUtil.stringToDate(strStart);
		LocalDateTime localDateStart = dateStart.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

		String strIn = tbUserAttendance.getTbuaDate() + " " + tbUserAttendance.getTbuaInTime();
		Date dateIn = stringUtil.stringToDate(strIn);
		LocalDateTime localDateIn = dateIn.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

		String strOut = tbUserAttendanceOut.getTbuaDate() + " " + tbUserAttendanceOut.getTbuaOutTime();
		Date dateOut = stringUtil.stringToDate(strOut);
		LocalDateTime localDateOut = dateOut.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

		Duration durationStart = Duration.between(localDateStart, localDateIn);
		Duration durationWork = Duration.between(localDateIn, localDateOut);

		int intDurationStart = (int) durationStart.toMinutes();
		int intDurationWork = ((int) durationWork.toMinutes()) - intDurationStart;
		int intDurationOvertime = 0;

		if (intDurationWork > 480) {
			String status = "";
			if (localDateIn.getDayOfWeek() == DayOfWeek.SATURDAY || localDateIn.getDayOfWeek() == DayOfWeek.SUNDAY || localDateOut.getDayOfWeek() == DayOfWeek.SATURDAY || localDateOut.getDayOfWeek() == DayOfWeek.SUNDAY) {
				status = "Off";
			} else {
				status = "Work";
			}
			
			String strStartOvertimeWork = tbUserAttendance.getTbuaDate() + " " + optTbProject.get().getTbpShiftEnd();
			Date dateStartOvertimeWork = stringUtil.stringToDate(strStartOvertimeWork);
			LocalDateTime localDateStartOvertimeWork = dateStartOvertimeWork.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			
			String strStartOvertimeOff = tbUserAttendance.getTbuaDate() + " " + tbUserAttendance.getTbuaInTime();
			Date dateStartOvertimeOff = stringUtil.stringToDate(strStartOvertimeOff);
			LocalDateTime localDateStartOvertimeOff = dateStartOvertimeOff.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			
			Duration durationOvertime = null;
			if (status.equals("Work")) {
				//Work
				durationOvertime = Duration.between(localDateStartOvertimeWork, localDateOut);
			} else {
				//Off
				durationOvertime = Duration.between(localDateStartOvertimeOff, localDateOut);
			}
			
			intDurationOvertime = (int) durationOvertime.toMinutes();
		}
		
		return intDurationOvertime;
	}
	
	public PutOvertimeResponseModel putUserOvertime(PutOvertimeRequestModel requestModel) throws Exception {
		PutOvertimeResponseModel responseModel = new PutOvertimeResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);

		TbUserOvertime tbUserOvertimeExample = new TbUserOvertime();
		tbUserOvertimeExample.setTbuoId(requestModel.getTboId());
		tbUserOvertimeExample.setTbuoStatus(TbUserOvertime.statusNotApproved);
		
		Optional<TbUserOvertime> optTbUserOvertime = tbUserOvertimeRepository.findOne(Example.of(tbUserOvertimeExample));
		
		optTbUserOvertime.ifPresentOrElse(tbUserOvertime -> {
			StringUtil stringUtil = new StringUtil();
			
			Date tboStart = stringUtil.stringToDate(requestModel.getTboStart());
			Date tboEnd = stringUtil.stringToDate(requestModel.getTboEnd());

			tbUserOvertime.setTbuoInDate(stringUtil.toDateString(tboStart));
			tbUserOvertime.setTbuoInTime(stringUtil.toTimeString(tboStart));
			tbUserOvertime.setTbuoOutDate(stringUtil.toDateString(tboEnd));
			tbUserOvertime.setTbuoOutTime(stringUtil.toTimeString(tboEnd));

			tbUserOvertime.setTbuoStatus(TbUserOvertime.statusApproved);
			tbUserOvertime.setTbuoUpdateDate(new Date());
			tbUserOvertime.setTbuoUpdateId(0);
			
			TbUser exampleTbUser = new TbUser();
			exampleTbUser.setTbuId(tbUserOvertime.getTbuId());
			Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
			
			TbUserAttendance exampleTbUserAttendanceIn = new TbUserAttendance();
			exampleTbUserAttendanceIn.setTbuaId(tbUserOvertime.getTbuaIdIn());
			Optional<TbUserAttendance> optTbUserAttendanceIn = tbUserAttendanceRepository.findOne(Example.of(exampleTbUserAttendanceIn));
			TbUserAttendance tbUserAttendanceIn = optTbUserAttendanceIn.get();
			tbUserAttendanceIn.setTbuaDate(tbUserOvertime.getTbuoInDate());
			tbUserAttendanceIn.setTbuaInTime(tbUserOvertime.getTbuoInTime());
			
			TbUserAttendance exampleTbUserAttendanceOut = new TbUserAttendance();
			exampleTbUserAttendanceOut.setTbuaId(tbUserOvertime.getTbuaIdOut());
			Optional<TbUserAttendance> optTbUserAttendanceOut = tbUserAttendanceRepository.findOne(Example.of(exampleTbUserAttendanceOut));
			TbUserAttendance tbUserAttendanceOut = optTbUserAttendanceOut.get();
			tbUserAttendanceOut.setTbuaDate(tbUserOvertime.getTbuoOutDate());
			tbUserAttendanceOut.setTbuaOutTime(tbUserOvertime.getTbuoOutTime());
			
			int intDurationOvertime = calcDuration(optTbUser.get(), tbUserAttendanceIn, tbUserAttendanceOut);
			
			tbUserOvertime.setTbuoDuration(intDurationOvertime);

			tbUserOvertimeRepository.save(tbUserOvertime);

			responseModel.setTbUserOvertime(tbUserOvertime);
			
			responseModel.setStatus("200");
			responseModel.setMessage("Put User Overtime ok");

		}, () -> {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		});

		return responseModel;
	}

	@Deprecated
	public PostOvertimeResponseModel postUserOvertime(PostOvertimeRequestModel requestModel) throws Exception {
		PostOvertimeResponseModel responseModel = new PostOvertimeResponseModel(requestModel);
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			simpleDateFormat.parse(requestModel.getTbuoInDate());
			simpleDateFormat.parse(requestModel.getTbuoOutDate());

			SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hh:mm:ss");
			simpleTimeFormat.parse(requestModel.getTbuoInTime());
			simpleTimeFormat.parse(requestModel.getTbuoOutTime());
		} catch (Exception e) {
			responseModel.setStatus("400");
			responseModel.setMessage("Invalid Date or Time format");
			return responseModel;
		}

		tokenUtil.claims(requestModel);

		TbUser exampleTbUser = new TbUser();
		if (requestModel.getTbuId() == null)
			exampleTbUser.setTbuEmail(requestModel.getEmail());
		else
			exampleTbUser.setTbuId(requestModel.getTbuId());
		exampleTbUser.setTbuStatus(TbUser.StatusActive);
		tbUserRepository.findOne(Example.of(exampleTbUser)).ifPresentOrElse(tbUser -> {
//                 if(tbUserOvertimeRepository.findByTbuaIdIn(requestModel.getTbuaId()).isPresent()) {
//                    responseModel.setStatus("400");
//                    responseModel.setMessage("Overtime entry exist");
//                 }else {
			TbUserOvertime tbUserOvertime = new TbUserOvertime();
			tbUserOvertime.setTbuoCreateDate(new Date());
			tbUserOvertime.setTbuoCreateId(0);
			tbUserOvertime.setTbuId(requestModel.getTbuId());
			tbUserOvertime.setTbuaIdIn(requestModel.getTbuaId());
			tbUserOvertime.setTbuaIdOut(requestModel.getTbuaId());
			tbUserOvertime.setTbuoInDate(requestModel.getTbuoInDate());
			tbUserOvertime.setTbuoInTime(requestModel.getTbuoInTime());
			tbUserOvertime.setTbuoOutDate(requestModel.getTbuoOutDate());
			tbUserOvertime.setTbuoOutTime(requestModel.getTbuoOutTime());
			tbUserOvertime.setTbuoDuration(requestModel.getTbuoDuration());
			tbUserOvertime.setTbuoStatus(TbUserOvertime.statusNotApproved);

			tbUserOvertimeRepository.save(tbUserOvertime);
			responseModel.setTbUserOvertime(tbUserOvertime);
			responseModel.setStatus("200");
			responseModel.setMessage("Put User Overtime ok");
//                 }

		}, () -> {
			responseModel.setStatus("404");
			responseModel.setMessage("User Not Found");
		});

		return responseModel;
	}
}
