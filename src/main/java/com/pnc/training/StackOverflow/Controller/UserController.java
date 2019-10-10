package com.pnc.training.StackOverflow.Controller;

import com.pnc.training.StackOverflow.DAO.UserDao;
import com.pnc.training.StackOverflow.Entity.LoginRequest;
import com.pnc.training.StackOverflow.Entity.User;

import com.pnc.training.StackOverflow.Exception.StackOverFlowEx;
import com.pnc.training.StackOverflow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/stackoverflow")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    @PostMapping("/signup")
    public ResponseEntity saveUser(@RequestBody User user) throws NoSuchAlgorithmException{
       try {

           userService.saveUser(user);
           return new ResponseEntity<User>(user,HttpStatus.OK);
       }catch(Exception exception)
       {
           StackOverFlowEx ex=new StackOverFlowEx();
           ex.setStatusCode("1023");
           ex.setMessage("Invalid Email");
           return new ResponseEntity<StackOverFlowEx>(ex,HttpStatus.BAD_REQUEST);
       }


    }

//    @PostMapping("{userid}")
//    public ResponseEntity updateUserDetails(@PathVariable long userid, @RequestBody User user){
//        if(userDao.existsById(userid)){
//            User oldUser = userDao.findById(userid).get();
//            oldUser.setFirstname(user.getFirstname());
//            oldUser.setLastname(user.getLastname());
//            oldUser.setEmail(user.getEmail());
//            oldUser.setPassword(user.getPassword());
//            userDao.save(oldUser);
//            return ResponseEntity.status(HttpStatus.OK).build();
//
//
//        }
//        else{
//            return new ResponseEntity(new StackOverFlowEx("1021", "user Not Found"),HttpStatus.BAD_REQUEST);
//        }
//
//    }

    @PostMapping("/login1")
    public ResponseEntity Login(@RequestBody User user){
        try{
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("token",userService.loginAccount(user));
            return new ResponseEntity(httpHeaders,HttpStatus.OK);
        }
        catch (Exception | StackOverFlowEx ex){
            System.out.println("Bad request");
            return new ResponseEntity(new StackOverFlowEx("1022","Invalid Data"),HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(@RequestBody LoginRequest loginRequest) {

            User user=userDao.findByEmail(loginRequest.getEmail());
            if(user.getPassword().equals(loginRequest.getPassword()))
            {
                System.out.println("true kinjal");
            }
        return user;
    }

}
