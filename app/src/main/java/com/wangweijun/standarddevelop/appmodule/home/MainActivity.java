package com.wangweijun.standarddevelop.appmodule.home;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wangweijun.standarddevelop.R;
import com.wangweijun.standarddevelop.io.network.LeHttpApi;

public class MainActivity extends Activity {
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LeHttpApi.listRepos();

        iv = (ImageView)findViewById(R.id.iv);

        Glide.with(getApplicationContext())
                .load("http://i1.letvimg.com//lc05_iptv//201709//19//17//20//tmp3e3e95cf-3bf4-46c1-a36a-95ca33010891256.png")
                .into(iv);
    }
}
