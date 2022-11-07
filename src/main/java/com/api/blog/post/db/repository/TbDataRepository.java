package com.api.blog.post.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.blog.post.db.entity.TbData;

public interface TbDataRepository extends JpaRepository<TbData, Integer> {
}