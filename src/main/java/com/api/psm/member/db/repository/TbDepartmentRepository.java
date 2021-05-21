package com.api.psm.member.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.psm.member.db.entity.TbDepartment;

public interface TbDepartmentRepository extends JpaRepository<TbDepartment, Integer> {
	
}