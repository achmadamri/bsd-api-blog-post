package com.api.psm.member.model.userattendance;

import com.api.psm.member.model.RequestModel;

public class PostPunchOutRequestModel extends RequestModel {

	private String tbuaOutNote;
	
	private String tbuaOutLongitude;
	
	private String tbuaOutLatitude;

	private String tbuaOutPhoto;

	public String getTbuaOutNote() {
		return tbuaOutNote;
	}

	public void setTbuaOutNote(String tbuaOutNote) {
		this.tbuaOutNote = tbuaOutNote;
	}

	public String getTbuaOutLongitude() {
		return tbuaOutLongitude;
	}

	public void setTbuaOutLongitude(String tbuaOutLongitude) {
		this.tbuaOutLongitude = tbuaOutLongitude;
	}

	public String getTbuaOutLatitude() {
		return tbuaOutLatitude;
	}

	public void setTbuaOutLatitude(String tbuaOutLatitude) {
		this.tbuaOutLatitude = tbuaOutLatitude;
	}

	public String getTbuaOutPhoto() {
		return tbuaOutPhoto;
	}

	public void setTbuaOutPhoto(String tbuaOutPhoto) {
		this.tbuaOutPhoto = tbuaOutPhoto;
	}
}
