package com.api.psm.member.model.userattendance;

import java.util.List;

import com.api.psm.member.db.entity.TbUser;
import com.api.psm.member.db.entity.ViewUserAttendance;
import com.api.psm.member.model.ResponseModel;

public class GetAttendanceResponseModel extends ResponseModel {

	public GetAttendanceResponseModel(GetAttendanceRequestModel requestModel) {
		super(requestModel);
	}

	private TbUser tbUser;

	private List<ViewUserAttendance> lstViewUserAttendance;

	public TbUser getTbUser() {
		return tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	public List<ViewUserAttendance> getLstViewUserAttendance() {
		return lstViewUserAttendance;
	}

	public void setLstViewUserAttendance(List<ViewUserAttendance> lstViewUserAttendance) {
		this.lstViewUserAttendance = lstViewUserAttendance;
	}
}
