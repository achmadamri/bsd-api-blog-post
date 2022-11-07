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
 * The persistent class for the tb_data database table.
 * 
 */
@Entity
@Table(name="tb_data")
@NamedQuery(name="TbData.findAll", query="SELECT t FROM TbData t")
public class TbData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tbd_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tbdId;

	@Lob
	@Column(name="tbd_content", columnDefinition = "longtext")
	private String tbdContent;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbd_create_date")
	private Date tbdCreateDate;

	@Column(name="tbd_create_id")
	private int tbdCreateId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbd_update_date")
	private Date tbdUpdateDate;

	@Column(name="tbd_update_id")
	private int tbdUpdateId;

	@Column(name="tbe_id")
	private int tbeId;

	public TbData() {
	}

	public int getTbdId() {
		return this.tbdId;
	}

	public void setTbdId(int tbdId) {
		this.tbdId = tbdId;
	}

	public String getTbdContent() {
		return this.tbdContent;
	}

	public void setTbdContent(String tbdContent) {
		this.tbdContent = tbdContent;
	}

	public Date getTbdCreateDate() {
		return this.tbdCreateDate;
	}

	public void setTbdCreateDate(Date tbdCreateDate) {
		this.tbdCreateDate = tbdCreateDate;
	}

	public int getTbdCreateId() {
		return this.tbdCreateId;
	}

	public void setTbdCreateId(int tbdCreateId) {
		this.tbdCreateId = tbdCreateId;
	}

	public Date getTbdUpdateDate() {
		return this.tbdUpdateDate;
	}

	public void setTbdUpdateDate(Date tbdUpdateDate) {
		this.tbdUpdateDate = tbdUpdateDate;
	}

	public int getTbdUpdateId() {
		return this.tbdUpdateId;
	}

	public void setTbdUpdateId(int tbdUpdateId) {
		this.tbdUpdateId = tbdUpdateId;
	}

	public int getTbeId() {
		return this.tbeId;
	}

	public void setTbeId(int tbeId) {
		this.tbeId = tbeId;
	}

}