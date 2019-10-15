package com.pnc.training.StackOverflow.Service;
import com.pnc.training.StackOverflow.Entity.LoginRequest;
import com.pnc.training.StackOverflow.Entity.User;
import com.pnc.training.StackOverflow.Exception.EmailExistsException;
import com.pnc.training.StackOverflow.Exception.StackOverFlowEx;

import javax.jws.soap.SOAPBinding;
import javax.persistence.NonUniqueResultException;
import java.security.NoSuchAlgorithmException;

public interface UserService {

    public void saveUser(User user) throws NoSuchAlgorithmException, NonUniqueResultException;

    public String loginAccount(LoginRequest loginRequest) throws StackOverFlowEx;

    public void invalidToken(String token) throws StackOverFlowEx;

    public void updateUser(User user);

    public User getOne(long uid);

    public User registerNewUserAccount(User user) throws EmailExistsException;
}
