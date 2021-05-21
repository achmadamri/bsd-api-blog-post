package com.api.psm.member.service;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.Optional;

import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.api.psm.member.db.entity.TbAddress;
import com.api.psm.member.db.entity.TbBusiness;
import com.api.psm.member.db.entity.TbDepartment;
import com.api.psm.member.db.entity.TbNotification;
import com.api.psm.member.db.entity.TbNotificationData;
import com.api.psm.member.db.entity.TbProject;
import com.api.psm.member.db.entity.TbUser;
import com.api.psm.member.db.entity.TbUserBusiness;
import com.api.psm.member.db.entity.TbUserDepartment;
import com.api.psm.member.db.entity.TbUserProject;
import com.api.psm.member.db.repository.TbAddressRepository;
import com.api.psm.member.db.repository.TbBusinessRepository;
import com.api.psm.member.db.repository.TbDepartmentRepository;
import com.api.psm.member.db.repository.TbNotificationDataRepository;
import com.api.psm.member.db.repository.TbNotificationRepository;
import com.api.psm.member.db.repository.TbProjectRepository;
import com.api.psm.member.db.repository.TbUserBusinessRepository;
import com.api.psm.member.db.repository.TbUserDepartmentRepository;
import com.api.psm.member.db.repository.TbUserProjectRepository;
import com.api.psm.member.db.repository.TbUserRepository;
import com.api.psm.member.model.payroll.PostSyncUserRequestModel;
import com.api.psm.member.model.user.GetBusinessRequestModel;
import com.api.psm.member.model.user.GetBusinessResponseModel;
import com.api.psm.member.model.user.GetDepartmentRequestModel;
import com.api.psm.member.model.user.GetDepartmentResponseModel;
import com.api.psm.member.model.user.GetProjectRequestModel;
import com.api.psm.member.model.user.GetProjectResponseModel;
import com.api.psm.member.model.user.GetUserRequestModel;
import com.api.psm.member.model.user.GetUserResponseModel;
import com.api.psm.member.model.user.PostAddRequestModel;
import com.api.psm.member.model.user.PostAddResponseModel;
import com.api.psm.member.model.user.PostConfirmationRequestModel;
import com.api.psm.member.model.user.PostConfirmationResponseModel;
import com.api.psm.member.model.user.PostNotifyRequestModel;
import com.api.psm.member.model.user.PostNotifyResponseModel;
import com.api.psm.member.model.user.PostSyncRequestModel;
import com.api.psm.member.model.user.PostSyncResponseModel;
import com.api.psm.member.model.user.PostUploadPhotoByStringRequestModel;
import com.api.psm.member.model.user.PostUploadPhotoByStringResponseModel;
import com.api.psm.member.model.user.PostUploadPhotoRequestModel;
import com.api.psm.member.model.user.PostUploadPhotoResponseModel;
import com.api.psm.member.model.user.PutUpdateRequestModel;
import com.api.psm.member.model.user.PutUpdateResponseModel;
import com.api.psm.member.util.SimpleMapper;
import com.api.psm.member.util.TokenUtil;
import com.api.psm.member.util.Uid;

@Service
public class UserService {

	private Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private Environment env;
	
	private TokenUtil tokenUtil = new TokenUtil();
	
	@Autowired
	private TbUserRepository tbUserRepository;
	
	@Autowired
	private TbUserBusinessRepository tbUserBusinessRepository;
	
	@Autowired
	private TbUserDepartmentRepository tbUserDepartmentRepository;
	
	@Autowired
	private TbUserProjectRepository tbUserProjectRepository;
	
	@Autowired
	private TbAddressRepository tbAddressRepository;
	
	@Autowired
	private TbNotificationRepository tbNotificationRepository;

	@Autowired
	private TbNotificationDataRepository tbNotificationDataRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private TbProjectRepository tbProjectRepository;
	
	@Autowired
	private TbDepartmentRepository tbDepartmentRepository;
	
	@Autowired
	private TbBusinessRepository tbBusinessRepository;
	
