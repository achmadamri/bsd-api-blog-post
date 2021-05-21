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
 * The persistent class for the tb_user_department database table.
 * 
 */
@Entity
@Table(name = "tb_user_department")
@NamedQuery(name = "TbUserDepartment.findAll", query = "SELECT t FROM TbUserDepartment t")
public class TbUserDepartment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "tbud_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tbudId;
	
	@Column(name = "tbud_create_date")
	private Date tbudCreateDate;
	
	@Column(name = "tbud_create_id")
	private Integer tbudCreateId;
	
	@Column(name = "tbud_update_date")
	private Date tbudUpdateDate;
	
	@Column(name = "tbud_update_id")
	private Integer tbudUpdateId;
	
	@Column(name = "tbu_member_id")
	private Integer tbuMemberId;
	
	@Column(name = "tbd_id")
	private Integer tbdId;

	public Integer getTbudId() {
		return tbudId;
	}

	public void setTbudId(Integer tbudId) {
		this.tbudId = tbudId;
	}

	public Date getTbudCreateDate() {
		return tbudCreateDate;
	}

	public void setTbudCreateDate(Date tbudCreateDate) {
		this.tbudCreateDate = tbudCreateDate;
	}

	public Integer getTbudCreateId() {
		return tbudCreateId;
	}

	public void setTbudCreateId(Integer tbudCreateId) {
		this.tbudCreateId = tbudCreateId;
	}

	public Date getTbudUpdateDate() {
		return tbudUpdateDate;
	}

	public void setTbudUpdateDate(Date tbudUpdateDate) {
		this.tbudUpdateDate = tbudUpdateDate;
	}

	public Integer getTbudUpdateId() {
		return tbudUpdateId;
	}

	public void setTbudUpdateId(Integer tbudUpdateId) {
		this.tbudUpdateId = tbudUpdateId;
	}

	public Integer getTbuMemberId() {
		return tbuMemberId;
	}

	public void setTbuMemberId(Integer tbuMemberId) {
		this.tbuMemberId = tbuMemberId;
	}

	public Integer getTbdId() {
		return tbdId;
	}

	public void setTbdId(Integer tbdId) {
		this.tbdId = tbdId;
	}
}