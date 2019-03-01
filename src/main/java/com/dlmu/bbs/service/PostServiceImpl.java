package com.dlmu.bbs.service;

import com.dlmu.bbs.domain.Post;
import com.dlmu.bbs.domain.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postService;
    @Override
    public List<Post> getAllPost() {
        return postService.findAll();
    }

    @Override
    public Post findById(String id) {
        return postService.findById(id).get();
    }

    @Override
    public void updataPost(Post post) {
            postService.save(post);
    }

    @Override
    public void addPost(Post post) {
            postService.save(post);
    }

    @Override
    public void removeById(String id) {
        postService.deleteById(id);
    }
}
