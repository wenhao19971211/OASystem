package com.geek.service;

import com.alibaba.fastjson.JSONObject;
import com.geek.bo.Leave_bo;
import com.geek.dao.*;
import com.geek.dto.Result;
import com.geek.pojo.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 请假相关
 */
@Service
public class LeaveService {
    @Autowired
    private DominantDao dominantDao;
    @Autowired
    private DayOffDao dayOffDao;
    @Autowired
    private LeaveDao leaveDao;
    @Autowired
    private YearLeaveDao yearLeaveDao;
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private WorkOnDao workOnDao;

    /**
     * 请假选择
     * @param leaveFlag 判断是哪种请假请求 1为调休 2为事假 3为年假
     * @param applyEmpId 发起人的id
     * @param content 请假的内容
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param empId 接受人id
     */
    @Transactional
    public void addLeave(int leaveFlag, int applyEmpId, String content, Date startTime,Date endTime, int empId){

        if (leaveFlag==1){
            //调休
            dayOffDao.addDayOff(applyEmpId,content,startTime,endTime,empId,null,1);
//            Dominant dominant=dominantDao.findDominantByEmpId(applyEmpId);
//            if (dominant.getAllowLeaveTime()>=8*days){
//            }
        }else if (leaveFlag==2){
            //事假
            leaveDao.addLeave(applyEmpId,content,startTime,endTime,empId,null,1);
        }else {
            //年假
            yearLeaveDao.addYearLeave(applyEmpId,content,startTime,endTime,empId,null,1);
        }
        //封装对象
        Message message=new Message();
        message.setMessageType(2);
        message.setMessageStatus(1);
        message.setReadStatus(1);
        message.setMessageContent(content);
        message.setSendTime(new Date());
        message.setEmpId(empId);
        //发送消息
        messageDao.addMessage(message);
    }


    /**
     * 通过员工id查找对应的可支配找时间
     * @param empId
     * @return
     */
    @Transactional
    public Dominant findDominantByEmpId(int empId){
        return dominantDao.findDominantByEmpId(empId);
    }

    /**
     * 获取到请假信息
     * 1员工获取  empId为员工id即可其他为0
     * 2经理获取  empId为0 其他需要值
     * @param depId 部门id
     * @param empId 员工id
     * @param state 状态
     * @return
     */
    @Transactional
    public List findLeaveList(int depId,int empId,int state,int flag){
        List<Leave_bo>list=new ArrayList();
        List<DayOff>dayOffList=dayOffDao.findAllDayOffBydepIdAndempId(depId,empId,state,flag);
        List<Leave>leaveList=leaveDao.findAllLeave(depId,empId,state,flag);
        List<YearLeave>yearLeaveList=yearLeaveDao.findAllYearLeave(depId,empId,state,flag);
        if (dayOffList!=null){

            for (DayOff dayOff : dayOffList) {
                long days =(dayOff.getEndTime().getTime()-dayOff.getStartTime().getTime())/(60*60*24*1000)+1;

                //封装数据
                Leave_bo leave_bo=new Leave_bo();
//                System.out.println("获取到empName"+dayOff.getEmp().getEmpName());
                leave_bo.setDays(days);
                leave_bo.setCheckTime(dayOff.getCheckTime());
                leave_bo.setApplyId(dayOff.getDayOffId());

                leave_bo.setIntType(1);

                leave_bo.setEmp(dayOff.getEmp());
                leave_bo.setCause(dayOff.getDayOffCause());
                leave_bo.setSendTime(dayOff.getSendTime());
                leave_bo.setStartTime(dayOff.getStartTime());
                leave_bo.setEndTime(dayOff.getEndTime());
                leave_bo.setType("调休");
                if (dayOff.getCheckStatus()==1){
                    leave_bo.setCheckStatus("未审核");
                }else if (dayOff.getCheckStatus()==2){
                    leave_bo.setCheckStatus("通过");
                }else {
                    leave_bo.setCheckStatus("未通过");
                }
                list.add(leave_bo);
            }
        }
        if (leaveList!=null){
            for (Leave leave : leaveList) {
                long days =(leave.getEndTime().getTime()-leave.getStartTime().getTime())/(60*60*24*1000)+1;
                //封装数据
                Leave_bo leave_bo=new Leave_bo();
                leave_bo.setCheckTime(leave.getCheckTime());
                leave_bo.setApplyId(leave.getLeaveId());
                leave_bo.setDays(days);
                leave_bo.setIntType(2);

                leave_bo.setEmp(leave.getEmp());
                leave_bo.setCause(leave.getLeaveCause());
                leave_bo.setEndTime(leave.getEndTime());
                leave_bo.setSendTime(leave.getSendTime());
                leave_bo.setStartTime(leave.getStartTime());
                leave_bo.setType("事假");
                if (leave.getCheckStatus()==1){
                    leave_bo.setCheckStatus("未审核");
                }else if (leave.getCheckStatus()==2){
                    leave_bo.setCheckStatus("通过");
                }else {
                    leave_bo.setCheckStatus("未通过");
                }
                list.add(leave_bo);
            }
        }
        if (yearLeaveList!=null){
//            System.out.println("yearLeaveList长度为"+yearLeaveList.size());
            for (YearLeave yearLeave : yearLeaveList) {
                long days =(yearLeave.getEndTime().getTime()-yearLeave.getStartTime().getTime())/(60*60*24*1000)+1;
                //封装数据
                Leave_bo leave_bo=new Leave_bo();

                leave_bo.setApplyId(yearLeave.getYearLeaveId());
                leave_bo.setDays(days);
                leave_bo.setCheckTime(yearLeave.getCheckTime());
                leave_bo.setIntType(3);
                leave_bo.setEmp(yearLeave.getEmp());
                leave_bo.setSendTime(yearLeave.getSendTime());
                leave_bo.setCause(yearLeave.getYearLeaveCause());
                leave_bo.setStartTime(yearLeave.getStartTime());
                leave_bo.setEndTime(yearLeave.getEndTime());
                leave_bo.setType("年假");
                if (yearLeave.getCheckStatus()==1){
                    leave_bo.setCheckStatus("未审核");
                }else if (yearLeave.getCheckStatus()==2){
                    leave_bo.setCheckStatus("通过");
                }else {
                    leave_bo.setCheckStatus("未通过");
                }
                list.add(leave_bo);
            }
        }
        return list;
    }

