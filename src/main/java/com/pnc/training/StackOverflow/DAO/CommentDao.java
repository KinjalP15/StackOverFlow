package com.pnc.training.StackOverflow.DAO;

import com.pnc.training.StackOverflow.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment,Long> {
}
