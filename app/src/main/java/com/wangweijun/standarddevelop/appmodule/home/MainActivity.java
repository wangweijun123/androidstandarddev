package com.wangweijun.standarddevelop.appmodule.home;

import android.app.Activity;
import android.os.Bundle;

import com.wangweijun.standarddevelop.R;
import com.wangweijun.standarddevelop.io.network.LeHttpApi;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LeHttpApi.listRepos();
    }
}
