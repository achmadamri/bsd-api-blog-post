package com.api.psm.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.psm.member.model.user.GetUserRequestModel;
import com.api.psm.member.model.user.GetUserResponseModel;
import com.api.psm.member.service.UserService;
import com.api.psm.member.util.Uid;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	private Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
    private UserService userService;
	
	@GetMapping("/getuser")
	@Transactional
	public HttpEntity<?> getUser(@RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		GetUserRequestModel requestModel = new GetUserRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetUserResponseModel responseModel = userService.getUser(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
}
