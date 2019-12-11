package com.hungry.hotel.hungryhoteladmin.dashboard.adapter;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.dashboard.model.OrderDashboard;
import com.hungry.hotel.hungryhoteladmin.orders.model.Order;
import com.hungry.hotel.hungryhoteladmin.utils.HungryAdminUtility;

import java.util.List;

public class DashboardOrderAdapter extends RecyclerView.Adapter<DashboardOrderAdapter.DashboardViewHolder> {
    List<OrderDashboard> orderDashboardList;
    OrderClickListener orderClickListener;
    Activity context;

    public DashboardOrderAdapter(Activity context, List<OrderDashboard> orderDashboardList, OrderClickListener orderClickListener) {
        this.orderDashboardList = orderDashboardList;
        this.orderClickListener = orderClickListener;
        this.context = context;
    }

    @NonNull
    @Override
    public DashboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dashboard_order, parent, false);
        itemView.setMinimumHeight(itemView.getWidth());
        return new DashboardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardViewHolder holder, int position) {
        final OrderDashboard orderDashboard = orderDashboardList.get(position);
        setBackground(holder, orderDashboard);
//        holder.itemView.setBackgroundColor(orderDashboard.getBackgroundColor());
        holder.tvTotalOrders.setText(String.valueOf(orderDashboard.getTotalOrder()));
        holder.tvOrderName.setText(orderDashboard.getOrderName());
        holder.tvOrderPrice.setText(String.valueOf(orderDashboard.getOrderPrice()));
        if (orderDashboard.isNew()) {
            holder.tvNewOrder.setVisibility(View.VISIBLE);
            holder.tvNewOrder.setText("NEW");
        } else {
            holder.tvNewOrder.setVisibility(View.GONE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderClickListener.orderOpen(orderDashboard);
            }
        });

//        final DisplayMetrics displayMetrics = new DisplayMetrics();
//        context.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//        int width = (int) (displayMetrics.widthPixels - HungryAdminUtility.getDpFfromPixel(60, context)) / 1;
//        // int width = (int)(holder1.itemview.getWidth());
//
//        int height = (int) (width * 1.8);
//
//        holder.itemView.setLayoutParams(new CardView.LayoutParams(width, height));


    }


    @Override
    public int getItemCount() {
        return orderDashboardList.size();
    }

    public class DashboardViewHolder extends RecyclerView.ViewHolder {
        TextView tvTotalOrders, tvNewOrder, tvOrderName, tvOrderPrice;
        CardView rlDashboardOrderItem;

        public DashboardViewHolder(@NonNull View itemView) {
            super(itemView);

            rlDashboardOrderItem = itemView.findViewById(R.id.rlDashboardOrderItem);
            tvTotalOrders = itemView.findViewById(R.id.tvTotalOrder);
            tvNewOrder = itemView.findViewById(R.id.tvNewOrder);
            tvOrderName = itemView.findViewById(R.id.tvOrderName);
            tvOrderPrice = itemView.findViewById(R.id.tvOrderPrice);
//            int width = rlDashboardOrderItem.getWidth();
//            rlDashboardOrderItem.setMinimumHeight(width);
//            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
//            int dpWidth = displayMetrics.widthPixels;
//            int height = dpWidth;
//
//            itemView.setLayoutParams(new CardView.LayoutParams(new ViewGroup.LayoutParams(dpWidth, height)));


        }
    }

    public interface OrderClickListener {
        void orderOpen(OrderDashboard order);
    }

    private void setBackground(DashboardViewHolder holder, OrderDashboard orderDashboard) {
        if (orderDashboard.getOrderName().equalsIgnoreCase(OrderDashboard.TOTAL_ORDER)) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.totalOrder));

        }
        if (orderDashboard.getOrderName().equalsIgnoreCase(OrderDashboard.NEW_ORDER)) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.darkGreen));

        }
        if (orderDashboard.getOrderName().equalsIgnoreCase(OrderDashboard.ACCEPTED_ORDER)) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.accepted));

        }
        if (orderDashboard.getOrderName().equalsIgnoreCase(OrderDashboard.READY_ORDER)) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.ready));
        }
        if (orderDashboard.getOrderName().equalsIgnoreCase(OrderDashboard.REJECTED_ORDER)) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.lightGray));

        }
        if (orderDashboard.getOrderName().equalsIgnoreCase(OrderDashboard.DELIVERED_ORDER)) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.delivered));

        }
    }
}
