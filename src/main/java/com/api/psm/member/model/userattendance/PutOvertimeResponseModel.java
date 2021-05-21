package com.api.psm.member.model.userattendance;

import com.api.psm.member.db.entity.TbUserAttendance;
import com.api.psm.member.db.entity.TbUserOvertime;
import com.api.psm.member.model.ResponseModel;

public class PutOvertimeResponseModel extends ResponseModel {

	public PutOvertimeResponseModel(PutOvertimeRequestModel requestModel) {
		super(requestModel);
	}
	
	private TbUserOvertime tbUserOvertime;

	public TbUserOvertime getTbUserOvertime() {
		return tbUserOvertime;
	}

	public void setTbUserOvertime(TbUserOvertime tbUserOvertime) {
		this.tbUserOvertime = tbUserOvertime;
	}
}
