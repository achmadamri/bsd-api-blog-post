package com.api.psm.member.model.hierarchy;

import java.util.List;

import com.api.psm.member.db.entity.TbUser;
import com.api.psm.member.db.entity.ViewHierarchyUser;
import com.api.psm.member.model.ResponseModel;

public class GetHierarchyResponseModel extends ResponseModel {

	public GetHierarchyResponseModel(GetHierarchyRequestModel requestModel) {
		super(requestModel);
	}

	private TbUser tbUser;

	private List<ViewHierarchyUser> lstViewHierarchyUserSpv;

	private List<ViewHierarchyUser> lstViewHierarchyUserSub;

	public TbUser getTbUser() {
		return tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	public List<ViewHierarchyUser> getLstViewHierarchyUserSpv() {
		return lstViewHierarchyUserSpv;
	}

	public void setLstViewHierarchyUserSpv(List<ViewHierarchyUser> lstViewHierarchyUserSpv) {
		this.lstViewHierarchyUserSpv = lstViewHierarchyUserSpv;
	}

	public List<ViewHierarchyUser> getLstViewHierarchyUserSub() {
		return lstViewHierarchyUserSub;
	}

	public void setLstViewHierarchyUserSub(List<ViewHierarchyUser> lstViewHierarchyUserSub) {
		this.lstViewHierarchyUserSub = lstViewHierarchyUserSub;
	}
}
