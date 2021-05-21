package com.api.psm.member.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the view_user_overtime database table.
 * 
 */
@Entity
@Table(name="view_user_overtime")
@NamedQuery(name="ViewUserOvertime.findAll", query="SELECT v FROM ViewUserOvertime v")
public class ViewUserOvertime implements Serializable {
	private static final long serialVersionUID = 1L;

	public final static String StatusApproved = "approved";
	public final static String StatusNotApproved = "not approved";

	@Column(name="tbb_id")
	private Integer tbbId;

	@Column(name="tbb_name")
	private String tbbName;

	@Column(name="tbp_id")
	private Integer tbpId;

	@Column(name="tbp_project_name")
	private String tbpProjectName;

	@Column(name="tbu_email")
	private String tbuEmail;

	@Column(name="tbu_firstname")
	private String tbuFirstname;

	@Column(name="tbu_id")
	private Integer tbuId;

	@Column(name="tbu_id_login")
	private String tbuIdLogin;

	@Column(name="tbu_lastname")
	private String tbuLastname;

	@Column(name="tbu_member_id")
	private String tbuMemberId;

	@Column(name="tbua_id_in")
	private Integer tbuaIdIn;

	@Column(name="tbua_id_out")
	private Integer tbuaIdOut;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbuo_create_date")
	private Date tbuoCreateDate;

	@Column(name="tbuo_create_id")
	private Integer tbuoCreateId;

	@Column(name="tbuo_duration")
	private Integer tbuoDuration;

	@Column(name="tbuo_id")
	private Integer tbuoId;

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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbuo_update_date")
	private Date tbuoUpdateDate;

	@Column(name="tbuo_update_id")
	private Integer tbuoUpdateId;
	
	@Id
	@Column(name="uuid")
	private String uuid;

	@Column(name="period")
	private String period;

	public ViewUserOvertime() {
	}

	public Integer getTbbId() {
		return this.tbbId;
	}

	public void setTbbId(Integer tbbId) {
		this.tbbId = tbbId;
	}

	public String getTbbName() {
		return this.tbbName;
	}

	public void setTbbName(String tbbName) {
		this.tbbName = tbbName;
	}

	public Integer getTbpId() {
		return this.tbpId;
	}

	public void setTbpId(Integer tbpId) {
		this.tbpId = tbpId;
	}

	public String getTbpProjectName() {
		return this.tbpProjectName;
	}

	public void setTbpProjectName(String tbpProjectName) {
		this.tbpProjectName = tbpProjectName;
	}

	public String getTbuEmail() {
		return this.tbuEmail;
	}

	public void setTbuEmail(String tbuEmail) {
		this.tbuEmail = tbuEmail;
	}

	public String getTbuFirstname() {
		return this.tbuFirstname;
	}

	public void setTbuFirstname(String tbuFirstname) {
		this.tbuFirstname = tbuFirstname;
	}

	public Integer getTbuId() {
		return this.tbuId;
	}

	public void setTbuId(Integer tbuId) {
		this.tbuId = tbuId;
	}

	public String getTbuIdLogin() {
		return this.tbuIdLogin;
	}

	public void setTbuIdLogin(String tbuIdLogin) {
		this.tbuIdLogin = tbuIdLogin;
	}

	public String getTbuLastname() {
		return this.tbuLastname;
	}

	public void setTbuLastname(String tbuLastname) {
		this.tbuLastname = tbuLastname;
	}

	public String getTbuMemberId() {
		return this.tbuMemberId;
	}

	public void setTbuMemberId(String tbuMemberId) {
		this.tbuMemberId = tbuMemberId;
	}

	public Integer getTbuaIdIn() {
		return this.tbuaIdIn;
	}

	public void setTbuaIdIn(Integer tbuaIdIn) {
		this.tbuaIdIn = tbuaIdIn;
	}

	public Integer getTbuaIdOut() {
		return this.tbuaIdOut;
	}

	public void setTbuaIdOut(Integer tbuaIdOut) {
		this.tbuaIdOut = tbuaIdOut;
	}

	public Date getTbuoCreateDate() {
		return this.tbuoCreateDate;
	}

	public void setTbuoCreateDate(Date tbuoCreateDate) {
		this.tbuoCreateDate = tbuoCreateDate;
	}

	public Integer getTbuoCreateId() {
		return this.tbuoCreateId;
	}

	public void setTbuoCreateId(Integer tbuoCreateId) {
		this.tbuoCreateId = tbuoCreateId;
	}

	public Integer getTbuoDuration() {
		return this.tbuoDuration;
	}

	public void setTbuoDuration(Integer tbuoDuration) {
		this.tbuoDuration = tbuoDuration;
	}

	public Integer getTbuoId() {
		return this.tbuoId;
	}

	public void setTbuoId(Integer tbuoId) {
		this.tbuoId = tbuoId;
	}

	public String getTbuoInDate() {
		return this.tbuoInDate;
	}

	public void setTbuoInDate(String tbuoInDate) {
		this.tbuoInDate = tbuoInDate;
	}

	public String getTbuoInTime() {
		return this.tbuoInTime;
	}

	public void setTbuoInTime(String tbuoInTime) {
		this.tbuoInTime = tbuoInTime;
	}

	public String getTbuoOutDate() {
		return this.tbuoOutDate;
	}

	public void setTbuoOutDate(String tbuoOutDate) {
		this.tbuoOutDate = tbuoOutDate;
	}

	public String getTbuoOutTime() {
		return this.tbuoOutTime;
	}

	public void setTbuoOutTime(String tbuoOutTime) {
		this.tbuoOutTime = tbuoOutTime;
	}

	public String getTbuoStatus() {
		return this.tbuoStatus;
	}

	public void setTbuoStatus(String tbuoStatus) {
		this.tbuoStatus = tbuoStatus;
	}

	public Date getTbuoUpdateDate() {
		return this.tbuoUpdateDate;
	}

	public void setTbuoUpdateDate(Date tbuoUpdateDate) {
		this.tbuoUpdateDate = tbuoUpdateDate;
	}

	public Integer getTbuoUpdateId() {
		return this.tbuoUpdateId;
	}

	public void setTbuoUpdateId(Integer tbuoUpdateId) {
		this.tbuoUpdateId = tbuoUpdateId;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

}