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
@Table(name="tb_hierarchy")
@NamedQuery(name="TbHierarchy.findAll", query="SELECT t FROM TbHierarchy t")
public class TbHierarchy implements Serializable {
	private static final long serialVersionUID = 1L;

	public final static String statusDirect = "direct";
	public final static String statusIndirect = "indirect";

	@Id
	@Column(name="tbh_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tbhId;

	@Column(name="tbh_create_date")
	private Date tbuCreateDate;

	@Column(name="tbh_create_id")
	private Integer tbuCreateId;

	@Column(name="tbh_update_date")
	private Date tbuUpdateDate;

	@Column(name="tbh_update_id")
	private Integer tbuUpdateId;
	
	@Column(name="tbu_id_supervisor")
	private Integer tbuIdSupervisor;
	
	@Column(name="tbu_id_subordinate")
	private Integer tbuIdSubordinate;

	@Column(name="tbh_status")
	private String tbhStatus;

	public Integer getTbhId() {
		return tbhId;
	}

	public void setTbhId(Integer tbhId) {
		this.tbhId = tbhId;
	}

	public Date getTbuCreateDate() {
		return tbuCreateDate;
	}

	public void setTbuCreateDate(Date tbuCreateDate) {
		this.tbuCreateDate = tbuCreateDate;
	}

	public Integer getTbuCreateId() {
		return tbuCreateId;
	}

	public void setTbuCreateId(Integer tbuCreateId) {
		this.tbuCreateId = tbuCreateId;
	}

	public Date getTbuUpdateDate() {
		return tbuUpdateDate;
	}

	public void setTbuUpdateDate(Date tbuUpdateDate) {
		this.tbuUpdateDate = tbuUpdateDate;
	}

	public Integer getTbuUpdateId() {
		return tbuUpdateId;
	}

	public void setTbuUpdateId(Integer tbuUpdateId) {
		this.tbuUpdateId = tbuUpdateId;
	}

	public Integer getTbuIdSupervisor() {
		return tbuIdSupervisor;
	}

	public void setTbuIdSupervisor(Integer tbuIdSupervisor) {
		this.tbuIdSupervisor = tbuIdSupervisor;
	}

	public Integer getTbuIdSubordinate() {
		return tbuIdSubordinate;
	}

	public void setTbuIdSubordinate(Integer tbuIdSubordinate) {
		this.tbuIdSubordinate = tbuIdSubordinate;
	}

	public String getTbhStatus() {
		return tbhStatus;
	}

	public void setTbhStatus(String tbhStatus) {
		this.tbhStatus = tbhStatus;
	}
}