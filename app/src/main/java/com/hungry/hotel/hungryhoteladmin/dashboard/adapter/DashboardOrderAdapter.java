package com.hungry.hotel.hungryhoteladmin.dashboard.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.dashboard.model.Dashboard;
import com.hungry.hotel.hungryhoteladmin.utils.HungryAdminUtility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DashboardOrderAdapter extends RecyclerView.Adapter<DashboardOrderAdapter.DashboardViewHolder> {
    List<Dashboard> orderDashboardList;
    OrderClickListener orderClickListener;
    Activity context;

    public List<Dashboard> getOrderDashboardList() {
        return orderDashboardList;
    }

    public void setOrderDashboardList(List<Dashboard> orderDashboardList) {
        this.orderDashboardList = orderDashboardList;
    }

    public DashboardOrderAdapter(Activity context, OrderClickListener orderClickListener) {
        this.orderClickListener = orderClickListener;
        this.context = context;
    }
    public DashboardOrderAdapter(List<Dashboard> orderDashboardList, OrderClickListener orderClickListener) {
            this.orderDashboardList = orderDashboardList;
            this.orderClickListener = orderClickListener;

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
        final Dashboard orderDashboard = orderDashboardList.get(position);
      //10-10  setBackground(holder, orderDashboard);

        Random r = new Random();
        int red=r.nextInt(255 - 0 + 1)+0;
        int green=r.nextInt(255 - 0 + 1)+0;
        int blue=r.nextInt(255 - 0 + 1)+0;

       /* GradientDrawable draw = new GradientDrawable();
        draw.setShape(GradientDrawable.OVAL);
        draw.setColor(Color.rgb(red,green,blue));
*/
       // holder.itemView.setBackgroundColor(Color.rgb(red,green,blue));
        holder.tvOrderPrice.setText(orderDashboard.getSTATUS());
        holder.tvTotalOrders.setText(String.valueOf(orderDashboard.getTotal()));
        holder.tvOrderName.setText(orderDashboard.getTitle());
       // holder.tvOrderPrice.setText(String.valueOf(HungryAdminUtility.getFormattedPrice(Double.parseDouble(orderDashboard.getTotal()))));
       /* 10-10 if (orderDashboard.isNew()) {
            holder.tvNewOrder.setVisibility(View.VISIBLE);
            holder.tvNewOrder.setText("NEW");
        } else {
            holder.tvNewOrder.setVisibility(View.GONE);
        }*/
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderClickListener.orderOpen(orderDashboard);
            }
        });

       /* final DisplayMetrics displayMetrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = (int) (displayMetrics.widthPixels - HungryAdminUtility.getDpFfromPixel(60, context)) / 3;
//         int width = (int)(holder.itemView.getWidth());

        int height = (int) (width * 1.8);

        holder.itemView.setLayoutParams(new LinearLayout.LayoutParams(width, height));*/


        if (position % 3 == 0) {
            holder.itemView.setBackgroundResource(R.color.totalOrder);
        } else if (position % 3 == 1) {
            holder.itemView.setBackgroundResource(R.color.delivered);
        } else if (position % 3 == 2) {
            holder.itemView.setBackgroundResource(R.color.accepted);
        }else if (position % 3 == 3) {
            holder.itemView.setBackgroundResource(R.color.ready);
        }else if (position % 3 == 4) {
            holder.itemView.setBackgroundResource(R.color.lightGray);
        }else if (position % 3 == 5) {
            holder.itemView.setBackgroundResource(R.color.darkGreen);
        }
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
        void orderOpen(Dashboard order);
    }

   /* private void setBackground(DashboardViewHolder holder, Dashboard orderDashboard) {
        if (orderDashboard.getTitle().equalsIgnoreCase(Dashboard.TOTAL_ORDER)) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.totalOrder));

        }
        if (orderDashboard.getTitle().equalsIgnoreCase(Dashboard.NEW_ORDER)) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.darkGreen));

        }
        if (orderDashboard.getTitle().equalsIgnoreCase(Dashboard.ACCEPTED_ORDER)) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.accepted));

        }
        if (orderDashboard.getTitle().equalsIgnoreCase(Dashboard.READY_ORDER)) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.ready));
        }
        if (orderDashboard.getTitle().equalsIgnoreCase(Dashboard.REJECTED_ORDER)) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.lightGray));

        }
        if (orderDashboard.getTitle().equalsIgnoreCase(Dashboard.DELIVERED_ORDER)) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.delivered));

        }
    }*/
}
