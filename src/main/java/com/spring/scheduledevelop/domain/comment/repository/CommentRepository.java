package com.spring.scheduledevelop.domain.comment.repository;

import com.spring.scheduledevelop.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
