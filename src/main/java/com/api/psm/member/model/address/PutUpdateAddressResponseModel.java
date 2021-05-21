package com.api.psm.member.model.address;

import com.api.psm.member.db.entity.TbAddress;
import com.api.psm.member.model.ResponseModel;

public class PutUpdateAddressResponseModel extends ResponseModel {

	public PutUpdateAddressResponseModel(PutUpdateAddressRequestModel requestModel) {
		super(requestModel);
	}

	private TbAddress tbAddress;

	public TbAddress getTbAddress() {
		return tbAddress;
	}

	public void setTbAddress(TbAddress tbAddress) {
		this.tbAddress = tbAddress;
	}
}
