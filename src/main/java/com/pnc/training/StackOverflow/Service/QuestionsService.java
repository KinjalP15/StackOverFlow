package com.pnc.training.StackOverflow.Service;

import com.pnc.training.StackOverflow.Entity.Questions;

import java.util.List;

public interface QuestionsService {

    public List<Questions> getAllQuestions();

    public void saveQuestion(Questions questions);

    public Questions getQuestionById(Long id);

    public void deleteQuestionById(Long id);


}
