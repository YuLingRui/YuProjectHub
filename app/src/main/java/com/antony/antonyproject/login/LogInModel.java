package com.antony.antonyproject.login;

import base.BaseObjectBean;
import bean.LoginBean;
import io.reactivex.Flowable;

public class LogInModel implements LogInContract.Model {

    @Override
    public Flowable<BaseObjectBean<LoginBean>> login(String username, String password) {
        return null;
    }
}
