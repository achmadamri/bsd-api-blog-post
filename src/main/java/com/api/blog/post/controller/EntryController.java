package com.api.blog.post.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.blog.post.model.post.GetEntryListRequestModel;
import com.api.blog.post.model.post.GetEntryListResponseModel;
import com.api.blog.post.model.post.GetEntryRequestModel;
import com.api.blog.post.model.post.GetEntryResponseModel;
import com.api.blog.post.model.post.PostEntryAddRequestModel;
import com.api.blog.post.model.post.PostEntryAddResponseModel;
import com.api.blog.post.model.post.PostEntryDeleteRequestModel;
import com.api.blog.post.model.post.PostEntryDeleteResponseModel;
import com.api.blog.post.model.post.PostEntryEditRequestModel;
import com.api.blog.post.model.post.PostEntryEditResponseModel;
import com.api.blog.post.service.EntryService;
import com.api.blog.post.util.Uid;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("/entry")
public class EntryController {

	private Logger log = LoggerFactory.getLogger(EntryController.class);

	@Autowired
	private ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private EntryService entryService;

	@GetMapping("/getentrylist")
	public HttpEntity<?> getEntryList(@RequestParam String tbeTitle, @RequestParam String tbeChunk, @RequestParam String tbeContent, @RequestParam String length, @RequestParam String pageSize, @RequestParam String pageIndex, @RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		GetEntryListRequestModel requestModel = new GetEntryListRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);

		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));

		GetEntryListResponseModel responseModel = entryService.getEntryList(tbeTitle, tbeChunk, tbeContent, length, pageSize, pageIndex, requestModel);

		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel,
				responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@PostMapping("/postentryadd")
	@Transactional
	public HttpEntity<?> postEntryAdd(@Valid @RequestBody PostEntryAddRequestModel requestModel) throws Exception {
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		PostEntryAddResponseModel responseModel = entryService.postEntryAdd(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("403") ? HttpStatus.FORBIDDEN : (responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND));
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@GetMapping("/getentry")
	@Transactional
	public HttpEntity<?> getEntry(@RequestParam String tbeId, @RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		GetEntryRequestModel requestModel = new GetEntryRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetEntryResponseModel responseModel = entryService.getEntry(tbeId, requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@PostMapping("/postentryedit")
	@Transactional
	public HttpEntity<?> postEntryEdit(@Valid @RequestBody PostEntryEditRequestModel requestModel) throws Exception {
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		PostEntryEditResponseModel responseModel = entryService.postEntryEdit(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("403") ? HttpStatus.FORBIDDEN : (responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND));
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@PostMapping("/postentrydelete")
	@Transactional
	public HttpEntity<?> postEntryDelete(@Valid @RequestBody PostEntryDeleteRequestModel requestModel) throws Exception {
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		PostEntryDeleteResponseModel responseModel = entryService.postEntryDelete(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("403") ? HttpStatus.FORBIDDEN : (responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND));
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
}
