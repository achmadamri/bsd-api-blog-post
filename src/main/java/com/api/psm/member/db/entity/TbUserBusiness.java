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
 * The persistent class for the tb_user_business database table.
 * 
 */
@Entity
@Table(name = "tb_user_business")
@NamedQuery(name = "TbUserBusiness.findAll", query = "SELECT t FROM TbUserBusiness t")
public class TbUserBusiness implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "tbub_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tbubId;
	
	@Column(name = "tbub_create_date")
	private Date tbubCreateDate;
	
	@Column(name = "tbub_create_id")
	private Integer tbubCreateId;
	
	@Column(name = "tbub_update_date")
	private Date tbubUpdateDate;
	
	@Column(name = "tbub_update_id")
	private Integer tbubUpdateId;
	
	@Column(name = "tbu_member_id")
	private Integer tbuMemberId;
	
	@Column(name = "tbb_id")
	private Integer tbbId;

	public Integer getTbubId() {
		return tbubId;
	}

	public void setTbubId(Integer tbubId) {
		this.tbubId = tbubId;
	}

	public Date getTbubCreateDate() {
		return tbubCreateDate;
	}

	public void setTbubCreateDate(Date tbubCreateDate) {
		this.tbubCreateDate = tbubCreateDate;
	}

	public Integer getTbubCreateId() {
		return tbubCreateId;
	}

	public void setTbubCreateId(Integer tbubCreateId) {
		this.tbubCreateId = tbubCreateId;
	}

	public Date getTbubUpdateDate() {
		return tbubUpdateDate;
	}

	public void setTbubUpdateDate(Date tbubUpdateDate) {
		this.tbubUpdateDate = tbubUpdateDate;
	}

	public Integer getTbubUpdateId() {
		return tbubUpdateId;
	}

	public void setTbubUpdateId(Integer tbubUpdateId) {
		this.tbubUpdateId = tbubUpdateId;
	}

	public Integer getTbuMemberId() {
		return tbuMemberId;
	}

	public void setTbuMemberId(Integer tbuMemberId) {
		this.tbuMemberId = tbuMemberId;
	}

	public Integer getTbbId() {
		return tbbId;
	}

	public void setTbbId(Integer tbbId) {
		this.tbbId = tbbId;
	}
}