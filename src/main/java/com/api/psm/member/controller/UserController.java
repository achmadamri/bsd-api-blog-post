package com.api.psm.member.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
import com.api.psm.member.service.UserService;
import com.api.psm.member.util.MD5;
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
	
	@PostMapping("/postuploadphoto")
	@Transactional
	public HttpEntity<?> postUploadPhoto(PostUploadPhotoRequestModel requestModel, @RequestParam("file") MultipartFile file) throws Exception {
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + file.toString());
		
		PostUploadPhotoResponseModel responseModel = userService.postUploadPhoto(requestModel, file);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@PostMapping("/postuploadphotobystring")
	@Transactional
	public HttpEntity<?> postUploadPhotoByString(PostUploadPhotoByStringRequestModel requestModel) throws Exception {
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		PostUploadPhotoByStringResponseModel responseModel = userService.postUploadPhotoByString(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@GetMapping("/getuser")
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
	
	@GetMapping("/getproject")
	public HttpEntity<?> getProject(@RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		GetProjectRequestModel requestModel = new GetProjectRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetProjectResponseModel responseModel = userService.getProject(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@GetMapping("/getdepartment")
	public HttpEntity<?> getDepartment(@RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		GetDepartmentRequestModel requestModel = new GetDepartmentRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetDepartmentResponseModel responseModel = userService.getDepartment(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@GetMapping("/getbusiness")
	public HttpEntity<?> getProjectBusiness(@RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		GetBusinessRequestModel requestModel = new GetBusinessRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetBusinessResponseModel responseModel = userService.getBusiness(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@PutMapping("/putupdate")
	@Transactional
	public HttpEntity<?> putUpdate(@Valid @RequestBody PutUpdateRequestModel requestModel) throws Exception {
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		PutUpdateResponseModel responseModel = userService.putUpdate(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@PostMapping("/postadd")
	@Transactional
	public HttpEntity<?> postAdd(@Valid @RequestBody PostAddRequestModel requestModel) throws Exception {
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		MD5 md5 = new MD5();
		requestModel.setTbuPassword(md5.get(requestModel.getTbuPassword()));
		
		PostAddResponseModel responseModel = userService.postAdd(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("208") ? HttpStatus.ALREADY_REPORTED : HttpStatus.OK);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@PostMapping("/postsync")
	@Transactional
	public HttpEntity<?> postSync(@Valid @RequestBody PostSyncRequestModel requestModel) throws Exception {
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		PostSyncResponseModel responseModel = userService.postSync(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("208") ? HttpStatus.ALREADY_REPORTED : HttpStatus.OK);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@PostMapping("/postnotify")
	@Transactional
	public HttpEntity<?> postNotify(@Valid @RequestBody PostNotifyRequestModel requestModel) throws Exception {
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		PostNotifyResponseModel responseModel = userService.postNotify(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : (responseModel.getStatus().equals("500") ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.UNAUTHORIZED));
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@PostMapping("/postconfirmation")
	@Transactional
	public HttpEntity<?> postConfirmation(@Valid @RequestBody PostConfirmationRequestModel requestModel) throws Exception {
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		PostConfirmationResponseModel responseModel = userService.postConfirmation(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.UNAUTHORIZED);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
}
