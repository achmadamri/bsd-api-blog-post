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
 * The persistent class for the tb_user_overtime database table.
 * 
 */
@Entity
@Table(name="tb_user_overtime")
@NamedQuery(name="TbUserOvertime.findAll", query="SELECT t FROM TbUserOvertime t")
public class TbUserOvertime implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public final static String statusApproved = "approved";
	public final static String statusNotApproved = "not approved";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tbuo_id")
	private Integer tbuoId;

	@Column(name="tbu_id")
	private Integer tbuId;

	@Column(name="tbua_id_in")
	private Integer tbuaIdIn;

	@Column(name="tbua_id_out")
	private Integer tbuaIdOut;

	@Column(name="tbuo_create_date")
	private Date tbuoCreateDate;

	@Column(name="tbuo_create_id")
	private Integer tbuoCreateId;

	@Column(name="tbuo_duration")
	private Integer tbuoDuration;

	@Column(name="tbuo_in_date")
	private String tbuoInDate;

	@Column(name="tbuo_in_time")
	private String tbuoInTime;

	@Column(name="tbuo_out_date")
	private String tbuoOutDate;

	@Column(name="tbuo_out_time")
	private String tbuoOutTime;

	@Column(name="tbuo_status")
	private String tbuoStatus;

	@Column(name="tbuo_update_date")
	private Date tbuoUpdateDate;

	@Column(name="tbuo_update_id")
	private Integer tbuoUpdateId;

	public Integer getTbuoId() {
		return tbuoId;
	}

	public void setTbuoId(Integer tbuoId) {
		this.tbuoId = tbuoId;
	}

	public Integer getTbuId() {
		return tbuId;
	}

	public void setTbuId(Integer tbuId) {
		this.tbuId = tbuId;
	}

	public Integer getTbuaIdIn() {
		return tbuaIdIn;
	}

	public void setTbuaIdIn(Integer tbuaIdIn) {
		this.tbuaIdIn = tbuaIdIn;
	}

	public Integer getTbuaIdOut() {
		return tbuaIdOut;
	}

	public void setTbuaIdOut(Integer tbuaIdOut) {
		this.tbuaIdOut = tbuaIdOut;
	}

	public Date getTbuoCreateDate() {
		return tbuoCreateDate;
	}

	public void setTbuoCreateDate(Date tbuoCreateDate) {
		this.tbuoCreateDate = tbuoCreateDate;
	}

	public Integer getTbuoCreateId() {
		return tbuoCreateId;
	}

	public void setTbuoCreateId(Integer tbuoCreateId) {
		this.tbuoCreateId = tbuoCreateId;
	}

	public Integer getTbuoDuration() {
		return tbuoDuration;
	}

	public void setTbuoDuration(Integer tbuoDuration) {
		this.tbuoDuration = tbuoDuration;
	}

	public String getTbuoInDate() {
		return tbuoInDate;
	}

	public void setTbuoInDate(String tbuoInDate) {
		this.tbuoInDate = tbuoInDate;
	}

	public String getTbuoInTime() {
		return tbuoInTime;
	}

	public void setTbuoInTime(String tbuoInTime) {
		this.tbuoInTime = tbuoInTime;
	}

	public String getTbuoOutDate() {
		return tbuoOutDate;
	}

	public void setTbuoOutDate(String tbuoOutDate) {
		this.tbuoOutDate = tbuoOutDate;
	}

	public String getTbuoOutTime() {
		return tbuoOutTime;
	}

	public void setTbuoOutTime(String tbuoOutTime) {
		this.tbuoOutTime = tbuoOutTime;
	}

	public String getTbuoStatus() {
		return tbuoStatus;
	}

	public void setTbuoStatus(String tbuoStatus) {
		this.tbuoStatus = tbuoStatus;
	}

	public Date getTbuoUpdateDate() {
		return tbuoUpdateDate;
	}

	public void setTbuoUpdateDate(Date tbuoUpdateDate) {
		this.tbuoUpdateDate = tbuoUpdateDate;
	}

	public Integer getTbuoUpdateId() {
		return tbuoUpdateId;
	}

	public void setTbuoUpdateId(Integer tbuoUpdateId) {
		this.tbuoUpdateId = tbuoUpdateId;
	}

}