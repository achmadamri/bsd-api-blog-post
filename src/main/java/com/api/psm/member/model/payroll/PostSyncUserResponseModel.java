package com.api.psm.member.model.payroll;

import com.api.psm.member.db.entity.TbProject;
import com.api.psm.member.db.entity.TbUser;
import com.api.psm.member.model.ResponseModel;

public class PostSyncUserResponseModel extends ResponseModel {
	
	public PostSyncUserResponseModel(PostSyncUserRequestModel requestModel) {
		super(requestModel);
	}
	
	private TbUser tbUser;
	
	private TbProject tbProject;
	
	public TbProject getTbProject() {
		return tbProject;
	}

	public void setTbProject(TbProject tbProject) {
		this.tbProject = tbProject;
	}

	public TbUser getTbUser() {
		return tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}
}
