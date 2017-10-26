package com.wangweijun.standarddevelop.appmodule.home;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.wangweijun.standarddevelop.R;

/**
 * Created by wangweijun1 on 2017/10/26.
 */

public class SecondActivity extends Activity{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_second);
    }
}
