package com.pnc.training.StackOverflow.Service;

import com.pnc.training.StackOverflow.DAO.CommentDao;
import com.pnc.training.StackOverflow.Entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Override
    public void saveComment(Comment comment) {
        commentDao.save(comment);

    }

    @Override
    public List<Comment> getAllCommnet() {
     return commentDao.findAll();
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentDao.getOne(id);
    }
}
