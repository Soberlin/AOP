package com.xfwlkjyxgs.sober.poa.utils;

import android.view.View;

import com.google.gson.Gson;

public class CommonUtil {
    /**
     * 测量View的宽高
     *
     * @param view View
     */
    public static void measureWidthAndHeight(View view) {
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        view.measure(widthMeasureSpec, heightMeasureSpec);
    }



    private static Gson gson = new Gson();

    /**
     * 解析方法
     * @param json
     * @return
     */
    public static <T> T parseResult(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }


}