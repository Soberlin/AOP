package com.xfwlkjyxgs.sober.poa.MVP.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.xfwlkjyxgs.sober.poa.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public  void  update(String msg){
        Toast.makeText(this, "怎么创建一个本地仓库", Toast.LENGTH_SHORT).show();
    }

    public  void  update2(String msg){
        Toast.makeText(this, "怎么创建一个本地仓库", Toast.LENGTH_SHORT).show();
    }


    public  void  update3(String msg){
        Toast.makeText(this, "怎么创建一个本地仓库", Toast.LENGTH_SHORT).show();
    }



}
