package com.api.psm.member.model.userattendance;

import com.api.psm.member.db.entity.TbUser;
import com.api.psm.member.db.entity.ViewUserAttendance;
import com.api.psm.member.model.ResponseModel;

public class GetAttendanceDetailResponseModel extends ResponseModel {

	public GetAttendanceDetailResponseModel(GetAttendanceDetailRequestModel requestModel) {
		super(requestModel);
	}

	private TbUser tbUser;

	private ViewUserAttendance viewUserAttendance;

	public TbUser getTbUser() {
		return tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	public ViewUserAttendance getViewUserAttendance() {
		return viewUserAttendance;
	}

	public void setViewUserAttendance(ViewUserAttendance viewUserAttendance) {
		this.viewUserAttendance = viewUserAttendance;
	}
}
