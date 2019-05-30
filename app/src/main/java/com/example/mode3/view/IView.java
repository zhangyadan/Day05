package com.example.mode3.view;

import com.example.mode3.beans.User;

/**
 * Created by 张亚丹 on 2019/5/29.
 */

public interface IView {
    void OnSuccess(User user);
    void OnFailed(String error);

}
