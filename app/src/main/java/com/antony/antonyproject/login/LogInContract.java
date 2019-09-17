package com.antony.antonyproject.login;

import base.BaseObjectBean;
import base.BaseView;
import bean.LoginBean;
import io.reactivex.Flowable;

public interface LogInContract {

    interface View extends BaseView {

        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(BaseObjectBean<LoginBean> bean);
    }

    interface Presenter {
        /**
         * 登陆
         *
         * @param username
         * @param password
         */
        void login(String username, String password);
    }
}
