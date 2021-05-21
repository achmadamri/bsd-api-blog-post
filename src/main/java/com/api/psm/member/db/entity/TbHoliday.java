package com.api.psm.member.db.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_holiday database table.
 * 
 */
@Entity
@Table(name="tb_holiday")
@NamedQuery(name="TbHoliday.findAll", query="SELECT t FROM TbHoliday t")
public class TbHoliday implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tbh_id")
	private int tbhId;

	@Column(name="tbh_date")
	private String tbhDate;

	public TbHoliday() {
	}

	public int getTbhId() {
		return this.tbhId;
	}

	public void setTbhId(int tbhId) {
		this.tbhId = tbhId;
	}

	public String getTbhDate() {
		return this.tbhDate;
	}

	public void setTbhDate(String tbhDate) {
		this.tbhDate = tbhDate;
	}

}