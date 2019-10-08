package com.pnc.training.StackOverflow.DAO;

import com.pnc.training.StackOverflow.Entity.Answers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerDao  extends JpaRepository<Answers,Long> {
}
