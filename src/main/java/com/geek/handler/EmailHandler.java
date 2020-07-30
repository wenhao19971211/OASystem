package com.geek.handler;

import com.geek.dto.Result;
import com.geek.pojo.Email;
import com.geek.pojo.Emp;
import com.geek.service.EmailService;
import com.geek.service.EmpService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@RestController
public class EmailHandler {
    @Autowired
    private EmpService empService;
    @Autowired
    private EmailService emailService;

    /**
     * 获得所有的员工
     * @return
     */
    @GetMapping("findAllEmp")
    public Result findAllEmp(){
        Result result=new Result();
       List<Emp>list=empService.findAll(0,1000);
       result.setList(list);
       return result;
    }

    /**
     * 发送邮件
     * @param empId
     * @param type
     * @param title
     * @param content
     * @return
     */
    @PostMapping("sendEmail")
    public Integer sendEmail(int empId, int type, String title, String content,int [] receive){
        System.out.println("进入了发送邮件");
        if (title==null){
            title=" ";
        }
        for (int receiveId : receive) {
           emailService.addEmail(empId,receiveId,title,content,type);
        }
        return 1;
    }



    /**
     * 根据已读已读未读查询接收到的邮件
     * @param empId
     * @param readStatus
     * @return
     */
    @GetMapping("findEmail")
    public Result findEmailByReadStatusAndempId(int emailId,int empId, int type, int readStatus, int receiveEmpId){
        Result result=new Result();
//        System.out.println("进入了");
//        System.out.println("接收到的员工id是"+empId);
//        System.out.println("接收到的类型是"+type);
//        System.out.println("接收到的状态是"+readStatus);
//        System.out.println("接收到的接收者id为"+receiveEmpId);
        List<Email>list=emailService.findEmail(emailId,empId,type,readStatus,receiveEmpId);
        String[]Name=new String[list.size()];
        System.out.println("集合的长度是"+list.size());

        if (type!=2){
            if (emailId==0){
                for (int i=0;i<list.size();i++){
                    //获得接收人的对象
                    Emp emp=empService.findEmpById(list.get(i).getReceiveEmpId());
                    System.out.println("接收人的名字是"+emp.getEmpName());
                    Name[i]=emp.getEmpName();
                }
            }else {
                for (int i=0;i<list.size();i++){
                    //获得接收人的对象
                    Emp emp=empService.findEmpById(list.get(i).getEmpId());
                    System.out.println("接收人的名字是"+emp.getEmpName());
                    Name[i]=emp.getEmpName();
                }
                //修改阅读状态
                emailService.updateReadStatusByEmailId(2,emailId);
            }

        }else {
                for (int i=0;i<list.size();i++){
                    //获得接收人的对象
                    Emp emp=empService.findEmpById(list.get(i).getEmpId());
                    System.out.println("接收人的名字是"+emp.getEmpName());
                    Name[i]=emp.getEmpName();
                }
        }


        result.setObject(Name);
        result.setList(list);
        return result;

    }


}
