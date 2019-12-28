package com.mdk.myapplication.ui.login;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.mdk.myapplication.R;
import com.mdk.myapplication.model.NewAccount;
import com.mdk.myapplication.ui.base.BaseActivity;
import com.mdk.myapplication.util.UtilObject;

public class ContactInfoActivity extends BaseActivity {
    private final static String TAG = ContactInfoActivity.class.getName();
    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        final ImageView contactBackButton = findViewById(R.id.contact_info_back_img);
        final Button contactNextButton = findViewById(R.id.contact_info_next_btn);
        final EditText contactMailTv = findViewById(R.id.contact_info_mail);
        final EditText contactPhoneTv = findViewById(R.id.contact_info_phone);
        final EditText contactPasswordTv = findViewById(R.id.contact_info_password);

        contactBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnotherActivity(context, UserInfoActivity.class);
            }
        });

        contactNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String mailTvInput = contactMailTv.getText().toString();
                final String phoneTvInput = contactPhoneTv.getText().toString();
                final String passwordTvText = contactPasswordTv.getText().toString();

                UtilObject.newAccount.setEmail(mailTvInput);
                UtilObject.newAccount.setMobile(phoneTvInput);
                UtilObject.newAccount.setPass(passwordTvText);

                startAnotherActivity(context, CityInfoActivity.class);
            }
        });


    }
}
