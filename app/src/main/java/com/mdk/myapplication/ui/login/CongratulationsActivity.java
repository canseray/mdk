package com.mdk.myapplication.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mdk.myapplication.R;
import com.mdk.myapplication.helper.HttpHelper;
import com.mdk.myapplication.helper.callbacks.NewAccountCallback;
import com.mdk.myapplication.model.NewAccount;
import com.mdk.myapplication.ui.base.BaseActivity;
import com.mdk.myapplication.ui.home.HomeActivity;
import com.mdk.myapplication.util.UtilObject;

import java.util.ArrayList;
import java.util.List;

public class CongratulationsActivity extends BaseActivity {
    private static final String TAG = CongratulationsActivity.class.getName();
    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulations);

        final Button complateButton = findViewById(R.id.cong_ok_btn);
        final TextView backStepButton = findViewById(R.id.cong_back_step_tv);
        final TextView startAgainButton = findViewById(R.id.cong_start_again_tv);


        backStepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnotherActivity(context, CityInfoActivity.class);
            }
        });

        startAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnotherActivity(context, UserInfoActivity.class);
            }
        });

        complateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Pair<String,String>> nameValuePairs;

                nameValuePairs = new ArrayList<Pair<String, String>>();

                Pair<String , String> namePair = new Pair<>("param1", UtilObject.newAccount.getName());
                Pair<String , String> surnamePair = new Pair<>("param2", UtilObject.newAccount.getSname());
                Pair<String , String> emailPair = new Pair<>("param3", UtilObject.newAccount.getEmail());
                Pair<String , String> passPair = new Pair<>("param4", UtilObject.newAccount.getPass());
                Pair<String , String> mobilePair = new Pair<>("param5", UtilObject.newAccount.getMobile());
                Pair<String , String> cityPair = new Pair<>("param6", UtilObject.newAccount.getCity());

                nameValuePairs.add(namePair);
                nameValuePairs.add(surnamePair);
                nameValuePairs.add(emailPair);
                nameValuePairs.add(passPair);
                nameValuePairs.add(mobilePair);
                nameValuePairs.add(cityPair);
                new HttpHelper.NewAccountRequest(context, nameValuePairs, new NewAccountCallback() {
                    @Override
                    public void onSuccess() {
                        startAnotherActivity(context, HomeActivity.class);
                    }

                    @Override
                    public void onError(String error) {
                        Toast.makeText(CongratulationsActivity.this, error,Toast.LENGTH_SHORT).show();
                    }
                }).execute();
            }
        });
    }
}
