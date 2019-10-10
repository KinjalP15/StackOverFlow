package com.pnc.training.StackOverflow.Service;
import com.pnc.training.StackOverflow.Entity.User;
import com.pnc.training.StackOverflow.Exception.StackOverFlowEx;

import javax.jws.soap.SOAPBinding;
import java.security.NoSuchAlgorithmException;

public interface UserService {

    public void saveUser(User user) throws NoSuchAlgorithmException;

    public String loginAccount(User user) throws StackOverFlowEx;

    public void invalidToken(String token) throws StackOverFlowEx;


    public void updateUser(User olduser, User newuser);
}
