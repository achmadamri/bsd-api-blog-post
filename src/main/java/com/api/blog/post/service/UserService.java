package com.api.blog.post.service;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.api.blog.post.db.entity.TbUser;
import com.api.blog.post.db.repository.TbUserRepository;
import com.api.blog.post.model.user.PostUserAddRequestModel;
import com.api.blog.post.model.user.PostUserAddResponseModel;
import com.api.blog.post.model.user.PostUserEditRequestModel;
import com.api.blog.post.model.user.PostUserEditResponseModel;
import com.api.blog.post.util.TokenUtil;

@Service
public class UserService {

	private Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private Environment env;
	
	private TokenUtil tokenUtil = new TokenUtil();
	
	@Autowired
	private TbUserRepository tbUserRepository;
	
	public PostUserAddResponseModel postUserAdd(PostUserAddRequestModel requestModel) throws Exception {
		PostUserAddResponseModel responseModel = new PostUserAddResponseModel(requestModel);
		
		TbUser exampleTbUserNew = new TbUser();
		exampleTbUserNew.setTbuEmail(requestModel.getTbUser().getTbuEmail());
		Optional<TbUser> optTbUserNew = tbUserRepository.findOne(Example.of(exampleTbUserNew));
		
		if (optTbUserNew.isPresent()) {
			responseModel.setStatus("403");
			responseModel.setMessage("Data already exists. Email : " + requestModel.getTbUser().getTbuEmail());
		} else {
			TbUser tbUser = new TbUser();
			tbUser.setTbuEmail(requestModel.getTbUser().getTbuEmail());
			tbUser.setTbuFirstname(requestModel.getTbUser().getTbuFirstname());
			tbUser.setTbuLastname(requestModel.getTbUser().getTbuLastname());
			tbUser.setTbuPassword(requestModel.getTbUser().getTbuPassword());
			tbUser.setTbuCreateDate(new Date());
			tbUser.setTbuCreateId(0);
			tbUser.setTbuStatus(requestModel.getTbUser().getTbuStatus());
			tbUser.setTbuTokenSalt(requestModel.getTbUser().getTbuTokenSalt());
			tbUser.setTbuRole(requestModel.getTbUser().getTbuRole());
			tbUserRepository.save(tbUser);
			
			responseModel.setStatus("200");
			responseModel.setMessage("User created");
		}
		
		return responseModel;
	}
	
	public PostUserEditResponseModel postUserEdit(PostUserEditRequestModel requestModel) throws Exception {
		PostUserEditResponseModel responseModel = new PostUserEditResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			TbUser exampleTbUserExisting = new TbUser();
			exampleTbUserExisting.setTbuEmail(requestModel.getTbUser().getTbuEmail());
			Optional<TbUser> optTbUserExisting = tbUserRepository.findOne(Example.of(exampleTbUserExisting));
			
			if (optTbUserExisting.isPresent()) {
				optTbUserExisting.get().setTbuRole(requestModel.getTbUser().getTbuRole());
				optTbUserExisting.get().setTbuFirstname(requestModel.getTbUser().getTbuFirstname());
				optTbUserExisting.get().setTbuLastname(requestModel.getTbUser().getTbuLastname());
				
				if (!requestModel.getTbUser().getTbuPassword().equals("")) {
					optTbUserExisting.get().setTbuPassword(requestModel.getTbUser().getTbuPassword());
				}
				
				optTbUserExisting.get().setTbuUpdateDate(new Date());
				optTbUserExisting.get().setTbuUpdateId(optTbUser.get().getTbuId());
				tbUserRepository.save(optTbUserExisting.get());
				
				responseModel.setStatus("200");
				responseModel.setMessage("User updated");
			} else {
				responseModel.setStatus("404");
				responseModel.setMessage("Not found");
			}
		} else {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		}
		
		return responseModel;
	}
}
