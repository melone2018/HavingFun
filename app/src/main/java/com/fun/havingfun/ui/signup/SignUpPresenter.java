package com.fun.havingfun.ui.signup;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;

import com.fun.havingfun.R;
import com.fun.havingfun.ui.home.HomeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpPresenter implements SignUpContract.IPresenter {
    public static final String PASSWORD_OR_EMAIL_IS_NULL = "Please make sure you entred a password and email";
    public static final String INVALID_PASSWORD_OR_EMAIL = "Invalid Password or Email";

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
            this.signUpViewRef.showSignUpFailuer(PASSWORD_OR_EMAIL_IS_NULL, INVALID_PASSWORD_OR_EMAIL);
        }else{
            this.signUpViewRef.registerAccountToRemote(email, password);
        }
    }
}
