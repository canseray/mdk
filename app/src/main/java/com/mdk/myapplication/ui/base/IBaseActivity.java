package com.mdk.myapplication.ui.base;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public interface IBaseActivity {

    void startAnotherActivity(Context currentContext, Class anotherActivity);

    void passDataAndStartAnotherActivity(Context currentContext, Class anotherActivity, String key, String value);

    void startFragment(FragmentManager fragmentManager, Fragment newFragment, int frameLayoutId);

    boolean hasPermissions(Context context, String... permissions);
}
