package com.fbj.config;

import com.fbj.pojo.Blog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
        // 配置redisTemplate
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(lettuceConnectionFactory);
       redisTemplate.setKeySerializer(new StringRedisSerializer());
       redisTemplate.setHashKeySerializer(new  Jackson2JsonRedisSerializer(Integer.class));
       redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer(Integer.class));
       redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Blog.class));
        return redisTemplate;
    }
}
