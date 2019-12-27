package com.mdk.myapplication.ui.start;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mdk.myapplication.R;

public class FirstInfoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_first_info, container, false);
        final ImageView fragmentImage = rootView.findViewById(R.id.first_fragment_image);
        final ImageView fragmentBackground = rootView.findViewById(R.id.first_fragment_background);
        final TextView fragmentTitle = rootView.findViewById(R.id.firs_fragment_title);
        final TextView fragmentExp = rootView.findViewById(R.id.first_fragment_exp);

        String topImage = getArguments().getString("topImage", "");
        String background = getArguments().getString("background", "");
        String title = getArguments().getString("title", "");
        String exp = getArguments().getString("exp", "");

        fragmentTitle.setText(title);
        fragmentExp.setText(exp);

        return rootView;
    }

    public static Fragment fragmentOne(String topImage, String background, String title, String exp) {
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
