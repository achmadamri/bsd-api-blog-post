package com.api.psm.member.model.address;

import javax.validation.constraints.NotNull;

import com.api.psm.member.model.RequestModel;

public class PutUpdateAddressRequestModel extends RequestModel {
	@NotNull(message = "tbaId is not null")
	private Integer tbaId;

	private String tbaAddress;

	private String tbaProvince;

	private String tbaCity;

	private String tbaDistrict;

	private String tbaVillage;

	private String tbaPostalCode;

	private Double tbaLongitude;

	private Double tbaLatidude;

	public Integer getTbaId() {
		return tbaId;
	}

	public void setTbaId(Integer tbaId) {
		this.tbaId = tbaId;
	}

	public String getTbaAddress() {
		return tbaAddress;
	}

	public void setTbaAddress(String tbaAddress) {
		this.tbaAddress = tbaAddress;
	}

	public String getTbaProvince() {
		return tbaProvince;
	}

	public void setTbaProvince(String tbaProvince) {
		this.tbaProvince = tbaProvince;
	}

	public String getTbaCity() {
		return tbaCity;
	}

	public void setTbaCity(String tbaCity) {
		this.tbaCity = tbaCity;
	}

	public String getTbaDistrict() {
		return tbaDistrict;
	}

	public void setTbaDistrict(String tbaDistrict) {
		this.tbaDistrict = tbaDistrict;
	}

	public String getTbaVillage() {
		return tbaVillage;
	}

	public void setTbaVillage(String tbaVillage) {
		this.tbaVillage = tbaVillage;
	}

	public String getTbaPostalCode() {
		return tbaPostalCode;
	}

	public void setTbaPostalCode(String tbaPostalCode) {
		this.tbaPostalCode = tbaPostalCode;
	}

	public Double getTbaLongitude() {
		return tbaLongitude;
	}

	public void setTbaLongitude(Double tbaLongitude) {
		this.tbaLongitude = tbaLongitude;
	}

	public Double getTbaLatidude() {
		return tbaLatidude;
	}

	public void setTbaLatidude(Double tbaLatidude) {
		this.tbaLatidude = tbaLatidude;
	}
}
