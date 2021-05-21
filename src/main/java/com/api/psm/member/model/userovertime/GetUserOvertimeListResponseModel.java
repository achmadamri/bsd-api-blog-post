package com.api.psm.member.model.userovertime;

import java.util.List;

import com.api.psm.member.db.entity.ViewUserOvertime;
import com.api.psm.member.model.ResponseModel;

public class GetUserOvertimeListResponseModel extends ResponseModel {

	public GetUserOvertimeListResponseModel(GetUserOvertimeListRequestModel requestModel) {
		super(requestModel);
	}
	
	private List<ViewUserOvertime> lstViewUserOvertime;

	public List<ViewUserOvertime> getLstViewUserOvertime() {
		return lstViewUserOvertime;
	}

	public void setLstViewUserOvertime(List<ViewUserOvertime> lstViewUserOvertime) {
		this.lstViewUserOvertime = lstViewUserOvertime;
	}
}
