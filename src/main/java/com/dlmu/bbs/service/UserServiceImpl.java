package com.dlmu.bbs.service;

import com.dlmu.bbs.domain.User;
import com.dlmu.bbs.domain.UserRepository;
import com.dlmu.bbs.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, RedisService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void updataUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void removeById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public void set(String key, Object value) {
        String str = JsonUtil.convertObj2String(value);

        redisTemplate.opsForValue().set(key, str);
    }

    @Override
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public <T> T get(String key, Class<T> clazz) {
        String s = get(key);
        if (null == s) {
            return null;
        }
        return JsonUtil.convertString2Obj(s, clazz);
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public void push(String key, User value) {
        String str = JsonUtil.convertObj2String(value);
        redisTemplate.opsForList().leftPush(key, str);
    }
    public String rightPop (String key){

       return redisTemplate.opsForList().rightPop(key);
    }

    public void listSet(String key, Integer index, User value) {
        String str = JsonUtil.convertObj2String(value);
        redisTemplate.opsForList().set(key, index, str);
    }
    public Long getLen(String key){
        return redisTemplate.opsForList().size(key);
    }



}
