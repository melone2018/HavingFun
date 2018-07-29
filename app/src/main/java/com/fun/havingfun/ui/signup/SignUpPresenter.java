package com.fun.havingfun.ui.signup;

import com.google.firebase.auth.FirebaseAuth;

import static com.fun.havingfun.ui.util.Constants.INVALID_PASSWORD_OR_EMAIL;
import static com.fun.havingfun.ui.util.Constants.PASSWORD_OR_EMAIL_IS_NULL;

public class SignUpPresenter implements SignUpContract.IPresenter {


    public FirebaseAuth getFirebaseAuth() {
        return mFirebaseAuth;
    }

    private FirebaseAuth mFirebaseAuth;
    private SignUpContract.IView signUpViewRef;

    public SignUpPresenter(FirebaseAuth firebaseAuth, SignUpContract.IView signUpView){
        this.mFirebaseAuth = firebaseAuth;
        this.signUpViewRef = signUpView;
    }
    @Override
    public void start() {

    }

    @Override
    public void signUpNewAccount(String email, String password) {
        if(email.isEmpty() || password.isEmpty()){
            this.signUpViewRef.showSignUpFailure(PASSWORD_OR_EMAIL_IS_NULL, INVALID_PASSWORD_OR_EMAIL);
        }else{
            this.signUpViewRef.registerAccountToRemote(email, password);
        }
    }
}
