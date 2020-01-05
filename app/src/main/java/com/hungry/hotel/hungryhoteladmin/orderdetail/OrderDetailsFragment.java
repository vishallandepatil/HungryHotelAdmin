package com.hungry.hotel.hungryhoteladmin.orderdetail;


import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.home.MainActivity2;
import com.hungry.hotel.hungryhoteladmin.login.model.User;
import com.hungry.hotel.hungryhoteladmin.orderdetail.adapter.DishesAdapter;
import com.hungry.hotel.hungryhoteladmin.orders.model.Order;
import com.hungry.hotel.hungryhoteladmin.utils.HungryAdminUtility;
import com.hungry.hotel.hungryhoteladmin.utils.OnFragmentInteractionListener;
import com.hungry.hotel.hungryhoteladmin.utils.SharedPreferenceHelper;

import java.util.zip.GZIPOutputStream;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderDetailsFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    private String ACCEPT_ORDER = "Accept Order";
    private String REJECT_ORDER = "Reject Order";
    private String READY_TO_DISPATCH = "Ready TO Dispatch";
    private String DISPATCH_ORDER = "Dispatch";
    private String TRACK_ORDER = "Track";

    private CircleImageView civCustomerImage;
    private TextView tvCustomerName, tvOrderDate, tvOrderStatus, tvDeliveryBoy, tvTotalPrice, tvTotalAmount, tvCommissionPercent,
            tvCommissionAmount, tvReceivableAmount, tvDeliveredToName, tvDeliveryAddress, tvDeliveryMobileNumber, tvDeliveryBoyName,
            tvOrderFeedback;
    private RatingBar rbOrderRating;
    private RecyclerView rvDishes;
    private EditText etDispatchCode;
    Button btnAcceptOrder, btnRejectOrder, btnTrackDispatch;
    LinearLayout llDeliveryBoy, llDeliveryDetails, llOrderFeedback, llOrderAction, llDeliveryBoyName;
    private Order order;
    boolean isDeliveryBoy;


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
        setupToolbar();
        String accountType = "";

        View orderDetailsView = inflater.inflate(R.layout.fragment_order_details, container, false);
        instantiateView(orderDetailsView);
        accountType = getAccountType();
        isDeliveryBoy = isDeliveryBoy(accountType);
//        boolean isOrderAccepted = false;


//        deliveryboy
        if (isDeliveryBoy) {
            llDeliveryBoy.setVisibility(View.GONE);
            btnTrackDispatch.setBackground(getActivity().getResources().getDrawable(R.drawable.ic_rounded_corner_gray));
            btnTrackDispatch.setText(TRACK_ORDER);
        }

        btnAcceptOrder.setOnClickListener(v -> {
            showOrderDialog(true);
        });
        btnRejectOrder.setOnClickListener(v -> {
            showOrderDialog(false);
        });

        btnTrackDispatch.setOnClickListener(v -> {
            if (btnTrackDispatch.getText().toString().equalsIgnoreCase(TRACK_ORDER)) {
                llOrderFeedback.setVisibility(View.VISIBLE);
                tvOrderFeedback.setVisibility(View.VISIBLE);
                tvOrderFeedback.setText("The food was tasty but quantity was less");

            } else if (btnTrackDispatch.getText().toString().equalsIgnoreCase(DISPATCH_ORDER)) {
                btnTrackDispatch.setBackground(getActivity().getResources().getDrawable(R.drawable.ic_rounded_corner_gray));
                btnTrackDispatch.setText(TRACK_ORDER);
                llDeliveryBoy.setVisibility(View.VISIBLE);
                etDispatchCode.setVisibility(View.GONE);
            } else if (btnTrackDispatch.getText().toString().equalsIgnoreCase(READY_TO_DISPATCH)) {
                llDeliveryBoy.setVisibility(View.VISIBLE);
                etDispatchCode.setVisibility(View.VISIBLE);
                tvDeliveryBoyName.setText("Gagan");
                btnTrackDispatch.setText(DISPATCH_ORDER);
                Toast.makeText(getActivity(), "Order ready for dispatch", Toast.LENGTH_SHORT).show();
                btnTrackDispatch.setBackground(getActivity().getResources().getDrawable(R.drawable.ic_rounded_corner_green));
            }
        });
//        showOrderDialog(isOrderAccepted);

