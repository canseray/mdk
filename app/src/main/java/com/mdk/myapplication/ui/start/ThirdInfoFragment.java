package com.mdk.myapplication.ui.start;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mdk.myapplication.R;


public class ThirdInfoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_third_info, container, false);

        String topImage = getArguments().getString("topImage", "");
        String background = getArguments().getString("background", "");
        String title = getArguments().getString("title", "");
        String exp = getArguments().getString("exp", "");

        return rootView;
    }

    public static Fragment fragmentThird(String topImage, String background, String title, String exp) {
        FirstInfoFragment myFragment = new FirstInfoFragment();

        Bundle args = new Bundle();
        args.putString("topImage", topImage);
        args.putString("background", background);
        args.putString("title", title);
        args.putString("exp", exp);
        myFragment.setArguments(args);

        return myFragment;
    }


}
