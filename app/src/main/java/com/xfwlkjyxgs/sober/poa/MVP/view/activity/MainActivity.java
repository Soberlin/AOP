package com.xfwlkjyxgs.sober.poa.MVP.view.activity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;


import com.xfwlkjyxgs.sober.poa.R;
import com.xfwlkjyxgs.sober.poa.base.BaseActivity;
import com.xfwlkjyxgs.sober.poa.utils.CommonPopupWindow;
import com.xfwlkjyxgs.sober.poa.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_getCurrentTime)
    Button btnGetCurrentTime;
    @BindView(R.id.showTime)
    TextView showTime;
    @BindView(R.id.iv_showglide)
    ImageView ivShowglide;

    String url = "http://img1.dzwww.com:8080/tupian_pl/20150813/16/7858995348613407436.jpg";
    @BindView(R.id.btn_hidedialog)
    Button btnHidedialog;

    private CommonPopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnHidedialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.show(MainActivity.this,"隐藏dialog",1000);
                hideLoading();
            }
        });
    }

   /* @OnClick(R.id.btn_hidedialog)
    public void onClick() {
    }*/
    @OnClick(R.id.btn_getCurrentTime)
    public void onClick() {

        /*OkHttpRequest();*/
       /* ToastUtil.show(this, "当前系统时间", 100);
        showTime.setText(MyTime.getSystemCurrentTime());*/
        /*Glide.with(this).load(url).into(ivShowglide);*/
        /*TestPopupWindow();*/
        /*ShowLoading();*/
      /*  showTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.show(MainActivity.this, "当前系统时间", 100);
                hideLoading();
            }
        });*/


     /*   try {
            Thread.sleep(1000);
            hideLoading();
        } catch (InterruptedException e) {

        }*/
    }

    /**
     * okhttp的测试
     */
   /* private void OkHttpRequest() {
        OkHttpClient client=new OkHttpClient();
        final Request  request=new Request.Builder().url("https://github.com/hongyangAndroid").build();
        Call call=client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(final Response response) throws IOException {
                 ;
                 runOnUiThread(new Runnable() {
                     @Override
                     public void run() {
                         showTime.setText(response.body().toString());
                     }
                 });
            }
        });

    }*/


    /**
     * 测试弹窗dialog
     */
    private void TestPopupWindow() {
        if (popupWindow != null && popupWindow.isShowing()) {
            return;
        }
        popupWindow = new CommonPopupWindow.Builder(this)
                .setView(R.layout.popupwindow)
                .setWidthAndHeight(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                .setBackGroundLevel(0.5f)
                .setOutsideTouchable(true)
                .setViewOnclickListener(new CommonPopupWindow.ViewInterface() {
                    @Override
                    public void getChildView(View view, int layoutResId) {

                        TextView view1 = view.findViewById(R.id.photo);
                        view1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ToastUtil.show(MainActivity.this, "调用相册", 100);
                            }
                        });

                    }
                })
                .create();
        View view = LayoutInflater.from(this).inflate(R.layout.activity_home, null);
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
    }



}
