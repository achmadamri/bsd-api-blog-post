package com.api.blog.post.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.blog.post.db.entity.ViewUserEntry;

public interface ViewUserEntryRepository extends JpaRepository<ViewUserEntry, Integer> {
}