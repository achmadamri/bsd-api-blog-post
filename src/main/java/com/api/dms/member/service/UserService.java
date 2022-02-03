package com.api.dms.member.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.dms.member.db.entity.TbUser;
import com.api.dms.member.db.entity.TbUserBrand;
import com.api.dms.member.db.entity.TbUserMenu;
import com.api.dms.member.db.entity.ViewUserBrand;
import com.api.dms.member.db.entity.ViewUserMenu;
import com.api.dms.member.db.repository.TbUserBrandRepository;
import com.api.dms.member.db.repository.TbUserMenuRepository;
import com.api.dms.member.db.repository.TbUserRepository;
import com.api.dms.member.db.repository.ViewUserBrandRepository;
import com.api.dms.member.db.repository.ViewUserMenuRepository;
import com.api.dms.member.model.auth.PostAddRequestModel;
import com.api.dms.member.model.auth.PutUpdateRequestModel;
import com.api.dms.member.model.user.GetUserListRequestModel;
import com.api.dms.member.model.user.GetUserListResponseModel;
import com.api.dms.member.model.user.GetUserMenuListRequestModel;
import com.api.dms.member.model.user.GetUserMenuListResponseModel;
import com.api.dms.member.model.user.GetUserRequestModel;
import com.api.dms.member.model.user.GetUserResponseModel;
import com.api.dms.member.model.user.PostUserAddRequestModel;
import com.api.dms.member.model.user.PostUserAddResponseModel;
import com.api.dms.member.model.user.PostUserEditRequestModel;
import com.api.dms.member.model.user.PostUserEditResponseModel;
import com.api.dms.member.model.user.TbBrand;
import com.api.dms.member.util.MD5;
import com.api.dms.member.util.SimpleMapper;
import com.api.dms.member.util.TokenUtil;
import com.api.dms.member.util.Uid;

@Service
public class UserService {

	private Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private Environment env;
	
	private TokenUtil tokenUtil = new TokenUtil();
	
	@Autowired
	private TbUserRepository tbUserRepository;
	
	@Autowired
	private TbUserBrandRepository tbUserBrandRepository;
	
	@Autowired
	private TbUserMenuRepository tbUserMenuRepository;
	
	@Autowired
	private ViewUserMenuRepository viewUserMenuRepository;
	
	@Autowired
	private ViewUserBrandRepository viewUserBrandRepository;
	
	public GetUserResponseModel getUser(String tbuId, GetUserRequestModel requestModel) throws Exception {
		GetUserResponseModel responseModel = new GetUserResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		
		if (tbuId.equals("")) {
			exampleTbUser.setTbuEmail(requestModel.getEmail());
		} else {
			exampleTbUser.setTbuId(Integer.valueOf(tbuId));
		}
		
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			responseModel.setTbUser(optTbUser.get());
			
			ViewUserMenu exampleViewUserMenu = new ViewUserMenu();
			exampleViewUserMenu.setTbuId(optTbUser.get().getTbuId());
			List<ViewUserMenu> lstViewUserMenu = viewUserMenuRepository.findAll(Example.of(exampleViewUserMenu), Sort.by("tbmName").ascending());
			responseModel.setLstViewUserMenu(lstViewUserMenu);
			
			ViewUserBrand exampleViewUserBrand = new ViewUserBrand();
			exampleViewUserBrand.setTbuId(optTbUser.get().getTbuId());
			List<ViewUserBrand> lstViewUserBrand = viewUserBrandRepository.findAll(Example.of(exampleViewUserBrand), Sort.by("tbbBrand").ascending());
			responseModel.setLstViewUserBrand(lstViewUserBrand);
			
			responseModel.setStatus("200");
			responseModel.setMessage("User ok");
		} else {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		}
		
