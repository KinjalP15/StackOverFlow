package com.pnc.training.StackOverflow.Controller;

import com.pnc.training.StackOverflow.Entity.Questions;
import com.pnc.training.StackOverflow.Entity.Tag;
import com.pnc.training.StackOverflow.Service.QuestionsService;
import com.pnc.training.StackOverflow.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/stackoverflow/v3")
public class TagController {

    @Autowired
    QuestionsService questionsService;

    @Autowired
    TagService tagService;


//    @PostMapping("{qid}/tags")
//    public List<Tag> saveTag(@PathVariable long qid, @RequestBody List<Tag> tag){
//        List<Questions> questionsList=new ArrayList<>();
//        //List<Tag> tags=new ArrayList<>();
//
//        Questions questions=questionsService.getQuestionById(qid);
//        questionsList.add(questions);
//        //foreach
//        for(Tag temptag: tag ) {
//            tagService.saveTag(temptag);
//            questions.setTags(tag);
//        }
//        questionsService.saveQuestion(questions);
//        return tag;
//    }

    @PostMapping(value="{qid}")
    public void tagQuestion(@PathVariable long qid, @RequestBody List<Tag> tag)
    {
        Questions question=questionsService.getQuestionById(qid);
        List<Questions> questions=new ArrayList<>();
        questions.add(question);
        for (Tag temp : tag)
        {
            System.out.println(temp);
            temp.setQuestionsList(questions);
            tagService.saveTag(temp);
        }
        question.setTags(tag);
    }

}
