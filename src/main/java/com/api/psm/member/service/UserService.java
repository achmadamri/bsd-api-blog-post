package com.api.psm.member.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Example;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.api.psm.member.db.entity.TbUser;
import com.api.psm.member.db.repository.TbUserRepository;
import com.api.psm.member.model.user.GetUserRequestModel;
import com.api.psm.member.model.user.GetUserResponseModel;
import com.api.psm.member.util.TokenUtil;

@Service
public class UserService {

	private Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private Environment env;
	
	private TokenUtil tokenUtil = new TokenUtil();
	
	@Autowired
	private TbUserRepository tbUserRepository;
	
	public GetUserResponseModel getUser(GetUserRequestModel requestModel) throws Exception {
		GetUserResponseModel responseModel = new GetUserResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		optTbUser.ifPresentOrElse(tbUser -> {
			responseModel.setTbUser(tbUser);
			
			responseModel.setStatus("200");
			responseModel.setMessage("User ok");
		}, () -> {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		});
		
		return responseModel;
	}
}
