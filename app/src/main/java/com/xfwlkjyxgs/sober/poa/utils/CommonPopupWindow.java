package com.xfwlkjyxgs.sober.poa.utils;

/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2018/1/15.
 * 你能我就能****
 */

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;

/**
 *封装PopupWindow的工具类
 */
public class CommonPopupWindow  extends PopupWindow{

    private  PopupController  controller;
    /**
     * 得到宽度
     * @return
     */
    @Override
    public int getWidth() {
         return  controller.mPopupView.getMeasuredWidth();
    }

    /**
     * 得到高度
     * @return
     */
    @Override
    public int getHeight() {
        return controller.mPopupView.getHeight();
    }

    public  interface  ViewInterface{
        void  getChildView(View view,int layoutResId);
    }


    public CommonPopupWindow(Context context) {
        super(context);
        controller=new PopupController(context,this);
    }


    @Override
    public void dismiss() {
         super.dismiss();
         controller.setBackGroundLevel(1.0f);
    }

    public  static class  Builder{
        private  final PopupController.PopupParams  params;
        private  ViewInterface listener;

        public Builder(Context context) {
            params = new PopupController.PopupParams(context);
        }

        public  Builder setView(int layoutResId){
            params.mView=null;
            params.layoutResId=layoutResId;
            return this;
        }


        public Builder  setView(View view){
            params.mView=view;
            params.layoutResId=0;
            return this;
        }

        public Builder setViewOnclickListener(ViewInterface listener) {
            this.listener = listener;
            return this;
        }

        public Builder setWidthAndHeight(int width, int height) {
            params.mWidth = width;
            params.mHeight = height;
            return this;
        }

        public Builder setBackGroundLevel(float level) {
            params.isShowBg = true;
            params.bg_level = level;
            return this;
        }

        public Builder setOutsideTouchable(boolean touchable) {
            params.isTouchable = touchable;
            return this;
        }

        public Builder setAnimationStyle(int animationStyle) {
            params.isShowAnim = true;
            params.animationStyle = animationStyle;
            return this;
        }

        public CommonPopupWindow create() {
            final CommonPopupWindow popupWindow = new CommonPopupWindow(params.mContext);
            params.apply(popupWindow.controller);
            if (listener != null && params.layoutResId != 0) {
                listener.getChildView(popupWindow.controller.mPopupView, params.layoutResId);
            }
            CommonUtil.measureWidthAndHeight(popupWindow.controller.mPopupView);
            return popupWindow;
        }

    }


}