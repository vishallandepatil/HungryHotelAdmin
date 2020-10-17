package com.hungry.hotel.hungryhoteladmin.orders;


import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.dashboard.adapter.DashboardOrderAdapter;
import com.hungry.hotel.hungryhoteladmin.dashboard.model.Dashboard;
import com.hungry.hotel.hungryhoteladmin.home.HomeActivity;
import com.hungry.hotel.hungryhoteladmin.menudetails.AddUpdateMenuFragment;
import com.hungry.hotel.hungryhoteladmin.orderdetail.OrderDetailsFragment;
import com.hungry.hotel.hungryhoteladmin.orders.adapter.OrdersAdapter;
import com.hungry.hotel.hungryhoteladmin.orders.api.OrderApi;
import com.hungry.hotel.hungryhoteladmin.orders.model.Items;
import com.hungry.hotel.hungryhoteladmin.orders.model.OrderResponse;
import com.hungry.hotel.hungryhoteladmin.orders.viewmodel.OrdersViewModel;
import com.hungry.hotel.hungryhoteladmin.orders.model.Order;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.adapter.RestaurantMenuAdapter;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.api.RestaurantMenuApi;
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
import retrofit2.http.Query;


public class OrderFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    String orderName;
    private OnFragmentInteractionListener mListener;
    FloatingActionButton fab;
    Toolbar toolbar;
    ActionBar actionBar;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    ProgressDialog progressDialog;
    PrefManager prefManager;
    RecyclerView rvOrders;
    OrdersAdapter ordersAdapter;
    RelativeLayout layout1, layout2;
    TextView txt_error;

    String HOT_MS_ID,  OR_STATUS,  CM_MS_ID,  start,  limit,  DL_BO_MA_ID,
     DL_BOY_STATUS;

    public OrderFragment() {
        // Required empty public constructor
    }


    public static OrderFragment newInstance(String orderName) {
        OrderFragment fragment = new OrderFragment();
        Bundle args = new Bundle();
        args.putString("ORDER_NAME", orderName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.orderName = getArguments().getString("ORDER_NAME");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setupToolbar();
        View orderView = inflater.inflate(R.layout.fragment_order, container, false);
        instantiateView(orderView);

        if(prefManager.getROLEID()==1)
        {
            HOT_MS_ID= String.valueOf(prefManager.getUSERID());
            OR_STATUS=this.orderName;
            CM_MS_ID=null;
            start=null;
            limit=null;
            DL_BO_MA_ID=null;
            DL_BOY_STATUS=null;     }
        else {
            HOT_MS_ID=null;
            OR_STATUS=null;
            CM_MS_ID=null;
            start=null;
            limit=null;
            DL_BO_MA_ID= String.valueOf(prefManager.getUSERID());
            DL_BOY_STATUS=this.orderName;
        }
        setOrderList(HOT_MS_ID,OR_STATUS,CM_MS_ID,start,limit,DL_BO_MA_ID,DL_BOY_STATUS);
        return orderView;
    }

    private void instantiateView(View orderView) {

        layout1 = orderView.findViewById(R.id.layout1);
        layout2 = orderView.findViewById(R.id.layout2);
        txt_error = orderView.findViewById(R.id.txt_error);
        progressDialog=new ProgressDialog(getActivity());
        prefManager=new PrefManager(getActivity());
        rvOrders = orderView.findViewById(R.id.rvOrders);



    }
        private void setupToolbar() {
        fab = ((HomeActivity) getActivity()).findViewById(R.id.fab);
        toolbar = ((HomeActivity) getActivity()).findViewById(R.id.toolbar);
        actionBar = ((HomeActivity) getActivity()).getSupportActionBar();
        drawer = ((HomeActivity) getActivity()).findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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
       // tvToolbarTitle.setText("Orders");
        tvToolbarTitle.setText(this.orderName);
        AppBarLayout.LayoutParams params =
                (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
                | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
        toggle.syncState();

            ImageButton ibFilter = toolbar.findViewById(R.id.ibFilter);
            ibFilter.setVisibility(View.GONE);

        }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ((DrawerLocker) getActivity()).setDrawerLocked(false);
    }


    private void setOrdersProperty(RecyclerView rvOrders) {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvOrders.setLayoutManager(mLayoutManager);
        rvOrders.setItemAnimator(new DefaultItemAnimator());
    }

    private void openOrderDetailFragment(Order order) {
        OrderDetailsFragment fragment = OrderDetailsFragment.newInstance(order);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.clHomePageContainer, fragment);
        fragmentTransaction.addToBackStack("ORDER_DETAILS");
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

    void setOrderList(String HOT_MS_ID, String OR_STATUS, String CM_MS_ID, String start, String limit, String DL_BO_MA_ID,
                      String DL_BOY_STATUS)
    {
          if(Utilities.isNetworkAvailable(getActivity()))
        {
            OrderApi orderApi = RetrofitClientInstance.getRetrofitInstanceServer().
                    create(OrderApi.class);

            progressDialog.setMessage("Please Wait...");
            progressDialog.setCancelable(false);
            // pbLoading.setProgressStyle(R.id.abbreviationsBar);
            progressDialog.show();
            orderApi.getOrder(RetrofitClientInstance.API_KEY, HOT_MS_ID, OR_STATUS, CM_MS_ID, start, limit, DL_BO_MA_ID,
                    DL_BOY_STATUS).
                    enqueue(new Callback<OrderResponse>() {

                        @Override
                        public void onResponse(Call<OrderResponse> call, Response<OrderResponse> response) {
                            OrderResponse orderResponse = response.body();
                            Log.e("orderResponse: ", orderResponse.getResult().toString());

                            if(orderResponse.getStatus()==200)
                            {
                                bindOrder(orderResponse.getResult());

                            }
                            else {

                                Utilities.setError(layout1,layout2,txt_error,orderResponse.getMessage());

                            }
                            progressDialog.dismiss();
                        }

                        @Override
                        public void onFailure(Call<OrderResponse> call, Throwable t) {

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


    void bindOrder(final ArrayList<Order> levelwiseQuizArrayList)
    {
        Log.e( "seta: ", levelwiseQuizArrayList.toString() );
        setOrdersProperty(rvOrders);
        ordersAdapter = new OrdersAdapter( levelwiseQuizArrayList, new OrdersAdapter.OrderClickListener() {
            @Override
            public void orderOpen(Order order) {
                Toast.makeText(getActivity(), "Order clicked"+ order.getTOTAL(), Toast.LENGTH_LONG).show();
                OrderFragment orderFragment = OrderFragment.newInstance(order.getCM_FIRST_NAME());
                openOrderDetailFragment(order);
            }
        });
        rvOrders.setAdapter(ordersAdapter);
        ordersAdapter.notifyDataSetChanged();
    }
}
