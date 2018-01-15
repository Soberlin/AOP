package com.xfwlkjyxgs.sober.poa.utils;

/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2018/1/15.
 * 你能我就能****
 */

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串转换为时间搓的相关工具类
 */
public class MyTime {

    /**
     * 得到时间搓
     * @return
     */
    public  static  String getTimestamp(){
        SimpleDateFormat   format=new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        Date   date=new Date(System.currentTimeMillis());
        String  currentTime=format.format(date);
        currentTime=currentTime.substring(0,currentTime.length()-6)+"00分00秒";
        return   getTime(currentTime);
    }


    /**
     * 字符串转换为时间搓
     */
     public  static  String  getTime(String user_time){
         String re_time = null;
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
         Date d;
         try {
             d = sdf.parse(user_time);
             long l = d.getTime();
             String str = String.valueOf(l);
             re_time = str.substring(0, 10);
         } catch (Exception e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         return re_time;
     }


    /**
     * 得到当前的系统时间
     */
    public  static  String getSystemCurrentTime(){
        SimpleDateFormat   format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date   date=new Date(System.currentTimeMillis());
        String  currentTime=format.format(date);
        return  currentTime;
    }



}
