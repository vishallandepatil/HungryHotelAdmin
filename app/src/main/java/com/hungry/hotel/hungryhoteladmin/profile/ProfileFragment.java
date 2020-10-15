package com.hungry.hotel.hungryhoteladmin.profile;

import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.net.IpSecAlgorithm;
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
import android.widget.ImageButton;
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
import com.hungry.hotel.hungryhoteladmin.menudetails.AddUpdateMenuFragment;
import com.hungry.hotel.hungryhoteladmin.menudetails.api.MenuDetailsApi;
import com.hungry.hotel.hungryhoteladmin.profile.api.IsActiveApi;
import com.hungry.hotel.hungryhoteladmin.profile.model.IsActiveResponse;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.RestaurantMenuFragment;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.adapter.RestaurantMenuAdapter;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.api.RestaurantMenuApi;
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

    Switch swIsActive;
    String isActive="NO";
    ProgressDialog progressDialog;
    RelativeLayout layout1, layout2;
    TextView txt_error;

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

        // Set a checked change listener for toggle button
        swIsActive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    isActive="YES";

                }
                else{

                    isActive="NO";
                }
            }
        });

        setIsActive("NO","1");

        return view;
    }


    private void instantiateView(View view) {

        swIsActive = view.findViewById(R.id.swIsActive);
        progressDialog=new ProgressDialog(getActivity());
        layout1 = view.findViewById(R.id.layout11);
        layout2 = view.findViewById(R.id.layout22);
        txt_error = view.findViewById(R.id.txt_error);


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

        ImageButton ibFilter = toolbar.findViewById(R.id.ibFilter);
        ibFilter.setVisibility(View.GONE);



    }


    void setIsActive(String IS_ACTIVE, String DL_BO_MA_ID)
    {
        if(Utilities.isNetworkAvailable(getActivity()))
        {
            IsActiveApi isActiveApi = RetrofitClientInstance.getRetrofitInstanceServer().
                    create(IsActiveApi.class);

            progressDialog.setMessage("Please Wait...");
            progressDialog.setCancelable(false);
            progressDialog.show();
            isActiveApi.updateIsactive(RetrofitClientInstance.API_KEY, IS_ACTIVE,DL_BO_MA_ID).
                    enqueue(new Callback<IsActiveResponse>() {

                        @Override
                        public void onResponse(Call<IsActiveResponse> call, Response<IsActiveResponse> response) {

                            IsActiveResponse isActiveResponse = response.body();
                            if (isActiveResponse.getStatus() == 200) {
                                Log.e("onResponseckhk: ", isActiveResponse.getResult().toString());

                                progressDialog.dismiss();
                            } else {
                                Utilities.setError(layout1, layout2, txt_error, isActiveResponse.getMessage());

                            }

                        }


                        @Override
                        public void onFailure(Call<IsActiveResponse> call, Throwable t) {

                            progressDialog.dismiss();
                            Utilities.setError(layout1,layout2,txt_error,getResources().getString(R.string.something_went_wrong));
                            Log.d("errorchk",t.getMessage());

                        }
                    });
        }

        else {
            Utilities.setError(layout1,layout2,txt_error,getResources().getString(R.string.check_internet));


        }

    }
}
