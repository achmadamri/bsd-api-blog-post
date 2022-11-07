package com.api.blog.post.db.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the tb_entry database table.
 * 
 */
@Entity
@Table(name="tb_entry")
@NamedQuery(name="TbEntry.findAll", query="SELECT t FROM TbEntry t")
public class TbEntry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tbe_id")
	private int tbeId;

	@Column(name="tbe_chunk")
	private String tbeChunk;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbe_create_date")
	private Date tbeCreateDate;

	@Column(name="tbe_create_id")
	private int tbeCreateId;

	@Column(name="tbe_title")
	private String tbeTitle;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbe_update_date")
	private Date tbeUpdateDate;

	@Column(name="tbe_update_id")
	private int tbeUpdateId;

	public TbEntry() {
	}

	public int getTbeId() {
		return this.tbeId;
	}

	public void setTbeId(int tbeId) {
		this.tbeId = tbeId;
	}

	public String getTbeChunk() {
		return this.tbeChunk;
	}

	public void setTbeChunk(String tbeChunk) {
		this.tbeChunk = tbeChunk;
	}

	public Date getTbeCreateDate() {
		return this.tbeCreateDate;
	}

	public void setTbeCreateDate(Date tbeCreateDate) {
		this.tbeCreateDate = tbeCreateDate;
	}

	public int getTbeCreateId() {
		return this.tbeCreateId;
	}

	public void setTbeCreateId(int tbeCreateId) {
		this.tbeCreateId = tbeCreateId;
	}

	public String getTbeTitle() {
		return this.tbeTitle;
	}

	public void setTbeTitle(String tbeTitle) {
		this.tbeTitle = tbeTitle;
	}

	public Date getTbeUpdateDate() {
		return this.tbeUpdateDate;
	}

	public void setTbeUpdateDate(Date tbeUpdateDate) {
		this.tbeUpdateDate = tbeUpdateDate;
	}

	public int getTbeUpdateId() {
		return this.tbeUpdateId;
	}

	public void setTbeUpdateId(int tbeUpdateId) {
		this.tbeUpdateId = tbeUpdateId;
	}

}