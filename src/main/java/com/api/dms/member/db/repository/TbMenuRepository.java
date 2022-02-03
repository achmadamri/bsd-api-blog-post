package com.api.dms.member.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.dms.member.db.entity.TbMenu;

public interface TbMenuRepository extends JpaRepository<TbMenu, Integer> {
}