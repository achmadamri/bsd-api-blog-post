package com.api.psm.member.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.psm.member.db.entity.TbDistrict;

public interface TbDistrictRepository extends JpaRepository<TbDistrict, Integer> {
	
}