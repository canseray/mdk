package com.mdk.myapplication.ui.start;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;

import com.mdk.myapplication.R;
import com.mdk.myapplication.adapter.BaseInfoAdapter;
import com.mdk.myapplication.db.IntroScreenItem;
import com.mdk.myapplication.helper.HttpHelper;
import com.mdk.myapplication.helper.callbacks.IntroScreenItemCallback;
import com.mdk.myapplication.ui.base.BaseActivity;
import com.rd.PageIndicatorView;

import java.util.ArrayList;
import java.util.List;

public class BaseInfoActivity extends BaseActivity {
    private final String TAG = BaseInfoActivity.class.getName();
    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_info);

        final ViewPager viewPager = findViewById(R.id.info_fragment_view_pager);
        final PageIndicatorView pageIndicatorView = setPageIndicatorView(R.id.pageIndicatorView);



        new HttpHelper.IntroScreenRequest(this, new IntroScreenItemCallback() {
            @Override
            public void onUpdate() {

            }

            @Override
            public void onRepair() {

            }

            @Override
            public void onError() {

            }

            @Override
            public void onSuccess(List<IntroScreenItem> introScreenItemList) {
                ArrayList<Fragment> fragmentArrayList = new ArrayList<>();


                for(int i=0;i<introScreenItemList.size()-1;i++){

                    IntroScreenItem introScreenItem = introScreenItemList.get(i);

                    if(i == 0){
                        fragmentArrayList.add(FirstInfoFragment.fragmentOne(introScreenItem.getImage_path(),introScreenItem.getImage_back_url(),introScreenItem.getTitle(),introScreenItem.getExp()));

                    }
                    if(i == 1){
                        fragmentArrayList.add(SecondInfoFragment.fragmentTwo(introScreenItem.getImage_path(),introScreenItem.getImage_back_url(),introScreenItem.getTitle(),introScreenItem.getExp()));

                    }
                    if(i == 2){
                        fragmentArrayList.add(ThirdInfoFragment.fragmentThird(introScreenItem.getImage_path(),introScreenItem.getImage_back_url(),introScreenItem.getTitle(),introScreenItem.getExp()));

                    }
                    if(i == 3){
                        fragmentArrayList.add(FourthInfoFragment.fragmentFour(introScreenItem.getImage_path(),introScreenItem.getImage_back_url(),introScreenItem.getTitle(),introScreenItem.getExp()));

                    }
                }

                final BaseInfoAdapter viewPagerAdapter = new BaseInfoAdapter(getSupportFragmentManager(), fragmentArrayList);

                viewPager.setAdapter(viewPagerAdapter);
                viewPager.setCurrentItem(0);

                setViewPageListener(viewPager, pageIndicatorView);

            }
        }).execute();

    }


    private PageIndicatorView setPageIndicatorView(int pageIndicatorId) {
        final PageIndicatorView pageIndicatorView = findViewById(pageIndicatorId);
        pageIndicatorView.setCount(4);
        pageIndicatorView.setSelection(0);
        return pageIndicatorView;
    }

    private void setViewPageListener(final ViewPager viewPager, final PageIndicatorView pageIndicatorView) {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }

    ///////////////////////////



}






