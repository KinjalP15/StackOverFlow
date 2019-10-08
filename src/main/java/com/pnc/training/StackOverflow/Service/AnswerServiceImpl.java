package com.pnc.training.StackOverflow.Service;

import com.pnc.training.StackOverflow.DAO.AnswerDao;
import com.pnc.training.StackOverflow.Entity.Answers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService{

    @Autowired
    AnswerDao answerDao;

    @Override
    public void saveAnswer(Answers answers) {
        answerDao.save(answers);

    }

    @Override
    public Answers getAnswersById(Long id) {
        return answerDao.getOne(id);
    }

    @Override
    public void updateAnswer(Answers oldanswer, Answers newanswer) {
        oldanswer.setAnswerId(newanswer.getAnswerId());
    }


}
