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
@RequestMapping("/stackoverflow123/")
public class TagController {

    @Autowired
    QuestionsService questionsService;

    @Autowired
    TagService tagService;

//    @PostMapping("/questions/new")
//    public String createNewQuestion(@RequestParam(value="question") String question, @RequestParam(value="tags") String tags, Model model) {
//        String[] tagsArr = tags.split(",");
//        int count = 0;
//        List<Tag> tagsForQuestion = new ArrayList<>();
//        Questions newQuestion = new Questions(question);
//        String tagStr = "";
//
//        if(tagsArr.length > 3) {
//            model.addAttribute("tags_err", "Please enter 3 or less tags, all comma separated");
//            model.addAttribute("questionVal", question);
//            return "newQuestion";
//        }
//
//        for(int i=0; i<tagsArr.length; i++){
//
//            System.out.println("tagsarr:" +tagsArr[i]);
//
//            tagStr = tagsArr[i].toLowerCase().trim();
//            count = tagService.findTagCountByTagName(tagStr);
//
//            System.out.println("count: " + count);
//
//            Tag tag = new Tag(tagStr);
//
//            if(count ==0){
//                tagService.saveTag(tag);
//                tagsForQuestion.add(tag);
//            }
//            else{
//                tag = tagService.findByTagName(tagStr);
//                tagsForQuestion.add(tag);
//            }
//
//        }
//
//        newQuestion.setTags(tagsForQuestion);
//        questionsService.saveQuestion(newQuestion);
//
//        return question.toString();
//
//    }

    @PostMapping("{qid}/tags")
    public List<Tag> saveTag(@PathVariable long qid, @RequestBody List<Tag> tag){
        List<Questions> questionsList=new ArrayList<>();
        //List<Tag> tags=new ArrayList<>();

        Questions questions=questionsService.getQuestionById(qid);
        questionsList.add(questions);
        //foreach
        for(Tag temptag: tag ) {
            tagService.saveTag(temptag);
            questions.setTags(tag);
        }
        questionsService.saveQuestion(questions);
        return tag;
    }


}
