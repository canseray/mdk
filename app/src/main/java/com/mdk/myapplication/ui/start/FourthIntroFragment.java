package com.mdk.myapplication.ui.start;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mdk.myapplication.R;
import com.mdk.myapplication.ui.login.SignInActivity;


public class FourthIntroFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_fourth_intro, container, false);
        final Button startButton = rootView.findViewById(R.id.start_button);
        final ImageView fragmentImage = rootView.findViewById(R.id.fourth_fragment_image);
        final ImageView fragmentBackground = rootView.findViewById(R.id.fourth_fragment_background);
        final TextView fragmentTitle = rootView.findViewById(R.id.fourth_fragment_title);
        final TextView fragmentExp = rootView.findViewById(R.id.fourth_fragment_exp);

        String topImage = getArguments().getString("topImage", "");
        String background = getArguments().getString("background", "");
        String title = getArguments().getString("title", "");
        String exp = getArguments().getString("exp", "");

        fragmentTitle.setText(title);
        fragmentExp.setText(exp);

        Glide.with(this).load(Uri.parse(background)).into(fragmentBackground);
        Glide.with(this).load(Uri.parse(topImage)).into(fragmentImage);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SignInActivity.class);
                startActivity(intent);
            }
        });


        return rootView;
    }


    public static Fragment fragmentFour(String topImage, String background, String title, String exp) {
      FourthIntroFragment myFragment = new FourthIntroFragment();

        Bundle args = new Bundle();
        args.putString("topImage", topImage);
        args.putString("background", background);
        args.putString("title", title);
        args.putString("exp", exp);
        myFragment.setArguments(args);

        return myFragment;
    }

}
