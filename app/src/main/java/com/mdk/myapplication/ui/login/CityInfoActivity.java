package com.mdk.myapplication.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mdk.myapplication.R;
import com.mdk.myapplication.ui.base.BaseActivity;

public class CityInfoActivity extends BaseActivity {
    private final static String TAG = CityInfoActivity.class.getName();
    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_info);

        final ImageView cityInfoBackButton = findViewById(R.id.city_info_back_img);

        cityInfoBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnotherActivity(context, ContactInfoActivity.class);
            }
        });

    }
}
