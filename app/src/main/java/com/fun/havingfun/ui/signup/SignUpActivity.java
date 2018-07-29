package com.fun.havingfun.ui.signup;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.fun.havingfun.R;
import com.fun.havingfun.ui.home.HomeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity implements SignUpContract.IView {
    private SignUpPresenter mSignUpPresenter;

    @BindView(R.id.your_email_address)
    EditText mEmailEt;
    @BindView(R.id.create_new_password)
    EditText mPasswordEt;
    @BindView(R.id.email_sign_up_button)
    Button mSignUpButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        mSignUpPresenter = new SignUpPresenter(FirebaseAuth.getInstance(), this);
    }

    @OnClick(R.id.email_sign_up_button)
    public void setSignUpButton(){
        String email = mEmailEt.getText().toString().trim();
        String password = mPasswordEt.getText().toString().trim();
        mSignUpPresenter.signUpNewAccount(email, password);
    }

    @Override
    public void showSignUpFailure(String signUpFailMsg, String failureTitle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
        builder.setMessage(signUpFailMsg)
                .setTitle(failureTitle)
                .setPositiveButton(android.R.string.ok, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void registerAccountToRemote(String email, String password) {
        mSignUpPresenter.getFirebaseAuth().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        } else {
                            showSignUpFailure(task.getException().getMessage(), "Log in failure!");
                        }
                    }
                });
    }

    @Override
    public void setPresenter(SignUpContract.IPresenter presenter) {
        this.mSignUpPresenter = (SignUpPresenter)presenter;
    }
}
