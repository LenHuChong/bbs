package com.dlmu.bbs.web;

import com.dlmu.bbs.domain.User;
import com.dlmu.bbs.service.UserServiceImpl;
import com.dlmu.bbs.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/users")
@ResponseBody
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    /**
     * 数据读取当数据量较小时直接从缓存中读取数据
     * 数据量大于该限制时数据被导入到数据库中，从数据库内读值
     * @return
     */
    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public List<User> getUserList(){
        List<User> users=userService.getAllUsers();
        return users ;

    }


    /**
     * post方法缓存机制
     * 数据以list形式大量post到缓存中
     * 当数据超过缓存设定是由缓存读入数据库
     *
     * @param userList
     * @return
     */
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String postUser(@RequestBody List<User> userList){
        for (User user: userList){
           //userService.set(user.getEmail(),user.getName());
            userService.push("User",user);

            if(userService.getLen("User")>=2){

                String str =userService.rightPop("User");
               User user1=JsonUtil.convertString2Obj(str,User.class);
                userService.addUser(user1);

            }


        }


        return "Success!";
    }



    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable String id){
        return userService.findById(id);
    }
    @RequestMapping(value="/{id}", method= RequestMethod.PUT)
    public String putUser(@PathVariable String id, @RequestBody User user){
        User user1=userService.findById(id);
        user1.setAuthority(user.getAuthority());
        user1.setAge(user.getAge());
        userService.updataUser(user1);
        return  "Success!";
    }
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") String id){
        //System.out.println(id);
        userService.removeById(id);
        return "success";
    }



}
