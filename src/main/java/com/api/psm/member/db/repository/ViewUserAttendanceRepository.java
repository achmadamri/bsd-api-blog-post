package com.api.psm.member.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.psm.member.db.entity.ViewUserAttendance;

public interface ViewUserAttendanceRepository extends JpaRepository<ViewUserAttendance, Integer> {
	
}