package com.mdk.myapplication.ui.start;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mdk.myapplication.R;


public class ThirdIntroFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_third_intro, container, false);
        final ImageView fragmentImage = rootView.findViewById(R.id.third_fragment_image);
        final ImageView fragmentBackground = rootView.findViewById(R.id.third_fragment_background);
        final TextView fragmentTitle = rootView.findViewById(R.id.third_fragment_title);
        final TextView fragmentExp = rootView.findViewById(R.id.third_fragment_exp);

        String topImage = getArguments().getString("topImage", "");
        String background = getArguments().getString("background", "");
        String title = getArguments().getString("title", "");
        String exp = getArguments().getString("exp", "");

        fragmentTitle.setText(title);
        fragmentExp.setText(exp);

        Glide.with(this).load(Uri.parse(background)).into(fragmentBackground);
        Glide.with(this).load(Uri.parse(topImage)).into(fragmentImage);

        return rootView;
    }

    public static Fragment fragmentThird(String topImage, String background, String title, String exp) {
        ThirdIntroFragment myFragment = new ThirdIntroFragment();

        Bundle args = new Bundle();
        args.putString("topImage", topImage);
        args.putString("background", background);
        args.putString("title", title);
        args.putString("exp", exp);
        myFragment.setArguments(args);

        return myFragment;
    }


}
