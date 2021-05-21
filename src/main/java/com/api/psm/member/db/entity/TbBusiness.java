package com.api.psm.member.db.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the tb_business database table.
 * 
 */
@Entity
@Table(name = "tb_business")
@NamedQuery(name = "TbBusiness.findAll", query = "SELECT t FROM TbBusiness t")
public class TbBusiness implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "tbb_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tbbId;
	
	@Column(name = "tbb_create_date")
	private Date tbbCreateDate;
	
	@Column(name = "tbb_create_id")
	private Integer tbbCreateId;
	
	@Column(name = "tbb_update_date")
	private Date tbbUpdateDate;
	
	@Column(name = "tbb_update_id")
	private Integer tbbUpdateId;
	
	@Column(name = "tbb_name")
	private String tbbName;
	
	@Column(name = "tbb_color")
	private String tbbColor;
	
	@Column(name = "tbb_logo")
	private String tbbLogo;
	
	@Column(name = "tbb_brand")
	private String tbbBrand;
	
	@Column(name = "tbb_business_line")
	private String tbbBusinessLine;
	
	@Column(name = "tbb_address")
	private String tbbAddress;
	
	@Column(name = "tbb_phone")
	private String tbbPhone;
	
	@Column(name = "tbb_email")
	private String tbbEmail;
	
	@Column(name = "tbb_website")
	private String tbbWebsite;
	
	@Column(name = "tbb_contact_person")
	private String tbbContactPerson;
	
	@Column(name = "tbb_contact_person_position")
	private String tbbContactPersonPosition;
	
	@Column(name = "tbb_contact_person_telp")
	private String tbbContactPersonTelp;
	
	@Column(name = "tbb_contact_person_mobile")
	private String tbbContactPersonMobile;
	
	@Column(name = "tbb_contact_person_email")
	private String tbbContactPersonEmail;

	public Integer getTbbId() {
		return tbbId;
	}

	public void setTbbId(Integer tbbId) {
		this.tbbId = tbbId;
	}

	public Date getTbbCreateDate() {
		return tbbCreateDate;
	}

	public void setTbbCreateDate(Date tbbCreateDate) {
		this.tbbCreateDate = tbbCreateDate;
	}

	public Integer getTbbCreateId() {
		return tbbCreateId;
	}

	public void setTbbCreateId(Integer tbbCreateId) {
		this.tbbCreateId = tbbCreateId;
	}

	public Date getTbbUpdateDate() {
		return tbbUpdateDate;
	}

	public void setTbbUpdateDate(Date tbbUpdateDate) {
		this.tbbUpdateDate = tbbUpdateDate;
	}

	public Integer getTbbUpdateId() {
		return tbbUpdateId;
	}

	public void setTbbUpdateId(Integer tbbUpdateId) {
		this.tbbUpdateId = tbbUpdateId;
	}

	public String getTbbName() {
		return tbbName;
	}

	public void setTbbName(String tbbName) {
		this.tbbName = tbbName;
	}

	public String getTbbColor() {
		return tbbColor;
	}

	public void setTbbColor(String tbbColor) {
		this.tbbColor = tbbColor;
	}

	public String getTbbLogo() {
		return tbbLogo;
	}

	public void setTbbLogo(String tbbLogo) {
		this.tbbLogo = tbbLogo;
	}

	public String getTbbBrand() {
		return tbbBrand;
	}

	public void setTbbBrand(String tbbBrand) {
		this.tbbBrand = tbbBrand;
	}

	public String getTbbBusinessLine() {
		return tbbBusinessLine;
	}

	public void setTbbBusinessLine(String tbbBusinessLine) {
		this.tbbBusinessLine = tbbBusinessLine;
	}

	public String getTbbAddress() {
		return tbbAddress;
	}

	public void setTbbAddress(String tbbAddress) {
		this.tbbAddress = tbbAddress;
	}

	public String getTbbPhone() {
		return tbbPhone;
	}

	public void setTbbPhone(String tbbPhone) {
		this.tbbPhone = tbbPhone;
	}

	public String getTbbEmail() {
		return tbbEmail;
	}

	public void setTbbEmail(String tbbEmail) {
		this.tbbEmail = tbbEmail;
	}

	public String getTbbWebsite() {
		return tbbWebsite;
	}

	public void setTbbWebsite(String tbbWebsite) {
		this.tbbWebsite = tbbWebsite;
	}

	public String getTbbContactPerson() {
		return tbbContactPerson;
	}

	public void setTbbContactPerson(String tbbContactPerson) {
		this.tbbContactPerson = tbbContactPerson;
	}

	public String getTbbContactPersonPosition() {
		return tbbContactPersonPosition;
	}

	public void setTbbContactPersonPosition(String tbbContactPersonPosition) {
		this.tbbContactPersonPosition = tbbContactPersonPosition;
	}

	public String getTbbContactPersonTelp() {
		return tbbContactPersonTelp;
	}

	public void setTbbContactPersonTelp(String tbbContactPersonTelp) {
		this.tbbContactPersonTelp = tbbContactPersonTelp;
	}

	public String getTbbContactPersonMobile() {
		return tbbContactPersonMobile;
	}

	public void setTbbContactPersonMobile(String tbbContactPersonMobile) {
		this.tbbContactPersonMobile = tbbContactPersonMobile;
	}

	public String getTbbContactPersonEmail() {
		return tbbContactPersonEmail;
	}

	public void setTbbContactPersonEmail(String tbbContactPersonEmail) {
		this.tbbContactPersonEmail = tbbContactPersonEmail;
	}
}