    /**
     * 审批通过与不通过的相关事务
     * @param type 请假类型 1.调休 2.事假 3.年假
     * @param leaveId 对应类型中的申请Id
     * @param opinion 2.同意 3.不同意
     * @param days 请假天数
     * @param empId 员工Id
     */
    @Transactional
    public void updateStateAndTime(int type,int leaveId,int opinion,int days,int empId){
        if (type==1){
            System.out.println("进入调休");
            if (opinion==2){
                int time=days*8;
                System.out.println("time"+time);
                dayOffDao.updateCheckTimeByDayOffId(new Date(),leaveId);
                dayOffDao.updatecheckStatusByDayOffId(opinion,leaveId);
                dominantDao.updateAllowLeaveTimeByEmpId(empId,(-time));
            }else {
                dayOffDao.updateCheckTimeByDayOffId(new Date(),leaveId);
                dayOffDao.updatecheckStatusByDayOffId(opinion,leaveId);
            }

        }else if (type==2){
            System.out.println("J进入事假");
            leaveDao.updateCheckStatusByleaveId(opinion,leaveId);
            leaveDao.updateCheckTimeByleaveId(new Date(),leaveId);
        }else {
            System.out.println("进入年价");
            if (opinion==2){
                yearLeaveDao.updateCheckStatusByYearLeaveId(opinion,leaveId);
                yearLeaveDao.updateCheckTimeByYearLeaveId(new Date(),leaveId);
                dominantDao.updateReYearLeaveTimeByEmpId(empId,(-days));
            }else {
                yearLeaveDao.updateCheckStatusByYearLeaveId(opinion,leaveId);
                yearLeaveDao.updateCheckTimeByYearLeaveId(new Date(),leaveId);
            }

        }
    }

    /**
     * 获取当前用户打卡的时间
     * @param empId 用户id
     * @param workInTime 打卡的时间
     */
    public Result insertWorkonFrequency(int empId, Date workInTime){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH");
        //获取当天打卡的时间并写入
        Result result=new Result();
        String calenda="";
        //早上9点
        Date date=changeDate(1);
//        错误信息
        String message="";
        Map<String,String> map=new HashMap<>();
        //当前时间的日期
        Date today=getNowToday();
        //旷工的时间限制
        Date date2=changeDate(3);
        //下班打卡的时间
        Date date3=changeDate(2);
        //date小于workInTime返回-1，date大于workInTime返回1，相等返回0如下
        int compareTo= date.compareTo(workInTime);
        int compareTo2=date2.compareTo(workInTime);
        int compareTo3=date3.compareTo(workInTime);
        if (compareTo==1&&compareTo==0){
//            正常写入没有迟到
        calenda=df.format(today);
            map.put(calenda,"快点上班");
        }else if(compareTo==-1){

            if (compareTo2==-1){
                //旷工
                map.put(calenda,"已近旷工");
            }else{
                //迟到
                map.put(calenda,"已经迟到");
            }

        }
            workOnDao.insertWorkOnByEmpId(empId,today,workInTime);
        JSONObject o = (JSONObject) JSONObject.toJSON(map);
        String json = o.toJSONString();
        result.setMessage("");
        result.setCode(0);
        result.setObject(json);
            return result;
    }
    public Result updateWorkonFrequency(int empId, Date workOutTime){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH");
        Result result=new Result();
        Date date=changeDate(2);
        Date today=getNowToday();
        int compareTo=date.compareTo(workOutTime);
        String message="";
        Map<String,String> map=new HashMap<>();
        String calenda="";
        calenda=df.format(today);
        if (compareTo==-1){
            //正常下班
            map.put(calenda,"祝您晚餐愉快");
        }else{
            //早退
            map.put(calenda,"莫要早退");

        }
        workOnDao.updateWorkOnByEmpId(empId,workOutTime);
        JSONObject o = (JSONObject) JSONObject.toJSON(map);
        String json = o.toJSONString();
        result.setMessage("");
        result.setCode(0);
        result.setObject(json);
        return result;
    }
    /**
     * 获取当天上班的时间
     * @return
     */
    public Date changeDate(int i){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH");
        Date date=new Date();
        //将时间转换成字符串
        String newDate=df.format(date);
        StringBuilder strBuilder = new StringBuilder(newDate);
        strBuilder.delete(11,13);
        if (i==1){
            strBuilder.insert(11,9);
        }else if(i==2){
            strBuilder.insert(11,17);
        }else if(i==3){
            strBuilder.insert(11,12);
        }

        newDate=strBuilder.toString();
        try {
            date=df.parse(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("时间转换错误");
        }
        System.out.println(date);

        return date;
    };

    public Date getNowToday(){
        Date date=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String newDate=df.format(date);
        try {
            date=df.parse(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("日期转换错误已2");
        }

        return date;
    }



}
