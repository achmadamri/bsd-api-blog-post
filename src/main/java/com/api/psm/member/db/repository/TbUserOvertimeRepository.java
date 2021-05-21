package com.api.psm.member.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.psm.member.db.entity.TbUserOvertime;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TbUserOvertimeRepository extends JpaRepository<TbUserOvertime, Integer> {
//	@Query("select t from TbUserOvertime t where t.tbuaIdIn=?1")
//   Optional<TbUserOvertime> findByTbuaIdIn(Integer tbuaIdIn);
}