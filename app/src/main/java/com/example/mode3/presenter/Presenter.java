package com.example.mode3.presenter;

import com.example.mode3.R;
import com.example.mode3.beans.User;
import com.example.mode3.callback.ICallback;
import com.example.mode3.model.Model;
import com.example.mode3.view.IView;

/**
 * Created by 张亚丹 on 2019/5/29.
 */

public class Presenter implements IPresenter,ICallback{
    private Model mModelm;
    private IView mIViewm;

    public Presenter(Model model, IView IView) {
        mModelm = model;
        mIViewm = IView;
    }

    @Override
    public void getData() {
        mModelm.getData(this);
    }

    @Override
    public void OnSuccess(User user) {
        mIViewm.OnSuccess(user);
    }

    @Override
    public void OnFailed(String error) {
        mIViewm.OnFailed(error);
    }
}
