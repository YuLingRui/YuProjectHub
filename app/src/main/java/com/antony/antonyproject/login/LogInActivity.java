package com.antony.antonyproject.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.antony.antonyproject.R;

import base.BaseMvpActivity;
import base.BaseObjectBean;
import bean.LoginBean;

public class LogInActivity extends BaseMvpActivity<LogInPresenter>  implements LogInContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_log_in;
    }

    @Override
    public void initView() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onSuccess(BaseObjectBean<LoginBean> bean) {

    }


}
