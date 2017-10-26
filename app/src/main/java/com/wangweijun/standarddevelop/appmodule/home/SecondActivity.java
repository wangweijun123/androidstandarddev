package com.wangweijun.standarddevelop.appmodule.home;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wangweijun.standarddevelop.R;

/**
 * Created by wangweijun1 on 2017/10/26.
 */

public class SecondActivity extends Activity implements View.OnClickListener{
    Button bt1;
    ImageView iv1;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_second);

        bt1 = (Button)findViewById(R.id.bt1);
        bt1.setOnClickListener(this);
        iv1 = (ImageView)findViewById(R.id.iv1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:
                Glide.with(this).load("http://img1.dzwww.com:8080/tupian_pl/20150813/16/7858995348613407436.jpg")
                        .into(iv1);
                break;
        }
    }
}
