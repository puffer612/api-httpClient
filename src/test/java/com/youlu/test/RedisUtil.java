/*
package com.youlu.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
    private static JedisPool jedisPool = null;//初始化redis连接池
    static{
        JedisPoolConfig config = new JedisPoolConfig();// 设置最大连接数
        config.setMaxTotal(3000); // 可以创建30jedis实例
        // 设置最大空闲连接数
        config.setMaxIdle(300);
        //等待可用连接的最大时间
        config.setMaxWaitMillis(10000);
        //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的
        config.setTestOnBorrow(true);
        jedisPool = new JedisPool(config,"192.168.28.77",6379,10000,"123456");
    }
    */
/**
     *  * 获取Jedis实例
     *  *	 每次用完要将连接返回给连接池 jedis.close();
     *  *//*

    public synchronized static Jedis getJedis(){
        if(jedisPool != null){
            Jedis resource = jedisPool.getResource();
            return resource;
        }
        else {
            return null;
        }
    }
}*/
