package com.mdk.myapplication.helper.callbacks;

import com.mdk.myapplication.model.IntroScreenItem;

import java.util.List;

public interface IntroScreenItemCallback {
    void onUpdate();
    void onRepair();
    void onError();
    void onSuccess(List<IntroScreenItem> introScreenItemList);
}
