package com.xfwlkjyxgs.sober.poa.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.xfwlkjyxgs.sober.poa.R;

/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2018/1/16.
 * 你能我就能****
 */
public class LoadingDialog  extends Dialog{
    private Activity  activity;
    public LoadingDialog(@NonNull Context context) {
        super(context);
        activity= (Activity) context;
    }

    public LoadingDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        activity= (Activity) context;
    }

    public LoadingDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        activity= (Activity) context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);
    }
}
