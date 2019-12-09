package com.hungry.hotel.hungryhoteladmin.orderdetail;


import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.orderdetail.adapter.DishesAdapter;
import com.hungry.hotel.hungryhoteladmin.orders.model.Order;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderDetailsFragment extends Fragment {
    private CircleImageView civCustomerImage;
    private TextView tvCustomerName, tvOrderDate, tvOrderStatus, tvDeliveryBoy, tvTotalPrice, tvTotalAmount, tvCommissionPercent,
            tvCommissionAmount, tvReceivableAmount, tvDeliveredToName, tvDeliveryAddress, tvDeliveryMobileNumber, tvDeliveryBoyName,
            tvOrderFeedback;
    private RatingBar rbOrderRating;
    private RecyclerView rvDishes;
    private EditText etDispatchCode;
    Button btnAcceptOrder, btnRejectOrder, btnTrackDispatch;
    private Order order;


    public OrderDetailsFragment() {
    }


    public static OrderDetailsFragment newInstance(Order order) {
        OrderDetailsFragment fragment = new OrderDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable("ORDER", order);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            order = args.getParcelable("ORDER");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View orderDetailsView = inflater.inflate(R.layout.fragment_order_details, container, false);
        instantiateView(orderDetailsView);
//  /      //recyclerview setting
        setValues();


        return orderDetailsView;
    }

    private void setValues() {
        if (order != null) {

            Glide.with(getActivity())
                    .load(R.drawable.food)
                    .centerCrop()
                    .placeholder(R.drawable.ic_user)
                    .into(civCustomerImage);
            tvCustomerName.setText(order.getCustomer().getCustomerName());
            tvOrderDate.setText(order.getOrderDate());
            tvOrderStatus.setText(order.getOrderStatus());
            rbOrderRating.setRating(order.getOrderRating());
            tvTotalPrice.setText("Rs. " + order.getTotalPrice());
            tvTotalAmount.setText("Rs. " + order.getTotalPrice());
            tvCommissionPercent.setText("Commission " + order.getCommissionPercent() + "%");
            tvCommissionAmount.setText("Rs. " + order.getCommission());
            tvReceivableAmount.setText("Rs. " + order.getReceivableAmount());
            tvDeliveredToName.setText(order.getCustomer().getCustomerName());
            tvDeliveryAddress.setText(order.getDeliveryAddress());
            tvDeliveryMobileNumber.setText(order.getCustomer().getCustomerMobileNumber());
            tvDeliveryBoyName.setText(order.getDeliveryBoy().getDeliveryBoyName());
            tvOrderFeedback.setText(order.getOrderFeedback());
            Log.i("dishes", order.getDishList().get(0).getDishName());
            DishesAdapter dishesAdapter = new DishesAdapter(order.getDishList());
            setDishListProperty(rvDishes);
            rvDishes.setAdapter(dishesAdapter);

        }
    }

    private void instantiateView(View orderDetailsView) {
        tvCustomerName = orderDetailsView.findViewById(R.id.tvCustomerName);
        tvOrderDate = orderDetailsView.findViewById(R.id.tvOrderDate);
        tvOrderStatus = orderDetailsView.findViewById(R.id.tvOrderStatus);
        tvDeliveryBoy = orderDetailsView.findViewById(R.id.tvDeliveryBoy);
        tvTotalPrice = orderDetailsView.findViewById(R.id.tvTotalPrice);
        tvTotalAmount = orderDetailsView.findViewById(R.id.tvTotalAmount);
        tvCommissionPercent = orderDetailsView.findViewById(R.id.tvCommissionPercent);
        tvCommissionAmount = orderDetailsView.findViewById(R.id.tvCommissionAmount);
        tvReceivableAmount = orderDetailsView.findViewById(R.id.tvReceivableAmount);
        tvDeliveredToName = orderDetailsView.findViewById(R.id.tvDeliveredToName);
        tvDeliveryAddress = orderDetailsView.findViewById(R.id.tvDeliveryAddress);
        tvDeliveryMobileNumber = orderDetailsView.findViewById(R.id.tvDeliveryMobileNumber);
        tvDeliveryBoyName = orderDetailsView.findViewById(R.id.tvDeliveryBoyName);
        tvOrderFeedback = orderDetailsView.findViewById(R.id.tvOrderFeedback);
        rbOrderRating = orderDetailsView.findViewById(R.id.rbOrderRating);
        rvDishes = orderDetailsView.findViewById(R.id.rvDishes);
        etDispatchCode = orderDetailsView.findViewById(R.id.etDispatchCode);
        btnAcceptOrder = orderDetailsView.findViewById(R.id.btnAcceptOrder);
        btnRejectOrder = orderDetailsView.findViewById(R.id.btnRejectOrder);
        btnTrackDispatch = orderDetailsView.findViewById(R.id.btnTrackDispatch);
        civCustomerImage = orderDetailsView.findViewById(R.id.civOrderImage);
        etDispatchCode = orderDetailsView.findViewById(R.id.etDispatchCode);
    }


    private void setDishListProperty(RecyclerView rvOrders) {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvOrders.setLayoutManager(mLayoutManager);
        rvOrders.setItemAnimator(new DefaultItemAnimator());
    }

}