//        hotel
//  /      //recyclerview setting
        setValues();


        return orderDetailsView;
    }

    private void showOrderDialog(boolean isOrderAccepted) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        if (isOrderAccepted) {
            builder.setTitle("Accept");
            builder.setMessage("Are you sure you want to accept the order?");

        } else {
            builder.setTitle("Reject");
            builder.setMessage("Are you sure you want to reject the order?");
        }
        builder.setPositiveButton("Yes", (dialog, which) -> {
            if (isOrderAccepted) {
                btnTrackDispatch.setVisibility(View.VISIBLE);
                if (isDeliveryBoy) {
                    btnTrackDispatch.setBackground(getActivity().getResources().getDrawable(R.drawable.ic_rounded_corner_gray));
                    btnTrackDispatch.setText(TRACK_ORDER);
                } else {
                    btnTrackDispatch.setBackground(getActivity().getResources().getDrawable(R.drawable.ic_rounded_corner_green));
                    btnTrackDispatch.setText(READY_TO_DISPATCH);
                }
                btnAcceptOrder.setVisibility(View.GONE);
                btnRejectOrder.setVisibility(View.GONE);

                Toast.makeText(getActivity(), "Order Accepted successfuly", Toast.LENGTH_SHORT).show();

            } else {
                btnAcceptOrder.setVisibility(View.VISIBLE);
                btnRejectOrder.setVisibility(View.VISIBLE);
                btnTrackDispatch.setVisibility(View.GONE);
                Toast.makeText(getActivity(), "Order Cancelled successfuly", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("No", ((dialog, which) -> {
            dialog.dismiss();
        }));

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private boolean isDeliveryBoy(String accountType) {
        return accountType.equalsIgnoreCase(User.DELIVERY_BOY);
    }

    private String getAccountType() {
        SharedPreferences sharedPreferences = SharedPreferenceHelper.getSharedPreferenceInstance(getActivity(), "USER");
        String accType = sharedPreferences.getString(User.ACCOUNT_TYPE, User.ACCOUNT_TYPE);
        return accType;
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
            tvTotalPrice.setText("Rs. " + HungryAdminUtility.getFormattedPrice(order.getTotalPrice()));
            tvTotalAmount.setText("Rs. " + HungryAdminUtility.getFormattedPrice(order.getTotalPrice()));
            tvCommissionPercent.setText("Commission " + HungryAdminUtility.getFormattedPrice(order.getCommissionPercent()) + "%");
            tvCommissionAmount.setText("Rs. " + HungryAdminUtility.getFormattedPrice(order.getCommission()));
            tvReceivableAmount.setText("Rs. " + HungryAdminUtility.getFormattedPrice(order.getReceivableAmount()));
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
        llDeliveryBoy = orderDetailsView.findViewById(R.id.llDeliveryBoy);
        llDeliveryDetails = orderDetailsView.findViewById(R.id.llDeliveryDetails);
        llOrderFeedback = orderDetailsView.findViewById(R.id.llOrderFeedback);
        llOrderAction = orderDetailsView.findViewById(R.id.llOrderAction);
        llDeliveryBoyName = orderDetailsView.findViewById(R.id.llDeliveryBoyName);
        llOrderFeedback.setVisibility(View.GONE);
        btnTrackDispatch.setVisibility(View.GONE);
        llDeliveryBoy.setVisibility(View.GONE);

    }


    private void setDishListProperty(RecyclerView rvOrders) {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvOrders.setLayoutManager(mLayoutManager);
        rvOrders.setItemAnimator(new DefaultItemAnimator());
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

    private void setupToolbar() {
        Toolbar toolbar;
        ActionBar actionBar;
        ActionBarDrawerToggle toggle;
        DrawerLayout drawer;
        toolbar = ((MainActivity2) getActivity()).findViewById(R.id.toolbar);
        actionBar = ((MainActivity2) getActivity()).getSupportActionBar();
        drawer = ((MainActivity2) getActivity()).findViewById(R.id.drawer_layout);
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
        ((MainActivity2) getActivity()).setDrawerLocked(true);
        TextView tvToolbarTitle = toolbar.findViewById(R.id.tvToolbarTitle);
        tvToolbarTitle.setText("Order Details");
        AppBarLayout.LayoutParams params =
                (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        params.setScrollFlags(0);
        toggle.syncState();
//        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
      /*  Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Delivery Boy");
        toolbar.setTitleTextColor(getActivity().getResources().getColor(R.color.black));

        AutoCompleteTextView actvSearchMenu = toolbar.findViewById(R.id.actvSearchMenu);
        ImageButton ibFilter = toolbar.findViewById(R.id.ibFilter);
        ImageButton ibSearch = toolbar.findViewById(R.id.ibSearch);
        actvSearchMenu.setVisibility(View.GONE);
        ibSearch.setVisibility(View.GONE);
        ibFilter.setVisibility(View.GONE);*/
        /*Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Delivery Boy");
        toolbar.setTitleTextColor(getActivity().getResources().getColor(R.color.black));
        AutoCompleteTextView actvSearchMenu = toolbar.findViewById(R.id.actvSearchMenu);
        ImageButton ibFilter = toolbar.findViewById(R.id.ibFilter);
        ImageButton ibSearch = toolbar.findViewById(R.id.ibSearch);
        actvSearchMenu.setVisibility(View.GONE);
        ibSearch.setVisibility(View.GONE);
        ibFilter.setVisibility(View.GONE);*/
    }

}
