package com.api.psm.member.model.address;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.api.psm.member.model.RequestModel;

public class PostAddressRequestModel extends RequestModel {
	@NotEmpty(message = "Name may not be empty")
	@Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters long")
	private String tbaName;

	@NotEmpty(message = "Address may not be empty")
	@Size(min = 1, max = 1000, message = "Address must be between 1 and 1000 characters long")
	private String tbaAddress;

	@NotNull(message = "Province is not null")
	private String tbaProvince;

	@NotNull(message = "City is not null")
	private String tbaCity;

	@NotNull(message = "District is not null")
	private String tbaDistrict;

	@NotNull(message = "Village is not null")
	private String tbaVillage;

	@NotEmpty(message = "Postal may not be empty")
	@Size(min = 1, max = 20, message = "Postal must be between 1 and 20 characters long")
	private String tbaPostalCode;

	@NotNull(message = "Longitude code is not null")
	private Double tbaLongitude;

	@NotNull(message = "Latidude code is not null")
	private Double tbaLatidude;

	public String getTbaName() {
		return tbaName;
	}

	public void setTbaName(String tbaName) {
		this.tbaName = tbaName;
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
