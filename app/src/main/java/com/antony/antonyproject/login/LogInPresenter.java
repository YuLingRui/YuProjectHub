package com.antony.antonyproject.login;

import base.BasePresenter;

public class LogInPresenter extends BasePresenter<LogInContract.View> implements LogInContract.Presenter {

    private LogInContract.Model model;

    public LogInPresenter() {
        model = new LogInModel();
    }

    @Override
    public void login(String username, String password) {

    }
}
