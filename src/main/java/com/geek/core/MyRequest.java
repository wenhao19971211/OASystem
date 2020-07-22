package com.geek.core;

import javax.servlet.http.*;
import java.util.UUID;

/**
 * 自定义请求对象
 */
public class MyRequest extends HttpServletRequestWrapper {
    private HttpServletRequest request;
    private HttpServletResponse response;
    /**
     * 重写构造
     * @param request
     */
    public MyRequest(HttpServletRequest request, HttpServletResponse response){
        //调用父类的带参构造
        super(request);
        this.request = request;
        this.response = response;
    }

    @Override
    public HttpSession getSession() {
        //从cookie中获取sessionId
        Cookie[] cookies = request.getCookies();
        String sessionId = null;
        //遍历cookie
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("mySessionId")){
                    sessionId = cookie.getValue();
                    break;
                }
            }
        }
        //如果没有获取到sessionId
        if(sessionId == null){
            //生成一个sessionId
            sessionId = UUID.randomUUID().toString();
            //创建cookie，将sessionId通过cookie发送给客户端
            Cookie cookie = new Cookie("mySessionId", sessionId);
            response.addCookie(cookie);
        }
        //创建HttpSession
        MySession session = new MySession(sessionId);
        //返回session
        return session;
    }
}
