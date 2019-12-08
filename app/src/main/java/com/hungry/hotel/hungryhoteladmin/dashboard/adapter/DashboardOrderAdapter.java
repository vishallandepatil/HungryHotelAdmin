package com.hungry.hotel.hungryhoteladmin.dashboard.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.dashboard.model.OrderDashboard;

import java.util.List;

public class DashboardOrderAdapter extends RecyclerView.Adapter<DashboardOrderAdapter.DashboardViewHolder> {
    List<OrderDashboard> orderDashboardList;
    OrderClickListener orderClickListener;

    public DashboardOrderAdapter(List<OrderDashboard> orderDashboardList, OrderClickListener orderClickListener) {
        this.orderDashboardList = orderDashboardList;
        this.orderClickListener = orderClickListener;
    }

    @NonNull
    @Override
    public DashboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dashboard_order, parent, false);

        return new DashboardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardViewHolder holder, int position) {
        final OrderDashboard orderDashboard = orderDashboardList.get(position);
        holder.tvTotalOrders.setText(String.valueOf(orderDashboard.getTotalOrder()));
        holder.rlDashboardOrderItem.setBackgroundColor(orderDashboard.getBackgroundColor());
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


        }
    }

    public interface OrderClickListener {
        void orderOpen(OrderDashboard order);
    }
}
