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
@Table(name = "tb_village")
@NamedQuery(name = "TbVillage.findAll", query = "SELECT t FROM TbVillage t")
public class TbVillage implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@Column(name = "district_id")
	private String regencyId;

	@Column(name = "name")
	private String name;

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
}