package com.api.psm.member.model.user;

import java.util.List;

import com.api.psm.member.db.entity.TbBusiness;
import com.api.psm.member.db.entity.TbUser;
import com.api.psm.member.model.ResponseModel;

public class GetBusinessResponseModel extends ResponseModel {
	
	public GetBusinessResponseModel(GetBusinessRequestModel requestModel) {
		super(requestModel);
	}
	
	private TbUser tbUser;
	
	private List<TbBusiness> lstTbBusiness;

	public TbUser getTbUser() {
		return tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	public List<TbBusiness> getLstTbBusiness() {
		return lstTbBusiness;
	}

	public void setLstTbBusiness(List<TbBusiness> lstTbBusiness) {
		this.lstTbBusiness = lstTbBusiness;
	}
}
