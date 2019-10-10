package com.pnc.training.StackOverflow.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Question")
public class Questions {


//    @Column(name="question_Id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long questionId;
    private long userId;
    private String title;
    private String body;
    private String tag;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Questions(String Questions){
    }



    @ElementCollection(targetClass=Answers.class)
   // @OneToMany(targetEntity=Questions.class, mappedBy="answerID",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
  // @OneToMany(targetEntity=Questions.class,fetch = FetchType.LAZY, mappedBy = "questionId", cascade=CascadeType.ALL)
   @JsonIgnore
    @OneToMany
    private List<Answers> answers;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="tag_questions",
            joinColumns = @JoinColumn(name="questionId"),
            inverseJoinColumns = @JoinColumn(name="tagId")
    )

    @JsonIgnore
    private List<Tag> tags;

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @JsonIgnore
    public List<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }

    @JsonIgnore
    public List<Answers> getAnswersList() {
        return answers;
    }

    public void setAnswersList(List<Answers> answersList) {
        this.answers = answersList;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Questions(){

    }

    @Override
    public String toString() {
        return "Questions{" +
                "questionId=" + questionId +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", tag='" + tag + '\'' +
                ", answersList=" + answers +
                '}';
    }


//    @Override
//    public String toString() {
//        return "Questions{" +
//                "questionId=" + questionId +
//                ", answers=" + answers +
//                ", tags=" + tags +
//                '}';
//    }



}
