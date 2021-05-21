package com.api.psm.member.model.userattendance;

import java.util.List;

import com.api.psm.member.db.entity.TbUser;
import com.api.psm.member.db.entity.TbUserAttendance;
import com.api.psm.member.model.ResponseModel;

public class GetPunchStatusResponseModel extends ResponseModel {
	
	public GetPunchStatusResponseModel(GetPunchStatusRequestModel requestModel) {
		super(requestModel);
	}
	
	private TbUser tbUser;
	
	private List<TbUserAttendance> lstTbUserAttendance;
	
	private String punchStatus;

	public TbUser getTbUser() {
		return tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	public List<TbUserAttendance> getLstTbUserAttendance() {
		return lstTbUserAttendance;
	}

	public void setLstTbUserAttendance(List<TbUserAttendance> lstTbUserAttendance) {
		this.lstTbUserAttendance = lstTbUserAttendance;
	}

	public String getPunchStatus() {
		return punchStatus;
	}

	public void setPunchStatus(String punchStatus) {
		this.punchStatus = punchStatus;
	}
}
