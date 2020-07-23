package com.geek.handler;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.geek.dto.Result;
import com.geek.pojo.Message;
import com.geek.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageHandler {
    @Autowired
    private MessageService messageService;
    @GetMapping("findAll")
    public Result findAllById(int empId){
        Result result = new Result();
        List<Message> list = messageService.findAllById(empId);
        result.setList(list);
        return result;
    }
    @GetMapping("findNoExamine")
    public Result findNoExamineById(int empId){
        Result result = new Result();
        List<Message> list = messageService.findNoExamineById(empId);
        result.setList(list);
        return result;
    }

    /**
     * 已审
     * @param empId
     * @return
     */
    @GetMapping("examine")
    public Result findExamineById(int empId){
        Result result = new Result();
        List<Message> list = messageService.findExamineById(empId);
        result.setList(list);
        return result;
    }

    /**
     * 待阅
     * @param empId
     * @return
     */
    @GetMapping("noRead")
    public Result findNoReadById(int empId){
        Result result = new Result();
        List<Message> list = messageService.findNoReadById(empId);
        result.setList(list);
        return result;
    }
    @GetMapping("read")
    public Result findReadById(int empId){
        Result result = new Result();
        List<Message> list = messageService.findReadById(empId);
        result.setList(list);
        return result;
    }
}
