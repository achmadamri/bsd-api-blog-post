package com.api.psm.member.model.user;

import com.api.psm.member.model.RequestModel;

public class PutUpdateRequestModel extends RequestModel {
	private String tbuFirstname;

	private String tbuLastname;
	
	private String tbuMobilePhone;

	private String tbuPlaceOfBirth;

	private String tbuDateOfBirth;
	
	private String tbuPassword;
	
	private String tbuStatus;
	
	private String tbuPhoto;

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

	public String getTbuMobilePhone() {
		return tbuMobilePhone;
	}

	public void setTbuMobilePhone(String tbuMobilePhone) {
		this.tbuMobilePhone = tbuMobilePhone;
	}

	public String getTbuPlaceOfBirth() {
		return tbuPlaceOfBirth;
	}

	public void setTbuPlaceOfBirth(String tbuPlaceOfBirth) {
		this.tbuPlaceOfBirth = tbuPlaceOfBirth;
	}

	public String getTbuDateOfBirth() {
		return tbuDateOfBirth;
	}

	public void setTbuDateOfBirth(String tbuDateOfBirth) {
		this.tbuDateOfBirth = tbuDateOfBirth;
	}

	public String getTbuPassword() {
		return tbuPassword;
	}

	public void setTbuPassword(String tbuPassword) {
		this.tbuPassword = tbuPassword;
	}

	public String getTbuStatus() {
		return tbuStatus;
	}

	public void setTbuStatus(String tbuStatus) {
		this.tbuStatus = tbuStatus;
	}

	public String getTbuPhoto() {
		return tbuPhoto;
	}

	public void setTbuPhoto(String tbuPhoto) {
		this.tbuPhoto = tbuPhoto;
	}
}
