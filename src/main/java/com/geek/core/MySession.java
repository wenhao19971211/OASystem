package com.geek.core;

import com.geek.util.JedisUtil;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;

/**
 * 自定义HttpSession
 */
public class MySession implements HttpSession {
    private String sessionId;
    //最大保存时间
    private int maxInterval = 60*10;



    //private RedisUtil redisUtil;

    public MySession(String sessionId){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //RedisUtil redisUtil = (RedisUtil) context.getBean("redisUtil");
        //this.redisUtil = redisUtil;
        this.sessionId = sessionId;
    }

    @Override
    public long getCreationTime() {
        return 0;
    }

    @Override
    public String getId() {
       return this.sessionId;
    }

    @Override
    public long getLastAccessedTime() {
        return 0;
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }

    /**
     * session保存时间
     * @param i
     */
    @Override
    public void setMaxInactiveInterval(int i) {
        this.maxInterval = i;
    }

    @Override
    public int getMaxInactiveInterval() {
        return this.maxInterval;
    }

    @Override
    public HttpSessionContext getSessionContext() {
        return null;
    }

    @Override
    public Object getAttribute(String s) {
        return JedisUtil.hgetObject(sessionId, s);
    }

    @Override
    public Object getValue(String s) {
        return null;
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return null;
    }

    @Override
    public String[] getValueNames() {
        return new String[0];
    }

    @Override
    public void setAttribute(String s, Object o) {
        JedisUtil.hset(sessionId, s, o, maxInterval);
    }

    @Override
    public void putValue(String s, Object o) {

    }

    @Override
    public void removeAttribute(String s) {

    }

    public void removeAttribute(String... s){
        JedisUtil.hdel(sessionId, s);
    }

    @Override
    public void removeValue(String s) {

    }

    @Override
    public void invalidate() {
        JedisUtil.del(sessionId);
    }

    @Override
    public boolean isNew() {
        return false;
    }
}
