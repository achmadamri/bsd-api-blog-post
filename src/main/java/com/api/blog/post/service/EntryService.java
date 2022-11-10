package com.api.blog.post.service;

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
import org.springframework.stereotype.Service;

import com.api.blog.post.db.entity.TbComment;
import com.api.blog.post.db.entity.TbEntry;
import com.api.blog.post.db.entity.TbUser;
import com.api.blog.post.db.entity.ViewUserEntry;
import com.api.blog.post.db.repository.TbCommentRepository;
import com.api.blog.post.db.repository.TbEntryRepository;
import com.api.blog.post.db.repository.TbUserRepository;
import com.api.blog.post.db.repository.ViewUserEntryRepository;
import com.api.blog.post.model.post.GetEntryListRequestModel;
import com.api.blog.post.model.post.GetEntryListResponseModel;
import com.api.blog.post.model.post.GetEntryRequestModel;
import com.api.blog.post.model.post.GetEntryResponseModel;
import com.api.blog.post.model.post.PostEntryAddRequestModel;
import com.api.blog.post.model.post.PostEntryAddResponseModel;
import com.api.blog.post.model.post.PostEntryCommentRequestModel;
import com.api.blog.post.model.post.PostEntryCommentResponseModel;
import com.api.blog.post.model.post.PostEntryDeleteRequestModel;
import com.api.blog.post.model.post.PostEntryDeleteResponseModel;
import com.api.blog.post.model.post.PostEntryEditRequestModel;
import com.api.blog.post.model.post.PostEntryEditResponseModel;
import com.api.blog.post.util.TokenUtil;

@Service
public class EntryService {

