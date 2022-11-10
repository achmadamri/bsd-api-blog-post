package com.api.blog.post.model.post;

import com.api.blog.post.db.entity.TbEntry;
import com.api.blog.post.model.ResponseModel;

public class PostEntryDeleteResponseModel extends ResponseModel {

	public PostEntryDeleteResponseModel(PostEntryDeleteRequestModel requestModel) {
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
