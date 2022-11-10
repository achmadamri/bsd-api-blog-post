package com.api.blog.post.model.user;

import com.api.blog.post.model.ResponseModel;

public class PostUserChangePasswordResponseModel extends ResponseModel {

	public PostUserChangePasswordResponseModel(PostUserChangePasswordRequestModel requestModel) {
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
