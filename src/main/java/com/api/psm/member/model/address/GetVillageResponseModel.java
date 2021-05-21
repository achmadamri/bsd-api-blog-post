package com.api.psm.member.model.address;

import java.util.List;

import com.api.psm.member.db.entity.TbVillage;
import com.api.psm.member.model.ResponseModel;

public class GetVillageResponseModel extends ResponseModel {

	public GetVillageResponseModel(GetVillageRequestModel requestModel) {
		super(requestModel);
	}
	
	private List<TbVillage> lstTbVillage;

	public List<TbVillage> getLstTbVillage() {
		return lstTbVillage;
	}

	public void setLstTbVillage(List<TbVillage> lstTbVillage) {
		this.lstTbVillage = lstTbVillage;
	}

}
