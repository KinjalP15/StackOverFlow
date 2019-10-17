package com.pnc.training.StackOverflow.Controller;

import com.pnc.training.StackOverflow.Entity.Answers;
import com.pnc.training.StackOverflow.Entity.Questions;
import com.pnc.training.StackOverflow.Entity.Tag;
import com.pnc.training.StackOverflow.Service.AnswerService;
import com.pnc.training.StackOverflow.Service.QuestionsService;
import com.pnc.training.StackOverflow.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stackoverflow/v1")
public class QuestionController {

    @Autowired
    QuestionsService questionsService;

    @Autowired
    AnswerService answerService;



    @GetMapping("/question")
    public ResponseEntity getQuestions(){
        return new ResponseEntity(questionsService.getAllQuestions(), HttpStatus.OK);
    }

    @GetMapping("questions/{questionId}")
    public String questionDetails(@PathVariable long questionId) {
        Questions onequestion = questionsService.getQuestionById(questionId);
        return onequestion.toString();
    }

    @PostMapping("/question")
    public Questions saveQuestion(@RequestBody Questions questions){
        questionsService.saveQuestion(questions);
        return questions;

    }



    //@PostMapping("/questions/{questionId}")
    @PostMapping("questions/ans")
    public String createNewAnswer(@RequestBody Answers newAns) {
//        Questions questions = questionsService.getQuestionById(newAns.getQuestions().getQuestionId());
//        //Answers newAns = new Answers();
//        newAns.setQuestions(questions);
//        answerService.saveAnswer(newAns);
//        List<Answers> answersofque = questions.getAnswersList();
//        answersofque.add(newAns);
//        questions.setAnswersList(answersofque);
//        questionsService.saveQuestion(questions);
        answerService.saveAnswer(newAns);

        return newAns.toString();
    }

    @DeleteMapping("/question/{id}")
    public void deleteQuestionById(@PathVariable Long id){
        questionsService.deleteQuestionById(id);
    }


}
