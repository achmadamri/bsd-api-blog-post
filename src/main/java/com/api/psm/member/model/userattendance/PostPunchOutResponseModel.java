package com.api.psm.member.model.userattendance;

import com.api.psm.member.db.entity.TbUserAttendance;
import com.api.psm.member.model.ResponseModel;

public class PostPunchOutResponseModel extends ResponseModel {
	
	public PostPunchOutResponseModel(PostPunchOutRequestModel requestModel) {
		super(requestModel);
	}
	
	private TbUserAttendance tbUserAttendance;

	public TbUserAttendance getTbUserAttendance() {
		return tbUserAttendance;
	}

	public void setTbUserAttendance(TbUserAttendance tbUserAttendance) {
		this.tbUserAttendance = tbUserAttendance;
	}
}
