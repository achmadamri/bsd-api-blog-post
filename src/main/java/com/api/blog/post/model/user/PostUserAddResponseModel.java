package com.api.blog.post.model.user;

import com.api.blog.post.model.RequestModel;
import com.api.blog.post.model.ResponseModel;

public class PostUserAddResponseModel extends ResponseModel {

	public PostUserAddResponseModel(RequestModel requestModel) {
		super(requestModel);
	}

	private TbUser tbUser;
	
	public TbUser getTbUser() {
		return tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}
}
