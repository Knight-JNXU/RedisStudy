package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * Created by Knigh on 2016/11/14.
 */
public class BaseDao {
    @Autowired
    protected RedisTemplate<String, Object> redisTemplate;

    /**
     * 获取RedisSerializer
     * @return
     */
    protected RedisSerializer<String> getRedisSerializer(){
        return redisTemplate.getStringSerializer();
    }

    /**
     *
     * @param key
     * @return
     */
    protected Object get(String key){
        return redisTemplate.boundValueOps(key).get();
    }

    /**
     *
     * @param key
     * @param value
     */
    protected void set(String key, Object value){
        redisTemplate.boundValueOps(key).set(value);
    }

    /**
     *
     * @param key
     */
    protected void del(String key){
        redisTemplate.delete(key);
    }
}
