package com.api.psm.member.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.psm.member.db.entity.TbUserBusiness;

public interface TbUserBusinessRepository extends JpaRepository<TbUserBusiness, Integer> {
	
}