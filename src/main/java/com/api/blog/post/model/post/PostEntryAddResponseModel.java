package com.api.blog.post.model.post;

import com.api.blog.post.db.entity.TbEntry;
import com.api.blog.post.model.ResponseModel;

public class PostEntryAddResponseModel extends ResponseModel {

	public PostEntryAddResponseModel(PostEntryAddRequestModel requestModel) {
		super(requestModel);
	}

	private TbEntry tbEntry;

	public TbEntry getTbEntry() {
		return tbEntry;
	}

	public void setTbEntry(TbEntry tbEntry) {
		this.tbEntry = tbEntry;
	}
}
