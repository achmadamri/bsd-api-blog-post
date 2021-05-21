package com.api.psm.member.model.user;

import java.util.List;

import com.api.psm.member.db.entity.TbAddress;
import com.api.psm.member.db.entity.TbUser;
import com.api.psm.member.model.ResponseModel;

public class GetUserResponseModel extends ResponseModel {
	
	public GetUserResponseModel(GetUserRequestModel requestModel) {
		super(requestModel);
	}
	
	private TbUser tbUser;
	
	private List<TbAddress> lstTbAddress;

	public TbUser getTbUser() {
		return tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	public List<TbAddress> getLstTbAddress() {
		return lstTbAddress;
	}

	public void setLstTbAddress(List<TbAddress> lstTbAddress) {
		this.lstTbAddress = lstTbAddress;
	}
}
