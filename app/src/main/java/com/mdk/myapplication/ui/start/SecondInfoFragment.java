package com.mdk.myapplication.ui.start;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mdk.myapplication.R;


public class SecondInfoFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_info, container, false);
    }


    public static Fragment fragmentTwo(String topImage, String background, String title, String exp) {
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