	public PostUploadPhotoResponseModel postUploadPhoto(PostUploadPhotoRequestModel requestModel, MultipartFile file) throws Exception {
		PostUploadPhotoResponseModel responseModel = new PostUploadPhotoResponseModel(requestModel);

		tokenUtil.claims(requestModel);

		String fileName = responseModel.getResponseId() + "-" + StringUtils.cleanPath(file.getOriginalFilename());
		Files.copy(file.getInputStream(), Paths.get(env.getProperty("file.upload-photo-dir") + fileName), StandardCopyOption.REPLACE_EXISTING);
		
		responseModel.setFileName(fileName);
		
		responseModel.setStatus("200");
		responseModel.setMessage(fileName + " saved");

		return responseModel;
	}
	
	public PostUploadPhotoByStringResponseModel postUploadPhotoByString(PostUploadPhotoByStringRequestModel requestModel) throws Exception {
		PostUploadPhotoByStringResponseModel responseModel = new PostUploadPhotoByStringResponseModel(requestModel);

		tokenUtil.claims(requestModel);
		
		InputStream inputStream = new URL(requestModel.getFile()).openStream();
		
		String fileName = responseModel.getResponseId() + "-" + FilenameUtils.getName(requestModel.getFile());
		Files.copy(inputStream, Paths.get(env.getProperty("file.upload-photo-dir") + fileName), StandardCopyOption.REPLACE_EXISTING);
		
		responseModel.setFileName(fileName);
		
		responseModel.setStatus("200");
		responseModel.setMessage(fileName + " saved");

		return responseModel;
	}
	
	public GetUserResponseModel getUser(GetUserRequestModel requestModel) throws Exception {
		GetUserResponseModel responseModel = new GetUserResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUser.StatusActive);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		optTbUser.ifPresentOrElse(tbUser -> {
			responseModel.setTbUser(tbUser);
			
			TbAddress exampleTbAddress = new TbAddress();
			exampleTbAddress.setTbuId(tbUser.getTbuId());
			
			responseModel.setLstTbAddress(tbAddressRepository.findAll(Example.of(exampleTbAddress)));
			
			responseModel.setStatus("200");
			responseModel.setMessage("User ok");
		}, () -> {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		});
		
