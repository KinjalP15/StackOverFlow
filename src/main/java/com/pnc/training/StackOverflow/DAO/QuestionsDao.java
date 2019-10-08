package com.pnc.training.StackOverflow.DAO;

import com.pnc.training.StackOverflow.Entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsDao extends JpaRepository<Questions, Long> {
    Questions getByTitle(String question);
}