		return responseModel;
	}
	
	public GetUserListResponseModel getUserList(String tbuEmail, String tbuFirstname, String tbuLastname, String length, String pageSize, String pageIndex, GetUserListRequestModel requestModel) throws Exception {
		GetUserListResponseModel responseModel = new GetUserListResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			ExampleMatcher matcher = ExampleMatcher.matching()
				.withMatcher("tbuEmail", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
				.withMatcher("tbuFirstname", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
				.withMatcher("tbuLastname", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
				;
	
			exampleTbUser = new TbUser();
			exampleTbUser.setTbuEmail(tbuEmail);
			exampleTbUser.setTbuFirstname(tbuFirstname);
			exampleTbUser.setTbuLastname(tbuLastname);
			
			Page<TbUser> pgTbUser = tbUserRepository.findAll(Example.of(exampleTbUser, matcher), PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by("tbuId").ascending()));
			
			if (pgTbUser.toList().size() > 0) {
				List<TbUser> lstTbUser = pgTbUser.toList();
				responseModel.setLstTbUser(lstTbUser);
				
				responseModel.setLength(tbUserRepository.count(Example.of(exampleTbUser, matcher)));
				
				responseModel.setStatus("200");
				responseModel.setMessage("Get User List ok");
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
	
	public GetUserMenuListResponseModel getUserMenuList(String tbuEmail, GetUserMenuListRequestModel requestModel) throws Exception {
		GetUserMenuListResponseModel responseModel = new GetUserMenuListResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			ViewUserMenu exampleViewUserMenu = new ViewUserMenu();	
			exampleViewUserMenu.setTbuEmail(tbuEmail.equals("") ? "admin@mail.com" : tbuEmail);
			
			List<ViewUserMenu> lstViewUserMenu = viewUserMenuRepository.findAll(Example.of(exampleViewUserMenu), Sort.by("tbmName").ascending());
			
			if (tbuEmail.equals("")) {
				for (ViewUserMenu viewUserMenu : lstViewUserMenu) {
					viewUserMenu.setTbumAdd(0);
					viewUserMenu.setTbumEdit(0);
					viewUserMenu.setTbumDelete(0);
					viewUserMenu.setTbumView(0);
				}
			}
			
			responseModel.setLstViewUserMenu(lstViewUserMenu);
			
			responseModel.setStatus("200");
			responseModel.setMessage("Get User Menu List ok");
		} else {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		}
		
		return responseModel;
	}
	
	public PostUserAddResponseModel postUserAdd(PostUserAddRequestModel requestModel) throws Exception {
		PostUserAddResponseModel responseModel = new PostUserAddResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
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
				tbUser.setTbuPassword(new MD5().get(requestModel.getTbUser().getTbuPassword()));
				tbUser.setTbuCreateDate(new Date());
				tbUser.setTbuCreateId(optTbUser.get().getTbuId());
				tbUser.setTbuStatus(TbUserRepository.Active);
				tbUser.setTbuTokenSalt(new Uid().generateString(36));
				tbUserRepository.save(tbUser);
				
				for (ViewUserMenu viewUserMenu : requestModel.getLstViewUserMenu()) {
					TbUserMenu tbUserMenu = new TbUserMenu();
					tbUserMenu.setTbumCreateDate(new Date());
					tbUserMenu.setTbumCreateId(optTbUser.get().getTbuId());
					tbUserMenu.setTbuId(tbUser.getTbuId());
					tbUserMenu.setTbmId(viewUserMenu.getTbmId());
					tbUserMenu.setTbumAdd(viewUserMenu.getTbumAdd());
					tbUserMenu.setTbumEdit(viewUserMenu.getTbumEdit());
					tbUserMenu.setTbumDelete(viewUserMenu.getTbumDelete());
					tbUserMenu.setTbumView(viewUserMenu.getTbumView());
					tbUserMenuRepository.save(tbUserMenu);
				}
				
				for (TbBrand tbBrand : requestModel.getLstTbBrand()) {
					TbUserBrand tbUserBrand = new TbUserBrand();
					tbUserBrand.setTbubCreateDate(new Date());
					tbUserBrand.setTbubCreateId(optTbUser.get().getTbuId());
					tbUserBrand.setTbuId(tbUser.getTbuId());
					tbUserBrand.setTbbBrand(tbBrand.getTbbBrand());					
					tbUserBrand.setTbbBrandId(tbBrand.getTbbBrandId());
					tbUserBrand.setTbbBrandCheck(tbBrand.getCheck());
					tbUserBrandRepository.save(tbUserBrand);
				}
				
				RestTemplate restTemplate = new RestTemplate();
				
				PostAddRequestModel postAddRequestModel = new PostAddRequestModel();
				postAddRequestModel.setEmail(requestModel.getEmail());
				postAddRequestModel.setToken(requestModel.getToken());
				postAddRequestModel.setTbaEmail(tbUser.getTbuEmail());
				postAddRequestModel.setTbaPassword(tbUser.getTbuPassword());
				postAddRequestModel.setTbaStatus(tbUser.getTbuStatus());
				postAddRequestModel.setTbaTokenSalt(tbUser.getTbuTokenSalt());
				HttpEntity<PostAddRequestModel> requestPostAdd = new HttpEntity<>(postAddRequestModel);
				restTemplate.postForEntity(env.getProperty("eblo-api-psm-auth") + "auth/postadd", requestPostAdd, String.class);
				
				SimpleMapper simpleMapper = new SimpleMapper();
				
				com.api.dms.member.model.order.PostUserAddRequestModel postUserAddOrderRequestModel = new com.api.dms.member.model.order.PostUserAddRequestModel();
				postUserAddOrderRequestModel.setEmail(requestModel.getEmail());
				postUserAddOrderRequestModel.setToken(requestModel.getToken());
				com.api.dms.member.model.order.TbUser postUserAddOrderTbUser = new com.api.dms.member.model.order.TbUser();
				postUserAddOrderTbUser = (com.api.dms.member.model.order.TbUser) simpleMapper.assign(tbUser, postUserAddOrderTbUser);
				postUserAddOrderRequestModel.setTbUser(postUserAddOrderTbUser);
				List<com.api.dms.member.model.order.TbUserBrand> lstOrderTbUserBrand = new ArrayList<com.api.dms.member.model.order.TbUserBrand>();
				for (TbBrand tbBrand : requestModel.getLstTbBrand()) {
					com.api.dms.member.model.order.TbUserBrand tbUserBrand = new com.api.dms.member.model.order.TbUserBrand();
					tbUserBrand.setTbuId(tbUser.getTbuId());
					tbUserBrand.setTbbBrand(tbBrand.getTbbBrand());					
					tbUserBrand.setTbbBrandId(tbBrand.getTbbBrandId());
					tbUserBrand.setTbbBrandCheck(tbBrand.getCheck());
					lstOrderTbUserBrand.add(tbUserBrand);
				}
				postUserAddOrderRequestModel.setLstTbUserBrand(lstOrderTbUserBrand);
				HttpEntity<com.api.dms.member.model.order.PostUserAddRequestModel> requestPostUserAddOrder = new HttpEntity<>(postUserAddOrderRequestModel);
				restTemplate.postForEntity(env.getProperty("eblo-api-psm-order") + "user/postuseradd", requestPostUserAddOrder, String.class);
				
				com.api.dms.member.model.product.PostUserAddRequestModel postUserAddProductRequestModel = new com.api.dms.member.model.product.PostUserAddRequestModel();
				postUserAddProductRequestModel.setEmail(requestModel.getEmail());
				postUserAddProductRequestModel.setToken(requestModel.getToken());
				com.api.dms.member.model.product.TbUser postUserAddProductTbUser = new com.api.dms.member.model.product.TbUser();
				postUserAddProductTbUser = (com.api.dms.member.model.product.TbUser) simpleMapper.assign(tbUser, postUserAddProductTbUser);
				postUserAddProductRequestModel.setTbUser(postUserAddProductTbUser);
				List<com.api.dms.member.model.product.TbUserBrand> lstProductTbUserBrand = new ArrayList<com.api.dms.member.model.product.TbUserBrand>();
				for (TbBrand tbBrand : requestModel.getLstTbBrand()) {
					com.api.dms.member.model.product.TbUserBrand tbUserBrand = new com.api.dms.member.model.product.TbUserBrand();
					tbUserBrand.setTbuId(tbUser.getTbuId());
					tbUserBrand.setTbbBrand(tbBrand.getTbbBrand());					
					tbUserBrand.setTbbBrandId(tbBrand.getTbbBrandId());
					tbUserBrand.setTbbBrandCheck(tbBrand.getCheck());
					lstProductTbUserBrand.add(tbUserBrand);
				}
				postUserAddProductRequestModel.setLstTbUserBrand(lstProductTbUserBrand);
				HttpEntity<com.api.dms.member.model.product.PostUserAddRequestModel> requestPostUserAddProduct = new HttpEntity<>(postUserAddProductRequestModel);
				restTemplate.postForEntity(env.getProperty("eblo-api-psm-product") + "user/postuseradd", requestPostUserAddProduct, String.class);
				
				com.api.dms.member.model.report.PostUserAddRequestModel postUserAddReportRequestModel = new com.api.dms.member.model.report.PostUserAddRequestModel();
				postUserAddReportRequestModel.setEmail(requestModel.getEmail());
				postUserAddReportRequestModel.setToken(requestModel.getToken());
				com.api.dms.member.model.report.TbUser postUserAddReportTbUser = new com.api.dms.member.model.report.TbUser();
				postUserAddReportTbUser = (com.api.dms.member.model.report.TbUser) simpleMapper.assign(tbUser, postUserAddReportTbUser);
				postUserAddReportRequestModel.setTbUser(postUserAddReportTbUser);
				List<com.api.dms.member.model.report.TbUserBrand> lstReportTbUserBrand = new ArrayList<com.api.dms.member.model.report.TbUserBrand>();
				for (TbBrand tbBrand : requestModel.getLstTbBrand()) {
					com.api.dms.member.model.report.TbUserBrand tbUserBrand = new com.api.dms.member.model.report.TbUserBrand();
					tbUserBrand.setTbuId(tbUser.getTbuId());
					tbUserBrand.setTbbBrand(tbBrand.getTbbBrand());					
					tbUserBrand.setTbbBrandId(tbBrand.getTbbBrandId());
					tbUserBrand.setTbbBrandCheck(tbBrand.getCheck());
					lstReportTbUserBrand.add(tbUserBrand);
				}
				postUserAddReportRequestModel.setLstTbUserBrand(lstReportTbUserBrand);
				HttpEntity<com.api.dms.member.model.report.PostUserAddRequestModel> requestPostUserAddReport = new HttpEntity<>(postUserAddReportRequestModel);
				restTemplate.postForEntity(env.getProperty("eblo-api-psm-report") + "user/postuseradd", requestPostUserAddReport, String.class);
			}
			
			responseModel.setStatus("200");
			responseModel.setMessage("User created");
		} else {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
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
				optTbUserExisting.get().setTbuFirstname(requestModel.getTbUser().getTbuFirstname());
				optTbUserExisting.get().setTbuLastname(requestModel.getTbUser().getTbuLastname());
				
				if (!requestModel.getTbUser().getTbuPassword().equals("")) {
					optTbUserExisting.get().setTbuPassword(new MD5().get(requestModel.getTbUser().getTbuPassword()));	
				}
				
				optTbUserExisting.get().setTbuUpdateDate(new Date());
				optTbUserExisting.get().setTbuUpdateId(optTbUser.get().getTbuId());
				tbUserRepository.save(optTbUserExisting.get());
				
				TbUserMenu exampleTbUserMenu = new TbUserMenu();
				exampleTbUserMenu.setTbuId(optTbUserExisting.get().getTbuId());
				List<TbUserMenu> lstTbUserMenu = tbUserMenuRepository.findAll(Example.of(exampleTbUserMenu));
				tbUserMenuRepository.deleteAll(lstTbUserMenu);
				for (ViewUserMenu viewUserMenu : requestModel.getLstViewUserMenu()) {
					TbUserMenu tbUserMenu = new TbUserMenu();
					tbUserMenu.setTbumCreateDate(new Date());
					tbUserMenu.setTbumCreateId(optTbUser.get().getTbuId());
					tbUserMenu.setTbuId(optTbUserExisting.get().getTbuId());
					tbUserMenu.setTbmId(viewUserMenu.getTbmId());
					tbUserMenu.setTbumAdd(viewUserMenu.getTbumAdd());
					tbUserMenu.setTbumEdit(viewUserMenu.getTbumEdit());
					tbUserMenu.setTbumDelete(viewUserMenu.getTbumDelete());
					tbUserMenu.setTbumView(viewUserMenu.getTbumView());
					tbUserMenuRepository.save(tbUserMenu);
				}
				
				TbUserBrand exampleTbUserBrand = new TbUserBrand();
				exampleTbUserBrand.setTbuId(optTbUserExisting.get().getTbuId());
				List<TbUserBrand> lstTbUserBrand = tbUserBrandRepository.findAll(Example.of(exampleTbUserBrand));
				tbUserBrandRepository.deleteAll(lstTbUserBrand);
				for (ViewUserBrand viewUserBrand : requestModel.getLstViewUserBrand()) {
					TbUserBrand tbUserBrand = new TbUserBrand();
					tbUserBrand.setTbubCreateDate(new Date());
					tbUserBrand.setTbubCreateId(optTbUser.get().getTbuId());
					tbUserBrand.setTbuId(optTbUserExisting.get().getTbuId());
					tbUserBrand.setTbbBrand(viewUserBrand.getTbbBrand());					
					tbUserBrand.setTbbBrandId(viewUserBrand.getTbbBrandId());
					tbUserBrand.setTbbBrandCheck(viewUserBrand.getTbbBrandCheck());
					tbUserBrandRepository.save(tbUserBrand);
				}
				
				RestTemplate restTemplate = new RestTemplate();
				
				if (!requestModel.getTbUser().getTbuPassword().equals("")) {
					PutUpdateRequestModel putUpdateRequestModel = new PutUpdateRequestModel();
					putUpdateRequestModel.setTbaEmail(optTbUserExisting.get().getTbuEmail());
					putUpdateRequestModel.setTbaPassword(optTbUserExisting.get().getTbuPassword());
					putUpdateRequestModel.setTbaStatus(optTbUserExisting.get().getTbuStatus());
					HttpEntity<PutUpdateRequestModel> requestPutUpdate = new HttpEntity<>(putUpdateRequestModel);
					restTemplate.put(env.getProperty("eblo-api-psm-auth") + "auth/putupdate", requestPutUpdate, String.class);					
				}
				
				SimpleMapper simpleMapper = new SimpleMapper();
				
				com.api.dms.member.model.order.PostUserEditRequestModel postUserEditOrderRequestModel = new com.api.dms.member.model.order.PostUserEditRequestModel();
				postUserEditOrderRequestModel.setEmail(requestModel.getEmail());
				postUserEditOrderRequestModel.setToken(requestModel.getToken());
				com.api.dms.member.model.order.TbUser postUserEditOrderTbUser = new com.api.dms.member.model.order.TbUser();
				postUserEditOrderTbUser = (com.api.dms.member.model.order.TbUser) simpleMapper.assign(optTbUserExisting.get(), postUserEditOrderTbUser);
				postUserEditOrderRequestModel.setTbUser(postUserEditOrderTbUser);
				List<com.api.dms.member.model.order.TbUserBrand> lstOrderTbUserBrand = new ArrayList<com.api.dms.member.model.order.TbUserBrand>();
				for (ViewUserBrand viewUserBrand : requestModel.getLstViewUserBrand()) {
					com.api.dms.member.model.order.TbUserBrand tbUserBrand = new com.api.dms.member.model.order.TbUserBrand();
					tbUserBrand.setTbuId(viewUserBrand.getTbuId());
					tbUserBrand.setTbbBrand(viewUserBrand.getTbbBrand());					
					tbUserBrand.setTbbBrandId(viewUserBrand.getTbbBrandId());
					tbUserBrand.setTbbBrandCheck(viewUserBrand.getTbbBrandCheck());
					lstOrderTbUserBrand.add(tbUserBrand);
				}
				postUserEditOrderRequestModel.setLstTbUserBrand(lstOrderTbUserBrand);
				HttpEntity<com.api.dms.member.model.order.PostUserEditRequestModel> requestPostUserEditOrder = new HttpEntity<>(postUserEditOrderRequestModel);
				restTemplate.postForEntity(env.getProperty("eblo-api-psm-order") + "user/postuseredit", requestPostUserEditOrder, String.class);
				
				com.api.dms.member.model.product.PostUserEditRequestModel postUserEditProductRequestModel = new com.api.dms.member.model.product.PostUserEditRequestModel();
				postUserEditProductRequestModel.setEmail(requestModel.getEmail());
				postUserEditProductRequestModel.setToken(requestModel.getToken());
				com.api.dms.member.model.product.TbUser postUserEditProductTbUser = new com.api.dms.member.model.product.TbUser();
				postUserEditProductTbUser = (com.api.dms.member.model.product.TbUser) simpleMapper.assign(optTbUserExisting.get(), postUserEditProductTbUser);
				postUserEditProductRequestModel.setTbUser(postUserEditProductTbUser);
				List<com.api.dms.member.model.product.TbUserBrand> lstProductTbUserBrand = new ArrayList<com.api.dms.member.model.product.TbUserBrand>();
				for (ViewUserBrand viewUserBrand : requestModel.getLstViewUserBrand()) {
					com.api.dms.member.model.product.TbUserBrand tbUserBrand = new com.api.dms.member.model.product.TbUserBrand();
					tbUserBrand.setTbuId(viewUserBrand.getTbuId());
					tbUserBrand.setTbbBrand(viewUserBrand.getTbbBrand());					
					tbUserBrand.setTbbBrandId(viewUserBrand.getTbbBrandId());
					tbUserBrand.setTbbBrandCheck(viewUserBrand.getTbbBrandCheck());
					lstProductTbUserBrand.add(tbUserBrand);
				}
				postUserEditProductRequestModel.setLstTbUserBrand(lstProductTbUserBrand);
				HttpEntity<com.api.dms.member.model.product.PostUserEditRequestModel> requestPostUserEditProduct = new HttpEntity<>(postUserEditProductRequestModel);
				restTemplate.postForEntity(env.getProperty("eblo-api-psm-product") + "user/postuseredit", requestPostUserEditProduct, String.class);

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