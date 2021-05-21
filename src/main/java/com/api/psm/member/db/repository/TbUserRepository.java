package com.api.psm.member.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.psm.member.db.entity.TbUser;

public interface TbUserRepository extends JpaRepository<TbUser, Integer> {
	
}