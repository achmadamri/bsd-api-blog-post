package com.api.psm.member.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.psm.member.db.entity.ViewUserOvertime;

public interface ViewUserOvertimeRepository extends JpaRepository<ViewUserOvertime, Integer> {
	
}