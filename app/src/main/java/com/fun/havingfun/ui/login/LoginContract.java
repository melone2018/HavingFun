package com.fun.havingfun.ui.login;

import com.fun.havingfun.ui.BasePresenter;
import com.fun.havingfun.ui.BaseView;

public interface LoginContract {
    interface IPresenter extends BasePresenter{
        void loginAccount(String email, String password);
    }
    interface IView extends BaseView<IPresenter> {
        void showLoginFailure(String loginFailMsg, String failureTitle);
        void loginAccountToRemote(String email, String password);
    }
}
