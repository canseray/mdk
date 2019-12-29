package com.mdk.myapplication.ui.login;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mdk.myapplication.R;
import com.mdk.myapplication.helper.HttpHelper;
import com.mdk.myapplication.helper.callbacks.LoginCallback;
import com.mdk.myapplication.ui.base.BaseActivity;
import com.mdk.myapplication.ui.home.HomeActivity;

import java.util.ArrayList;
import java.util.List;

public class SignInActivity extends BaseActivity {
    private final static String TAG = SignInActivity.class.getName();
    private final Context context = this;
    private EditText emailTv, passwordTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        final Button signInButton = findViewById(R.id.sign_in_btn);
        final ImageView exitButton = findViewById(R.id.signin_exit_img);
        final TextView newUserButton = findViewById(R.id.signin_new_tv);
        final TextView forgotPassword = findViewById(R.id.forgot_password_tv);
        emailTv = findViewById(R.id.email_tv);
        passwordTv = findViewById(R.id.password_tv);



        newUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnotherActivity(context, UserInfoActivity.class);
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnotherActivity(context, ForgotPasswordActivity.class);
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String emailTvInput = emailTv.getText().toString();
                final String passwordTvInput = passwordTv.getText().toString();

                List<Pair<String, String>> nameValuePairs2;

                nameValuePairs2 = new ArrayList<Pair<String, String>>();

                Pair<String, String> emailPair2 = new Pair<>("param1", emailTvInput);
                Pair<String, String> passwordPair2 = new Pair<>("param2", passwordTvInput);

                nameValuePairs2.add(emailPair2);
                nameValuePairs2.add(passwordPair2);

                new HttpHelper.LoginRequest(context, nameValuePairs2, new LoginCallback() {
                    @Override
                    public void onSuccess() {
                        startAnotherActivity(context, HomeActivity.class);
                    }

                    @Override
                    public void onError(String error) {
                        Toast.makeText(SignInActivity.this, error,Toast.LENGTH_SHORT).show();

                    }
                }).execute();
            }
        });



    }
}
