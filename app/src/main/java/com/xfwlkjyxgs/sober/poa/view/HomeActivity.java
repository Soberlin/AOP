package com.xfwlkjyxgs.sober.poa.view;

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


}
