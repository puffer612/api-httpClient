package com.youlu.util;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class Redis {
    public static Jedis getRedis(){
        Jedis jedis = new Jedis("192.168.27.127",6379);
        jedis.auth("123456");
        return jedis;
    }


}
