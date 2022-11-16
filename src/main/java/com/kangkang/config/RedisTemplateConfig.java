package com.kangkang.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * ClassName:MyCacheConfig
 * Package:com.kangkang.config
 * Description:
 *
 * @date:2022/4/16 22:14
 * @author:kangkang
 */

@Configuration
@EnableCaching //开启注解
public class RedisTemplateConfig {

    @Bean
    public RedisTemplate<Object, Object> redisCacheConfiguration(RedisConnectionFactory  factory) {
//        创建redis字符串
        RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<>();
//        将连接工厂注入给redistemplate
        redisTemplate.setConnectionFactory(factory);
//        创建key的序列化器
            redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
//        设置value 的序列化器
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));

        return redisTemplate;

    }
}
