package com.api.psm.member.model.user;

import java.util.List;

import com.api.psm.member.db.entity.TbDepartment;
import com.api.psm.member.db.entity.TbUser;
import com.api.psm.member.model.ResponseModel;

public class GetDepartmentResponseModel extends ResponseModel {
	
	public GetDepartmentResponseModel(GetDepartmentRequestModel requestModel) {
		super(requestModel);
	}
	
	private TbUser tbUser;
	
	private List<TbDepartment> lstTbDepartment;

	public TbUser getTbUser() {
		return tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	public List<TbDepartment> getLstTbDepartment() {
		return lstTbDepartment;
	}

	public void setLstTbDepartment(List<TbDepartment> lstTbDepartment) {
		this.lstTbDepartment = lstTbDepartment;
	}
}
