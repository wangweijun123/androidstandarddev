package com.wangweijun.standarddevelop.io.network;

import android.util.Log;

import com.wangweijun.standarddevelop.model.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wangweijun on 2017/10/22.
 */

public class LeHttpApi {

    public static final String TAG = LeHttpApi.class.getSimpleName();

    /**
     * api 测试
     */
    public static void listRepos() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpUtils.getInstance().getOkHttpClient())
                .build();
        GitHubService service = retrofit.create(GitHubService.class);
        Call<List<Repo>> call = service.listRepos("octocat");
        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                List<Repo> list = response.body();
                Log.i(TAG, response.message() + ", list size :" + list.size());
                for (Repo repo : list) {
                    Log.i(TAG,repo.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                t.printStackTrace();
                Log.i(TAG, "error");
            }
        });
    }
}
