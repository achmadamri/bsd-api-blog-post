package com.api.dms.member.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.dms.member.db.entity.TbStructure;

public interface TbStructureRepository extends JpaRepository<TbStructure, Integer> {
	public final static String PRINCIPAL = "PRINCIPAL";
	public final static String DISTRIBUTOR = "DISTRIBUTOR";
	public final static String SUBDIST = "SUBDIST";
	public final static String GROSIR = "GROSIR";
}