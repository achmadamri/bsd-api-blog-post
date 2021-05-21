package com.api.psm.member.model.userattendance;

import java.util.List;

import com.api.psm.member.db.entity.TbUser;
import com.api.psm.member.model.ResponseModel;

public class GetAttendanceReportResponseModel extends ResponseModel {

	public GetAttendanceReportResponseModel(GetAttendanceReportRequestModel requestModel) {
		super(requestModel);
	}

	private TbUser tbUser;
	
	private List<TbUserAttendanceModel> lstTbUserAttendanceModel;

	public TbUser getTbUser() {
		return tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	public List<TbUserAttendanceModel> getLstTbUserAttendanceModel() {
		return lstTbUserAttendanceModel;
	}

	public void setLstTbUserAttendanceModel(List<TbUserAttendanceModel> lstTbUserAttendanceModel) {
		this.lstTbUserAttendanceModel = lstTbUserAttendanceModel;
	}
}
