package com.api.psm.member.model.user;

import com.api.psm.member.db.entity.TbBusiness;
import com.api.psm.member.db.entity.TbDepartment;
import com.api.psm.member.db.entity.TbProject;
import com.api.psm.member.db.entity.TbUser;
import com.api.psm.member.model.ResponseModel;

public class PostSyncResponseModel extends ResponseModel {
	
	public PostSyncResponseModel(PostSyncRequestModel requestModel) {
		super(requestModel);
	}
	
	private TbUser tbUser;
	
	private TbBusiness tbBusiness;
	
	private TbDepartment tbDepartment;
	
	private TbProject tbProject;

	public TbUser getTbUser() {
		return tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	public TbBusiness getTbBusiness() {
		return tbBusiness;
	}

	public void setTbBusiness(TbBusiness tbBusiness) {
		this.tbBusiness = tbBusiness;
	}

	public TbDepartment getTbDepartment() {
		return tbDepartment;
	}

	public void setTbDepartment(TbDepartment tbDepartment) {
		this.tbDepartment = tbDepartment;
	}

	public TbProject getTbProject() {
		return tbProject;
	}

	public void setTbProject(TbProject tbProject) {
		this.tbProject = tbProject;
	}
}
