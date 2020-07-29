package com.geek.handler;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.geek.bo.Message_bo;
import com.geek.dto.Result;
import com.geek.pojo.Message;
import com.geek.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MessageHandler {
    @Autowired
    private MessageService messageService;
    @GetMapping("findAll")
    public String findAllById(Integer empId,Integer page,Integer limit){
        Result result = new Result();
        Message_bo message_bo = messageService.findAllById(empId,page,limit);
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",message_bo.getCount());
        map.put("data",message_bo.getMessages());
        JSONObject o = (JSONObject) JSONObject.toJSON(map);
        String json = o.toJSONString();
        //System.out.println(json);
        return json;
    }
    @GetMapping("findNoExamine")
    public String findNoExamineById(Integer empId,Integer page,Integer limit){
        Result result = new Result();
        Message_bo message_bo = messageService.findNoExamineById(empId,page,limit);
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",message_bo.getCount());
        map.put("data",message_bo.getMessages());
        JSONObject o = (JSONObject) JSONObject.toJSON(map);
        String json = o.toJSONString();
        //System.out.println(json);
        return json;
    }

    /**
     * 已审
     * @param empId
     * @return
     */
    @GetMapping("examine")
    public String findExamineById(Integer empId,Integer page,Integer limit){
        Result result = new Result();
        Message_bo message_bo = messageService.findExamineById(empId,page,limit);
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",message_bo.getCount());
        map.put("data",message_bo.getMessages());
        JSONObject o = (JSONObject) JSONObject.toJSON(map);
        String json = o.toJSONString();
        //System.out.println(json);
        return json;
    }

    /**
     * 待阅
     * @param empId
     * @return
     */
    @GetMapping("noRead")
    public String findNoReadById(Integer empId,Integer page,Integer limit){
        Result result = new Result();
        Message_bo message_bo = messageService.findNoReadById(empId,page,limit);
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",message_bo.getCount());
        map.put("data",message_bo.getMessages());
        JSONObject o = (JSONObject) JSONObject.toJSON(map);
        String json = o.toJSONString();
        //System.out.println(json);
        return json;
    }
    @GetMapping("read")
    public String findReadById(Integer empId,Integer page,Integer limit){
        Result result = new Result();
        Message_bo message_bo = messageService.findReadById(empId,page,limit);
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",message_bo.getCount());
        map.put("data",message_bo.getMessages());
        JSONObject o = (JSONObject) JSONObject.toJSON(map);
        String json = o.toJSONString();
        //System.out.println(json);
        return json;
    }
}
