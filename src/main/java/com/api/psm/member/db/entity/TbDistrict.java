package com.api.psm.member.db.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the tb_districts database table.
 * 
 */
@Entity
@Table(name = "tb_district")
@NamedQuery(name = "TbDistrict.findAll", query = "SELECT t FROM TbDistrict t")
public class TbDistrict implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@Column(name = "regency_id")
	private String regencyId;

	@Column(name = "name")
	private String name;

	@Column(name = "province_id")
	private String provinceId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRegencyId() {
		return regencyId;
	}

	public void setRegencyId(String regencyId) {
		this.regencyId = regencyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
}