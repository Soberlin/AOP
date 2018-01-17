package com.xfwlkjyxgs.sober.poa.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2018/1/16.
 * 你能我就能****
 */
public interface IBase {
     View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
     View getView();
     void bindView(View view, Bundle savedInstanceState);
     void initData();
     int getContentLayout();


}
