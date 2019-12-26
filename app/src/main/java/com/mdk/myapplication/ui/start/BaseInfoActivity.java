package com.mdk.myapplication.ui.start;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import com.mdk.myapplication.R;
import com.mdk.myapplication.adapter.BaseInfoAdapter;
import com.mdk.myapplication.ui.base.BaseActivity;
import com.rd.PageIndicatorView;

import java.util.ArrayList;

public class BaseInfoActivity extends BaseActivity {
    private final String TAG = BaseInfoActivity.class.getName();
    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_info);

        final ViewPager viewPager = findViewById(R.id.info_fragment_view_pager);
        final PageIndicatorView pageIndicatorView = setPageIndicatorView(R.id.pageIndicatorView);
        final BaseInfoAdapter viewPagerAdapter = new BaseInfoAdapter(getSupportFragmentManager(), setInfoFragments());

        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(0);

        setViewPageListener(viewPager, pageIndicatorView);

    }

    private ArrayList<Fragment> setInfoFragments() {
        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(new FirstInfoFragment());
        fragmentArrayList.add(new SecondInfoFragment());
        fragmentArrayList.add(new ThirdInfoFragment());
        fragmentArrayList.add(new FourthInfoFragment());
        return fragmentArrayList;
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

}






