package com.hungry.hotel.hungryhoteladmin.orders.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.home.MainActivity2;
import com.hungry.hotel.hungryhoteladmin.home.listener.DrawerLocker;
import com.hungry.hotel.hungryhoteladmin.orders.adapter.OrdersAdapter;
import com.hungry.hotel.hungryhoteladmin.orders.model.Customer;
import com.hungry.hotel.hungryhoteladmin.orders.model.DeliveryBoy;
import com.hungry.hotel.hungryhoteladmin.orders.model.Order;

import java.util.ArrayList;
import java.util.List;


public class OrderFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    String orderName;


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

        View orderView = inflater.inflate(R.layout.fragment_order, container, false);
        RecyclerView rvOrders = orderView.findViewById(R.id.rvOrders);
        List<Order> orderList = getOrders();

        OrdersAdapter ordersAdapter = new OrdersAdapter(orderList, new OrdersAdapter.OrderOpenListener() {
            @Override
            public void openOrder(Order order) {

                openOrderDetailFragment();
            }
        });
        setOrdersProperty(rvOrders);
        rvOrders.setAdapter(ordersAdapter);

        return orderView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((DrawerLocker) getActivity()).setDrawerLocked(false);
    }


    private void setOrdersProperty(RecyclerView rvOrders) {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvOrders.setLayoutManager(mLayoutManager);
        rvOrders.setItemAnimator(new DefaultItemAnimator());
    }

    private void openOrderDetailFragment() {

    }

    private List<Order> getOrders() {
        List<Order> orderList = new ArrayList<>();
        Order order = new Order();
        order.setOrderImage("");
        Customer customer = new Customer();
        customer.setCustomerName("Prasad Chawan");
        order.setCustomer(customer);
        DeliveryBoy deliveryBoy = new DeliveryBoy();
        deliveryBoy.setDeliveryBoyName("Delivery Boy");
        order.setDeliveryBoy(deliveryBoy);
        order.setOrderDate("26 Nov 2019 11:55AM");
        order.setDishCount(3);
        order.setNewOrder(true);
        order.setOrderRating(3.5f);
        order.setTotalPrice(300.00);
        orderList.add(order);
        orderList.add(order);
        orderList.add(order);

        return orderList;
    }

}
