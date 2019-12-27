package com.mdk.myapplication.ui.home;

import android.content.Context;
import android.os.Bundle;

import com.google.zxing.Result;
import com.mdk.myapplication.ui.base.BaseActivity;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRCodeScanActivity extends BaseActivity implements ZXingScannerView.ResultHandler {
    private final String TAG = QRCodeScanActivity.class.getName();
    private final Context context = this;
    ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);


    }

    @Override
    public void handleResult(Result result) {
        if (!(result == null)){

        MDCoinActivity.qrCodeResult.setText(result.getText());

        } else {
            MDCoinActivity.qrCodeResult.setText("Kodu okutmayı tekrar deneyin");
        }
        onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }
}
