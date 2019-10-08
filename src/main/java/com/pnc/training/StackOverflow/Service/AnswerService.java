package com.pnc.training.StackOverflow.Service;

import com.pnc.training.StackOverflow.Entity.Answers;

public interface AnswerService  {

    public void saveAnswer(Answers answers);

    public Answers getAnswersById(Long id);

    public void updateAnswer(Answers oldanswer, Answers newanswer );

}
