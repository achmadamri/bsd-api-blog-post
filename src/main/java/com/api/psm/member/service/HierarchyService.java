package com.api.psm.member.service;

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
import com.api.psm.member.db.entity.ViewHierarchyUser;
import com.api.psm.member.db.repository.TbUserRepository;
import com.api.psm.member.db.repository.ViewHierarchyUserRepository;
import com.api.psm.member.model.hierarchy.GetHierarchyRequestModel;
import com.api.psm.member.model.hierarchy.GetHierarchyResponseModel;
import com.api.psm.member.util.TokenUtil;

@Service
public class HierarchyService {

	private TokenUtil tokenUtil = new TokenUtil();

	@Autowired
	private TbUserRepository tbUserRepository;

	@Autowired
	private ViewHierarchyUserRepository viewHierarchyUserRepository;
	
	public GetHierarchyResponseModel getHierarchyUser(GetHierarchyRequestModel requestModel, String tbuId, String nama) throws Exception {
		GetHierarchyResponseModel responseModel = new GetHierarchyResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		if (tbuId.equals("0")) {
			exampleTbUser.setTbuEmail(requestModel.getEmail());
		} else {
			exampleTbUser.setTbuId(Integer.valueOf(tbuId));
		}
		
		exampleTbUser.setTbuStatus(TbUser.StatusActive);
		
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		optTbUser.ifPresentOrElse(tbUser -> {
			responseModel.setTbUser(tbUser);
			
			ExampleMatcher caseInsensitiveExampleMatcherSpv = ExampleMatcher.matching()
				    .withMatcher("tbuIdSubordinate", ExampleMatcher.GenericPropertyMatchers.contains().exact())
				    .withMatcher("tbuspvTbuFirstname", ExampleMatcher.GenericPropertyMatchers.contains().contains().ignoreCase());
			
			ViewHierarchyUser exampleViewHierarchyUserSpv = new ViewHierarchyUser();
			exampleViewHierarchyUserSpv.setTbuIdSubordinate(tbUser.getTbuId());
			exampleViewHierarchyUserSpv.setTbuspvTbuFirstname(nama);
			exampleViewHierarchyUserSpv.setTbhStatus("direct");
			
			Page<ViewHierarchyUser> pgViewHierarchyUserSpv = viewHierarchyUserRepository.findAll(Example.of(exampleViewHierarchyUserSpv, caseInsensitiveExampleMatcherSpv), PageRequest.of(0, 999999, Sort.by("tbuspvTbuFirstname").ascending()));
			
			if (pgViewHierarchyUserSpv.toList().size() > 0) {
				List<ViewHierarchyUser> lstViewHierarchyUser = pgViewHierarchyUserSpv.toList();
				
				responseModel.setLstViewHierarchyUserSpv(lstViewHierarchyUser);
			}
			
			ExampleMatcher caseInsensitiveExampleMatcherSub = ExampleMatcher.matching()
				    .withMatcher("tbuIdSupervisor", ExampleMatcher.GenericPropertyMatchers.contains().exact())
				    .withMatcher("tbusubTbuFirstname", ExampleMatcher.GenericPropertyMatchers.contains().contains().ignoreCase());
			
			ViewHierarchyUser exampleViewHierarchyUserSub = new ViewHierarchyUser();
			exampleViewHierarchyUserSub.setTbuIdSupervisor(tbUser.getTbuId());
			exampleViewHierarchyUserSub.setTbusubTbuFirstname(nama);
			exampleViewHierarchyUserSub.setTbhStatus("direct");
			
			Page<ViewHierarchyUser> pgViewHierarchyUserSub = viewHierarchyUserRepository.findAll(Example.of(exampleViewHierarchyUserSub, caseInsensitiveExampleMatcherSub), PageRequest.of(0, 999999, Sort.by("tbusubTbuFirstname").ascending()));
			
			if (pgViewHierarchyUserSub.toList().size() > 0) {
				List<ViewHierarchyUser> lstViewHierarchyUser = pgViewHierarchyUserSub.toList();
				
				responseModel.setLstViewHierarchyUserSub(lstViewHierarchyUser);
			}
			
			responseModel.setStatus("200");
			responseModel.setMessage("Hierarchy ok");
		}, () -> {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		});
		
		return responseModel;
	}
}
