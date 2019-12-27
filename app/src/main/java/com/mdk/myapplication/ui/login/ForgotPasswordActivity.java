package com.mdk.myapplication.ui.login;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.mdk.myapplication.R;
import com.mdk.myapplication.ui.base.BaseActivity;


public class ForgotPasswordActivity extends BaseActivity {
    private final static String TAG = ForgotPasswordActivity.class.getName();
    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        final Button sendButton = findViewById(R.id.forgot_password_send_btn);
        final ImageView backButton = findViewById(R.id.forgot_password_back_img);
        final EditText forgotEmailTv = findViewById(R.id.forgot_password_tv);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnotherActivity(context, SignInActivity.class);
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
