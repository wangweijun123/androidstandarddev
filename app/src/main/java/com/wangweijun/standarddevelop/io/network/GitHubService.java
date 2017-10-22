package com.wangweijun.standarddevelop.io.network;

import com.wangweijun.standarddevelop.model.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by wangweijun on 2017/10/22.
 */

public interface GitHubService {
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);

}
