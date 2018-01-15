package com.xfwlkjyxgs.sober.poa.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;


public  class PopupController{
    /**
     * 布局id
     */
    private int layoutResId;
    private Context context;
    private PopupWindow popupWindow;
    /**
     * 弹窗布局
     */
    View mPopupView;
    private View mView;

    /**
     *得到当前窗口
     */
    private Window mWindow;
    /**
     * 构造函数
     * @param context
     * @param popupWindow
     */
    PopupController(Context context, PopupWindow popupWindow) {
        this.context = context;
        this.popupWindow = popupWindow;
    }

    public void setView(int layoutResId) {
        mView = null;
        this.layoutResId = layoutResId;
        installContent();
    }

    public void setView(View view) {
        mView = view;
        this.layoutResId = 0;
        installContent();
    }

    private void installContent() {
        if (layoutResId != 0) {
            mPopupView = LayoutInflater.from(context).inflate(layoutResId, null);
        } else if (mView != null) {
            mPopupView = mView;
        }
        popupWindow.setContentView(mPopupView);
    }

    /**
     * 设置宽度
     *
     * @param width  宽
     * @param height 高
     */
    private void setWidthAndHeight(int width, int height) {
        if (width == 0 || height == 0) {
            /**
             * 如果没有置宽高，默认是WRAP_CONTENT
             */
            popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
            popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        } else {
            popupWindow.setWidth(width);
            popupWindow.setHeight(height);
        }
    }
    /**
     * 设置背景灰色程度
     *
     * @param level 0.0f-1.0f
     */
    void setBackGroundLevel(float level) {
        mWindow = ((Activity) context).getWindow();
        WindowManager.LayoutParams params = mWindow.getAttributes();
        params.alpha = level;
        mWindow.setAttributes(params);
    }


    /**
     * 设置动画
     */
    private void setAnimationStyle(int animationStyle) {
        popupWindow.setAnimationStyle(animationStyle);
    }

    /**
     * 设置Outside是否可点击
     *
     * @param touchable 是否可点击
     */
    private void setOutsideTouchable(boolean touchable) {
        //设置透明背景
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        //设置outside可点击
        popupWindow.setOutsideTouchable(touchable);
        popupWindow.setFocusable(touchable);
    }


    static class PopupParams {
        /**
         * 布局id
         */
        public int layoutResId;
        public Context mContext;
        /**
         * 弹窗的宽度和高度
         */
        public int mWidth,mHeight ;
        public boolean isShowBg, isShowAnim;
        /**
         * 透明度程度
         */
        public float bg_level;
        /**
         *动画id
         */
        public int animationStyle;
        public View mView;
        public boolean isTouchable = true;

        public PopupParams(Context mContext) {
            this.mContext = mContext;
        }

        public void apply(PopupController controller) {
            if (mView != null) {
                controller.setView(mView);
            } else if (layoutResId != 0) {
                controller.setView(layoutResId);
            } else {
                throw new IllegalArgumentException("PopupView's contentView is null");
            }
            controller.setWidthAndHeight(mWidth, mHeight);
            //设置outside可点击
            controller.setOutsideTouchable(isTouchable);
            if (isShowBg) {
                //设置背景
                controller.setBackGroundLevel(bg_level);
            }
            if (isShowAnim) {
                controller.setAnimationStyle(animationStyle);
            }
        }
    }
}