package com.api.dms.member.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_structure database table.
 * 
 */
@Entity
@Table(name="tb_structure")
@NamedQuery(name="TbStructure.findAll", query="SELECT t FROM TbStructure t")
public class TbStructure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tbs_id")
	private Integer tbsId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbs_create_date")
	private Date tbsCreateDate;

	@Column(name="tbs_create_id")
	private Integer tbsCreateId;

	@Column(name="tbs_id_parent")
	private Integer tbsIdParent;

	@Column(name="tbs_name")
	private String tbsName;

	@Column(name="tbs_role")
	private String tbsRole;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbs_update_date")
	private Date tbsUpdateDate;

	@Column(name="tbs_update_id")
	private Integer tbsUpdateId;

	public TbStructure() {
	}

	public Integer getTbsId() {
		return this.tbsId;
	}

	public void setTbsId(Integer tbsId) {
		this.tbsId = tbsId;
	}

	public Date getTbsCreateDate() {
		return this.tbsCreateDate;
	}

	public void setTbsCreateDate(Date tbsCreateDate) {
		this.tbsCreateDate = tbsCreateDate;
	}

	public Integer getTbsCreateId() {
		return this.tbsCreateId;
	}

	public void setTbsCreateId(Integer tbsCreateId) {
		this.tbsCreateId = tbsCreateId;
	}

	public Integer getTbsIdParent() {
		return this.tbsIdParent;
	}

	public void setTbsIdParent(Integer tbsIdParent) {
		this.tbsIdParent = tbsIdParent;
	}

	public String getTbsName() {
		return this.tbsName;
	}

	public void setTbsName(String tbsName) {
		this.tbsName = tbsName;
	}

	public String getTbsRole() {
		return this.tbsRole;
	}

	public void setTbsRole(String tbsRole) {
		this.tbsRole = tbsRole;
	}

	public Date getTbsUpdateDate() {
		return this.tbsUpdateDate;
	}

	public void setTbsUpdateDate(Date tbsUpdateDate) {
		this.tbsUpdateDate = tbsUpdateDate;
	}

	public Integer getTbsUpdateId() {
		return this.tbsUpdateId;
	}

	public void setTbsUpdateId(Integer tbsUpdateId) {
		this.tbsUpdateId = tbsUpdateId;
	}

}