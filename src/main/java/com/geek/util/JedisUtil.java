package com.geek.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;
import java.io.*;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * Redis访问的工具类
 */
public class JedisUtil {
    private static JedisPool pool;
    private static ResourceBundle bundle = ResourceBundle.getBundle("jedisConfig");

    static{
        JedisPoolConfig config = new JedisPoolConfig();
        int maxTotal = Integer.parseInt(bundle.getString("maxTotal"));
        int minIdle = Integer.parseInt(bundle.getString("minIdle"));
        String host = bundle.getString("host");
        int port = Integer.parseInt(bundle.getString("port"));
        config.setMaxTotal(maxTotal);
        config.setMinIdle(minIdle);
        pool = new JedisPool(config, host,port );
    }

    public static Jedis getJedis(){
        Jedis jedis = null;
        //获得连接
        jedis = pool.getResource();
        return jedis;
    }
    /*****************通用数据访问*******************/

    /**
     * 查看所有键
     * @return
     */
    public static Set<String> keys(){
        Jedis jedis = getJedis();
        Set<String> keys = jedis.keys("*");
        jedis.close();
        return keys;
    }

    /**
     * 设置键的生命周期
     * @param key
     * @param second
     */
    public static void expire(String key, int second){
        Jedis jedis = getJedis();
//        if(jedis.exists(key)){
            jedis.expire(key, second);
//        }
//        else{
//            throw new RuntimeException("redis的键不存在！");
//        }
        jedis.close();
    }

    /**
     * 删除键
     * @param key
     */
    public static void del(String... key){
        Jedis jedis = getJedis();
        jedis.del(key);
        jedis.close();
    }

    /*****************string类型的访问*******************/
    /**
     * 写入键值
     * @param key
     * @param value
     */
    public static void set(String key,String value){
        Jedis jedis = getJedis();
        jedis.set(key, value);
        jedis.close();
    }

    /**
     * 写入键值数据的同时设置键的生命周期
     * @param key
     * @param value
     * @param second
     */
    public static void set(String key,String value,int second){
        Jedis jedis = getJedis();
        jedis.set(key, value);
        jedis.expire(key, second);
        jedis.close();
    }

    /**
     * 重载set方法，实现批量写入
     * @param keysAndValues
     */
    public static void set(String... keysAndValues){
        Jedis jedis = getJedis();
        jedis.mset(keysAndValues);
        jedis.close();
    }

    /**
     * 通过序列化写入数据
     * @param key
     * @param value
     */
    public static void set(String key,Object value){
        //将序列化的结果转换为byte[]
        byte[] bytes = SerizableUtil.serizObject(value);
        Jedis jedis = JedisUtil.getJedis();
        //将序列化数据保存至redis
        jedis.set(key.getBytes(), bytes);
        jedis.close();

    }

    /**
     * 反序列化获取数据
     * @param key
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T get(String key, Class<T> tClass){
        T t = null;

        //读取redis序列化的数据
        Jedis jedis = JedisUtil.getJedis();
        byte[] bytes = jedis.get(key.getBytes());
        if(bytes != null){
           t = (T) SerizableUtil.reverSerizObject(bytes);
        }
        return t;
    }

    public static void set(String key, Object value,int second){
        set(key, value);
        expire(key, second);
    }


    /**
     * 获取值
     * @param key
     * @return
     */
    public static String get(String key){
        Jedis jedis = getJedis();
        String value = jedis.get(key);
        jedis.close();
        return value;
    }

    /**
     * 重载get 批量获取多个键的值
     * @param keys
     * @return
     */
    public static List<String> get(String...keys){
        Jedis jedis = getJedis();
        List<String> list = jedis.mget(keys);
        jedis.close();
        return list;
    }
    /*****************hash类型的访问*******************/
    public static void hset(String key,String field,String value){
        Jedis jedis = getJedis();
        jedis.hset(key, field, value);
        jedis.close();
    }
    public static void hset(String key,String field,String value,int second){
        Jedis jedis = getJedis();
        jedis.hset(key, field, value);
        jedis.close();
        expire(key, second);
    }

    /**
     * 序列化写入
     * @param key
     * @param field
     * @param value
     * @param second
     */
    public static void hset(String key,String field,Object value,int second){
        Jedis jedis = getJedis();
        //对写入的值进行序列化
        byte[] bytes = SerizableUtil.serizObject(value);
        jedis.hset(key.getBytes(), field.getBytes(), bytes);
        jedis.close();
        expire(key, second);
    }

    public static String hget(String key, String field){
        Jedis jedis = getJedis();
        String value = jedis.hget(key, field);
        jedis.close();
        return value;
    }

    /**
     * 反序列化获取字段值
     * @param key
     * @param field
     * @return
     */
    public static Object hgetObject(String key,String field){
        Object obj = null;
        Jedis jedis = getJedis();
        byte[] bytes = jedis.hget(key.getBytes(), field.getBytes());
        obj = SerizableUtil.reverSerizObject(bytes);
        jedis.close();
        return obj;
    }

    public static void hdel(String key, String... field){
        Jedis jedis = getJedis();
        jedis.hdel(key, field);
        jedis.close();
    }

    /*****************list类型的访问*******************/
    /*****************set类型的访问*******************/
    /*****************zset类型的访问*******************/
}
