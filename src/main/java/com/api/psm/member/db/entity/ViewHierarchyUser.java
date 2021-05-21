package com.api.psm.member.db.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the view_hierarchy_user database table.
 * 
 */
@Entity
@Table(name="view_hierarchy_user")
@NamedQuery(name="ViewHierarchyUser.findAll", query="SELECT t FROM ViewHierarchyUser t")
public class ViewHierarchyUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="uuid")
	private String uuid;

	@Column(name="tbh_id")
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
	
	@Column(name="tbuspv_tbu_id")
	private Integer tbuspvTbuId;

	@Column(name="tbuspv_tbu_email")
	private String tbuspvTbuEmail;

	@Column(name="tbuspv_tbu_firstname")
	private String tbuspvTbuFirstname;

	@Column(name="tbuspv_tbu_lastname")
	private String tbuspvTbuLastname;

	@Column(name="tbuspv_tbu_member_id")
	private String tbuspvTbuMemberId;
	
	@Column(name="tbusub_tbu_id")
	private Integer tbusubTbuId;

	@Column(name="tbusub_tbu_email")
	private String tbusubTbuEmail;

	@Column(name="tbusub_tbu_firstname")
	private String tbusubTbuFirstname;

	@Column(name="tbusub_tbu_lastname")
	private String tbusubTbuLastname;

	@Column(name="tbusub_tbu_member_id")
	private String tbusubTbuMemberId;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

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

	public Integer getTbuspvTbuId() {
		return tbuspvTbuId;
	}

	public void setTbuspvTbuId(Integer tbuspvTbuId) {
		this.tbuspvTbuId = tbuspvTbuId;
	}

	public String getTbuspvTbuEmail() {
		return tbuspvTbuEmail;
	}

	public void setTbuspvTbuEmail(String tbuspvTbuEmail) {
		this.tbuspvTbuEmail = tbuspvTbuEmail;
	}

	public String getTbuspvTbuFirstname() {
		return tbuspvTbuFirstname;
	}

	public void setTbuspvTbuFirstname(String tbuspvTbuFirstname) {
		this.tbuspvTbuFirstname = tbuspvTbuFirstname;
	}

	public String getTbuspvTbuLastname() {
		return tbuspvTbuLastname;
	}

	public void setTbuspvTbuLastname(String tbuspvTbuLastname) {
		this.tbuspvTbuLastname = tbuspvTbuLastname;
	}

	public String getTbuspvTbuMemberId() {
		return tbuspvTbuMemberId;
	}

	public void setTbuspvTbuMemberId(String tbuspvTbuMemberId) {
		this.tbuspvTbuMemberId = tbuspvTbuMemberId;
	}

	public Integer getTbusubTbuId() {
		return tbusubTbuId;
	}

	public void setTbusubTbuId(Integer tbusubTbuId) {
		this.tbusubTbuId = tbusubTbuId;
	}

	public String getTbusubTbuEmail() {
		return tbusubTbuEmail;
	}

	public void setTbusubTbuEmail(String tbusubTbuEmail) {
		this.tbusubTbuEmail = tbusubTbuEmail;
	}

	public String getTbusubTbuFirstname() {
		return tbusubTbuFirstname;
	}

	public void setTbusubTbuFirstname(String tbusubTbuFirstname) {
		this.tbusubTbuFirstname = tbusubTbuFirstname;
	}

	public String getTbusubTbuLastname() {
		return tbusubTbuLastname;
	}

	public void setTbusubTbuLastname(String tbusubTbuLastname) {
		this.tbusubTbuLastname = tbusubTbuLastname;
	}

	public String getTbusubTbuMemberId() {
		return tbusubTbuMemberId;
	}

	public void setTbusubTbuMemberId(String tbusubTbuMemberId) {
		this.tbusubTbuMemberId = tbusubTbuMemberId;
	}
}