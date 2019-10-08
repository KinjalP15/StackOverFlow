package com.pnc.training.StackOverflow.Service;

import com.pnc.training.StackOverflow.DAO.UserDao;
import com.pnc.training.StackOverflow.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    public void updateUser(User olduser, User newuser) {
        olduser.setUserId(newuser.getUserId());
    }
}
