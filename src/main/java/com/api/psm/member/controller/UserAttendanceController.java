package com.api.psm.member.controller;

import java.io.ByteArrayInputStream;

import javax.validation.Valid;

import com.api.psm.member.model.userattendance.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.api.psm.member.service.UserAttendanceService;
import com.api.psm.member.util.Uid;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("/userattendance")
public class UserAttendanceController {

	private Logger log = LoggerFactory.getLogger(UserAttendanceController.class);
	
	@Autowired
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
    private UserAttendanceService userAttendanceService;
	
	@GetMapping("/getattendancedetail")
	public HttpEntity<?> getAttendanceDetail(@RequestParam String email, @RequestParam String tbuaId, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		GetAttendanceDetailRequestModel requestModel = new GetAttendanceDetailRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetAttendanceDetailResponseModel responseModel = userAttendanceService.getAttendanceDetail(requestModel, tbuaId);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@GetMapping("/getattendance")
	public HttpEntity<?> getAttendance(@RequestParam String email, @RequestParam String token, @RequestParam String tbuId, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		GetAttendanceRequestModel requestModel = new GetAttendanceRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetAttendanceResponseModel responseModel = userAttendanceService.getAttendance(requestModel, tbuId);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@GetMapping("/getattendancereportexcel")
	public HttpEntity<?> getAttendanceReportExcel(@RequestParam String email, @RequestParam String token, @RequestParam String tbuId, @RequestParam String tbpId, @RequestParam String tbbId, @RequestParam String tbdId, @RequestParam String tbuaDate, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		GetAttendanceReportRequestModel requestModel = new GetAttendanceReportRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		ByteArrayInputStream in = userAttendanceService.getAttendanceReportExcel(requestModel, tbuId, tbpId, tbbId, tbdId, tbuaDate);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.add("Content-Disposition", "attachment; filename=" + fid + ".data.xlsx");

        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}
	
	@GetMapping("/getattendancereport")
	public HttpEntity<?> getAttendanceReport(@RequestParam String email, @RequestParam String token, @RequestParam String tbuId, @RequestParam String tbpId, @RequestParam String tbbId, @RequestParam String tbdId, @RequestParam String tbuaDate, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		GetAttendanceReportRequestModel requestModel = new GetAttendanceReportRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetAttendanceReportResponseModel responseModel = userAttendanceService.getAttendanceReport(requestModel, tbuId, tbpId, tbbId, tbdId, tbuaDate);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@GetMapping("/getuserovertime")
	public HttpEntity<?> getUserOvertime(@RequestParam String tbbId, @RequestParam String tbpId, @RequestParam String period, @RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		GetUserOvertimeRequestModel requestModel = new GetUserOvertimeRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetUserOvertimeResponseModel responseModel = userAttendanceService.getUserOvertime(requestModel, tbbId, tbpId, period);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@GetMapping("/getpunchstatus")
	public HttpEntity<?> getPunchStatus(@RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		GetPunchStatusRequestModel requestModel = new GetPunchStatusRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetPunchStatusResponseModel responseModel = userAttendanceService.getPunchStatus(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@PostMapping("/postpunchin")
	@Transactional
	public HttpEntity<?> postPunchIn(@Valid @RequestBody PostPunchInRequestModel requestModel) throws Exception {
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		PostPunchInResponseModel responseModel = userAttendanceService.postPunchIn(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@PostMapping("/postpunchout")
	@Transactional
	public HttpEntity<?> postPunchOut(@Valid @RequestBody PostPunchOutRequestModel requestModel) throws Exception {
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		PostPunchOutResponseModel responseModel = userAttendanceService.postPunchOut(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@PostMapping("/postuploadphoto")
	@Transactional
	public HttpEntity<?> postUploadPhoto(PostUploadPhotoRequestModel requestModel, @RequestParam("file") MultipartFile file) throws Exception {
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + file.toString());
		
		PostUploadPhotoResponseModel responseModel = userAttendanceService.postUploadPhoto(requestModel, file);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}

	@PutMapping("/putuserovertime")
	public HttpEntity<?> putUserOvertime(@RequestBody PutOvertimeRequestModel requestModel) throws Exception {

		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));

		PutOvertimeResponseModel responseModel = userAttendanceService.putUserOvertime(requestModel);

		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	@Deprecated
	@PostMapping("/postuserovertime")
	public HttpEntity<?> postUserOvertime(@Valid @RequestBody PostOvertimeRequestModel requestModel) throws Exception {

		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));

		PostOvertimeResponseModel responseModel = userAttendanceService.postUserOvertime(requestModel);

		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
}
