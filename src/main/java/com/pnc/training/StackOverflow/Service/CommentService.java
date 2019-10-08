package com.pnc.training.StackOverflow.Service;

import com.pnc.training.StackOverflow.Entity.Comment;

import java.util.List;

public interface CommentService {

    public void saveComment(Comment comment);

    public List<Comment> getAllCommnet();

    public Comment getCommentById(Long id);
}
