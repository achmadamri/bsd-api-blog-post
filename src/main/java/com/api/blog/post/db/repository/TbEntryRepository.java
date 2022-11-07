package com.api.blog.post.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.blog.post.db.entity.TbEntry;

public interface TbEntryRepository extends JpaRepository<TbEntry, Integer> {
}