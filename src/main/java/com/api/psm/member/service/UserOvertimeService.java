package com.api.psm.member.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.api.psm.member.db.entity.TbUser;
import com.api.psm.member.db.entity.ViewUserOvertime;
import com.api.psm.member.db.repository.TbUserRepository;
import com.api.psm.member.db.repository.ViewUserOvertimeRepository;
import com.api.psm.member.model.userovertime.GetUserOvertimeListRequestModel;
import com.api.psm.member.model.userovertime.GetUserOvertimeListResponseModel;
import com.api.psm.member.model.userovertime.GetUserOvertimeRequestModel;
import com.api.psm.member.model.userovertime.GetUserOvertimeResponseModel;
import com.api.psm.member.util.StringUtil;
import com.api.psm.member.util.TokenUtil;


@Service
public class UserOvertimeService {

	private TokenUtil tokenUtil = new TokenUtil();

	@Autowired
	private TbUserRepository tbUserRepository;

	@Autowired
	private ViewUserOvertimeRepository viewUserOvertimeRepository;
	
	public GetUserOvertimeResponseModel getUserOvertime(GetUserOvertimeRequestModel requestModel, String tbuoId) throws Exception {
		GetUserOvertimeResponseModel responseModel = new GetUserOvertimeResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUser.StatusActive);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		optTbUser.ifPresentOrElse(tbUser -> {
			ViewUserOvertime exampleUserOvertime = new ViewUserOvertime();
			exampleUserOvertime.setTbuoId(Integer.valueOf(tbuoId));
			Optional<ViewUserOvertime> optViewUserOvertime = viewUserOvertimeRepository.findOne(Example.of(exampleUserOvertime));
			
			optViewUserOvertime.ifPresentOrElse(viewUserOvertime -> {
				responseModel.setViewUserOvertime(viewUserOvertime);
				
				responseModel.setStatus("200");
				responseModel.setMessage("Overtime ok");
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
	
	public GetUserOvertimeListResponseModel getOvertimeList(GetUserOvertimeListRequestModel requestModel, String tbbId, String tbpId, String period) throws Exception {
		GetUserOvertimeListResponseModel responseModel = new GetUserOvertimeListResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUser.StatusActive);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		optTbUser.ifPresentOrElse(tbUser -> {
			ExampleMatcher exampleMatcher = ExampleMatcher.matching()
					.withMatcher("tbuoOutDate", ExampleMatcher.GenericPropertyMatchers.contains().contains());
			
			ViewUserOvertime exampleViewUserOvertime = new ViewUserOvertime();
			
			StringUtil stringUtil = new StringUtil();
			if (Integer.valueOf(stringUtil.stringToInteger(tbbId)) != 0 || Integer.valueOf(stringUtil.stringToInteger(tbpId)) != 0 || Integer.valueOf(stringUtil.stringToInteger(period)) != 0) {
				if (Integer.valueOf(stringUtil.stringToInteger(tbbId)) != 0) {
					exampleViewUserOvertime.setTbbId(Integer.valueOf(stringUtil.stringToInteger(tbbId)));
				}
				if (Integer.valueOf(stringUtil.stringToInteger(tbpId)) != 0) {
					exampleViewUserOvertime.setTbpId(Integer.valueOf(stringUtil.stringToInteger(tbpId)));
				}
				if (Integer.valueOf(stringUtil.stringToInteger(period)) != 0) {
					int year = Calendar.getInstance().get(Calendar.YEAR);
					exampleViewUserOvertime.setTbuoOutDate(String.valueOf(year).concat("-").concat(period));
				}
				
				Page<ViewUserOvertime> pgViewUserOvertime = viewUserOvertimeRepository.findAll(Example.of(exampleViewUserOvertime, exampleMatcher), PageRequest.of(0, 999999, Sort.by("tbuFirstname").ascending()));
				
				if (pgViewUserOvertime.toList().size() > 0) {
					List<ViewUserOvertime> lstViewUserOvertime = pgViewUserOvertime.toList();
					responseModel.setLstViewUserOvertime(lstViewUserOvertime);
					
					responseModel.setStatus("200");
					responseModel.setMessage("Get User Overtime ok");
				} else {
					responseModel.setStatus("404");
					responseModel.setMessage("Not found");
				}
			} else {
				responseModel.setStatus("404");
				responseModel.setMessage("Not found");
			}
		}, () -> {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		});
		
		return responseModel;
	}
}
