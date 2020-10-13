package com.hungry.hotel.hungryhoteladmin.restaurentmenu.adapter;

import android.app.Activity;
import android.util.Log;
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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public RestaurantMenuAdapter(Activity activity, List<Dish> dishList, RecyclerView rvDishes) {
        this.dishList = dishList;
        this.activity = activity;
        this.rvDishes = rvDishes;
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
                   // .load(R.drawable.food)
                    .load(dish.getPath())
                    .centerCrop()
                    .placeholder(R.drawable.ic_user)
                    .into(menuViewHolder.civDIshImage);
            menuViewHolder.tvDishName.setText(dish.getNAME());
            menuViewHolder.tvDishQuantity.setText(dish.getQUNTITY() + " items");
            menuViewHolder.tvDishPrice.setText("RS. " + HungryAdminUtility.getFormattedPrice(Double.parseDouble(dish.getAMOUNT())));
           // menuViewHolder.tvDishTime.setText(dish.getSTART_TIME() + " to " + dish.getEND_TIME());
            settime(dish.getSTART_TIME(), dish.getEND_TIME(), menuViewHolder.tvDishTime );

            if (dish.getTYPE().equals("VEG")) {
                menuViewHolder.ivDishType.setVisibility(View.VISIBLE);
                menuViewHolder.ivNonvegDishType.setVisibility(View.GONE);
            } else {
                menuViewHolder.ivDishType.setVisibility(View.GONE);
                menuViewHolder.ivNonvegDishType.setVisibility(View.VISIBLE);
            }
//            edit icon ivEditMenu
            if (dish.getIS_SHOWN().equals("Y")) {
                menuViewHolder.tvDishShown.setText("Visible");
                menuViewHolder.tvDishShown.setTextColor(ContextCompat.getColor(activity, R.color.darkGreen));
            } else {
                menuViewHolder.tvDishShown.setText("Hiden");
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
        ImageView ivDishType, ivDishEdit, ivNonvegDishType;

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
            ivNonvegDishType = itemView.findViewById(R.id.ivNonvegDishType);
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

    void settime(String time1, String time2, TextView tvDishTime)
    {
        DateFormat f1 = new SimpleDateFormat("HH:mm:ss"); //HH for hour of the day (0 - 23)
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = f1.parse(time1);
            d2 = f1.parse(time2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat f2 = new SimpleDateFormat("h:mma");
        f2.format(d1).toLowerCase(); // "12:18am"
        f2.format(d2).toLowerCase(); // "12:18am"
        Log.e( "settime: ",  f2.format(d1).toLowerCase());
        tvDishTime.setText( f2.format(d1).toLowerCase()+ " to "+ f2.format(d2).toLowerCase());

    }
}
