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
 * The persistent class for the tb_project database table.
 * 
 */
@Entity
@Table(name = "tb_project")
@NamedQuery(name = "TbProject.findAll", query = "SELECT t FROM TbProject t")
public class TbProject implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "tbp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tbpId;
	
	@Column(name = "tbp_create_date")
	private Date tbpCreateDate;
	
	@Column(name = "tbp_create_id")
	private Integer tbpCreateId;
	
	@Column(name = "tbp_update_date")
	private Date tbpUpdateDate;
	
	@Column(name = "tbp_update_id")
	private Integer tbpUpdateId;
	
	@Column(name = "tbp_branch_building")
	private String tbpBranchBuilding;
	
	@Column(name = "tbp_project_name")
	private String tbpProjectName;
	
	@Column(name = "tbb_id")
	private Integer tbbId;
	
	@Column(name = "tbp_latitude")
	private String tbpLatitude;
	
	@Column(name = "tbp_longitude")
	private String tbpLongitude;
	
	@Column(name = "tbp_cekin_radius")
	private Integer tbpCekinRadius;
	
	@Column(name = "tbp_note")
	private String tbpNote;
	
	@Column(name = "tbp_shift_start")
	private String tbpShiftStart;
	
	@Column(name = "tbp_shift_end")
	private String tbpShiftEnd;

	public String getTbpShiftStart() {
		return tbpShiftStart;
	}

	public void setTbpShiftStart(String tbpShiftStart) {
		this.tbpShiftStart = tbpShiftStart;
	}

	public String getTbpShiftEnd() {
		return tbpShiftEnd;
	}

	public void setTbpShiftEnd(String tbpShiftEnd) {
		this.tbpShiftEnd = tbpShiftEnd;
	}

	public Integer getTbpId() {
		return tbpId;
	}

	public void setTbpId(Integer tbpId) {
		this.tbpId = tbpId;
	}

	public Date getTbpCreateDate() {
		return tbpCreateDate;
	}

	public void setTbpCreateDate(Date tbpCreateDate) {
		this.tbpCreateDate = tbpCreateDate;
	}

	public Integer getTbpCreateId() {
		return tbpCreateId;
	}

	public void setTbpCreateId(Integer tbpCreateId) {
		this.tbpCreateId = tbpCreateId;
	}

	public Date getTbpUpdateDate() {
		return tbpUpdateDate;
	}

	public void setTbpUpdateDate(Date tbpUpdateDate) {
		this.tbpUpdateDate = tbpUpdateDate;
	}

	public Integer getTbpUpdateId() {
		return tbpUpdateId;
	}

	public void setTbpUpdateId(Integer tbpUpdateId) {
		this.tbpUpdateId = tbpUpdateId;
	}

	public String getTbpBranchBuilding() {
		return tbpBranchBuilding;
	}

	public void setTbpBranchBuilding(String tbpBranchBuilding) {
		this.tbpBranchBuilding = tbpBranchBuilding;
	}

	public String getTbpProjectName() {
		return tbpProjectName;
	}

	public void setTbpProjectName(String tbpProjectName) {
		this.tbpProjectName = tbpProjectName;
	}

	public Integer getTbbId() {
		return tbbId;
	}

	public void setTbbId(Integer tbbId) {
		this.tbbId = tbbId;
	}

	public String getTbpLatitude() {
		return tbpLatitude;
	}

	public void setTbpLatitude(String tbpLatitude) {
		this.tbpLatitude = tbpLatitude;
	}

	public String getTbpLongitude() {
		return tbpLongitude;
	}

	public void setTbpLongitude(String tbpLongitude) {
		this.tbpLongitude = tbpLongitude;
	}

	public Integer getTbpCekinRadius() {
		return tbpCekinRadius;
	}

	public void setTbpCekinRadius(Integer tbpCekinRadius) {
		this.tbpCekinRadius = tbpCekinRadius;
	}

	public String getTbpNote() {
		return tbpNote;
	}

	public void setTbpNote(String tbpNote) {
		this.tbpNote = tbpNote;
	}
}