package com.xfwlkjyxgs.sober.poa.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xfwlkjyxgs.sober.poa.R;
import com.xfwlkjyxgs.sober.poa.utils.LoadingDialog;

import butterknife.Unbinder;

/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2018/1/15.
 * 你能我就能****
 */
public class BaseActivity  extends AppCompatActivity{

    private LoadingDialog  loading;
    private View mRootView;
    Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(mRootView);*/
        /*mRootView=createView(null,null,savedInstanceState);
        initData();*/
    }
    /**
     * 展示dialog
     */
    public  void ShowLoading(){
        if (loading==null){
            loading=new LoadingDialog(this, R.style.loading_dialog);
        }
        if (!loading.isShowing()) {
            loading.show();
        }
    }

    /**
     * 关闭对话框
     */
      public  void  hideLoading(){
          if (loading!=null&&loading.isShowing()){
              loading.dismiss();
          }
      }


   /* @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=getLayoutInflater().inflate(getContentLayout(),container);
        unbinder= ButterKnife.bind(this,view);
        return  view;
    }

    @Override
    public View getView() {
     return  mRootView;
    }*/
    /**
     * 获取版本号
     */



}
