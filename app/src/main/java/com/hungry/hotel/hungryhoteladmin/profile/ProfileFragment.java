package com.hungry.hotel.hungryhoteladmin.profile;

import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.textfield.TextInputLayout;
import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.home.HomeActivity;
import com.hungry.hotel.hungryhoteladmin.menudetails.api.MenuDetailsApi;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.RestaurantMenuFragment;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.Dish;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.DishResponse;
import com.hungry.hotel.hungryhoteladmin.retrofit.RetrofitClientInstance;
import com.hungry.hotel.hungryhoteladmin.utils.HungryAdminUtility;
import com.hungry.hotel.hungryhoteladmin.utils.OnFragmentInteractionListener;
import com.hungry.hotel.hungryhoteladmin.utils.PrefManager;
import com.hungry.hotel.hungryhoteladmin.utils.Utilities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public ProfileFragment() {
        // Required empty public constructor
    }


    public static ProfileFragment newInstance(Dish dish) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putParcelable("DISH", dish);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        setupToolbar();
        instantiateView(view);

        return view;
    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(this);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void instantiateView(View view) {

       // spDishType = view.findViewById(R.id.spDishType);

    }

    private void setupToolbar() {
        Toolbar toolbar;
        ActionBar actionBar;
        ActionBarDrawerToggle toggle;
        DrawerLayout drawer;
        toolbar = ((HomeActivity) getActivity()).findViewById(R.id.toolbar);
        actionBar = ((HomeActivity) getActivity()).getSupportActionBar();
        drawer = ((HomeActivity) getActivity()).findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(false);
        // Show back button
        actionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        ((HomeActivity) getActivity()).setDrawerLocked(true);
        TextView tvToolbarTitle = toolbar.findViewById(R.id.tvToolbarTitle);

            tvToolbarTitle.setText("Profile");

        AppBarLayout.LayoutParams params =
                (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        params.setScrollFlags(0);
        toggle.syncState();

    }


    public  void openEditMenuFragment() {
        RestaurantMenuFragment fragment;
        fragment = new RestaurantMenuFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.clHomePageContainer, fragment);
        fragmentTransaction.addToBackStack("ADD_UPDATE_MENU");
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }
}
