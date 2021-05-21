package com.api.psm.member.model.user;

import java.util.List;

import com.api.psm.member.db.entity.TbProject;
import com.api.psm.member.db.entity.TbUser;
import com.api.psm.member.model.ResponseModel;

public class GetProjectResponseModel extends ResponseModel {
	
	public GetProjectResponseModel(GetProjectRequestModel requestModel) {
		super(requestModel);
	}
	
	private TbUser tbUser;
	
	private List<TbProject> lstTbProject;

	public TbUser getTbUser() {
		return tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	public List<TbProject> getLstTbProject() {
		return lstTbProject;
	}

	public void setLstTbProject(List<TbProject> lstTbProject) {
		this.lstTbProject = lstTbProject;
	}
}
