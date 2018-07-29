package com.fun.havingfun.ui.login;

import com.fun.havingfun.ui.signup.SignUpPresenter;
import com.google.firebase.auth.FirebaseAuth;

import static com.fun.havingfun.ui.util.Constants.INVALID_PASSWORD_OR_EMAIL;
import static com.fun.havingfun.ui.util.Constants.PASSWORD_OR_EMAIL_IS_NULL;

public class LoginPresenter implements LoginContract.IPresenter {
    public FirebaseAuth getFirebaseAuth() {
        return mFirebaseAuth;
    }

    private FirebaseAuth mFirebaseAuth;
    private LoginContract.IView loginViewRef;
    public LoginPresenter(FirebaseAuth firebaseAuth, LoginContract.IView loginViewRef){
        this.mFirebaseAuth = firebaseAuth;
        this.loginViewRef = loginViewRef;
    }
    @Override
    public void loginAccount(String email, String password) {
        if(email.isEmpty() || password.isEmpty()){
            this.loginViewRef.showLoginFailure(PASSWORD_OR_EMAIL_IS_NULL, INVALID_PASSWORD_OR_EMAIL);
        }else{
            this.loginViewRef.loginAccountToRemote(email, password);
        }
    }

    @Override
    public void start() {

    }
}
