package com.fun.havingfun.ui.signup;

import com.fun.havingfun.ui.BasePresenter;
import com.fun.havingfun.ui.BaseView;

public interface SignUpContract {
    interface IPresenter extends BasePresenter{
        void signUpNewAccount(String email, String password);
    }
    interface IView extends BaseView<IPresenter>{
        void showSignUpFailure(String signUpFailMsg, String failureTitle);

        void registerAccountToRemote(String email, String password);
    }
}
