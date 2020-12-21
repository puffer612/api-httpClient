package com.youlu.test;

import com.youlu.util.RedisUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class testRedis {
   /* @Test
    public void test1(){
        Jedis jedis = new Jedis("192.168.28.77",6379);
        jedis.auth("123456");
        jedis.set("aaa","hello");
        System.out.println(jedis.get("aaa"));
        jedis.close();
    }*/
    @Test
    public void test2(){
        Jedis jedis = RedisUtils.getJedis();
        String code = jedis.set("aaa","bbb");
        System.out.println(code);
    }
}
