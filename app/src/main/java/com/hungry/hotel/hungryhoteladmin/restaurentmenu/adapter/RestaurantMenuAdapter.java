package com.hungry.hotel.hungryhoteladmin.restaurentmenu.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.listener.EditMenuListener;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.listener.LoadMoreListener;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.Dish;
import com.hungry.hotel.hungryhoteladmin.utils.HungryAdminUtility;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RestaurantMenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int VIEW_TYPE_NO_RECORD = 0;
    private final int VIEW_TYPE_LOADING = 1;
    private final int VIEW_TYPE_MENU_ITEM = 2;
    private List<Dish> dishList;
    private Activity activity;
    private LoadMoreListener loadMoreListener;
    private EditMenuListener editMenuListener;
    private boolean isMenuLoading;
    RecyclerView rvDishes;

    public RestaurantMenuAdapter(Activity activity, List<Dish> dishList, RecyclerView rvDishes, EditMenuListener editMenuListener) {
        this.dishList = dishList;
        this.activity = activity;
        this.rvDishes = rvDishes;
        this.editMenuListener = editMenuListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NO_RECORD:
                View noDishView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_no_dish, parent, false);
                return new NoRecordViewHolder(noDishView);
            case VIEW_TYPE_LOADING:
                View loadingView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_progress_bar_small, parent, false);
                return new MenuLoadingViewHolder(loadingView);
            case VIEW_TYPE_MENU_ITEM:
                View menuView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_menu_item, parent, false);
                return new MenuViewHolder(menuView);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof NoRecordViewHolder) {

        } else if (holder instanceof MenuLoadingViewHolder) {

        } else if (holder instanceof MenuViewHolder) {
            Dish dish = dishList.get(position);
            MenuViewHolder menuViewHolder = (MenuViewHolder) holder;
            Glide.with(menuViewHolder.civDIshImage.getContext())
                    .load(R.drawable.food)
                    .centerCrop()
                    .placeholder(R.drawable.ic_user)
                    .into(menuViewHolder.civDIshImage);
            menuViewHolder.tvDishName.setText(dish.getDishName());
            menuViewHolder.tvDishQuantity.setText(dish.getDishQuantity() + " items");
            menuViewHolder.tvDishPrice.setText("RS. " + HungryAdminUtility.getFormattedPrice(dish.getDishPrice()));
            menuViewHolder.tvDishTime.setText(dish.getDishStartTime() + " to " + dish.getDishEndTime());
            if (dish.isVeg()) {

            } else {

            }
//            edit icon ivEditMenu
            if (dish.isShown()) {
                menuViewHolder.tvDishShown.setText("visible");
                menuViewHolder.tvDishShown.setTextColor(ContextCompat.getColor(activity, R.color.darkGreen));
            } else {
                menuViewHolder.tvDishShown.setText("Hide");
                menuViewHolder.tvDishShown.setTextColor(ContextCompat.getColor(activity, R.color.red));

            }
            menuViewHolder.ivDishEdit.setOnClickListener((view) -> {
                editMenuListener.openEditMenu(dish);
            });

        }
    }


    @Override
    public int getItemCount() {
        return dishList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (dishList.get(position) != null && dishList.size() == 1 && dishList.get(0) == null) {
            return VIEW_TYPE_NO_RECORD;
        }
        return dishList.get(position) != null ? VIEW_TYPE_MENU_ITEM : VIEW_TYPE_LOADING;
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        CircleImageView civDIshImage;
        TextView tvDishName, tvDishQuantity, tvDishPrice, tvDishTime, tvDishShown;
        ImageView ivDishType, ivDishEdit;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            civDIshImage = itemView.findViewById(R.id.civDIshImage);
            tvDishName = itemView.findViewById(R.id.tvDishName);
            tvDishQuantity = itemView.findViewById(R.id.tvDishQuantity);
            tvDishPrice = itemView.findViewById(R.id.tvDishPrice);
            tvDishTime = itemView.findViewById(R.id.tvDishTime);
            tvDishShown = itemView.findViewById(R.id.tvDishShown);
            ivDishType = itemView.findViewById(R.id.ivDishType);
            ivDishEdit = itemView.findViewById(R.id.ivDishEdit);
        }
    }

    private class NoRecordViewHolder extends RecyclerView.ViewHolder {


        public NoRecordViewHolder(View view) {
            super(view);

        }
    }

    public class MenuLoadingViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar pbLoading;

        public MenuLoadingViewHolder(View v) {
            super(v);
            pbLoading = v.findViewById(R.id.pbLoading);
        }
    }
}
