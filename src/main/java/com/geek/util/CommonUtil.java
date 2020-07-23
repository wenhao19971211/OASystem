package com.geek.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

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
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-ddTHH:mm:ss");
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
    public static Date getDate(String str)
    {

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(str.replaceAll("T", " ") + ":00", df);
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        return date;
    }



}
