//package com.personal.system.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import lombok.extern.slf4j.Slf4j;
//
///**
// * Created by yangqj on 2017/4/30.
// */
//@Configuration
//@EnableCaching
//@Slf4j
//public class RedisConfig extends CachingConfigurerSupport {
//    @Value("${spring.redis.host}")
//    private String host;
//    @Value("${spring.redis.password}")
//    private String password;
//    @Value("${spring.redis.port}")
//    private int port;
//    @Value("${spring.redis.timeout}")
//    private int timeout;
//    @Value("${spring.redis.pool.max-idle}")
//    private int maxIdle;
//    @Value("${spring.redis.pool.max-wait}")
//    private long maxWaitMillis;
//
//    @Bean
//    public JedisPool redisPoolFactory() {
//    	
//    	log.info("JedisPool注入成功！！");;
//    	log.info("JedisPool注入成功！！");
//        log.info("redis地址：" + host + ":" + port);
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxIdle(maxIdle);
//        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
//
//        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout,password);
//
//        return jedisPool;
//    }
//
//}
