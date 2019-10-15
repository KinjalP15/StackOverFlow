package com.pnc.training.StackOverflow.Service;

import com.pnc.training.StackOverflow.DAO.UserDao;
import com.pnc.training.StackOverflow.Entity.LoginRequest;
import com.pnc.training.StackOverflow.Entity.User;
import com.pnc.training.StackOverflow.Exception.EmailExistsException;
import com.pnc.training.StackOverflow.Exception.StackOverFlowEx;
import com.pnc.training.StackOverflow.Security.JWTHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NonUniqueResultException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
   private  JWTHandler jwtHandler;

    @Override
    public void saveUser(User user) throws NoSuchAlgorithmException, NonUniqueResultException {
        if(userDao.findByEmail(user.getEmail())!=null)
        {
            System.out.println("Email exist");
            throw new NonUniqueResultException();
        }
        System.out.println("email doesnt exist");
        user.setPassword(toHexString(getSHA(user.getPassword())));
        userDao.save(user);
    }

    @Override
    public String loginAccount(LoginRequest loginRequest) throws StackOverFlowEx {
        User user1 = userDao.findByEmail(loginRequest.getEmail());
        String token = null;
        try{
            if(user1 != null && user1.getPassword().equals(toHexString(getSHA(loginRequest.getPassword())))) {
                token = jwtHandler.createToken(user1.getUserId());
            }
        }
       catch (Exception e){
            System.out.println("User has entered invalid user name and passsword");
            throw new StackOverFlowEx("1024","Invalid Username and Password");
       }
        return token;
    }

    @Override
    public void invalidToken(String token) throws StackOverFlowEx {
        try{
            jwtHandler.revokeToken(token);
        }
        catch (Exception ex){
            System.out.println("Failed to logout the user");
            throw new StackOverFlowEx("1023","Failed to Logout");
        }
    }

    private static byte[] getSHA(String input) throws NoSuchAlgorithmException{
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        return messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
    }


    private static String toHexString(byte[] hash){
        BigInteger number = new BigInteger(1,hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while(hexString.length() < 32){
            hexString.insert(0,'0');
        }
        return hexString.toString();
    }

    @Override
    public void updateUser(User user) {
        userDao.save(user);

    }

    @Override
    public User getOne(long uid) {
        return userDao.getOne(uid);
    }

    @Override
    public User registerNewUserAccount(User user) throws EmailExistsException {
        if((userDao.findByEmail(user.getEmail())==null)){
            throw new EmailExistsException("There is an account with that email address:"  + user.getEmail());
        }
       User user1 = new User();
        user1.setFirstname(user.getFirstname());
        user1.setLastname(user.getLastname());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());

        return userDao.save(user);
    }

//    private boolean emailExists(String email) {
//        User user = userDao.findByEmail(email);
//        if (user != null) {
//            return true;
//        }
//        return false;
//    }
}
