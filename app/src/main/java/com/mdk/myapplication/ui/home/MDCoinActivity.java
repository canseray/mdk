package com.mdk.myapplication.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mdk.myapplication.R;
import com.mdk.myapplication.ui.base.BaseActivity;

public class MDCoinActivity extends BaseActivity {
    private final String TAG = MDCoinActivity.class.getName();
    private final Context context = this;
    public static TextView qrCodeResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mdcoin);

        qrCodeResult = findViewById(R.id.qr_code_result);
        final Button myGiftButton = findViewById(R.id.my_gift);
        final Button qrCodeScan = findViewById(R.id.scan_code);

        qrCodeScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnotherActivity(context, QRCodeScanActivity.class);
            }
        });
    }
}
