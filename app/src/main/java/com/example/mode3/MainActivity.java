package com.example.mode3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.mode3.adapter.MyAdapter;
import com.example.mode3.beans.User;
import com.example.mode3.model.Model;
import com.example.mode3.presenter.Presenter;
import com.example.mode3.view.IView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IView {

    private RecyclerView mRecy;
    private ArrayList<User.ResultsBean> list;
    private MyAdapter adapter;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initData() {
        Presenter presenter = new Presenter(new Model(), this);
        presenter.getData();
    }

    private void initView() {
        mRecy = (RecyclerView) findViewById(R.id.Recy);

        mRecy.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new MyAdapter(list, this);
        mRecy.setAdapter(adapter);
        adapter.setOnItemClick(new MyAdapter.onItemClick() {
            @Override
            public void onClick() {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("new",list);
                startActivity(intent);

            }
        });


    }

    @Override
    public void OnSuccess(User user) {
        List<User.ResultsBean> results = user.getResults();
        list.addAll(results);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void OnFailed(String error) {

    }


}
