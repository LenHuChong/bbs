package com.dlmu.bbs.service;

import com.dlmu.bbs.domain.Section;
import com.dlmu.bbs.domain.SectionRepository;
import com.dlmu.bbs.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SectionServiceImpl implements SectionService,RedisService {
    @Autowired
    private SectionRepository sectionService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public List<Section> getAllSection() {
        return sectionService.findAll();
    }

    @Override
    public Section findById(String id) {
        return sectionService.findById(id).get();
    }

    @Override
    public void updataSection(Section section) {
        sectionService.save(section);
    }

    @Override
    public void addSection(Section section) {
        sectionService.save(section);
    }

    @Override
    public void removeById(String id) {
        sectionService.deleteById(id);
    }

    @Override
    public void set(String key, Object value) {
        String str = JsonUtil.convertObj2String(value);

        redisTemplate.opsForValue().set(key, str);
    }

    @Override
    public String get(String key) {
        System.out.println(key);
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
    } public void push(String key, Section value) {
        String str = JsonUtil.convertObj2String(value);
        redisTemplate.opsForList().leftPush(key, str);
    }
    public String rightPop (String key){

        return redisTemplate.opsForList().rightPop(key);
    }

    public void listSet(String key, Integer index,Section value) {
        String str = JsonUtil.convertObj2String(value);
        redisTemplate.opsForList().set(key, index, str);
    }
    public Long getLen(String key){
        return redisTemplate.opsForList().size(key);
    }
}
