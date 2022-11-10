package com.api.blog.post.model.post;

import java.util.List;

import com.api.blog.post.db.entity.TbUser;
import com.api.blog.post.db.entity.ViewUserEntry;
import com.api.blog.post.model.ResponseModel;

public class GetEntryListResponseModel extends ResponseModel {
	
	public GetEntryListResponseModel(GetEntryListRequestModel requestModel) {
		super(requestModel);
	}
	
	private List<ViewUserEntry> lstViewUserEntry;
	
	private Long length;

	public List<ViewUserEntry> getLstViewUserEntry() {
		return lstViewUserEntry;
	}

	public void setLstViewUserEntry(List<ViewUserEntry> lstViewUserEntry) {
		this.lstViewUserEntry = lstViewUserEntry;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}
}
