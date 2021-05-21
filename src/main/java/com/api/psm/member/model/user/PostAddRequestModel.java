package com.api.psm.member.model.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.api.psm.member.model.RequestModel;

public class PostAddRequestModel extends RequestModel {
	@NotEmpty(message = "First name may not be empty")
	@Size(min = 1, max = 100, message = "First name must be between 1 and 100 characters long")
	private String tbuFirstname;
	
	@NotEmpty(message = "Last name may not be empty")
	@Size(min = 1, max = 100, message = "Last name must be between 1 and 100 characters long")
	private String tbuLastname;

	@NotEmpty(message = "Email may not be empty")
	@Email(message = "Email should be valid")
	@Size(min = 1, max = 255, message = "Email must be between 1 and 255 characters long")
	private String tbuEmail;

	@NotNull(message = "Password is not null")
	private String tbuPassword;

	public String getTbuFirstname() {
		return tbuFirstname;
	}

	public void setTbuFirstname(String tbuFirstname) {
		this.tbuFirstname = tbuFirstname;
	}

	public String getTbuLastname() {
		return tbuLastname;
	}

	public void setTbuLastname(String tbuLastname) {
		this.tbuLastname = tbuLastname;
	}

	public String getTbuEmail() {
		return tbuEmail;
	}

	public void setTbuEmail(String tbuEmail) {
		this.tbuEmail = tbuEmail;
	}

	public String getTbuPassword() {
		return tbuPassword;
	}

	public void setTbuPassword(String tbuPassword) {
		this.tbuPassword = tbuPassword;
	}
}
