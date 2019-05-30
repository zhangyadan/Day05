package com.example.mode3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mode3.adapter.Main2Adapter;
import com.example.mode3.beans.User;

import java.io.Serializable;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = Main2Activity.class.getName();
    private ViewPager mVp;
    private TextView mTv;
    private ArrayList<View> list;
    private Main2Adapter adapter;
    private User.ResultsBean mANewm;
    private ArrayList<User.ResultsBean> mANewm1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        mANewm1 = (ArrayList<User.ResultsBean>) intent.getSerializableExtra("new");
//        Log.d(TAG, "onCreate: "+ mANewm1);
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.Vp);
        mTv = (TextView) findViewById(R.id.tv);

        Main2Adapter main2Adapter = new Main2Adapter(mANewm1, this);
        mVp.setAdapter(main2Adapter);

    }
}
