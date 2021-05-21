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
 * The persistent class for the tb_users database table.
 * 
 */
@Entity
@Table(name="tb_user_attendance")
@NamedQuery(name="TbUserAttendance.findAll", query="SELECT t FROM TbUserAttendance t")
public class TbUserAttendance implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public final static String statusCreated = "created";
	public final static String statusNeedConfirmation = "need confirmation";
	public final static String statusApproved = "approved";
	public final static String statusNotApproved = "not approved";

	@Id
	@Column(name="tbua_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tbuaId;

	@Column(name="tbua_create_date")
	private Date tbuaCreateDate;

	@Column(name="tbua_create_id")
	private Integer tbuaCreateId;

	@Column(name="tbua_update_date")
	private Date tbuaUpdateDate;

	@Column(name="tbua_update_id")
	private Integer tbuaUpdateId;
	
	@Column(name="tbu_id")
	private Integer tbuId;

	@Column(name="tbua_date")
	private String tbuaDate;

	@Column(name="tbua_in_time")
	private String tbuaInTime;

	@Column(name="tbua_in_time_diff")
	private Integer tbuaInTimeDiff;

	@Column(name="tbua_out_time")
	private String tbuaOutTime;

	@Column(name="tbua_out_time_diff")
	private Integer tbuaOutTimeDiff;

	@Column(name="tbua_in_note")
	private String tbuaInNote;

	@Column(name="tbua_out_note")
	private String tbuaOutNote;

	@Column(name="tbua_in_longitude")
	private String tbuaInLongitude;

	@Column(name="tbua_in_latitude")
	private String tbuaInLatitude;

	@Column(name="tbua_out_longitude")
	private String tbuaOutLongitude;

	@Column(name="tbua_out_latitude")
	private String tbuaOutLatitude;

	@Column(name="tbua_in_photo")
	private String tbuaInPhoto;

	@Column(name="tbua_out_photo")
	private String tbuaOutPhoto;

	@Column(name="tbua_attendance_status")
	private String tbuaAttendanceStatus;

	public Integer getTbuaId() {
		return tbuaId;
	}

	public void setTbuaId(Integer tbuaId) {
		this.tbuaId = tbuaId;
	}

	public Date getTbuaCreateDate() {
		return tbuaCreateDate;
	}

	public void setTbuaCreateDate(Date tbuaCreateDate) {
		this.tbuaCreateDate = tbuaCreateDate;
	}

	public Integer getTbuaCreateId() {
		return tbuaCreateId;
	}

	public void setTbuaCreateId(Integer tbuaCreateId) {
		this.tbuaCreateId = tbuaCreateId;
	}

	public Date getTbuaUpdateDate() {
		return tbuaUpdateDate;
	}

	public void setTbuaUpdateDate(Date tbuaUpdateDate) {
		this.tbuaUpdateDate = tbuaUpdateDate;
	}

	public Integer getTbuaUpdateId() {
		return tbuaUpdateId;
	}

	public void setTbuaUpdateId(Integer tbuaUpdateId) {
		this.tbuaUpdateId = tbuaUpdateId;
	}

	public Integer getTbuId() {
		return tbuId;
	}

	public void setTbuId(Integer tbuId) {
		this.tbuId = tbuId;
	}

	public String getTbuaDate() {
		return tbuaDate;
	}

	public void setTbuaDate(String tbuaDate) {
		this.tbuaDate = tbuaDate;
	}

	public String getTbuaInTime() {
		return tbuaInTime;
	}

	public void setTbuaInTime(String tbuaInTime) {
		this.tbuaInTime = tbuaInTime;
	}

	public Integer getTbuaInTimeDiff() {
		return tbuaInTimeDiff;
	}

	public void setTbuaInTimeDiff(Integer tbuaInTimeDiff) {
		this.tbuaInTimeDiff = tbuaInTimeDiff;
	}

	public String getTbuaOutTime() {
		return tbuaOutTime;
	}

	public void setTbuaOutTime(String tbuaOutTime) {
		this.tbuaOutTime = tbuaOutTime;
	}

	public Integer getTbuaOutTimeDiff() {
		return tbuaOutTimeDiff;
	}

	public void setTbuaOutTimeDiff(Integer tbuaOutTimeDiff) {
		this.tbuaOutTimeDiff = tbuaOutTimeDiff;
	}

	public String getTbuaInNote() {
		return tbuaInNote;
	}

	public void setTbuaInNote(String tbuaInNote) {
		this.tbuaInNote = tbuaInNote;
	}

	public String getTbuaOutNote() {
		return tbuaOutNote;
	}

	public void setTbuaOutNote(String tbuaOutNote) {
		this.tbuaOutNote = tbuaOutNote;
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

	public String getTbuaInPhoto() {
		return tbuaInPhoto;
	}

	public void setTbuaInPhoto(String tbuaInPhoto) {
		this.tbuaInPhoto = tbuaInPhoto;
	}

	public String getTbuaOutPhoto() {
		return tbuaOutPhoto;
	}

	public void setTbuaOutPhoto(String tbuaOutPhoto) {
		this.tbuaOutPhoto = tbuaOutPhoto;
	}

	public String getTbuaAttendanceStatus() {
		return tbuaAttendanceStatus;
	}

	public void setTbuaAttendanceStatus(String tbuaAttendanceStatus) {
		this.tbuaAttendanceStatus = tbuaAttendanceStatus;
	}
}
