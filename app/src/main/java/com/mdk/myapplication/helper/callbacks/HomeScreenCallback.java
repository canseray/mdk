package com.mdk.myapplication.helper.callbacks;

import com.mdk.myapplication.model.HomeCardsItem;

import java.util.List;

public interface HomeScreenCallback {
    void onSuccess(List<HomeCardsItem> homeCardsItemList);
    void onError();
}
