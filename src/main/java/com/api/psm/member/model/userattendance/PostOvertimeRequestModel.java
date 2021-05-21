package com.api.psm.member.model.userattendance;

import com.api.psm.member.model.RequestModel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PostOvertimeRequestModel extends RequestModel {
   @NotNull(message = "tbuoId can't be null")
   @NotEmpty(message = "tbuoId can't be empty")
   Integer tbuoId;
   Integer tbuId;
   @NotNull(message = "tbuaId can't be null")
   @NotEmpty(message = "tbuaId can't be empty")
   Integer tbuaId;
   @NotNull(message = "tbuoInDate can't be null")
   @NotEmpty(message = "tbuoInDate can't be empty")
   String tbuoInDate;
   @NotNull(message = "tbuoOutDate can't be null")
   @NotEmpty(message = "tbuoOutDate can't be empty")
   String tbuoOutDate;
   @NotNull(message = "tbuoInTime can't be null")
   @NotEmpty(message = "tbuoInTime can't be empty")
   String tbuoInTime;
   @NotNull(message = "tbuoOutTime can't be null")
   @NotEmpty(message = "tbuoOutTime can't be empty")
   String tbuoOutTime;
   @NotNull(message = "tbuoDuration can't be null")
   @NotEmpty(message = "tbuoDuration can't be empty")
   Integer tbuoDuration;

   public Integer getTbuId() {
      return tbuId;
   }

   public void setTbuId(Integer tbuId) {
      this.tbuId = tbuId;
   }

   public Integer getTbuaId() {
      return tbuaId;
   }

   public void setTbuaId(Integer tbuaId) {
      this.tbuaId = tbuaId;
   }

   public Integer getTbuoId() {
      return tbuoId;
   }

   public void setTbuoId(Integer tbuoId) {
      this.tbuoId = tbuoId;
   }

   public String getTbuoInDate() {
      return tbuoInDate;
   }

   public void setTbuoInDate(String tbuoInDate) {
      this.tbuoInDate = tbuoInDate;
   }

   public String getTbuoOutDate() {
      return tbuoOutDate;
   }

   public void setTbuoOutDate(String tbuoOutDate) {
      this.tbuoOutDate = tbuoOutDate;
   }

   public String getTbuoInTime() {
      return tbuoInTime;
   }

   public void setTbuoInTime(String tbuoInTime) {
      this.tbuoInTime = tbuoInTime;
   }

   public String getTbuoOutTime() {
      return tbuoOutTime;
   }

   public void setTbuoOutTime(String tbuoOutTime) {
      this.tbuoOutTime = tbuoOutTime;
   }

   public Integer getTbuoDuration() {
      return tbuoDuration;
   }

   public void setTbuoDuration(Integer tbuoDuration) {
      this.tbuoDuration = tbuoDuration;
   }
}
