package com.api.psm.member.model.user;

import com.api.psm.member.db.entity.TbUser;
import com.api.psm.member.model.ResponseModel;

public class PutUpdateResponseModel extends ResponseModel {
	
	public PutUpdateResponseModel(PutUpdateRequestModel requestModel) {
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
