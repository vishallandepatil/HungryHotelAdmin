package com.hungry.hotel.hungryhoteladmin.utils;

import android.app.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hungry.hotel.hungryhoteladmin.R;

public class FragmentUtils {

    public static void showBackButton(boolean show, FloatingActionButton fab, Toolbar toolbar, ActionBar actionBar, DrawerLayout drawer, ActionBarDrawerToggle toggle, boolean mToolBarNavigationListenerIsRegistered, FragmentActivity activity) {

        if (show) {
            // Remove hamburger
            toggle.setDrawerIndicatorEnabled(false);
            // Show back button
            actionBar.setDisplayHomeAsUpEnabled(true);
            // when DrawerToggle is disabled i.e. setDrawerIndicatorEnabled(false), navigation icon
            // clicks are disabled i.e. the UP button will not work.
            // We need to add a listener, as in below, so DrawerToggle will forward
            // click events to this listener.
            if (!mToolBarNavigationListenerIsRegistered) {
                toggle.setToolbarNavigationClickListener(v -> activity.onBackPressed());
                mToolBarNavigationListenerIsRegistered = true;
            }

        } else {
            // Remove back button
            actionBar.setDisplayHomeAsUpEnabled(false);
            // Show hamburger
            toggle.setDrawerIndicatorEnabled(true);
            // Remove the/any drawer toggle listener
            toggle.setToolbarNavigationClickListener(null);
            mToolBarNavigationListenerIsRegistered = false;
        }
        toggle.syncState();
        // So, one may think "Hmm why not simplify to:
        // .....
        // getSupportActionBar().setDisplayHomeAsUpEnabled(enable);
        // mDrawer.setDrawerIndicatorEnabled(!enable);
        // ......
        // To re-iterate, the order in which you enable and disable views IS important #dontSimplify.
    }
}
