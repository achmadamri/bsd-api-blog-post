package com.api.psm.member.model.user;

import com.api.psm.member.model.ResponseModel;

public class PostUploadPhotoByStringResponseModel extends ResponseModel {
	
	public PostUploadPhotoByStringResponseModel(PostUploadPhotoByStringRequestModel requestModel) {
		super(requestModel);
	}
	
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
