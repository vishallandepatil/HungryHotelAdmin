package com.hungry.hotel.hungryhoteladmin;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.hungry.hotel.hungryhoteladmin.login.fragment.LoginFragment;

public class MainActivity extends AppCompatActivity {
//    FrameLayout flContainer = findViewById(R.id.flContainer);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        LoginFragment loginFragment = new LoginFragment();

        showLoginActitivty(loginFragment);

//

    }

    private void showLoginActitivty(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.flContainer, fragment);
//        fragmentTransaction.addToBackStack("LOGIN_FRAGMENT");
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }
}
