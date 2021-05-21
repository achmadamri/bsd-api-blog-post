package com.api.psm.member.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.psm.member.db.entity.TbNotification;

public interface TbNotificationRepository extends JpaRepository<TbNotification, Integer> {
	
}