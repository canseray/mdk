package com.mdk.myapplication.ui.start;

import android.content.Context;
import android.os.Bundle;

import com.mdk.myapplication.R;
import com.mdk.myapplication.ui.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        waitScreen(context);

    }

    public void waitScreen(final Context context){
        Thread timer= new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(2000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    //if first begin in app
                    startAnotherActivity(context, BaseIntroActivity.class);

                    //else if not first begin && not current user
                    //start signup act

                    //else if if not first begin && have a current user
                    //start main act
                }
            }
        };
        timer.start();
    }
}
