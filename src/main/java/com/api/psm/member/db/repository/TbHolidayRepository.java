package com.api.psm.member.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.psm.member.db.entity.TbHoliday;

public interface TbHolidayRepository extends JpaRepository<TbHoliday, Integer> {
	
}