package com.api.psm.member.model.userattendance;

import com.api.psm.member.model.RequestModel;

public class PutOvertimeRequestModel extends RequestModel {

   Integer tboId;
   String tboStart;
   String tboEnd;
   Integer tboTotal;
   Integer tboTotalNominal;
	public Integer getTboId() {
		return tboId;
	}
	public void setTboId(Integer tboId) {
		this.tboId = tboId;
	}
	public String getTboStart() {
		return tboStart;
	}
	public void setTboStart(String tboStart) {
		this.tboStart = tboStart;
	}
	public String getTboEnd() {
		return tboEnd;
	}
	public void setTboEnd(String tboEnd) {
		this.tboEnd = tboEnd;
	}
	public Integer getTboTotal() {
		return tboTotal;
	}
	public void setTboTotal(Integer tboTotal) {
		this.tboTotal = tboTotal;
	}
	public Integer getTboTotalNominal() {
		return tboTotalNominal;
	}
	public void setTboTotalNominal(Integer tboTotalNominal) {
		this.tboTotalNominal = tboTotalNominal;
	}	
   
}
