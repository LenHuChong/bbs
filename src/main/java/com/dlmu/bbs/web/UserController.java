package com.dlmu.bbs.web;

import com.dlmu.bbs.domain.User;
import com.dlmu.bbs.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/users")
//@ResponseBody
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public List<User> getUserList(){
       List<User> users= userService.getAllUsers();
    return users ;
    }
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        userService.addUser(user);
        return "Success!";
    }
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable String id){
        return userService.findById(id);
    }
    @RequestMapping(value="/{id}", method= RequestMethod.PUT)
    public String putUser(@PathVariable String id, @ModelAttribute User user){
        User user1=userService.findById(id);
        user1.setAuthority(user.getAuthority());
        user1.setAge(user.getAge());
        userService.updataUser(user1);
        return  "Success!";
    }
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable String id){
        userService.removeById(id);
        return "success";
    }



}
