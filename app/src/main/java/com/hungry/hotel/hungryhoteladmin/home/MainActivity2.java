package com.hungry.hotel.hungryhoteladmin.home;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.View;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.dashboard.fragment.OrderDashboardFragment;
import com.hungry.hotel.hungryhoteladmin.deliveryboy.DeliveryBoyFragment;
import com.hungry.hotel.hungryhoteladmin.home.listener.DrawerLocker;
import com.hungry.hotel.hungryhoteladmin.login.fragment.LoginFragment;
import com.hungry.hotel.hungryhoteladmin.login.model.User;
import com.hungry.hotel.hungryhoteladmin.orders.fragment.OrderFragment;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.RestaurentMenuFragment;
import com.hungry.hotel.hungryhoteladmin.utils.SharedPreferenceHelper;

import android.view.Menu;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, DrawerLocker {
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    AutoCompleteTextView actvSearchMenu;
    ImageButton ibFilter;
    ImageButton ibSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(null);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        loadFragment(new LoginFragment(), "ORDER_DASHBOARD", false);
//        adding fragments

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.navOrders) {
            loadFragment(new OrderFragment(), "ORDER_DASHBOARD", false);
        } else if (id == R.id.navMenus) {
            loadFragment(new RestaurentMenuFragment(), "RESTAURANT_MENU", false);
        } else if (id == R.id.navReports) {
            loadFragment(new OrderDashboardFragment(), "ORDER_DASHBOARD", false);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_deliveryBoy) {
            loadFragment(new DeliveryBoyFragment(), "DELIVERY_BOY", true);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadFragment(Fragment fragment, String fragmentName, boolean needToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.clHomePageContainer, fragment);
        if (needToBackStack) {
            fragmentTransaction.addToBackStack(fragmentName);
        }
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

    @Override
    public void setDrawerLocked(boolean shouldLock) {
        if (shouldLock) {
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        } else {
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        }
    }

    @Override
    public void onAttachFragment(Fragment fragment) {

        if (fragment instanceof LoginFragment) {
            getSupportActionBar().hide();
        } else {
            getSupportActionBar().show();
        }
    }


}
