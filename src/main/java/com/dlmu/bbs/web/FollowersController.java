package com.dlmu.bbs.web;

import com.dlmu.bbs.domain.Followers;
import com.dlmu.bbs.service.FollowersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/followers")
@ResponseBody
public class FollowersController {
    @Autowired
    private FollowersService followersService;
    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public List<Followers> getFollowersList(){
        List<Followers> followersList=followersService.getAllFollowers();
        return followersList;
    }
    @RequestMapping(value="/", method=RequestMethod.POST)

    public String postFollowers(@ModelAttribute Followers followers){
        followersService.addFollowers(followers);
        return "'Success!";
    }
   @RequestMapping(value="/{id}", method=RequestMethod.GET)
   public Followers getFollowers(@PathVariable String id){
        return followersService.findById(id);
   }
    @RequestMapping(value="/{id}", method= RequestMethod.PUT)
    public String putFollowers(@PathVariable String id, @ModelAttribute Followers followers){
        Followers followers1=followersService.findById(id);
        followers1.setMarkdown(followers.getMarkdown());
        followers1.setDate(followers.getDate());
        followersService.updataFollowers(followers1);
        return "Success!";
    }
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public  String  deleteFollowers(@PathVariable String id){
        followersService.removeById(id);
        return "Success!";
    }

}
