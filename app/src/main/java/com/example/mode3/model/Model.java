package com.example.mode3.model;

import com.example.mode3.Apiservice;
import com.example.mode3.beans.User;
import com.example.mode3.callback.ICallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 张亚丹 on 2019/5/29.
 */

public class Model implements IModel{
    @Override
    public void getData(final ICallback callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Apiservice.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Apiservice apiservice = retrofit.create(Apiservice.class);
        Call<User> geturl = apiservice.geturl();
        geturl.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                callback.OnSuccess(user);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                callback.OnFailed(t.getMessage());
            }
        });
    }
}
