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
    ArrayList<String> list;

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

        colorset();
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
        if (position  == 0) {
            holder.itemView.setBackgroundResource(R.color.totalOrder);
        } else if (position  == 1) {
            holder.itemView.setBackgroundResource(R.color.delivered);
        }else if (position  == 2) {
            holder.itemView.setBackgroundResource(R.color.darkGray);
        } else if (position  == 3) {
            holder.itemView.setBackgroundResource(R.color.accepted);
        }else if (position  == 4) {
            holder.itemView.setBackgroundResource(R.color.ready);
        }else if (position  == 5) {
            holder.itemView.setBackgroundResource(R.color.lightGray);
        }else if (position  == 6) {
            holder.itemView.setBackgroundResource(R.color.darkGreen);
        }else if (position  == 7) {
            holder.itemView.setBackgroundResource(R.color.colorAccent);
        }else if (position  == 8) {
            holder.itemView.setBackgroundResource(R.color.colorPrimary);
        }else if (position  == 9) {
            holder.itemView.setBackgroundResource(R.color.accepted);
        }else if (position  == 10) {
            holder.itemView.setBackgroundResource(R.color.darkGreen);
        }

        /*for (int i=0; i<list.size(); i++)
        {
            if(position==i)
            {
                Log.e( "onBindViewHolder: ", list.get(i));
                //  holder.itemView.setBackgroundColor(Integer.parseInt(list.get(i)));

            }
        }*/
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
     }
    }

    public interface OrderClickListener {
        void orderOpen(Dashboard order);
    }


    public void  colorset() {
        list = new ArrayList<String>();
        list.add("#9c27b0");
        list.add("#673ab7");
        list.add("#009688");
        list.add("#3f51b5");
        list.add("#a4a4a4");
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
