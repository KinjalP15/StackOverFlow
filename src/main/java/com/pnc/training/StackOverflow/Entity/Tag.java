package com.pnc.training.StackOverflow.Entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tagId;
    private String tagName;

    /*
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="tag_questions",
            joinColumns = @JoinColumn(name="tagId"),
            inverseJoinColumns = @JoinColumn(name="questionId")

    )
    private List<Questions> questionsList;

    public List<Questions> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<Questions> questionsList) {
        this.questionsList = questionsList;
    }
*/
    public  Tag(String tagStr){}

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }


}
