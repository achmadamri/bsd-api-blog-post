package com.api.psm.member.model.userattendance;

import com.api.psm.member.model.RequestModel;

public class PostPunchInRequestModel extends RequestModel {

	private String tbuaInNote;

	private String tbuaInLongitude;
	
	private String tbuaInLatitude;
	
	private String tbuaInPhoto;

	public String getTbuaInNote() {
		return tbuaInNote;
	}

	public void setTbuaInNote(String tbuaInNote) {
		this.tbuaInNote = tbuaInNote;
	}

	public String getTbuaInLongitude() {
		return tbuaInLongitude;
	}

	public void setTbuaInLongitude(String tbuaInLongitude) {
		this.tbuaInLongitude = tbuaInLongitude;
	}

	public String getTbuaInLatitude() {
		return tbuaInLatitude;
	}

	public void setTbuaInLatitude(String tbuaInLatitude) {
		this.tbuaInLatitude = tbuaInLatitude;
	}

	public String getTbuaInPhoto() {
		return tbuaInPhoto;
	}

	public void setTbuaInPhoto(String tbuaInPhoto) {
		this.tbuaInPhoto = tbuaInPhoto;
	}
}
