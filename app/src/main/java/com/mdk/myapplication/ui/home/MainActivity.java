package com.mdk.myapplication.ui.home;

import android.content.Context;
import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.mdk.myapplication.R;
import com.mdk.myapplication.adapter.HomeCardsAdapter;
import com.mdk.myapplication.helper.HttpHelper;
import com.mdk.myapplication.helper.callbacks.HomeScreenCallback;
import com.mdk.myapplication.model.HomeCardsItem;
import com.mdk.myapplication.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getName();
    private Context context = this;
    private RecyclerView cardRecyclerView;
    private ArrayList<HomeCardsItem> homeCardsItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardRecyclerView = findViewById(R.id.card_rv);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        cardRecyclerView.setLayoutManager(layoutManager);
        cardRecyclerView.setHasFixedSize(true);

        new HttpHelper.HomeScreenRequest(this, new HomeScreenCallback() {
            @Override
            public void onSuccess(List<HomeCardsItem> homeCardsItemList) {
                HomeCardsAdapter homeCardsAdapter = new HomeCardsAdapter(context,homeCardsItems);
                cardRecyclerView.setAdapter(homeCardsAdapter);
            }

            @Override
            public void onError() {

            }
        }).execute();
    }
}
