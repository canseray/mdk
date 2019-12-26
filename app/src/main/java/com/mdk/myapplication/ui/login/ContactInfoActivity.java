package com.mdk.myapplication.ui.login;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mdk.myapplication.R;
import com.mdk.myapplication.ui.base.BaseActivity;

public class ContactInfoActivity extends BaseActivity {
    private final static String TAG = ContactInfoActivity.class.getName();
    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        final ImageView contactBackButton = findViewById(R.id.contact_info_back_img);
        final Button contactNextButton = findViewById(R.id.contact_info_next_btn);
        final TextView contactMailTv = findViewById(R.id.contact_info_mail);
        final TextView contactPhoneTv = findViewById(R.id.contact_info_phone);
        final TextView contactPasswordTv = findViewById(R.id.contact_info_password);

        contactBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnotherActivity(context, UserInfoActivity.class);
            }
        });

        contactNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnotherActivity(context, CityInfoActivity.class);
            }
        });


    }
}
