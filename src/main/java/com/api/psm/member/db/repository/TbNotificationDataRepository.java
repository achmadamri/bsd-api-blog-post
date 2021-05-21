package com.api.psm.member.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.psm.member.db.entity.TbNotificationData;

public interface TbNotificationDataRepository extends JpaRepository<TbNotificationData, Integer> {
	
}