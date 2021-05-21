package com.api.psm.member.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.psm.member.db.entity.TbVillage;

public interface TbVillageRepository extends JpaRepository<TbVillage, Integer> {
	
}