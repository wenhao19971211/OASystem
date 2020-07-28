package com.geek.util;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 工具类,读取配置文件
 */
public class CommonUtil {
    private static ResourceBundle bundle = ResourceBundle.getBundle("config");

    /**
     * 获得每页的记录条数
     * @return
     */
    public static Integer getPageSize(){

        return Integer.parseInt(bundle.getString("pageSize"));
    }

    public static Date parseDate(String str)
    {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try
        {
            return sf.parse(str);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        return null;
    }

   /* LocalDateTime类型的字符串转为Date*/
    public static Date getDate(String str) {

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(str.replaceAll("T", " ") + ":00", df);
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        return date;
    }

    /**
     * 字符串转换时间(年月日)
     * @param str
     * @return
     */
    public static Date getTime(String str){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date time = null;
        try {
            time = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 时间转换字符串
     * @param str
     * @return
     */
    public static String parseString(Date str){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(str);
    }
    /**
     *
     * 判断输入的日期是否为节假日，
     * 参数httpArg:  20200724  格式
     * 返回值： 0上班  1周末  2节假日
     * @param httpArg
     * @return
     *//*

    public static String request(String httpArg) {
        String httpUrl = "http://tool.bitefu.net/jiari/";
        //String httpUrl = "http://api.goseek.cn/Tools/holiday";
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?d=" +httpArg;
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null)
            {
                sbf.append(strRead);
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public static int request( String httpArg) {
        String httpUrl = "http://api.goseek.cn/Tools/holiday";
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?date=" + httpArg;

        int d=0;//工作日对应结果为 0, 休息日对应结果为 1, 节假日对应的结果为 2

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
            JSONObject ob= JSONObject.parseObject(result);
            if(ob!=null){
                d=Integer.parseInt(ob.getString("data"));
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    *//**
     * 根据传入的日期，返回该月有多少天工作日
     * @param date
     * @return
     *//*
    public static int getMonthDayCountByDate(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        System.out.println("year:"+year+"month:"+month);
        //判断该月总共有多少天
        int days = 0;
        if (month != 2) {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    days = 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    days = 30;

            }
        } else {
            // 闰年
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
                days = 29;
            else
                days = 28;
        }
        System.out.println("days:"+days);
        int workDay = 0;
        for (int i = 1;i <= days ;i++)
        {
            //System.out.println("进入循环");
            String httpArg = "";
            String daystr = ""+days;
            String monthstr = ""+month;
            String yearstr = ""+year;

            if (i<10)
            {
                daystr = "0"+i;
            }
            if (month<10)
            {
                monthstr = "0"+month;
            }
            httpArg = yearstr+monthstr+daystr;
            System.out.println("httpArg:"+httpArg);
            int request = request(httpArg);
            System.out.println("request:"+request);
            //0：工作日
            if (0==(request))
            {
                workDay++;
            }
        }
        return workDay;

    }

    */


//
//
//
//
//    //节假日列表
//    private static List<Calendar> holidayList = new ArrayList<Calendar>();
//    //周末为工作日
//    private static List<Calendar> weekendList = new ArrayList<Calendar>();
//
//
//    /**
//     * 判断是否为节假日
//     * @param date
//     * @return
//     */
//    public static boolean request(Date date) {
//        try {
//
//            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//            Calendar ca = Calendar.getInstance();
//            ca.setTime(date);
//
//
//
//
//            initHolidayList("2016-09-15");//初始节假日
//            initHolidayList("2016-09-16");//初始节假日
//            initHolidayList("2016-09-17");//初始节假日
//
//
//
//            boolean k = checkHoliday(ca);
//            System.out.println(k);
//            return k;
//        } catch ( Exception e) {
//             TODO: handle exception
//            System.out.println(e.getClass());
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//
//
//
//    /**
//     *
//     * 验证日期是否是节假日
//     * @param calendar  传入需要验证的日期
//     * @return
//     * return boolean    返回类型  返回true是节假日，返回false不是节假日
//     * throws
//     */
//    public static boolean checkHoliday(Calendar calendar) throws Exception{
//
//        //判断日期是否是周六周日
//        if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
//                calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
//
//            //判断日期是否是节假日
//            for (Calendar ca : weekendList) {
//                if(ca.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
//                        ca.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)&&
//                        ca.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)){
//                    return false;
//                }
//            }
//
//            return true;
//        }
//        //判断日期是否是节假日
//        for (Calendar ca : holidayList) {
//            if(ca.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
//                    ca.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)&&
//                    ca.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)){
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    /**
//     *
//     * 把所有节假日放入list
//     * @param date  从数据库查 查出来的格式2016-05-09
//     * return void    返回类型
//     * throws
//     */
//    public static void  initHolidayList(String date){
//
//        String [] da = date.split("-");
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.YEAR, Integer.valueOf(da[0]));
//        calendar.set(Calendar.MONTH, Integer.valueOf(da[1])-1);//月份比正常小1,0代表一月
//        calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(da[2]));
//        holidayList.add(calendar);
//    }
//
//    /**
//     * 初始化周末被调整为工作日的数据
//     */
//    public static void initWeekendList(String date){
//        String [] da = date.split("-");
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.YEAR, Integer.valueOf(da[0]));
//        calendar.set(Calendar.MONTH, Integer.valueOf(da[1])-1);//月份比正常小1,0代表一月
//        calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(da[2]));
//        weekendList.add(calendar);
//    }
//

    public static int getWorkDay(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        //System.out.println("year:"+year+"--month:"+month);
        //判断该月总共有多少天
        int days = 0;
        if (month != 2) {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    days = 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    days = 30;

            }
        } else {
            // 闰年
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
                days = 29;
            else
                days = 28;
        }
        //System.out.println("days:"+days);
        int workDay = 0;
        for (int i = 1;i <= days;i++)
        {
            calendar.set(Calendar.DATE,i);
            int week = calendar.get(Calendar.DAY_OF_WEEK);
            if (week>=2 && week<=6)
            {
                workDay++;
            }
            //System.out.println("i"+i+"--w:"+workDay);
        }
        return workDay;

    }



}
