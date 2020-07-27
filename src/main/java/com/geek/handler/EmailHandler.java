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
//        System.out.println(receive.length);
//        System.out.println("发送人编号"+empId);
//        System.out.println("发送的类别"+type);
//        System.out.println("发送人标题"+title);
//        System.out.println("发送人内容"+content);
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
    public Result findEmailByReadStatusAndempId(int empId, int type, int readStatus, int receiveEmpId){
        Result result=new Result();
        System.out.println("进入了");
        System.out.println("接收到的员工id是"+empId);
        System.out.println("接收到的类型是"+type);
        System.out.println("接收到的状态是"+readStatus);
        List<Email>list=emailService.findEmail(empId,type,readStatus,receiveEmpId);
        String[]Name=new String[list.size()];
        System.out.println("集合的长度是"+list.size());
        for (int i=0;i<list.size();i++){
            //获得接收人的对象
            Emp emp=empService.findEmpById(list.get(i).getReceiveEmpId());
            System.out.println("接收人的名字是"+emp.getEmpName());
            Name[i]=emp.getEmpName();
        }

        result.setObject(Name);
        result.setList(list);
        return result;

    }


}
