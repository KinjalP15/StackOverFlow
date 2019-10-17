package com.pnc.training.StackOverflow.Controller;

import com.pnc.training.StackOverflow.Entity.Answers;
import com.pnc.training.StackOverflow.Entity.Comment;
import com.pnc.training.StackOverflow.Service.AnswerService;
import com.pnc.training.StackOverflow.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stackoverflow/v2")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    AnswerService answerService;

    @PostMapping("/addcomment")
    public Comment saveQuestion(@RequestBody Comment comment){
        commentService.saveComment(comment);
        return comment;

    }

    @PostMapping("/answer/comment")
    public  String createComment(@RequestBody Comment newComment){
        commentService.saveComment(newComment);
        return newComment.toString();
    }
//    @PostMapping("/answers/{answerId}")
//    public String createComment(@PathVariable long answerId, @RequestBody Comment newcomment) {
//        Answers answers = answerService.getAnswersById(answerId);
//        //Answers newAns = new Answers();
//        newcomment.setAnswers(answers);
//        commentService.saveComment(newcomment);
//        List<Comment> ansofcomment = answers.getComments();
//        ansofcomment.add(newcomment);
//        answers.setComments(ansofcomment);
//        answerService.saveAnswer(answers);
//
//        return newcomment.toString();
//
//    }

    @GetMapping("/comments")
    public String getComments(){
        List<Comment> comments= commentService.getAllCommnet();
        return comments.toString();
    }
}
