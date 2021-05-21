package com.api.psm.member.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.psm.member.db.entity.TbProject;

public interface TbProjectRepository extends JpaRepository<TbProject, Integer> {
	
}