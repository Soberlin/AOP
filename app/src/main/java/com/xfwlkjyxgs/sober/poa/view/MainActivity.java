package com.xfwlkjyxgs.sober.poa.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.xfwlkjyxgs.sober.poa.R;
import com.xfwlkjyxgs.sober.poa.utils.MyTime;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_getCurrentTime)
    Button btnGetCurrentTime;
    @BindView(R.id.showTime)
    TextView showTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btn_getCurrentTime)
    public void onClick() {
       showTime.setText(MyTime.getSystemCurrentTime());
    }
}
