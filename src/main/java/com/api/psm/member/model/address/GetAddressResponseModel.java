package com.api.psm.member.model.address;

import java.util.List;

import com.api.psm.member.db.entity.TbAddress;
import com.api.psm.member.model.ResponseModel;

public class GetAddressResponseModel extends ResponseModel {

	public GetAddressResponseModel(GetAddressRequestModel requestModel) {
		super(requestModel);
	}
	
	private List<TbAddress> lstTbAddress;
	
	public List<TbAddress> getLstTbAddress() {
		return lstTbAddress;
	}

	public void setLstTbAddress(List<TbAddress> lstTbAddress) {
		this.lstTbAddress = lstTbAddress;
	}

}
