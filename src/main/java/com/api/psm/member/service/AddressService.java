package com.api.psm.member.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.api.psm.member.db.entity.TbAddress;
import com.api.psm.member.db.entity.TbCity;
import com.api.psm.member.db.entity.TbDistrict;
import com.api.psm.member.db.entity.TbProvince;
import com.api.psm.member.db.entity.TbUser;
import com.api.psm.member.db.entity.TbVillage;
import com.api.psm.member.db.repository.TbAddressRepository;
import com.api.psm.member.db.repository.TbCityRepository;
import com.api.psm.member.db.repository.TbDistrictRepository;
import com.api.psm.member.db.repository.TbProvinceRepository;
import com.api.psm.member.db.repository.TbUserRepository;
import com.api.psm.member.db.repository.TbVillageRepository;
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
import com.api.psm.member.util.SimpleMapper;
import com.api.psm.member.util.TokenUtil;

@Service
public class AddressService {
	private TokenUtil tokenUtil = new TokenUtil();
	
	@Autowired
	private TbVillageRepository tbVillageRepository;
	
	@Autowired
	private TbDistrictRepository tbDistrictRepository;
	
	@Autowired
	private TbCityRepository tbCityRepository;
	
	@Autowired
	private TbProvinceRepository tbProvinceRepository;
	
	@Autowired
	private TbUserRepository tbUserRepository;
	
	@Autowired
	private TbAddressRepository tbAddressRepository;
	
	public GetVillageResponseModel getVillage(GetVillageRequestModel requestModel, String districtId, String id) throws Exception {
		GetVillageResponseModel responseModel = new GetVillageResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbVillage exampleTbVillage = new TbVillage();
		exampleTbVillage.setRegencyId(districtId);
		
		if ("0".equals(id)) {
			//
		} else {
			exampleTbVillage.setId(id);
		}

		responseModel.setLstTbVillage(tbVillageRepository.findAll(Example.of(exampleTbVillage)));
		
		if (responseModel.getLstTbVillage().size() == 0) {
			responseModel.setStatus("404");
			responseModel.setMessage("Village not found");	
		} else {
			responseModel.setStatus("200");
			responseModel.setMessage("Village ok");
		}
		
		return responseModel;
	}
	
	public GetDistrictResponseModel getDistrict(GetDistrictRequestModel requestModel, String cityId, String id) throws Exception {
		GetDistrictResponseModel responseModel = new GetDistrictResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbDistrict exampleTbDistrict = new TbDistrict();
		exampleTbDistrict.setRegencyId(cityId);
		
		if ("0".equals(id)) {
			//
		} else {
			exampleTbDistrict.setId(id);
		}

		responseModel.setLstTbDistrict(tbDistrictRepository.findAll(Example.of(exampleTbDistrict)));
		
		if (responseModel.getLstTbDistrict().size() == 0) {
			responseModel.setStatus("404");
			responseModel.setMessage("District not found");	
		} else {
			responseModel.setStatus("200");
			responseModel.setMessage("District ok");
		}
		
		return responseModel;
	}
	
	public GetCityResponseModel getCity(GetCityRequestModel requestModel, String provinceId, String id) throws Exception {
		GetCityResponseModel responseModel = new GetCityResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbCity exampleTbCity = new TbCity();
		exampleTbCity.setProvinceId(provinceId);
		
		if ("0".equals(id)) {
			//
		} else {
			exampleTbCity.setId(id);
		}

		responseModel.setLstTbCity(tbCityRepository.findAll(Example.of(exampleTbCity)));
		
		if (responseModel.getLstTbCity().size() == 0) {
			responseModel.setStatus("404");
			responseModel.setMessage("City not found");	
		} else {
			responseModel.setStatus("200");
			responseModel.setMessage("City ok");
		}
		
		return responseModel;
	}
	
