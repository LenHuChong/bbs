package com.dlmu.bbs.service;

import com.dlmu.bbs.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public void set(String key, Object value) {
        String str= JsonUtil.convertObj2String(value);

        redisTemplate.opsForValue().set(key,str);
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
        String s=get(key);
        if(null==s){
            return null;
        }
        return JsonUtil.convertString2Obj(s,clazz) ;
    }

    @Override
    public void delete(String key) {
            redisTemplate.delete(key);

    }
    public void push(String key, Object value){
        String str= JsonUtil.convertObj2String(value);
        redisTemplate.opsForList().leftPush(key,str);
    }
    public void listSet(String key,int index,Object value){
        String str=JsonUtil.convertObj2String(value);
        redisTemplate.opsForList().set(key,index,str);
    }
}
