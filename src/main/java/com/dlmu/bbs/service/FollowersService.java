package com.dlmu.bbs.service;

import com.dlmu.bbs.domain.Followers;

import java.util.List;

public interface FollowersService {
    List<Followers>getAllFollowers();
    Followers findById(String id);
    void updataFollowers(Followers followers);//follows在这里是单数的帖子
    void addFollowers(Followers followers);
    void removeById(String id);
}
