package com.pnc.training.StackOverflow.Service;
import com.pnc.training.StackOverflow.Entity.User;
public interface UserService {

    public void saveUser(User user);

    public void updateUser(User olduser, User newuser);
}
