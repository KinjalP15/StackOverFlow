package com.pnc.training.StackOverflow.DAO;

import com.pnc.training.StackOverflow.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
    public User findByEmail(String email);

}
