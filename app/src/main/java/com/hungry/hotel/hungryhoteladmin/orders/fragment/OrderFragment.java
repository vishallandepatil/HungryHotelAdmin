package com.hungry.hotel.hungryhoteladmin.orders.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.orderdetail.OrderDetailsFragment;
import com.hungry.hotel.hungryhoteladmin.orders.adapter.OrdersAdapter;
import com.hungry.hotel.hungryhoteladmin.orders.model.Customer;
import com.hungry.hotel.hungryhoteladmin.orders.model.DeliveryBoy;
import com.hungry.hotel.hungryhoteladmin.orders.model.Dish;
import com.hungry.hotel.hungryhoteladmin.orders.model.Hotel;
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

                openOrderDetailFragment(order);
            }
        });
        setOrdersProperty(rvOrders);
        rvOrders.setAdapter(ordersAdapter);

        return orderView;
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

    private List<Order> getOrders() {
        List<Order> orderList = new ArrayList<>();

//        Customer
        Customer customer = new Customer();
        customer.setCustomerName("Prasad Chawan");
        customer.setCustomerMobileNumber("8888888888");
        customer.setCustomerAddress("Ghorpade peth swar gate Mominpura Pune 411042");
//DeliveryBoy
        DeliveryBoy deliveryBoy = new DeliveryBoy();
        deliveryBoy.setDeliveryBoyName("Delivery Boy");
        deliveryBoy.setDeliveryBoyMobile("9999999999");
//        Hotel
        Hotel hotel = new Hotel();
        hotel.setHotelName("Hotel Royal");
//        Dishes
        Dish dish = new Dish();
        dish.setDishName("Sev Bhaji");
        dish.setDishPrice(80.00);
        List<Dish> dishList = new ArrayList<>();
        dishList.add(dish);
        dishList.add(dish);
//        Order
        Order order = new Order();
        order.setHotel(hotel);
        order.setNewOrder(true);
        order.setOrderImage("");
        order.setOrderDate("26 Nov 2019 11:55AM");
        order.setCustomer(customer);
        order.setCustomer(customer);
        order.setDeliveryBoy(deliveryBoy);
        order.setDishCount(3);
        order.setOrderStatus("NEW");
        order.setTotalPrice(300.00);
        order.setCommissionPercent(20);
        order.setCommission(15.00);
        order.setReceivableAmount(200.00);
        order.setOrderRating(3.5f);
        order.setDeliveryAddress("Ghorpade peth swar gate Mominpura Pune 411042");
        orderList.add(order);
        orderList.add(order);
        orderList.add(order);
        order.setDishList(dishList);
        return orderList;
    }

}
