package com.mdk.myapplication.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mdk.myapplication.R;
import com.mdk.myapplication.ui.base.BaseActivity;

public class CongratulationsActivity extends BaseActivity {
    private static final String TAG = CongratulationsActivity.class.getName();
    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulations);

        final Button complateButton = findViewById(R.id.cong_ok_btn);
        final TextView backStepButton = findViewById(R.id.cong_back_step_tv);
        final TextView startAgainButton = findViewById(R.id.cong_start_again_tv);

        backStepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnotherActivity(context, CityInfoActivity.class);
            }
        });

        startAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnotherActivity(context, UserInfoActivity.class);
            }
        });

        complateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //input check & save database
                //open cong dialog
            }
        });
    }
}
