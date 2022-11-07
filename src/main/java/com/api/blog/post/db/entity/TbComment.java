package com.api.blog.post.db.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the tb_comment database table.
 * 
 */
@Entity
@Table(name="tb_comment")
@NamedQuery(name="TbComment.findAll", query="SELECT t FROM TbComment t")
public class TbComment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tbc_id")
	private int tbcId;

	@Lob
	@Column(name="tbc_content", columnDefinition = "text")
	private String tbcContent;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbc_create_date")
	private Date tbcCreateDate;

	@Column(name="tbc_create_id")
	private int tbcCreateId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbc_update_date")
	private Date tbcUpdateDate;

	@Column(name="tbc_update_id")
	private int tbcUpdateId;

	@Column(name="tbd_id")
	private int tbdId;

	public TbComment() {
	}

	public int getTbcId() {
		return this.tbcId;
	}

	public void setTbcId(int tbcId) {
		this.tbcId = tbcId;
	}

	public String getTbcContent() {
		return this.tbcContent;
	}

	public void setTbcContent(String tbcContent) {
		this.tbcContent = tbcContent;
	}

	public Date getTbcCreateDate() {
		return this.tbcCreateDate;
	}

	public void setTbcCreateDate(Date tbcCreateDate) {
		this.tbcCreateDate = tbcCreateDate;
	}

	public int getTbcCreateId() {
		return this.tbcCreateId;
	}

	public void setTbcCreateId(int tbcCreateId) {
		this.tbcCreateId = tbcCreateId;
	}

	public Date getTbcUpdateDate() {
		return this.tbcUpdateDate;
	}

	public void setTbcUpdateDate(Date tbcUpdateDate) {
		this.tbcUpdateDate = tbcUpdateDate;
	}

	public int getTbcUpdateId() {
		return this.tbcUpdateId;
	}

	public void setTbcUpdateId(int tbcUpdateId) {
		this.tbcUpdateId = tbcUpdateId;
	}

	public int getTbdId() {
		return this.tbdId;
	}

	public void setTbdId(int tbdId) {
		this.tbdId = tbdId;
	}

}