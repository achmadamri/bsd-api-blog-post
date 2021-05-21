package com.api.psm.member.db.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.psm.member.db.entity.TbUserAttendance;

import java.util.List;
import java.util.Optional;

public interface TbUserAttendanceRepository extends JpaRepository<TbUserAttendance, Integer> {
//	@Query("SELECT t.title FROM TbUserAttendance t where t.tbuId = :tbuId")
//	public List<TbUserAttendance> findAllByTbuId(Integer tbuId);
//    
//    @Query("SELECT t.title FROM Todo t where t.id = :id") 
//    String findTitleById(@Param("id") Long id);
}