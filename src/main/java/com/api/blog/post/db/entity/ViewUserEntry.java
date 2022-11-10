package com.api.blog.post.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the view_user_entry database table.
 * 
 */
@Entity
@Table(name="view_user_entry")
@NamedQuery(name="ViewUserEntry.findAll", query="SELECT v FROM ViewUserEntry v")
public class ViewUserEntry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="tbe_chunk")
	private String tbeChunk;
	
	@Lob
	@Column(name="tbe_content", columnDefinition = "longtext")
	private String tbeContent;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbe_create_date")
	private Date tbeCreateDate;

	@Column(name="tbe_create_id")
	private Integer tbeCreateId;

	@Column(name="tbe_id")
	private Integer tbeId;

	@Column(name="tbe_title")
	private String tbeTitle;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbe_update_date")
	private Date tbeUpdateDate;

	@Column(name="tbe_update_id")
	private Integer tbeUpdateId;

	@Column(name="tbu_email")
	private String tbuEmail;

	@Column(name="tbu_firstname")
	private String tbuFirstname;

	@Column(name="tbu_id")
	private Integer tbuId;

	@Column(name="tbu_lastname")
	private String tbuLastname;

	@Id
	private String uuid;

	public ViewUserEntry() {
	}

	public String getTbeChunk() {
		return tbeChunk;
	}

	public void setTbeChunk(String tbeChunk) {
		this.tbeChunk = tbeChunk;
	}

	public String getTbeContent() {
		return tbeContent;
	}

	public void setTbeContent(String tbeContent) {
		this.tbeContent = tbeContent;
	}

	public Date getTbeCreateDate() {
		return tbeCreateDate;
	}

	public void setTbeCreateDate(Date tbeCreateDate) {
		this.tbeCreateDate = tbeCreateDate;
	}

	public Integer getTbeCreateId() {
		return tbeCreateId;
	}

	public void setTbeCreateId(Integer tbeCreateId) {
		this.tbeCreateId = tbeCreateId;
	}

	public Integer getTbeId() {
		return tbeId;
	}

	public void setTbeId(Integer tbeId) {
		this.tbeId = tbeId;
	}

	public String getTbeTitle() {
		return tbeTitle;
	}

	public void setTbeTitle(String tbeTitle) {
		this.tbeTitle = tbeTitle;
	}

	public Date getTbeUpdateDate() {
		return tbeUpdateDate;
	}

	public void setTbeUpdateDate(Date tbeUpdateDate) {
		this.tbeUpdateDate = tbeUpdateDate;
	}

	public Integer getTbeUpdateId() {
		return tbeUpdateId;
	}

	public void setTbeUpdateId(Integer tbeUpdateId) {
		this.tbeUpdateId = tbeUpdateId;
	}

	public String getTbuEmail() {
		return tbuEmail;
	}

	public void setTbuEmail(String tbuEmail) {
		this.tbuEmail = tbuEmail;
	}

	public String getTbuFirstname() {
		return tbuFirstname;
	}

	public void setTbuFirstname(String tbuFirstname) {
		this.tbuFirstname = tbuFirstname;
	}

	public Integer getTbuId() {
		return tbuId;
	}

	public void setTbuId(Integer tbuId) {
		this.tbuId = tbuId;
	}

	public String getTbuLastname() {
		return tbuLastname;
	}

	public void setTbuLastname(String tbuLastname) {
		this.tbuLastname = tbuLastname;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}