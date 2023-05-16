package com.diudiu.sec.demos.web;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redis")
public class RedisController {
    private final RedisTemplate redisTemplate;

    public RedisController(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/save")
    public String save(){
        String key = "666";
        String value = "1234";
        redisTemplate.opsForValue().set(key, value);
        String res = redisTemplate.opsForValue().get(key).toString();
        return res;
    }
}
