package com.hungry.hotel.hungryhoteladmin.orders.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.dashboard.adapter.DashboardOrderAdapter;
import com.hungry.hotel.hungryhoteladmin.dashboard.model.Dashboard;
import com.hungry.hotel.hungryhoteladmin.orders.model.Order;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import de.hdodenhof.circleimageview.CircleImageView;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.OrderViewHolder> {
    List<Order> orderList;
    OrderOpenListener orderOpenListener;
    OrderClickListener orderClickListener;


    public OrdersAdapter(OrderOpenListener orderOpenListener) {
        this.orderOpenListener = orderOpenListener;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }



    public OrdersAdapter(List<Order> orderdList, OrderClickListener orderClickListener) {
        this.orderList = orderdList;
        this.orderClickListener = orderClickListener;

    }

    public interface OrderClickListener {
        void orderOpen(Order order);
    }
    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View orderView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_order_item, parent, false);
        return new OrderViewHolder(orderView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        final Order order = orderList.get(position);
        if (order != null) {
            Glide.with(holder.civOrderImage.getContext())
                    .load(R.drawable.food)
                    .centerCrop()
                    .placeholder(R.drawable.ic_user)
                    .into(holder.civOrderImage);
            holder.tvCustomerName.setText(order.getCM_FIRST_NAME()+ " "+ order.getCM_LAST_NAME());
          //  holder.tvOrderDate.setText(order.getEX_DILIVERY_TIME());
            holder.tvDeliveryBoy.setText(order.getFNAME()+" "+order.getLNAME());


            holder.tvDishCount.setText(order.getItems().size() + " Items");
           /* 10-10 if (order.isNewOrder()) {
                holder.tvOrderStatus.setText("New");
            }*/
            holder.rbOrderRating.setRating(Float.parseFloat(order.getRATING()));
            Log.e( "onBindViewHolder: ",order.getRATING() );
            holder.tvOrderStatus.setText(order.getOR_STATUS());

            setRS(Integer.parseInt(order.getTOTAL()), holder.tvTotalPrice);
           // holder.tvTotalPrice.setText("Rs. " + order.getTOTAL());
          //  settime(orderList.getSTART_TIME(), dish.getEND_TIME(), holder.tvOrderDate  );
           // settime(order.getEX_DILIVERY_TIME(), holder.tvOrderDate);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    orderClickListener.orderOpen(order);
                }
            });
        }

        setDateFormat(holder.tvOrderDate, order.getEX_DILIVERY_TIME());


    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public interface OrderOpenListener {
        void openOrder(Order order);
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {
        LinearLayout llOrder;
        CircleImageView civOrderImage;
        TextView tvCustomerName, tvOrderDate, tvDeliveryBoy, tvDishCount, tvOrderStatus, tvTotalPrice;
        RatingBar rbOrderRating;


        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            civOrderImage = itemView.findViewById(R.id.civOrderImage);
            tvCustomerName = itemView.findViewById(R.id.tvCustomerName);
            tvOrderDate = itemView.findViewById(R.id.tvOrderDate);
            tvDeliveryBoy = itemView.findViewById(R.id.tvDeliveryBoy);
            tvDishCount = itemView.findViewById(R.id.tvDishCount);
            tvOrderStatus = itemView.findViewById(R.id.tvOrderStatus);
            tvTotalPrice = itemView.findViewById(R.id.tvTotalPrice);
            rbOrderRating = itemView.findViewById(R.id.rbOrderRating);
        }
    }

    void setRS(int RS, TextView txtrs)
    {

        DecimalFormat formatter = new DecimalFormat("#,###,###");
        String yourFormattedString = formatter.format(RS);
        txtrs.setText("Rs. "+yourFormattedString);

    }

    public static void setDateFormat(TextView view, String date) {
        DateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yy hh:mma");

        try {
            Date date1= inputDateFormat.parse(date);
            view.setText( dateFormat.format(date1));
        } catch (ParseException e) {
            e.printStackTrace();
            view.setText("Invalid Date Format");
        }
    }


}
