package com.example.mode3.adapter;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mode3.R;
import com.example.mode3.beans.User;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL;

/**
 * Created by 张亚丹 on 2019/5/29.
 */

public class Main2Adapter extends PagerAdapter{
  private ArrayList<User.ResultsBean> mBeansm;
  private Context mContextm;

    public Main2Adapter(ArrayList<User.ResultsBean> beans, Context context) {
        mBeansm = beans;
        mContextm = context;
    }

    @Override
    public int getCount() {
        return mBeansm.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View inflate = View.inflate(mContextm, R.layout.layout_vp, null);
        ImageView viewById = inflate.findViewById(R.id.vp_tp);
        Glide.with(mContextm).load(mBeansm.get(position).getUrl()).into(viewById);
        container.addView(inflate);
        return inflate;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
