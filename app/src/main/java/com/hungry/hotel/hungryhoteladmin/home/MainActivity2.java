package com.hungry.hotel.hungryhoteladmin.home;

import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.View;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.broadcastreceiver.ConnectivityReceiver;
import com.hungry.hotel.hungryhoteladmin.dashboard.OrderDashboardFragment;
import com.hungry.hotel.hungryhoteladmin.deliveryboy.DeliveryBoyFragment;
import com.hungry.hotel.hungryhoteladmin.home.listener.DrawerLocker;
import com.hungry.hotel.hungryhoteladmin.login.LoginFragment;
import com.hungry.hotel.hungryhoteladmin.menudetails.AddUpdateMenuFragment;
import com.hungry.hotel.hungryhoteladmin.orderdetail.OrderDetailsFragment;
import com.hungry.hotel.hungryhoteladmin.orders.OrderFragment;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.RestaurantMenuFragment;
import com.hungry.hotel.hungryhoteladmin.utils.InternetConnectivityUtils;
import com.hungry.hotel.hungryhoteladmin.utils.OnFragmentInteractionListener;

import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, DrawerLocker, OnFragmentInteractionListener {
    ConnectivityReceiver connectivityReceiver;
    DrawerLayout drawer;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setupFirebase();
        connectivityReceiver = new ConnectivityReceiver();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        loadFragment(new LoginFragment(), "LOGIN", false, "LOGIN");
//        adding fragments

    }

    // Showing the status in Snackbar
    private void showSnack(boolean isConnected) {
        String message;
        int color;
        if (isConnected) {
            message = "Good! Connected to Internet";
            color = Color.WHITE;
        } else {
            message = "Sorry! Not connected to internet";
            color = Color.WHITE;
        }

        Snackbar snackbar = Snackbar
                .make(findViewById(R.id.fab), message, isConnected ? Snackbar.LENGTH_LONG : Snackbar.LENGTH_INDEFINITE);
        View snackBarView = snackbar.getView();
        if (isConnected) {
            snackBarView.setBackgroundColor(ContextCompat.getColor(this, R.color.darkGreen));
        } else {
            snackBarView.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
        }
        TextView textView = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(color);
        snackbar.show();
    }

    private void setupFirebase() {
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w("Fireabse Instance", "getInstanceId failed", task.getException());
                            return;
                        }

                        // Get new Instance ID token
                        String token = task.getResult().getToken();

                        // Log and toast
                        String msg = token;
                        Log.d("Firebase insance token", msg);
                        Toast.makeText(MainActivity2.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Fragment openedFragment = getSupportFragmentManager().findFragmentById(R.id.clHomePageContainer);
            if (openedFragment instanceof OrderDashboardFragment) {
                super.onBackPressed();
            } else if (openedFragment instanceof RestaurantMenuFragment) {
                loadFragment(new OrderDashboardFragment(), "ORDER_DASHBOARD", false, "ORDER_DASHBOARD");
            } else if (openedFragment instanceof OrderFragment) {
                loadFragment(new OrderDashboardFragment(), "ORDER_DASHBOARD", false, "ORDER_DASHBOARD");
            } else if (openedFragment instanceof DeliveryBoyFragment) {
                loadFragment(new OrderDashboardFragment(), "ORDER_DASHBOARD", false, "ORDER_DASHBOARD");
            } else if (openedFragment instanceof OrderDetailsFragment) {
                loadFragment(new OrderFragment(), "ORDERS", false, "ORDERS");
            } else if (openedFragment instanceof AddUpdateMenuFragment) {
                loadFragment(new RestaurantMenuFragment(), "RESTAURANT_MENU", false, "RESTAURANT_MENU");
            } else {
                super.onBackPressed();
            }
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

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
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

            loadFragment(new OrderFragment(), "ORDERS", false, "ORDERS");
        } else if (id == R.id.navMenus) {
            loadFragment(new RestaurantMenuFragment(), "RESTAURANT_MENU", false, "RESTAURANT_MENU");
        } else if (id == R.id.navReports) {
            loadFragment(new OrderDashboardFragment(), "ORDER_DASHBOARD", false, "ORDER_DASHBOARD");
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_deliveryBoy) {
            loadFragment(new DeliveryBoyFragment(), "DELIVERY_BOY", false, "DELIVERY_BOY");
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadFragment(Fragment fragment, String fragmentName, boolean needToBackStack, String fragmentTag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.clHomePageContainer, fragment, fragmentTag);
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


    @Override
    public void onFragmentInteraction(Fragment fragment) {
        if (fragment instanceof LoginFragment) {
        } else if (fragment instanceof OrderDashboardFragment) {
//            Menu nav_Menu = navigationView.getMenu();
//            nav_Menu.findItem(R.id.navMenus).setVisible(false);
        } else if (fragment instanceof DeliveryBoyFragment) {
           /* drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            // Remove hamburger
            toggle.setDrawerIndicatorEnabled(false);
            // Show back button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
        } else if (fragment instanceof RestaurantMenuFragment) {
        } else if (fragment instanceof OrderDetailsFragment) {
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(connectivityReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        InternetConnectivityUtils.setConnectivityListener(this::showSnack);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(connectivityReceiver);
    }
}
