package com.geek.handler;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.geek.bo.Contract_bo;
import com.geek.bo.Departure_bo;
import com.geek.dto.Result;
import com.geek.pojo.Departure;
import com.geek.pojo.Message;
import com.geek.redis.RedisUtil;
import com.geek.service.DepartureService;
import com.geek.service.EmpService;
import com.geek.service.MessageService;
import com.geek.util.CommonUtil;
import com.geek.util.SessionNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class MessageHandler {
    @Autowired
    private MessageService messageService;
    @Autowired
    private DepartureService departureService;
    @Autowired
    private EmpService empService;
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

    /**
     * 离职
     * @param empId
     * @param depId
     * @param position
     * @param departureTime
     * @param reason
     * @param checkEmpId
     * @return
     */
    @PostMapping("sendDeparture")
    public Result sendDeparture(int empId,int depId,String position, String departureTime,String reason,int checkEmpId){
        Result result = new Result();
        Date time = CommonUtil.getTime(departureTime);
        RedisUtil redisUtil = new RedisUtil();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        redisUtil.set(SessionNameUtil.Lastest_New,list);
        messageService.addMessage(6,1,1,"离职申请",new Date(),checkEmpId);
        Departure departure = new Departure(empId,depId,position,time,reason,checkEmpId);
        departureService.addDeparture(departure);
        result.setCode(1);
        return  result;
    }

    /**
     * 查看离职申请
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("seeDeparture")
    public String seeDeparture(int checkEmpId,int page,int limit){
        int count = departureService.findCount();
        int start = limit*(page-1);
        int end = limit*page;
        List<Departure> departures = departureService.findDeparture(checkEmpId,start,end);
        System.out.println(departures.size());
        List<Departure_bo> list = new ArrayList<>();
        for (Departure departure : departures) {
            Departure_bo departure_bo = new Departure_bo();
            departure_bo.setEmpId(departure.getEmpId());
            departure_bo.setEmpName(empService.findEmpById(departure.getEmpId()).getEmpName());
            departure_bo.setDepName(empService.findEmpById(departure.getEmpId()).getDep().getDepName());
            departure_bo.setPosition(departure.getPosition());
            departure_bo.setLastTime(CommonUtil.parseString(departure.getDepartureTime()));
            departure_bo.setReason(departure.getReason());
            list.add(departure_bo);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);
        JSONObject o = (JSONObject) JSONObject.toJSON(map);
        String json = o.toJSONString();
        return json;
    }

    /**
     * 查看离职信息
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("findDeparture")
    public String seeDepartureList(int page,int limit){
        int count = departureService.findCount();
        int start = limit*(page-1);
        int end = limit*page;
        List<Departure> departures = departureService.findDepartures(start,end);
        List<Departure_bo> list = new ArrayList<>();
        for (Departure departure : departures) {
            Departure_bo departure_bo = new Departure_bo();
            departure_bo.setEmpId(departure.getEmpId());
            departure_bo.setEmpName(empService.findEmpById(departure.getEmpId()).getEmpName());
            departure_bo.setDepName(empService.findEmpById(departure.getEmpId()).getDep().getDepName());
            departure_bo.setPosition(departure.getPosition());
            departure_bo.setLastTime(CommonUtil.parseString(departure.getDepartureTime()));
            departure_bo.setReason(departure.getReason());
            departure_bo.setCheckEmpName(empService.findEmpById(departure.getCheckEmpId()).getEmpName());
            departure_bo.setTime(CommonUtil.parseString(departure.getHandleTime()));
            list.add(departure_bo);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);
        JSONObject o = (JSONObject) JSONObject.toJSON(map);
        String json = o.toJSONString();
        return json;
    }

    /**
     * 同意离职
     * @param empId
     * @return
     */
    @PutMapping("agreeDeparture")
    public Result agreeDeparture(int empId){
        Result result = new Result();
        departureService.updateDeparture(empId);
        result.setCode(1);
        return result;
    }
    @DeleteMapping("notDeparture")
    public Result notDeparture(int empId){
        Result result = new Result();
        departureService.delDepartureById(empId);
        result.setCode(1);
        return result;
    }
}
