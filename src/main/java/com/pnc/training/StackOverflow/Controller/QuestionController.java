package com.pnc.training.StackOverflow.Controller;

import com.pnc.training.StackOverflow.Entity.Answers;
import com.pnc.training.StackOverflow.Entity.Questions;
import com.pnc.training.StackOverflow.Entity.Tag;
import com.pnc.training.StackOverflow.Service.AnswerService;
import com.pnc.training.StackOverflow.Service.QuestionsService;
import com.pnc.training.StackOverflow.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String getQuestions(){
        List<Questions> questions= questionsService.getAllQuestions();
        return questions.toString();
    }

    @GetMapping("questions/{questionId}")
    public String questionDetails(@PathVariable long questionId) {
        Questions onequestion = questionsService.getQuestionById(questionId);
        return "questionDetails";
    }

    @PostMapping("/question")
    public Questions saveQuestion(@RequestBody Questions questions){
        questionsService.saveQuestion(questions);
        return questions;

    }



    @PostMapping("/questions/{questionId}")
    public String createNewAnswer(@PathVariable long questionId, @RequestBody Answers newAns) {
        Questions questions = questionsService.getQuestionById(questionId);
        //Answers newAns = new Answers();
        newAns.setQuestions(questions);
        answerService.saveAnswer(newAns);
        List<Answers> answersofque = questions.getAnswersList();
        answersofque.add(newAns);
        questions.setAnswersList(answersofque);
        questionsService.saveQuestion(questions);

        return newAns.toString();
    }


}
