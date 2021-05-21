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
 * The persistent class for the tb_department database table.
 * 
 */
@Entity
@Table(name = "tb_department")
@NamedQuery(name = "TbDepartment.findAll", query = "SELECT t FROM TbDepartment t")
public class TbDepartment implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "tbd_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tbdId;
	
	@Column(name = "tbd_create_date")
	private Date tbdCreateDate;
	
	@Column(name = "tbd_create_id")
	private Integer tbdCreateId;
	
	@Column(name = "tbd_update_date")
	private Date tbdUpdateDate;
	
	@Column(name = "tbd_update_id")
	private Integer tbdUpdateId;
	
	@Column(name = "tbd_department_name")
	private String tbdDepartmentName;

	public Integer getTbdId() {
		return tbdId;
	}

	public void setTbdId(Integer tbdId) {
		this.tbdId = tbdId;
	}

	public Date getTbdCreateDate() {
		return tbdCreateDate;
	}

	public void setTbdCreateDate(Date tbdCreateDate) {
		this.tbdCreateDate = tbdCreateDate;
	}

	public Integer getTbdCreateId() {
		return tbdCreateId;
	}

	public void setTbdCreateId(Integer tbdCreateId) {
		this.tbdCreateId = tbdCreateId;
	}

	public Date getTbdUpdateDate() {
		return tbdUpdateDate;
	}

	public void setTbdUpdateDate(Date tbdUpdateDate) {
		this.tbdUpdateDate = tbdUpdateDate;
	}

	public Integer getTbdUpdateId() {
		return tbdUpdateId;
	}

	public void setTbdUpdateId(Integer tbdUpdateId) {
		this.tbdUpdateId = tbdUpdateId;
	}

	public String getTbdDepartmentName() {
		return tbdDepartmentName;
	}

	public void setTbdDepartmentName(String tbdDepartmentName) {
		this.tbdDepartmentName = tbdDepartmentName;
	}
}