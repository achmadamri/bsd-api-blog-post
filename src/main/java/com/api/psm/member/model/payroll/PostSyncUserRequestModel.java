package com.api.psm.member.model.payroll;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.api.psm.member.model.RequestModel;

public class PostSyncUserRequestModel extends RequestModel {
	@NotNull(message = "Member Id is not null")
	@Size(min = 1, max = 100, message = "Member Id must be between 1 and 100 characters long")
	private String tbuMemberId;

	@NotNull(message = "Id Login is not null")
	@Size(min = 1, max = 255, message = "Id Login must be between 1 and 255 characters long")
	private String tbuIdLogin;

	@NotEmpty(message = "First name may not be empty")
	@Size(min = 1, max = 100, message = "First name must be between 1 and 100 characters long")
	private String tbuFirstname;
	
	@NotEmpty(message = "Email may not be empty")
	@Email(message = "Email should be valid")
	@Size(min = 1, max = 255, message = "Email must be between 1 and 255 characters long")
	private String tbuEmail;

	@NotNull(message = "Password is not null")
	@Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters long")
	private String tbuPassword;

	@NotNull(message = "Project Id is not null")
	private Integer tbpId;

	public String getTbuMemberId() {
		return tbuMemberId;
	}

	public void setTbuMemberId(String tbuMemberId) {
		this.tbuMemberId = tbuMemberId;
	}

	public String getTbuIdLogin() {
		return tbuIdLogin;
	}

	public void setTbuIdLogin(String tbuIdLogin) {
		this.tbuIdLogin = tbuIdLogin;
	}

	public String getTbuFirstname() {
		return tbuFirstname;
	}

	public void setTbuFirstname(String tbuFirstname) {
		this.tbuFirstname = tbuFirstname;
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

	public Integer getTbpId() {
		return tbpId;
	}

	public void setTbpId(Integer tbpId) {
		this.tbpId = tbpId;
	}
}
