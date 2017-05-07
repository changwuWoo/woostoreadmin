package org.edge.woostore.utils.util;


import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2017/3/24.
 */
public class JedisUtils {

    private static Jedis resource;

    public static Jedis getResource() {
        return resource;
    }

    public static void setResource(Jedis resource) {
        JedisUtils.resource = resource;
    }

    public static void returnResource(Jedis jedis) {

    }

    public static void set(String s, String token, int interval) {

    }
}
