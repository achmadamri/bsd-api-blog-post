package com.api.psm.member.model.address;

import java.util.List;

import com.api.psm.member.db.entity.TbProvince;
import com.api.psm.member.model.ResponseModel;

public class GetProvinceResponseModel extends ResponseModel {

	public GetProvinceResponseModel(GetProvinceRequestModel requestModel) {
		super(requestModel);
	}
	
	private List<TbProvince> lstTbProvince;
	
	public List<TbProvince> getLstTbProvince() {
		return lstTbProvince;
	}

	public void setLstTbProvince(List<TbProvince> lstTbProvince) {
		this.lstTbProvince = lstTbProvince;
	}

}
