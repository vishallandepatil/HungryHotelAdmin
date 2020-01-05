package com.hungry.hotel.hungryhoteladmin.orders;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.home.MainActivity2;
import com.hungry.hotel.hungryhoteladmin.orderdetail.OrderDetailsFragment;
import com.hungry.hotel.hungryhoteladmin.orders.adapter.OrdersAdapter;
import com.hungry.hotel.hungryhoteladmin.orders.viewmodel.OrdersViewModel;
import com.hungry.hotel.hungryhoteladmin.orders.model.Order;
import com.hungry.hotel.hungryhoteladmin.utils.OnFragmentInteractionListener;

import java.util.List;


public class OrderFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    String orderName;
    private OnFragmentInteractionListener mListener;
    FloatingActionButton fab;
    Toolbar toolbar;
    ActionBar actionBar;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;

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
        // Inflate the layout for this fragment
//        ((DrawerLocker) getActivity()).setDrawerLocked(true);
        setupToolbar();
        View orderView = inflater.inflate(R.layout.fragment_order, container, false);
        RecyclerView rvOrders = orderView.findViewById(R.id.rvOrders);
        OrdersViewModel ordersViewModel = ViewModelProviders.of(getActivity()).get(OrdersViewModel.class);


        OrdersAdapter ordersAdapter
                = new OrdersAdapter(new OrdersAdapter.OrderOpenListener() {
            @Override
            public void openOrder(Order order) {

                openOrderDetailFragment(order);
            }
        });
        ordersViewModel.getOrderListObserver().observe(getActivity(), new Observer<List<Order>>() {
            @Override
            public void onChanged(List<Order> orders) {
                if (orders != null && orders.size() > 0) {
                    ordersAdapter.setOrderList(orders);
                }
            }
        });
        setOrdersProperty(rvOrders);
        rvOrders.setAdapter(ordersAdapter);

        return orderView;
    }

    private void setupToolbar() {
        fab = ((MainActivity2) getActivity()).findViewById(R.id.fab);
        toolbar = ((MainActivity2) getActivity()).findViewById(R.id.toolbar);
        actionBar = ((MainActivity2) getActivity()).getSupportActionBar();
        drawer = ((MainActivity2) getActivity()).findViewById(R.id.drawer_layout);
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
        ((MainActivity2) getActivity()).setDrawerLocked(true);
        TextView tvToolbarTitle = toolbar.findViewById(R.id.tvToolbarTitle);
        tvToolbarTitle.setText("Orders");
        AppBarLayout.LayoutParams params =
                (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
                | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
        toggle.syncState();
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
}
