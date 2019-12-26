package com.mdk.myapplication.ui.login;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mdk.myapplication.R;
import com.mdk.myapplication.ui.base.BaseActivity;
import com.mdk.myapplication.ui.start.FourthInfoFragment;

import org.w3c.dom.Text;

public class SignInActivity extends BaseActivity {
    private final static String TAG = SignInActivity.class.getName();
    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        final Button signInButton = findViewById(R.id.sign_in_btn);
        final ImageView exitButton = findViewById(R.id.signin_exit_img);
        final TextView newUserButton = findViewById(R.id.signin_new_tv);
        final TextView forgotPassword = findViewById(R.id.forgot_password_tv);
        final TextView emailTv = findViewById(R.id.email_tv);
        final TextView passwordTv = findViewById(R.id.password_tv);

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

            }
        });
    }
}
