package com.hungry.hotel.hungryhoteladmin.welcome;

import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.home.HomeActivity;
import com.hungry.hotel.hungryhoteladmin.utils.SharedPreferenceHelper;
import com.hungry.hotel.hungryhoteladmin.utils.Utilities;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = SplashActivity.class.getSimpleName();

    SharedPreferenceHelper sharedPreferenceHelper;

    Handler handler;

    RelativeLayout childlayout,parentlayout;
    TextView txt_error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        childlayout=findViewById(R.id.childlayout);
        parentlayout=findViewById(R.id.parentlayout);
        txt_error=findViewById(R.id.txt_error);

       // Utilities.launchActivity(SplashActivity.this, HomeActivity.class, true);
        animation();
    }


    public void animation() {
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                    Utilities.launchActivity(SplashActivity.this, HomeActivity.class, true);

            }
        }, 3000);
    }


}