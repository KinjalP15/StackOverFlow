package com.pnc.training.StackOverflow.Controller;

import com.pnc.training.StackOverflow.DAO.UserDao;
import com.pnc.training.StackOverflow.Entity.LoginRequest;
import com.pnc.training.StackOverflow.Entity.User;

import com.pnc.training.StackOverflow.Exception.EmailExistsException;
import com.pnc.training.StackOverflow.Exception.StackOverFlowEx;
import com.pnc.training.StackOverflow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NonUniqueResultException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/stackoverflow")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    @PostMapping("/registration")
    public ResponseEntity saveUser(@RequestBody User user) throws NoSuchAlgorithmException,EmailExistsException {

        try {
            System.out.println("user controller "+user.getEmail());
            userService.saveUser(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }  catch(NonUniqueResultException emailException)
        {
//            EmailExistsException ex = new EmailExistsException();
//            ex.setMessage("Invalid Email");
            return new ResponseEntity<NonUniqueResultException>(emailException,HttpStatus.BAD_REQUEST);
        }catch (Exception exception) {
            System.out.println("normal exception "+exception.getClass());
            if(exception.getClass().equals(org.springframework.dao.IncorrectResultSizeDataAccessException.class))
            {
                return new ResponseEntity<EmailExistsException>(new EmailExistsException("email already exists"),HttpStatus.BAD_REQUEST);
            }
            else if(exception.getClass().equals(org.springframework.transaction.TransactionSystemException.class)){
                return new ResponseEntity<EmailExistsException>(new EmailExistsException("Invali email"),HttpStatus.BAD_REQUEST);
            }
            else
            {
                StackOverFlowEx ex = new StackOverFlowEx();

                ex.setStatusCode("1023");
                ex.setMessage("Invalid Email");
                //return new ResponseEntity<Exception>(exception, HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Exception>(exception, HttpStatus.BAD_REQUEST);
        }



    }

//    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
//    public ModelAndView registerUserAccount(
//            @ModelAttribute("user") @Valid User user,
//            BindingResult result,
//            WebRequest request,
//            Errors errors) {
//
//        User registered = new User();
//        if (!result.hasErrors()) {
//            registered = createUserAccount(user, result);
//        }
//        if (registered == null) {
//            result.rejectValue("email", "message.regError");
//        }
//        if (result.hasErrors()) {
//            return new ModelAndView("registration", "user", user);
//        }
//        else {
//            return new ModelAndView("successRegister", "user", user);
//        }
//    }
//    private User createUserAccount(User user, BindingResult bindingResult){
//        User registered = null;
//        try {
//            registered = userService.registerNewUserAccount(user);
//        } catch (EmailExistsException e) {
//            return null;
//        }
//        return registered;
//    }

    @PutMapping(value="user")
    public void updateInfo(@RequestBody User user)
    {
        userService.updateUser(user);
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

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest ) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("token", userService.loginAccount(loginRequest));
            return new ResponseEntity(httpHeaders, HttpStatus.OK);
        } catch (Exception | StackOverFlowEx ex) {
            ex.printStackTrace();
            System.out.println("Bad request");
            return new ResponseEntity(new StackOverFlowEx("1022", "Invalid Data"), HttpStatus.BAD_REQUEST);
        }
    }


}
