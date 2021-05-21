package com.api.psm.member.model.userattendance;

import java.util.List;

import com.api.psm.member.db.entity.ViewUserOvertime;
import com.api.psm.member.model.ResponseModel;

public class GetUserOvertimeResponseModel extends ResponseModel {

	public GetUserOvertimeResponseModel(GetUserOvertimeRequestModel requestModel) {
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
