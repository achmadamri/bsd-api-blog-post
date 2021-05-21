package com.api.psm.member.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.psm.member.db.entity.TbHierarchy;

public interface TbHierarchyRepository extends JpaRepository<TbHierarchy, Integer> {
	
}