package com.xfwlkjyxgs.sober.poa.utils;

import com.google.gson.Gson;


/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2018/1/16.
 * 你能我就能****
 */

public class GsonUtil {
     private  static Gson gson=null;
     static {
         if (gson==null){
             gson=new Gson();
         }
     }
     private  GsonUtil(){

    }

    /**
     * @param object
     * @return
     */
    public  static String GsonString(Object object){
         String  gsonString=null;
         if (gson!=null){
             gsonString=gson.toJson(object);
         }
        return gsonString;
    }






}
