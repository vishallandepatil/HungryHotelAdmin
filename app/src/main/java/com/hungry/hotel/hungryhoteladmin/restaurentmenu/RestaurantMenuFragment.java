package com.hungry.hotel.hungryhoteladmin.restaurentmenu;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.home.HomeActivity;
import com.hungry.hotel.hungryhoteladmin.menudetails.AddUpdateMenuFragment;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.adapter.RestaurantMenuAdapter;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.api.RestaurantMenuApi;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.dialogs.FilterDialog;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.Dish;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.DishResponse;
import com.hungry.hotel.hungryhoteladmin.retrofit.RetrofitClientInstance;
import com.hungry.hotel.hungryhoteladmin.utils.OnFragmentInteractionListener;
import com.hungry.hotel.hungryhoteladmin.utils.PrefManager;
import com.hungry.hotel.hungryhoteladmin.utils.Utilities;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RestaurantMenuFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    Toolbar toolbar;
    ActionBar actionBar;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    RecyclerView rvMenu;
    FloatingActionButton fabAddNewMenu;
    ProgressDialog progressDialog;
    PrefManager prefManager;
    RelativeLayout layout1, layout2;
    TextView txt_error;
    public RestaurantMenuFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static RestaurantMenuFragment newInstance(String param1, String param2) {
        RestaurantMenuFragment fragment = new RestaurantMenuFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View dishMenu = inflater.inflate(R.layout.fragment_restaurent_menu, container, false);
        setupToolbar();
        instantiateView(dishMenu);
        fabAddNewMenu.setOnClickListener(view -> {
            openEditMenuFragment(null);
        });
            setList();

       return dishMenu;
    }

    private void instantiateView(View dishMenu) {
        rvMenu = dishMenu.findViewById(R.id.rvMenu);
        fabAddNewMenu = dishMenu.findViewById(R.id.fabAddNewMenu);
        layout1 = dishMenu.findViewById(R.id.layout1);
        layout2 = dishMenu.findViewById(R.id.layout2);
        txt_error = dishMenu.findViewById(R.id.txt_error);
        progressDialog=new ProgressDialog(getActivity());
        prefManager=new PrefManager(getActivity());
    }

    private void setupToolbar() {
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
        tvToolbarTitle.setText("Menus");

        AppBarLayout.LayoutParams params =
                (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
                | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
        toggle.syncState();

        tvToolbarTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FilterDialog filterDialog=new FilterDialog(getActivity());
                filterDialog.show();
                filterDialog.setCancelable(false);

            }
        });
    }



    private void setRecyclerViewProperty(RecyclerView recyclerView) {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void showMenuFilter() {
        String[] listItems = {"Less price ", "Max price ", "Rating", "Veg only", "Non_veg only"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Choose item");

        int checkedItem = 0; //this will checked the item when user open the dialog
        builder.setSingleChoiceItems(listItems, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), "Position: " + which + " Value: " + listItems[which], Toast.LENGTH_LONG).show();
            }
        });

        builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

     public  void openEditMenuFragment(Dish dish) {
        AddUpdateMenuFragment fragment;
        if (dish != null) {
            fragment = AddUpdateMenuFragment.newInstance(dish);
        } else {
            fragment = new AddUpdateMenuFragment();
        }
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.clHomePageContainer, fragment);
        fragmentTransaction.addToBackStack("ADD_UPDATE_MENU");
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
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

    void setList()
    {
        if(Utilities.isNetworkAvailable(getActivity()))
        {
            RestaurantMenuApi restaurantMenuApi = RetrofitClientInstance.getRetrofitInstanceServer().
                    create(RestaurantMenuApi.class);

            progressDialog.setMessage("Please Wait...");
            progressDialog.setCancelable(false);
            progressDialog.show();
            restaurantMenuApi.getMenus(RetrofitClientInstance.API_KEY, null,null,prefManager.getUSERID()).
                    enqueue(new Callback<DishResponse>() {

                        @Override
                        public void onResponse(Call<DishResponse> call, Response<DishResponse> response) {

                            DishResponse dishResponse = response.body();
                            if(dishResponse.getStatus()==200)
                            {
                                Log.e("onResponseckhk: ", dishResponse.getResult().toString());
                                RestaurantMenuAdapter menuAdapter = new RestaurantMenuAdapter(getActivity(), dishResponse.getResult(),
                                        rvMenu, this::openEditMenuFragment);
                                setRecyclerViewProperty(rvMenu);
                                rvMenu.setAdapter(menuAdapter);
                                progressDialog.dismiss();
                            }
                            else {
                                Utilities.setError(layout1,layout2,txt_error,dishResponse.getMessage());

                            }

                        }
                        private void openEditMenuFragment(Dish dish) {

                            AddUpdateMenuFragment fragment;
                            if (dish != null) {
                                fragment = AddUpdateMenuFragment.newInstance(dish);
                            } else {
                                fragment = new AddUpdateMenuFragment();
                            }
                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.clHomePageContainer, fragment);
                            fragmentTransaction.addToBackStack("ADD_UPDATE_MENU");
                            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                            fragmentTransaction.commit();
                        }

                        @Override
                        public void onFailure(Call<DishResponse> call, Throwable t) {

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
