package com.dlmu.bbs.web;

import com.dlmu.bbs.domain.Post;
import com.dlmu.bbs.service.PostServiceImpl;
import com.sun.tracing.dtrace.ModuleAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/post")
@ResponseBody
public class PostController {
    @Autowired
   private PostServiceImpl postService;
    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public List<Post> getPostList(){
        List<Post> posts=postService.getAllPost();
        return posts;
    }
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String  postPost(@RequestBody Post post){
        postService.addPost(post);
        postService.set(post.getMarkdown(),post);
        return "Success!";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public  Post getPost(@PathVariable String id){
        return  postService.findById(id);

    }

    @RequestMapping(value="/{id}", method= RequestMethod.PUT)
    public String putPost(@PathVariable String id ,@RequestBody Post post){
        Post post1=postService.findById(id);
        post1.setDate(post.getDate());
        post1.setSectionId(post.getSectionId());
        postService.updataPost(post1);
        return "Success!";
    }
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public  String deletePost(@PathVariable String id ){
        postService.removeById(id);
        return "Success!";
    }

}
