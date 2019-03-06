package com.dlmu.bbs.service;

public interface RedisService {
     void set(String key, Object value);
      String get(String key);
    boolean exists(final String key);
    <T> T get(String key, Class<T> clazz);
    void delete(String key);

}
