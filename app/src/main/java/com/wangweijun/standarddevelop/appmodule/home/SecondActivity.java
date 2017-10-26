package com.wangweijun.standarddevelop.appmodule.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.wangweijun.standarddevelop.GlideApp;
import com.wangweijun.standarddevelop.R;


/**
 * Created by wangweijun1 on 2017/10/26.
 */

public class SecondActivity extends Activity implements View.OnClickListener{
    Button bt1;
    ImageView iv1, iv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        bt1 = (Button)findViewById(R.id.bt1);
        bt1.setOnClickListener(this);
        iv1 = (ImageView)findViewById(R.id.iv1);

        iv2 = (ImageView)findViewById(R.id.iv2);

//        GlideApp.with(getApplicationContext())
//                .load("http://img1.dzwww.com:8080/tupian_pl/20150813/16/7858995348613407436ddddddd.jpg")
//                .placeholder(R.mipmap.ic_launcher)
//                .error(R.mipmap.error)
//                .centerCrop()
//                .into(iv1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:
                GlideApp.with(this).load("http://img1.dzwww.com:8080/tupian_pl/20150813/16/7858995348613407436.jpg")
                        .placeholder(R.mipmap.ic_launcher)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(iv1);


                GlideApp.with(this).load("http://img1.dzwww.com:8080/tupian_pl/20150813/16/7858995348613407436.jpg")
                        .placeholder(R.mipmap.ic_launcher)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(iv2);
                break;
        }
    }
}
