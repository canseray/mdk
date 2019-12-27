package com.mdk.myapplication.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import com.mdk.myapplication.R;
import com.mdk.myapplication.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {
    private final String TAG = MainActivity.class.getName();
    private final Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView qrButton = findViewById(R.id.qr_code);
        final ImageView menuButton = findViewById(R.id.menu_button);

    }
}
