package com.api.psm.member.model.userovertime;

import com.api.psm.member.db.entity.ViewUserOvertime;
import com.api.psm.member.model.ResponseModel;

public class GetUserOvertimeResponseModel extends ResponseModel {

	public GetUserOvertimeResponseModel(GetUserOvertimeRequestModel requestModel) {
		super(requestModel);
	}

	private ViewUserOvertime viewUserOvertime;

	public ViewUserOvertime getViewUserOvertime() {
		return viewUserOvertime;
	}

	public void setViewUserOvertime(ViewUserOvertime viewUserOvertime) {
		this.viewUserOvertime = viewUserOvertime;
	}
}
