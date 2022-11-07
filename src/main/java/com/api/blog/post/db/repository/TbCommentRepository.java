package com.api.blog.post.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.blog.post.db.entity.TbComment;

public interface TbCommentRepository extends JpaRepository<TbComment, Integer> {
}