	public GetProvinceResponseModel getProvince(GetProvinceRequestModel requestModel, String id) throws Exception {
		GetProvinceResponseModel responseModel = new GetProvinceResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbProvince exampleTbProvince = new TbProvince();
		
		if ("0".equals(id)) {
			//
		} else {
			exampleTbProvince.setId(id);
		}

		responseModel.setLstTbProvince(tbProvinceRepository.findAll(Example.of(exampleTbProvince)));
		
		if (responseModel.getLstTbProvince().size() == 0) {
			responseModel.setStatus("404");
			responseModel.setMessage("Province not found");
		} else {
			responseModel.setStatus("200");
			responseModel.setMessage("Province ok");
		}
		
		return responseModel;
	}
	
	public GetAddressResponseModel getAddress(GetAddressRequestModel requestModel, String tbaId) throws Exception {
		GetAddressResponseModel responseModel = new GetAddressResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUser.StatusActive);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		optTbUser.ifPresentOrElse(tbUser -> {
			TbAddress exampleTbAddress = new TbAddress();
			exampleTbAddress.setTbuId(tbUser.getTbuId());
			exampleTbAddress.setTbaId(Integer.valueOf(tbaId));
			
			if ("0".equals(tbaId)) {
				responseModel.setLstTbAddress(tbAddressRepository.findAll());
			} else {
				responseModel.setLstTbAddress(tbAddressRepository.findAll(Example.of(exampleTbAddress)));
			}
			
			if (responseModel.getLstTbAddress().size() == 0) {
				responseModel.setStatus("404");
				responseModel.setMessage("Address not found");	
			} else {
				responseModel.setStatus("200");
				responseModel.setMessage("Address ok");
			}
		}, () -> {
			responseModel.setStatus("404");
			responseModel.setMessage("User not found");
		});
		
		return responseModel;
	}
	
	public PutUpdateAddressResponseModel putUpdateAddress(PutUpdateAddressRequestModel requestModel) throws Exception {
		PutUpdateAddressResponseModel responseModel = new PutUpdateAddressResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUser.StatusActive);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		optTbUser.ifPresentOrElse(tbUser -> {
			SimpleMapper simpleMapper = new SimpleMapper();
			tbUser = (TbUser) simpleMapper.assign(requestModel, tbUser);
			
			TbAddress exampleTbAddress = new TbAddress();
			exampleTbAddress.setTbuId(tbUser.getTbuId());
			exampleTbAddress.setTbaId(requestModel.getTbaId());
			Optional<TbAddress> optTbAddress = tbAddressRepository.findOne(Example.of(exampleTbAddress));
			
			optTbAddress.ifPresentOrElse(tbAddress -> {
				tbAddress = (TbAddress) simpleMapper.assign(requestModel, tbAddress);
				
				responseModel.setTbAddress(tbAddress);
				responseModel.setStatus("200");
				responseModel.setMessage("Address updated");
			}, () -> {
				responseModel.setStatus("404");
				responseModel.setMessage("Address not found");
			});
		}, () -> {
			responseModel.setStatus("404");
			responseModel.setMessage("Email not found");
		});
		
		return responseModel;
	}
	
	public PostAddressResponseModel postAddAddress(PostAddressRequestModel requestModel) throws Exception {
		PostAddressResponseModel responseModel = new PostAddressResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUser.StatusActive);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		optTbUser.ifPresentOrElse(tbUser -> {
			TbAddress exampleTbAddress = new TbAddress();
			exampleTbAddress.setTbuId(tbUser.getTbuId());
			
			if (tbAddressRepository.count(Example.of(exampleTbAddress)) >= 5) {
				responseModel.setStatus("403");
				responseModel.setMessage("Address already 5");
			} else {
				TbAddress tbAddress = new TbAddress();
				SimpleMapper simpleMapper = new SimpleMapper();
				tbAddress = (TbAddress) simpleMapper.assign(requestModel, tbAddress);
				
				tbAddress.setTbaCreateDate(new Date());
				tbAddress.setTbaCreateId(0);
				tbAddress.setTbuId(tbUser.getTbuId());
				tbAddress.setTbaStatus(TbAddress.statusDefault);
				
				tbAddressRepository.save(tbAddress);
				
				responseModel.setTbAddress(tbAddress);
				responseModel.setStatus("200");
				responseModel.setMessage("Address created");
			}
		}, () -> {
			responseModel.setStatus("404");
			responseModel.setMessage("Email not found");
		});
		
		return responseModel;
	}
}