		return responseModel;
	}
	
	public GetProjectResponseModel getProject(GetProjectRequestModel requestModel) throws Exception {
		GetProjectResponseModel responseModel = new GetProjectResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUser.StatusActive);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		optTbUser.ifPresentOrElse(tbUser -> {
			responseModel.setTbUser(tbUser);
			
			responseModel.setLstTbProject(tbProjectRepository.findAll(Sort.by("tbpProjectName", "tbpBranchBuilding").ascending()));
			
			responseModel.setStatus("200");
			responseModel.setMessage("User ok");
		}, () -> {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		});
		
		return responseModel;
	}
	
	public GetDepartmentResponseModel getDepartment(GetDepartmentRequestModel requestModel) throws Exception {
		GetDepartmentResponseModel responseModel = new GetDepartmentResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUser.StatusActive);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		optTbUser.ifPresentOrElse(tbUser -> {
			responseModel.setTbUser(tbUser);
			
			responseModel.setLstTbDepartment(tbDepartmentRepository.findAll(Sort.by("tbdDepartmentName").ascending()));
			
			responseModel.setStatus("200");
			responseModel.setMessage("User ok");
		}, () -> {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		});
		
		return responseModel;
	}
	
	public GetBusinessResponseModel getBusiness(GetBusinessRequestModel requestModel) throws Exception {
		GetBusinessResponseModel responseModel = new GetBusinessResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUser.StatusActive);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		optTbUser.ifPresentOrElse(tbUser -> {
			responseModel.setTbUser(tbUser);
			
			responseModel.setLstTbBusiness(tbBusinessRepository.findAll(Sort.by("tbbName").ascending()));
			
			responseModel.setStatus("200");
			responseModel.setMessage("User ok");
		}, () -> {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		});
		
		return responseModel;
	}
	
	public PutUpdateResponseModel putUpdate(PutUpdateRequestModel requestModel) throws Exception {
		PutUpdateResponseModel responseModel = new PutUpdateResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUser.StatusActive);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		optTbUser.ifPresentOrElse(tbUser -> {
			com.api.psm.member.model.auth.PutUpdateRequestModel putUpdateRequestModel = new com.api.psm.member.model.auth.PutUpdateRequestModel();
			putUpdateRequestModel.setRequestDate(requestModel.getRequestDate());
			putUpdateRequestModel.setRequestId(requestModel.getRequestId());
			putUpdateRequestModel.setTbaEmail(tbUser.getTbuEmail());
			putUpdateRequestModel.setTbaPassword(tbUser.getTbuPassword());
			putUpdateRequestModel.setNewPassword(requestModel.getTbuPassword());
			putUpdateRequestModel.setTbaStatus(requestModel.getTbuStatus());
			
			HttpEntity<com.api.psm.member.model.auth.PutUpdateRequestModel> request = new HttpEntity<>(putUpdateRequestModel);
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.put(env.getProperty("services.rest.auth.url") + "auth/putupdate", request, String.class);
			
			SimpleMapper simpleMapper = new SimpleMapper();
			tbUser = (TbUser) simpleMapper.assign(requestModel, tbUser);
			
			tbUser.setTbuUpdateDate(new Date());
			tbUser.setTbuUpdateId(0);
			
			responseModel.setTbUser(tbUser);
			responseModel.setStatus("200");
			responseModel.setMessage("User updated");
		}, () -> {
			responseModel.setStatus("404");
			responseModel.setMessage("Email not found");
		});
		
		return responseModel;
	}
	
	public PostAddResponseModel postAdd(PostAddRequestModel requestModel) {
		PostAddResponseModel responseModel = new PostAddResponseModel(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getTbuEmail());
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		optTbUser.ifPresentOrElse(tbUser -> {
			responseModel.setStatus("208");
			responseModel.setMessage("Email already exists");
		}, () -> {
			TbUser tbUser = new TbUser();
			SimpleMapper simpleMapper = new SimpleMapper();
			tbUser = (TbUser) simpleMapper.assign(requestModel, tbUser);
			
			tbUser.setTbuCreateDate(new Date());
			tbUser.setTbuCreateId(0);
			tbUser.setTbuStatus(TbUser.StatusCreated);
			
			Uid uid = new Uid();
			tbUser.setTbuUid(uid.generateString(100));
			
			tbUserRepository.save(tbUser);
			
			responseModel.setTbUsers(tbUser);
			responseModel.setStatus("200");
			responseModel.setMessage("User created");
		});
		
		return responseModel;
	}
	
	public PostSyncResponseModel postSync(PostSyncRequestModel requestModel) {
		PostSyncResponseModel responseModel = new PostSyncResponseModel(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getTbuEmail());
		exampleTbUser.setTbuStatus(TbUser.StatusActive);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		optTbUser.ifPresentOrElse(tbUser -> {
			responseModel.setStatus("208");
			responseModel.setMessage("Email already exists");
		}, () -> {
			TbUser tbUser = new TbUser();
			SimpleMapper simpleMapper = new SimpleMapper();
			tbUser = (TbUser) simpleMapper.assign(requestModel, tbUser);
			
			tbUser.setTbuCreateDate(new Date());
			tbUser.setTbuCreateId(0);
			tbUser.setTbuStatus(TbUser.StatusActive);
			
			Uid uid = new Uid();
			tbUser.setTbuUid(uid.generateString(100));
			
			tbUserRepository.save(tbUser);
			
			TbBusiness exampleTbBusiness = new TbBusiness();
			exampleTbBusiness.setTbbId(requestModel.getTbbId());
			Optional<TbBusiness> optTbBusiness = tbBusinessRepository.findOne(Example.of(exampleTbBusiness));
			
			optTbBusiness.ifPresentOrElse(tbBusiness -> {
				TbUserBusiness tbUserBusiness = new TbUserBusiness();
				tbUserBusiness.setTbubCreateDate(new Date());
				tbUserBusiness.setTbubCreateId(0);
				tbUserBusiness.setTbuMemberId(Integer.valueOf(requestModel.getTbuMemberId()));
				tbUserBusiness.setTbbId(tbBusiness.getTbbId());
				tbUserBusinessRepository.save(tbUserBusiness);
				
				responseModel.setTbBusiness(tbBusiness);
			}, () -> {});
			
			TbDepartment exampleTbDepartment = new TbDepartment();
			exampleTbDepartment.setTbdId(requestModel.getTbdId());
			Optional<TbDepartment> optTbDepartment = tbDepartmentRepository.findOne(Example.of(exampleTbDepartment));
			
			optTbDepartment.ifPresentOrElse(tbDepartment -> {
				TbUserDepartment tbUserDepartment = new TbUserDepartment();
				tbUserDepartment.setTbudCreateDate(new Date());
				tbUserDepartment.setTbudCreateId(0);
				tbUserDepartment.setTbuMemberId(Integer.valueOf(requestModel.getTbuMemberId()));
				tbUserDepartment.setTbdId(tbDepartment.getTbdId());
				tbUserDepartmentRepository.save(tbUserDepartment);
				
				responseModel.setTbDepartment(tbDepartment);
			}, () -> {});
			
			TbProject exampleTbProject = new TbProject();
			exampleTbProject.setTbpId(requestModel.getTbpId());
			Optional<TbProject> optTbProject = tbProjectRepository.findOne(Example.of(exampleTbProject));
			
			optTbProject.ifPresentOrElse(tbProject -> {
				TbUserProject tbUserProject = new TbUserProject();
				tbUserProject.setTbupCreateDate(new Date());
				tbUserProject.setTbupCreateId(0);
				tbUserProject.setTbuMemberId(Integer.valueOf(requestModel.getTbuMemberId()));
				tbUserProject.setTbpId(tbProject.getTbpId());
				tbUserProjectRepository.save(tbUserProject);
				
				responseModel.setTbProject(tbProject);
			}, () -> {});
			
			com.api.psm.member.model.auth.PostAddRequestModel postAddRequestModel = new com.api.psm.member.model.auth.PostAddRequestModel();
			postAddRequestModel.setRequestDate(requestModel.getRequestDate());
			postAddRequestModel.setRequestId(requestModel.getRequestId());
			postAddRequestModel.setTbaEmail(tbUser.getTbuEmail());
			postAddRequestModel.setTbaPassword(tbUser.getTbuPassword());
			postAddRequestModel.setTbaMemberId(tbUser.getTbuMemberId());
			postAddRequestModel.setTbaIdLogin(tbUser.getTbuIdLogin());
			
			HttpEntity<com.api.psm.member.model.auth.PostAddRequestModel> requestPostAddRequestModel = new HttpEntity<>(postAddRequestModel);
			RestTemplate restTemplatePostAddRequestModel = new RestTemplate();
			restTemplatePostAddRequestModel.postForEntity(env.getProperty("services.rest.auth.url") + "auth/postadd", requestPostAddRequestModel, String.class);
			
			responseModel.setTbUser(tbUser);
			responseModel.setStatus("200");
			responseModel.setMessage("User created");
		});
		
		return responseModel;
	}
	
	public PostNotifyResponseModel postNotify(PostNotifyRequestModel requestModel) {
		PostNotifyResponseModel responseModel = new PostNotifyResponseModel(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuUid(requestModel.getTbuUid());
		exampleTbUser.setTbuStatus(TbUser.StatusCreated);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		optTbUser.ifPresentOrElse(tbUser -> {
			tbUser.setTbuUpdateDate(new Date());
			tbUser.setTbuUpdateId(0);
			tbUser.setTbuStatus(TbUser.StatusNeedConfirmation);
			
			TbNotification exampleTbNotification = new TbNotification();
			exampleTbNotification.setTbnCode("EMAIL.CONFIRMATION");
			exampleTbNotification.setTbnStatus(TbNotification.statusActive);
			Optional<TbNotification> optTbNotification = tbNotificationRepository.findOne(Example.of(exampleTbNotification));
			
			optTbNotification.ifPresentOrElse(tbNotification -> {
				TbNotificationData tbNotificationData = new TbNotificationData();
				tbNotificationData.setTbndCreateDate(new Date());
				tbNotificationData.setTbndCreateId(0);
				tbNotificationData.setTbnId(tbNotification.getTbnId());
				tbNotificationData.setTbndTo(tbUser.getTbuEmail());
				tbNotificationData.setTbndSubject(tbNotification.getTbnSubject());
				
				String strHtml = tbNotification.getTbnHtml();
				strHtml = strHtml.replaceAll("\\$\\{NAME\\}", tbUser.getTbuFirstname());
				strHtml = strHtml.replaceAll("\\$\\{USER_NAME\\}", tbUser.getTbuEmail());
				strHtml = strHtml.replaceAll("\\$\\{URL\\}", "http://localhost:4200/#/user-confirmation?uuid=" + tbUser.getTbuUid());
				tbNotificationData.setTbndHtml(strHtml);
				
				tbNotificationDataRepository.save(tbNotificationData);
				
		        try {
		        	MimeMessage mime = javaMailSender.createMimeMessage();
		        	MimeMessageHelper helper = new MimeMessageHelper(mime, true);
					helper.setTo(tbNotificationData.getTbndTo());
					helper.setSubject(tbNotificationData.getTbndSubject());
					helper.setText(tbNotificationData.getTbndHtml(), true);
					javaMailSender.send(mime);
					
			        tbNotificationData.setTbndStatus(TbNotificationData.statusSend);
			        
			        responseModel.setTbUsers(optTbUser.get());
					responseModel.setStatus("200");
					responseModel.setMessage("User notified");
		        } catch (Exception e) {
		        	log.error(e.getMessage());
		        	
		        	tbNotificationData.setTbndStatus(TbNotificationData.statusError);
		        	
		        	responseModel.setTbUsers(optTbUser.get());
					responseModel.setStatus("200");
					responseModel.setMessage("User notified pending");
		        }
			}, () -> {
				responseModel.setStatus("500");
				responseModel.setMessage("No email template");
			});
		}, () -> {
			responseModel.setStatus("401");
			responseModel.setError("Data not found or already notified");
		});
		
		return responseModel;
	}
	
	public PostConfirmationResponseModel postConfirmation(PostConfirmationRequestModel requestModel) {
		PostConfirmationResponseModel responseModel = new PostConfirmationResponseModel(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuUid(requestModel.getTbuUid());
		exampleTbUser.setTbuStatus(TbUser.StatusNeedConfirmation);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		optTbUser.ifPresentOrElse(tbUser -> {
			tbUser.setTbuUpdateDate(new Date());
			tbUser.setTbuUpdateId(0);
			tbUser.setTbuStatus(TbUser.StatusActive);
			
			com.api.psm.member.model.auth.PostAddRequestModel postAddRequestModel = new com.api.psm.member.model.auth.PostAddRequestModel();
			postAddRequestModel.setRequestDate(requestModel.getRequestDate());
			postAddRequestModel.setRequestId(requestModel.getRequestId());
			postAddRequestModel.setTbaEmail(tbUser.getTbuEmail());
			postAddRequestModel.setTbaPassword(tbUser.getTbuPassword());
			
			HttpEntity<com.api.psm.member.model.auth.PostAddRequestModel> request = new HttpEntity<>(postAddRequestModel);
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.postForEntity(env.getProperty("services.rest.auth.url") + "auth/postadd", request, String.class);
			
			responseModel.setTbUsers(tbUser);
			responseModel.setStatus("200");
			responseModel.setMessage("User confirmed");
		}, () -> {
			responseModel.setStatus("401");
			responseModel.setError("Data not found or already confirmed");
		});
		
		return responseModel;
	}
}
