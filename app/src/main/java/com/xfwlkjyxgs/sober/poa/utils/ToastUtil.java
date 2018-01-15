package com.xfwlkjyxgs.sober.poa.utils;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2018/1/15.
 * 你能我就能****
 */
public class ToastUtil {
    private  static  boolean  isShow=true;
    private  static Toast  mToast=null;

    /**
     * private 控制不应该被实例化
     */
    private ToastUtil() {
        throw  new UnsupportedOperationException("不能被实例化");
    }
    /**
     * 全局控制是否显示Toast
     */
    public static  void  controlShow(boolean isShowToast){
        isShow=isShowToast;
    }

    /**
     * 取消Toast的显示
     */
    public  void  cancelToast(){
        if (isShow&&mToast!=null){
            mToast.cancel();
        }
    }

    /**
     * 短时间显示Toast
     * @param context
     * @param message
     */
    public  static  void  showShort(Context   context,String message){
            if (isShow){
                if (mToast==null){
                  mToast=Toast.makeText(context,message,Toast.LENGTH_SHORT);
                }else{
                    mToast.setText(message);
                }
                mToast.show();
            }
    }
    /**
     * 短时间显示Toast
     * @param context
     * @param resId  资源id  getResources().getString(R.String.XXX)
     */
    public  static  void  showShort(Context   context,int resId){
        if (isShow){
            if (mToast==null){
                mToast=Toast.makeText(context,resId,Toast.LENGTH_SHORT);
            }else{
                mToast.setText(resId);
            }
            mToast.show();
        }
    }


    /**
     * 长时间显示Toast
     * @param context
     * @param message
     */
    public  static  void  showLong(Context   context,String message){
        if (isShow){
            if (mToast==null){
                mToast=Toast.makeText(context,message,Toast.LENGTH_LONG);
            }else{
                mToast.setText(message);
            }
            mToast.show();
        }
    }
    /**
     * 长时间显示Toast
     * @param context
     * @param resId  资源id  getResources().getString(R.String.XXX)
     */
    public  static  void  showLong(Context  context,int resId){
        if (isShow){
            if (mToast==null){
                mToast=Toast.makeText(context,resId,Toast.LENGTH_LONG);
            }else{
                mToast.setText(resId);
            }
            mToast.show();
        }
    }

    /**
     * 自定义显示Toast的时间
     * @param context
     * @param message
     * @param duration  单位：毫秒
     */
    public  static  void show(Context context,CharSequence message,int duration){
        if (isShow){
            if (mToast==null){
                mToast=Toast.makeText(context,message,duration);
            }else{
                mToast.setText(message);
            }
            mToast.show();
        }
    }


    /**
     * 自定义显示Toast的时间
     * @param context
     * @param resId
     * @param duration  单位：毫秒
     */
    public  static  void show(Context   context,int resId,int duration){
        if (isShow){
            if (mToast==null){
                mToast=Toast.makeText(context,resId,duration);
            }else{
                mToast.setText(resId);
            }
            mToast.show();
        }
    }


    /**
     * 自定义View的Toast
     * @param context
     * @param sequence
     * @param duration
     * @param view
     */
    public static void customToastView(Context context, CharSequence sequence, int duration,View view) {
        if (isShow){
            if (mToast == null) {
                mToast = Toast.makeText(context, sequence, duration);
            } else {
                mToast.setText(sequence);
            }

           if (view!=null){
                mToast.setView(view);
           }
            mToast.show();
        }
    }


    /**
     * 自定义Toast的位置
     * @param context
     * @param message
     * @param duration
     * @param gravity
     * @param xOffset
     * @param yOffset
     */
    public static void customToastGravity(Context context, CharSequence message, int duration,int gravity, int xOffset, int yOffset) {
        if (isShow){
            if (mToast == null) {
                mToast = Toast.makeText(context, message, duration);
            } else {
                mToast.setText(message);
            }
            mToast.setGravity(gravity, xOffset, yOffset);
            mToast.show();
        }
    }







}
