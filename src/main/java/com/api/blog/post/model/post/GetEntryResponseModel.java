package com.api.blog.post.model.post;

import java.util.List;

import com.api.blog.post.db.entity.TbComment;
import com.api.blog.post.db.entity.TbEntry;
import com.api.blog.post.model.ResponseModel;

public class GetEntryResponseModel extends ResponseModel {
	
	public GetEntryResponseModel(GetEntryRequestModel requestModel) {
		super(requestModel);
	}
	
	private TbEntry tbEntry;
	
	private List<TbComment> lstTbComment;

	public TbEntry getTbEntry() {
		return tbEntry;
	}

	public void setTbEntry(TbEntry tbEntry) {
		this.tbEntry = tbEntry;
	}

	public List<TbComment> getLstTbComment() {
		return lstTbComment;
	}

	public void setLstTbComment(List<TbComment> lstTbComment) {
		this.lstTbComment = lstTbComment;
	}
}
