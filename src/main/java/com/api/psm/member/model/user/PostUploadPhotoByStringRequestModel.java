package com.api.psm.member.model.user;

import javax.validation.constraints.NotEmpty;

import com.api.psm.member.model.RequestModel;

public class PostUploadPhotoByStringRequestModel extends RequestModel {
	@NotEmpty(message = "Uid may not be empty")
	private String file;

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
}
