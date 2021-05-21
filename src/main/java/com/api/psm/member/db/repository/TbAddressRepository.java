package com.api.psm.member.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.psm.member.db.entity.TbAddress;

public interface TbAddressRepository extends JpaRepository<TbAddress, Integer> {
	
}