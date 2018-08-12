//package com.zgz.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisNode;
//import org.springframework.data.redis.connection.RedisSentinelConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import redis.clients.jedis.JedisPoolConfig;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//public class RedisConfig {
//
//    @Value("${spring.redis.sentinel.master}")
//    private String master;
//
//    @Value("${spring.redis.sentinel.nodes}")
//    private String sentinelHostAndPort;
//
//    @Bean
//    @ConfigurationProperties(prefix="spring.redis")
//    public JedisPoolConfig getRedisConfig(){
//        JedisPoolConfig config = new JedisPoolConfig();
//        return config;
//    }
//
//    @Bean
//    public JedisConnectionFactory getConnectionFactory(){
//        JedisPoolConfig config = getRedisConfig();
//        JedisConnectionFactory factory = new JedisConnectionFactory(getRedisSentinelConfig(), config);
//        return factory;
//    }
//
//    @Bean
//    public RedisSentinelConfiguration getRedisSentinelConfig(){
//        RedisSentinelConfiguration sentinelConfiguration = new RedisSentinelConfiguration();
//        sentinelConfiguration.setMaster(master);
//        String[] ipAndPort=sentinelHostAndPort.split(",");
//        List<RedisNode> params=new ArrayList<>();
//        for(String tmp:ipAndPort){
//            String[] config=tmp.split(":");
//            if(config.length==2){
//                String ip=config[0];
//                Integer port=Integer.parseInt(config[1]);
//                RedisNode redisNode=new RedisNode(ip,port);
//                params.add(redisNode);
//            }
//        }
//        sentinelConfiguration.setSentinels(params);
//        return sentinelConfiguration;
//    }
//
//    @Bean
//    public StringRedisTemplate getStringRedisTemplate(){
//        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
//        stringRedisTemplate.setConnectionFactory(getConnectionFactory());
//        return stringRedisTemplate;
//    }
//    @Bean
//    public RedisTemplate<?,?> getRedisTemplate(){
//        RedisTemplate<?,?> redisTemplate=new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(getConnectionFactory());
//        return redisTemplate;
//    }
//}
