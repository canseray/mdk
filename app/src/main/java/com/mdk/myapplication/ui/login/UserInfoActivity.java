package com.mdk.myapplication.ui.login;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mdk.myapplication.R;
import com.mdk.myapplication.ui.base.BaseActivity;


public class UserInfoActivity extends BaseActivity {
    private final static String TAG = UserInfoActivity.class.getName();
    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        final TextView userName = findViewById(R.id.user_info_name);
        final TextView userSurname = findViewById(R.id.user_info_surname);
        final Button userInfoNextBtn = findViewById(R.id.user_info_next_btn);
        final ImageView userInfoBackBtn = findViewById(R.id.user_info_back_img);

        userInfoBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnotherActivity(context, SignInActivity.class);
            }
        });

        userInfoNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnotherActivity(context, ContactInfoActivity.class);
            }
        });
    }
}
