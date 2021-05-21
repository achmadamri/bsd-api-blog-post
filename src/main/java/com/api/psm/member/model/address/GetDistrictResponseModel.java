package com.api.psm.member.model.address;

import java.util.List;

import com.api.psm.member.db.entity.TbDistrict;
import com.api.psm.member.model.ResponseModel;

public class GetDistrictResponseModel extends ResponseModel {

	public GetDistrictResponseModel(GetDistrictRequestModel requestModel) {
		super(requestModel);
	}
	
	private List<TbDistrict> lstTbDistrict;

	public List<TbDistrict> getLstTbDistrict() {
		return lstTbDistrict;
	}

	public void setLstTbDistrict(List<TbDistrict> lstTbDistrict) {
		this.lstTbDistrict = lstTbDistrict;
	}

}
