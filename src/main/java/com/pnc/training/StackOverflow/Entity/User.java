package com.pnc.training.StackOverflow.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String firstname;
    private String lastname;
    private String email;
    private String password;


    @JsonIgnore
    @OneToMany
    public List<Questions> questions;

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }

    public User(){

    }

//    public User(long userId, String firstname, String lastname, String email, String password) {
//        this.userId = userId;
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.email = email;
//        this.password = password;
//    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


//    @Override
//    public String toString() {
//        return "User{" +
//                "userId=" + userId +
//                ", firstname='" + firstname + '\'' +
//                ", lastname='" + lastname + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", questions=" + questions +
//                '}';
//    }
}
