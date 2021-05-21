package com.api.psm.member.db.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the tb_user_address database table.
 * 
 */
@Entity
@Table(name="tb_address")
@NamedQuery(name="TbAddress.findAll", query="SELECT t FROM TbAddress t")
public class TbAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	public final static String statusDefault = "default";
	public final static String statusNotDefault = "not default";

	@Id
	@Column(name="tba_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tbaId;
	
	@Column(name="tbu_id")
	private Integer tbuId;
	
	@Column(name="tba_create_date")
	private Date tbaCreateDate;

	@Column(name="tba_create_id")
	private Integer tbaCreateId;

	@Column(name="tba_update_date")
	private Date tbaUpdateDate;

	@Column(name="tba_update_id")
	private Integer tbaUpdateId;

	@Column(name="tba_name")
	private String tbaName;

	@Column(name="tba_status")
	private String tbaStatus;

	@Column(name="tba_address")
	private String tbaAddress;

	@Column(name="tba_province")
	private String tbaProvince;

	@Column(name="tba_city")
	private String tbaCity;

	@Column(name="tba_district")
	private String tbaDistrict;

	@Column(name="tba_village")
	private String tbaVillage;

	@Column(name="tba_postal_code")
	private String tbaPostalCode;

	@Column(name="tba_longitude")
	private BigDecimal tbaLongitude;

	@Column(name="tba_latitude")
	private BigDecimal tbaLatitude;

	public Integer getTbaId() {
		return tbaId;
	}

	public void setTbaId(Integer tbaId) {
		this.tbaId = tbaId;
	}

	public Integer getTbuId() {
		return tbuId;
	}

	public void setTbuId(Integer tbuId) {
		this.tbuId = tbuId;
	}

	public Date getTbaCreateDate() {
		return tbaCreateDate;
	}

	public void setTbaCreateDate(Date tbaCreateDate) {
		this.tbaCreateDate = tbaCreateDate;
	}

	public Integer getTbaCreateId() {
		return tbaCreateId;
	}

	public void setTbaCreateId(Integer tbaCreateId) {
		this.tbaCreateId = tbaCreateId;
	}

	public Date getTbaUpdateDate() {
		return tbaUpdateDate;
	}

	public void setTbaUpdateDate(Date tbaUpdateDate) {
		this.tbaUpdateDate = tbaUpdateDate;
	}

	public Integer getTbaUpdateId() {
		return tbaUpdateId;
	}

	public void setTbaUpdateId(Integer tbaUpdateId) {
		this.tbaUpdateId = tbaUpdateId;
	}

	public String getTbaName() {
		return tbaName;
	}

	public void setTbaName(String tbaName) {
		this.tbaName = tbaName;
	}

	public String getTbaStatus() {
		return tbaStatus;
	}

	public void setTbaStatus(String tbaStatus) {
		this.tbaStatus = tbaStatus;
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

	public BigDecimal getTbaLongitude() {
		return tbaLongitude;
	}

	public void setTbaLongitude(BigDecimal tbaLongitude) {
		this.tbaLongitude = tbaLongitude;
	}

	public BigDecimal getTbaLatitude() {
		return tbaLatitude;
	}

	public void setTbaLatitude(BigDecimal tbaLatitude) {
		this.tbaLatitude = tbaLatitude;
	}
}