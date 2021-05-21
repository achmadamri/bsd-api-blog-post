package com.api.psm.member.db.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the view_user_attendance database table.
 * 
 */
@Entity
@Table(name="view_user_attendance")
@NamedQuery(name="ViewUserAttendance.findAll", query="SELECT t FROM ViewUserAttendance t")
public class ViewUserAttendance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="uuid")
	private String uuid;
	
	@Column(name="tbu_id")
	private Integer tbuId;

	@Column(name="tbu_member_id")
	private String tbuMemberId;

	@Column(name="tbu_id_login")
	private String tbuIdLogin;

	@Column(name="tbu_email")
	private String tbuEmail;

	@Column(name="tbu_firstname")
	private String tbuFirstname;

	@Column(name="tbu_lastname")
	private String tbuLastname;

	@Column(name="tbua_id")
	private Integer tbuaId;

	@Column(name="tbua_create_date")
	private Date tbuaCreateDate;

	@Column(name="tbua_create_id")
	private Integer tbuaCreateId;

	@Column(name="tbua_update_date")
	private Date tbuaUpdateDate;

	@Column(name="tbua_update_id")
	private Integer tbuaUpdateId;

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

	@Column(name="tbd_department_name")
	private String tbdDepartmentName;

	@Column(name="tbd_id")
	private Integer tbdId;

	@Column(name="tbb_name")
	private String tbbName;

	@Column(name="tbb_id")
	private Integer tbbId;

	@Column(name="tbp_project_name")
	private String tbpProjectName;

	@Column(name="tbp_id")
	private Integer tbpId;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getTbuId() {
		return tbuId;
	}

	public void setTbuId(Integer tbuId) {
		this.tbuId = tbuId;
	}

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

	public String getTbuEmail() {
		return tbuEmail;
	}

	public void setTbuEmail(String tbuEmail) {
		this.tbuEmail = tbuEmail;
	}

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

	public String getTbdDepartmentName() {
		return tbdDepartmentName;
	}

	public void setTbdDepartmentName(String tbdDepartmentName) {
		this.tbdDepartmentName = tbdDepartmentName;
	}

	public Integer getTbdId() {
		return tbdId;
	}

	public void setTbdId(Integer tbdId) {
		this.tbdId = tbdId;
	}

	public String getTbbName() {
		return tbbName;
	}

	public void setTbbName(String tbbName) {
		this.tbbName = tbbName;
	}

	public Integer getTbbId() {
		return tbbId;
	}

	public void setTbbId(Integer tbbId) {
		this.tbbId = tbbId;
	}

	public String getTbpProjectName() {
		return tbpProjectName;
	}

	public void setTbpProjectName(String tbpProjectName) {
		this.tbpProjectName = tbpProjectName;
	}

	public Integer getTbpId() {
		return tbpId;
	}

	public void setTbpId(Integer tbpId) {
		this.tbpId = tbpId;
	}
}
