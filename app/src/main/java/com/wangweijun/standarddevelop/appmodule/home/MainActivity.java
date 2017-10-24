package com.wangweijun.standarddevelop.appmodule.home;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wangweijun.standarddevelop.R;
import com.wangweijun.standarddevelop.io.network.LeHttpApi;
import com.wangweijun.standarddevelop.model.IResponse;
import com.wangweijun.standarddevelop.model.RankListModel;
import com.wangweijun.standarddevelop.model.RecommendModel.RankRecommedModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        LeHttpApi.listRepos();



        iv = (ImageView)findViewById(R.id.iv);

        Glide.with(getApplicationContext())
                .load("http://i1.letvimg.com//lc05_iptv//201709//19//17//20//tmp3e3e95cf-3bf4-46c1-a36a-95ca33010891256.png")
                .into(iv);




        Callback<IResponse<RankListModel>> callback = new Callback<IResponse<RankListModel>>() {
            @Override
            public void onResponse(Call<IResponse<RankListModel>> call, Response<IResponse<RankListModel>> response) {
                IResponse<RankListModel> model = response.body();
                RankListModel rankListModel = model.getEntity();
                Log.i(LeHttpApi.TAG, response.headers().toString());
                Log.i(LeHttpApi.TAG,  response.code()+", "+response.message());
                List<RankRecommedModel> list = rankListModel.ranklist.get(0).items;
                for(RankRecommedModel model1 : list) {
                    Log.i(LeHttpApi.TAG, model1.toString());
                }
            }

            @Override
            public void onFailure(Call<IResponse<RankListModel>> call, Throwable t) {
                t.printStackTrace();
                Log.i(LeHttpApi.TAG, "onFailure status");
            }
        };
        LeHttpApi.doGetAsync(callback);
    }
}
