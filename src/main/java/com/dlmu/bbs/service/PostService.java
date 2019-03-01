package com.dlmu.bbs.service;

import com.dlmu.bbs.domain.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPost();
    Post findById(String  id);
    void updataPost(Post post);
    void addPost(Post post);
    void removeById(String id);

}
