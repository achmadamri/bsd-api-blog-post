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
@Table(name = "tb_user_project")
@NamedQuery(name = "TbUserProject.findAll", query = "SELECT t FROM TbUserProject t")
public class TbUserProject implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "tbup_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tbupId;
	
	@Column(name = "tbup_create_date")
	private Date tbupCreateDate;
	
	@Column(name = "tbup_create_id")
	private Integer tbupCreateId;
	
	@Column(name = "tbup_update_date")
	private Date tbupUpdateDate;
	
	@Column(name = "tbup_update_id")
	private Integer tbupUpdateId;
	
	@Column(name = "tbu_member_id")
	private Integer tbuMemberId;
	
	@Column(name = "tbp_id")
	private Integer tbpId;

	public Integer getTbupId() {
		return tbupId;
	}

	public void setTbupId(Integer tbupId) {
		this.tbupId = tbupId;
	}

	public Date getTbupCreateDate() {
		return tbupCreateDate;
	}

	public void setTbupCreateDate(Date tbupCreateDate) {
		this.tbupCreateDate = tbupCreateDate;
	}

	public Integer getTbupCreateId() {
		return tbupCreateId;
	}

	public void setTbupCreateId(Integer tbupCreateId) {
		this.tbupCreateId = tbupCreateId;
	}

	public Date getTbupUpdateDate() {
		return tbupUpdateDate;
	}

	public void setTbupUpdateDate(Date tbupUpdateDate) {
		this.tbupUpdateDate = tbupUpdateDate;
	}

	public Integer getTbupUpdateId() {
		return tbupUpdateId;
	}

	public void setTbupUpdateId(Integer tbupUpdateId) {
		this.tbupUpdateId = tbupUpdateId;
	}

	public Integer getTbuMemberId() {
		return tbuMemberId;
	}

	public void setTbuMemberId(Integer tbuMemberId) {
		this.tbuMemberId = tbuMemberId;
	}

	public Integer getTbpId() {
		return tbpId;
	}

	public void setTbpId(Integer tbpId) {
		this.tbpId = tbpId;
	}
}