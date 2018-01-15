package com.xfwlkjyxgs.sober.poa.utils;

import android.util.Log;

/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2018/1/13.
 * 你能我就能****
 */

/**
 * 打印日志的工具类
 */


public class L {

    private  L() {
        throw  new  UnsupportedOperationException("cannot be instantiated");
    }

    // 是否需要打印bug，可以在application的onCreate函数里面初始化

    /**
     * 是否需要打印log   在Application的onCreate函数里面初始化
     */
    public  static  boolean  isDebug=true;
    private static final String TAG = "L";

    /**
     * 四个默认的tag函数
     * @param msg
     */
    public   static   void  i(String msg)
    {
        if (isDebug){
            Log.i(TAG,msg);
        }

    }

    public  static void  d(String msg){

         if (isDebug){
             Log.d(TAG,msg);
         }
    }

    public  static void  e(String msg){

        if (isDebug){
            Log.d(TAG,msg);
        }
    }

    public  static void   v(String msg){

        if (isDebug){
            Log.d(TAG,msg);
        }
    }



    public  static  void  i(String tag,String msg){
        if (isDebug){
            Log.i(tag,msg);
        }

    }


    public  static  void  d(String tag,String msg){
        if (isDebug){
            Log.i(tag,msg);
        }

    }


    public  static  void  e(String tag,String msg){
        if (isDebug){
            Log.i(tag,msg);
        }

    }

    public  static  void  v(String tag,String msg){
        if (isDebug){
            Log.i(tag,msg);
        }

    }


}
