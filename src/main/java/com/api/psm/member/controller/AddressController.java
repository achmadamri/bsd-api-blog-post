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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.psm.member.model.address.GetAddressRequestModel;
import com.api.psm.member.model.address.GetAddressResponseModel;
import com.api.psm.member.model.address.GetCityRequestModel;
import com.api.psm.member.model.address.GetCityResponseModel;
import com.api.psm.member.model.address.GetDistrictRequestModel;
import com.api.psm.member.model.address.GetDistrictResponseModel;
import com.api.psm.member.model.address.GetProvinceRequestModel;
import com.api.psm.member.model.address.GetProvinceResponseModel;
import com.api.psm.member.model.address.GetVillageRequestModel;
import com.api.psm.member.model.address.GetVillageResponseModel;
import com.api.psm.member.model.address.PostAddressRequestModel;
import com.api.psm.member.model.address.PostAddressResponseModel;
import com.api.psm.member.model.address.PutUpdateAddressRequestModel;
import com.api.psm.member.model.address.PutUpdateAddressResponseModel;
import com.api.psm.member.service.AddressService;
import com.api.psm.member.util.Uid;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("/address")
public class AddressController {

	private Logger log = LoggerFactory.getLogger(AddressController.class);
	
	@Autowired
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
    private AddressService addressService;
	
	@GetMapping("/getvillage/{districtId}")
	public HttpEntity<?> getVillage(@RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate, @PathVariable String districtId) throws Exception {
		return getVillage(email, token, requestId, requestDate, districtId, "0");
	}
	
	@GetMapping("/getvillage/{districtId}/{id}")
	public HttpEntity<?> getVillage(@RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate, @PathVariable String districtId, @PathVariable String id) throws Exception {
		GetVillageRequestModel requestModel = new GetVillageRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetVillageResponseModel responseModel = addressService.getVillage(requestModel, districtId, id);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@GetMapping("/getdistrict/{cityId}")
	public HttpEntity<?> getDistrict(@RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate, @PathVariable String cityId) throws Exception {
		return getDistrict(email, token, requestId, requestDate, cityId, "0");
	}
	
	@GetMapping("/getdistrict/{cityId}/{id}")
	public HttpEntity<?> getDistrict(@RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate, @PathVariable String cityId, @PathVariable String id) throws Exception {
		GetDistrictRequestModel requestModel = new GetDistrictRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetDistrictResponseModel responseModel = addressService.getDistrict(requestModel, cityId, id);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@GetMapping("/getcity/{provinceId}")
	public HttpEntity<?> getCity(@RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate, @PathVariable String provinceId) throws Exception {
		return getCity(email, token, requestId, requestDate, provinceId, "0");
	}
	
	@GetMapping("/getcity/{provinceId}/{id}")
	public HttpEntity<?> getCity(@RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate, @PathVariable String provinceId, @PathVariable String id) throws Exception {
		GetCityRequestModel requestModel = new GetCityRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetCityResponseModel responseModel = addressService.getCity(requestModel, provinceId, id);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@GetMapping("/getprovince")
	public HttpEntity<?> getProvince(@RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		return getProvince(email, token, requestId, requestDate, "0");
	}
	
	@GetMapping("/getprovince/{id}")
	public HttpEntity<?> getProvince(@RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate, @PathVariable String id) throws Exception {
		GetProvinceRequestModel requestModel = new GetProvinceRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetProvinceResponseModel responseModel = addressService.getProvince(requestModel, id);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}

	@GetMapping("/getaddress")
	public HttpEntity<?> getAddress(@RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		return getAddress(email, token, requestId, requestDate, "0");
	}
	
	@GetMapping("/getaddress/{tbaId}")
	public HttpEntity<?> getAddress(@RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate, @PathVariable String tbaId) throws Exception {
		GetAddressRequestModel requestModel = new GetAddressRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetAddressResponseModel responseModel = addressService.getAddress(requestModel, tbaId);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@PutMapping("/updateaddress")
	@Transactional
	public HttpEntity<?> putUpdateAddress(@Valid @RequestBody PutUpdateAddressRequestModel requestModel) throws Exception {
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		PutUpdateAddressResponseModel responseModel = addressService.putUpdateAddress(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@PostMapping("/addaddress")
	@Transactional
	public HttpEntity<?> postAddAddress(@Valid @RequestBody PostAddressRequestModel requestModel) throws Exception {
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		PostAddressResponseModel responseModel = addressService.postAddAddress(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("403") ? HttpStatus.FORBIDDEN : (responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND));
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
}
