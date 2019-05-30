package com.example.mode3;

import com.example.mode3.beans.User;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 张亚丹 on 2019/5/29.
 */

public interface Apiservice {
    //https://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/1
    String url = "https://gank.io/";

    @GET("api/data/%E7%A6%8F%E5%88%A9/20/1")
    Call<User> geturl();
}
