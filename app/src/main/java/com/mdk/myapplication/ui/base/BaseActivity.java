package com.mdk.myapplication.ui.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class BaseActivity extends AppCompatActivity implements IBaseActivity {

    private static final String TAG = BaseActivity.class.getName();

    @Override
    public void startAnotherActivity(Context currentContext, Class anotherActivity) {
        Intent intent = new Intent(currentContext, anotherActivity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    @Override
    public void passDataAndStartAnotherActivity(Context currentContext, Class anotherActivity, String key, String value) {
        Intent intent = new Intent(currentContext, anotherActivity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.putExtra(key,value);
        startActivity(intent);
    }

    @Override
    public void startFragment(FragmentManager fragmentManager, Fragment newFragment, int frameLayoutId){
        fragmentManager.beginTransaction().replace(frameLayoutId, newFragment).commit();
    }

    @Override
    public boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return false;
    }
}
