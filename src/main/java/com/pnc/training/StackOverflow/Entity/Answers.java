package com.pnc.training.StackOverflow.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="answer")
public class Answers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long answerId;
    private String body;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    //@JoinColumn(name="questionId")
    private Questions questions;

    public Answers(){}

    //Comments to add
    @ElementCollection(targetClass = Comment.class)
    @OneToMany(mappedBy = "answers",cascade = CascadeType.MERGE)
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }


    public Answers(long answerId, String body, Questions questions, List<Comment> comments) {
        this.answerId = answerId;
        this.body = body;
        this.questions = questions;
        this.comments = comments;
    }

    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Answers{" +
                "answerId=" + answerId +
                ", body='" + body + '\'' +

                ", comments=" + comments +
                '}';
    }
}
