package com.mdk.myapplication.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mdk.myapplication.R;
import com.mdk.myapplication.model.NewAccount;
import com.mdk.myapplication.ui.base.BaseActivity;
import com.mdk.myapplication.util.UtilObject;

public class CityInfoActivity extends BaseActivity {
    private final static String TAG = CityInfoActivity.class.getName();
    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_info);

        final ImageView cityInfoBackButton = findViewById(R.id.city_info_back_img);
        final Button cityNextbutton = findViewById(R.id.city_next_btn);


        cityInfoBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        cityNextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UtilObject.newAccount.setCity("1");

                startAnotherActivity(context, CongratulationsActivity.class);
            }
        });

    }
}