	private Logger log = LoggerFactory.getLogger(EntryService.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private TokenUtil tokenUtil;
	
	@Autowired
	private TbUserRepository tbUserRepository;
	
	@Autowired
	private ViewUserEntryRepository viewUserEntryRepository;
	
	@Autowired
	private TbEntryRepository tbEntryRepository;
	
	@Autowired
	private TbCommentRepository tbCommentRepository;
	
	public GetEntryListResponseModel getEntryList(String tbeTitle, String tbeChunk, String tbeContent, String length, String pageSize, String pageIndex, GetEntryListRequestModel requestModel) throws Exception {
		GetEntryListResponseModel responseModel = new GetEntryListResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			ExampleMatcher matcher = ExampleMatcher.matching()
				.withMatcher("tbeTitle", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
				.withMatcher("tbeChunk", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
				.withMatcher("tbeContent", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
				;
	
			ViewUserEntry viewUserEntry = new ViewUserEntry();
			viewUserEntry.setTbeTitle(tbeTitle);
			viewUserEntry.setTbeChunk(tbeChunk);
			viewUserEntry.setTbeContent(tbeContent);
			
			Page<ViewUserEntry> pgViewUserEntry = viewUserEntryRepository.findAll(Example.of(viewUserEntry, matcher), PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by("tbeId").ascending()));
			
			if (pgViewUserEntry.toList().size() > 0) {
				List<ViewUserEntry> lstViewUserEntry = pgViewUserEntry.toList();
				responseModel.setLstViewUserEntry(lstViewUserEntry);
				
				responseModel.setLength(viewUserEntryRepository.count(Example.of(viewUserEntry, matcher)));
				
				responseModel.setStatus("200");
				responseModel.setMessage("Get Entry List ok");
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
	
	public GetEntryListResponseModel getEntryView(String tbeTitle, String tbeChunk, String tbeContent, String length, String pageSize, String pageIndex, GetEntryListRequestModel requestModel) throws Exception {
		GetEntryListResponseModel responseModel = new GetEntryListResponseModel(requestModel);
		
		ViewUserEntry viewUserEntry = new ViewUserEntry();
		
		Page<ViewUserEntry> pgViewUserEntry = viewUserEntryRepository.findAll(Example.of(viewUserEntry), PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by("tbeCreateDate").descending()));
		
		if (pgViewUserEntry.toList().size() > 0) {
			List<ViewUserEntry> lstViewUserEntry = pgViewUserEntry.toList();
			responseModel.setLstViewUserEntry(lstViewUserEntry);
			
			responseModel.setLength(viewUserEntryRepository.count(Example.of(viewUserEntry)));
			
			responseModel.setStatus("200");
			responseModel.setMessage("Get Entry List ok");
		} else {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		}
		
		return responseModel;
	}
	
	public PostEntryAddResponseModel postEntryAdd(PostEntryAddRequestModel requestModel) throws Exception {
		PostEntryAddResponseModel responseModel = new PostEntryAddResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			TbEntry tbEntry = new TbEntry();
			tbEntry.setTbeCreateDate(new Date());
			tbEntry.setTbeCreateId(optTbUser.get().getTbuId());
			tbEntry.setTbeTitle(requestModel.getTbEntry().getTbeTitle());
			tbEntry.setTbeContent(requestModel.getTbEntry().getTbeContent());
			tbEntry.setTbeChunk(tbEntry.getTbeContent().length() > 100 ? tbEntry.getTbeContent().substring(0, 100) : tbEntry.getTbeContent().substring(0, tbEntry.getTbeContent().length()));
			
			tbEntryRepository.save(tbEntry);
			
			responseModel.setStatus("200");
			responseModel.setMessage("Entry created");
		} else {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		}
		
		return responseModel;
	}
	
	public PostEntryCommentResponseModel postEntryComment(PostEntryCommentRequestModel requestModel) throws Exception {
		PostEntryCommentResponseModel responseModel = new PostEntryCommentResponseModel(requestModel);
		
		Optional<TbEntry> optTbEntry = tbEntryRepository.findById(requestModel.getTbEntry().getTbeId());
		
		if (optTbEntry.isPresent()) {
			TbComment tbComment = new TbComment();
			tbComment.setTbcCreateDate(new Date());
			tbComment.setTbcCreateId(0);
			tbComment.setTbeId(optTbEntry.get().getTbeId());
			tbComment.setTbcContent(requestModel.getTbComment().getTbcContent());
			
			tbCommentRepository.save(tbComment);
			
			responseModel.setStatus("200");
			responseModel.setMessage("Comment created");
		} else {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		}
		
		return responseModel;
	}
	
	public GetEntryResponseModel getEntry(String tbeId, GetEntryRequestModel requestModel) throws Exception {
		GetEntryResponseModel responseModel = new GetEntryResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			Optional<TbEntry> optTbEntry = tbEntryRepository.findById(Integer.valueOf(tbeId));
			
			if (optTbEntry.isPresent()) {
				responseModel.setTbEntry(optTbEntry.get());
				
				responseModel.setStatus("200");
				responseModel.setMessage("Entry ok");				
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
	
	public GetEntryResponseModel getEntryPost(String tbeId, GetEntryRequestModel requestModel) throws Exception {
		GetEntryResponseModel responseModel = new GetEntryResponseModel(requestModel);
		
		Optional<TbEntry> optTbEntry = tbEntryRepository.findById(Integer.valueOf(tbeId));
		
		if (optTbEntry.isPresent()) {
			optTbEntry.get().setTbeCounter(optTbEntry.get().getTbeCounter() == null ? 1 : optTbEntry.get().getTbeCounter() + 1);
			tbEntryRepository.save(optTbEntry.get());
			
			responseModel.setTbEntry(optTbEntry.get());
			
			TbComment exampleTbComment = new TbComment();
			exampleTbComment.setTbeId(optTbEntry.get().getTbeId());
			
			List<TbComment> lstTbComment = tbCommentRepository.findAll(Example.of(exampleTbComment), Sort.by("tbcId").ascending());
			responseModel.setLstTbComment(lstTbComment);
			
			responseModel.setStatus("200");
			responseModel.setMessage("Entry ok");				
		} else {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		}
		
		return responseModel;
	}
	
	public PostEntryEditResponseModel postEntryEdit(PostEntryEditRequestModel requestModel) throws Exception {
		PostEntryEditResponseModel responseModel = new PostEntryEditResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			Optional<TbEntry> optTbEntry = tbEntryRepository.findById(Integer.valueOf(requestModel.getTbEntry().getTbeId()));
			
			if (optTbEntry.isPresent()) {
				optTbEntry.get().setTbeUpdateDate(new Date());
				optTbEntry.get().setTbeUpdateId(optTbUser.get().getTbuId());
				optTbEntry.get().setTbeTitle(requestModel.getTbEntry().getTbeTitle());
				optTbEntry.get().setTbeContent(requestModel.getTbEntry().getTbeContent());
				optTbEntry.get().setTbeChunk(optTbEntry.get().getTbeContent().length() > 100 ? optTbEntry.get().getTbeContent().substring(0, 100) : optTbEntry.get().getTbeContent().substring(0, optTbEntry.get().getTbeContent().length()));
				
				responseModel.setTbEntry(optTbEntry.get());
				
				tbEntryRepository.save(optTbEntry.get());
				
				responseModel.setStatus("200");
				responseModel.setMessage("Entry updated");				
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
	
	public PostEntryDeleteResponseModel postEntryDelete(PostEntryDeleteRequestModel requestModel) throws Exception {
		PostEntryDeleteResponseModel responseModel = new PostEntryDeleteResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			Optional<TbEntry> optTbEntry = tbEntryRepository.findById(Integer.valueOf(requestModel.getTbEntry().getTbeId()));
			
			if (optTbEntry.isPresent()) {
				tbEntryRepository.delete(optTbEntry.get());
				
				responseModel.setStatus("200");
				responseModel.setMessage("Entry deleted");				
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
