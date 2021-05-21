package com.api.psm.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.psm.member.model.userovertime.GetUserOvertimeListRequestModel;
import com.api.psm.member.model.userovertime.GetUserOvertimeListResponseModel;
import com.api.psm.member.model.userovertime.GetUserOvertimeRequestModel;
import com.api.psm.member.model.userovertime.GetUserOvertimeResponseModel;
import com.api.psm.member.service.UserOvertimeService;
import com.api.psm.member.util.Uid;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("/userovertime")
public class UserOvertimeController {

	private Logger log = LoggerFactory.getLogger(UserOvertimeController.class);
	
	@Autowired
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
    private UserOvertimeService userOvertimeService;
	
	@GetMapping("/getuserovertime")
	public HttpEntity<?> getUserOvertime(@RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate, @RequestParam String tbuoId) throws Exception {
		GetUserOvertimeRequestModel requestModel = new GetUserOvertimeRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetUserOvertimeResponseModel responseModel = userOvertimeService.getUserOvertime(requestModel, tbuoId);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@GetMapping("/getuserovertimelist")
	public HttpEntity<?> getUserOvertimeList(@RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate, @RequestParam String tbbId, @RequestParam String tbpId, @RequestParam String period) throws Exception {
		GetUserOvertimeListRequestModel requestModel = new GetUserOvertimeListRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetUserOvertimeListResponseModel responseModel = userOvertimeService.getOvertimeList(requestModel, tbbId, tbpId, period);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
}
