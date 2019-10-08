package com.pnc.training.StackOverflow.Service;

import com.pnc.training.StackOverflow.DAO.QuestionsDao;
import com.pnc.training.StackOverflow.Entity.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsServiceImpl implements QuestionsService {

    @Autowired
    QuestionsDao questionsdao;

    @Override
    public List<Questions> getAllQuestions() {
        return (List<Questions>) questionsdao.findAll();
    }

    @Override
    public void saveQuestion(Questions questions) {
         questionsdao.save(questions);

    }

    @Override
    public Questions getQuestionById(Long id) {
       return questionsdao.getOne(id);

    }


}
