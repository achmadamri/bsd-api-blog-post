package com.api.psm.member.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.psm.member.db.entity.TbBusiness;

public interface TbBusinessRepository extends JpaRepository<TbBusiness, Integer> {
	
}