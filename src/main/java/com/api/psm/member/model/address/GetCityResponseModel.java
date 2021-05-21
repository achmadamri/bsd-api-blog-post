package com.api.psm.member.model.address;

import java.util.List;

import com.api.psm.member.db.entity.TbCity;
import com.api.psm.member.model.ResponseModel;

public class GetCityResponseModel extends ResponseModel {

	public GetCityResponseModel(GetCityRequestModel requestModel) {
		super(requestModel);
	}
	
	private List<TbCity> lstTbCity;
	
	public List<TbCity> getLstTbCity() {
		return lstTbCity;
	}

	public void setLstTbCity(List<TbCity> lstTbCity) {
		this.lstTbCity = lstTbCity;
	}

}
