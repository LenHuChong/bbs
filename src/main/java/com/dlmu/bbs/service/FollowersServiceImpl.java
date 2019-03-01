package com.dlmu.bbs.service;

import com.dlmu.bbs.domain.Followers;
import com.dlmu.bbs.domain.FollowersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowersServiceImpl implements FollowersService {
    @Autowired
    FollowersRepository followersService;

    @Override
    public List<Followers> getAllFollowers() {
        return followersService.findAll();
    }

    @Override
    public Followers findById(String id) {
        return followersService.findById(id).get();
    }

    @Override
    public void updataFollowers(Followers followers) {
            followersService.save(followers);
    }

    @Override
    public void addFollowers(Followers followers) {
            followersService.save(followers);
    }

    @Override
    public void removeById(String id) {
            followersService.deleteById( id);
    }
}
