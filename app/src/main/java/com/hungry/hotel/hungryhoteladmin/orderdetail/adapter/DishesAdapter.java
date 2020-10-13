package com.hungry.hotel.hungryhoteladmin.orderdetail.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.orders.model.Items;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.Dish;
import com.hungry.hotel.hungryhoteladmin.utils.HungryAdminUtility;

import java.util.Collections;
import java.util.List;

public class DishesAdapter extends RecyclerView.Adapter<DishesAdapter.DishHolder> {

    List<Items> dishList;

    public DishesAdapter(List<Items> dishList) {
        this.dishList = dishList;
    }

    @NonNull
    @Override
    public DishHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View dishView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_dish_item, parent, false);
        return new DishHolder(dishView);
    }

    @Override
    public void onBindViewHolder(@NonNull DishHolder holder, int position) {
        Items dish = dishList.get(position);
        holder.tvDishName.setText(dish.getNAME());
        holder.tvDishPrice.setText("Rs. " + HungryAdminUtility.getFormattedPrice(Double.parseDouble(dish.getNET_PRICE())));
    }

    @Override
    public int getItemCount() {
        return dishList.size();
    }

    public class DishHolder extends RecyclerView.ViewHolder {
        private TextView tvDishName, tvDishPrice;

        public DishHolder(@NonNull View itemView) {
            super(itemView);
            tvDishName = itemView.findViewById(R.id.tvDishName);
            tvDishPrice = itemView.findViewById(R.id.tvDishPrice);
        }
    }
}
