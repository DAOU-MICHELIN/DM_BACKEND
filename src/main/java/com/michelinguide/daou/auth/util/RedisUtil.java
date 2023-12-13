package com.michelinguide.daou.auth.util;

import java.time.Duration;
import javax.swing.Spring;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisUtil {

    private final StringRedisTemplate stringRedisTemplate;

    public String getData(String key){
        ValueOperations<String, String> valueOperation = stringRedisTemplate.opsForValue();
        return valueOperation.get(key);
    }

    public void setData(String key, String value) {
        ValueOperations<String, String> valueOperation = stringRedisTemplate.opsForValue();
        valueOperation.set(key, value);
    }

    public void setDataExpire(String key, String value, long duration) {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        Duration expireDuration = Duration.ofSeconds(duration);
        valueOperations.set(key, value, expireDuration);
    }
    public void deleteData(String key) {
        stringRedisTemplate.delete(key);
    }
}
