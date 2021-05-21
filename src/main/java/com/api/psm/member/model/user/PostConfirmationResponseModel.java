package com.api.psm.member.model.user;

import com.api.psm.member.db.entity.TbUser;
import com.api.psm.member.model.ResponseModel;

public class PostConfirmationResponseModel extends ResponseModel {
	
	public PostConfirmationResponseModel(PostConfirmationRequestModel requestModel) {
		super(requestModel);
	}
	
	private TbUser tbUsers;

	public TbUser getTbUsers() {
		return tbUsers;
	}

	public void setTbUsers(TbUser tbUsers) {
		this.tbUsers = tbUsers;
	}
}
