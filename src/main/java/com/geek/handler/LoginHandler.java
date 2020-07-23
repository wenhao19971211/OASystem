package com.geek.handler;

import com.geek.pojo.Emp;
import com.geek.redis.RedisUtil;
import com.geek.service.EmpService;
import com.geek.util.RandomValidateCode;
import com.geek.util.SessionNameUtil;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginHandler {
    @Autowired
    private EmpService empService;
    @Autowired
    private RedisUtil redisUtil;
    /**
     * 获取生成验证码显示到 UI 界面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value="checkCode")
    public void checkCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");

        //设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);

        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            randomValidateCode.getRandcode(request, response);//输出图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @GetMapping("login")
    @ResponseBody
    public String login(String account, String password, String verCode, HttpSession session) {
        Emp emp=empService.findEmpByAccount(account);
        if (emp!=null){
            if (emp.getPassword().equals(password)){

                if (session.getAttribute(RandomValidateCode.RANDOMCODEKEY).equals(verCode)){
                    session.setAttribute(SessionNameUtil.Login_User,emp);
                    return "1";
                }else {
                    return "4";
                }

            }else {
                return "2";
            }
        }else {
            return "3";
        }
    }
}
