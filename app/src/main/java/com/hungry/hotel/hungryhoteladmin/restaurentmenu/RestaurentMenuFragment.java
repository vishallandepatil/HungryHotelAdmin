package com.hungry.hotel.hungryhoteladmin.restaurentmenu;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;

import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.adapter.RestaurentMenuAdapter;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.Dish;

import java.util.ArrayList;
import java.util.List;


public class RestaurentMenuFragment extends Fragment {
    RecyclerView rvMenu;

    public RestaurentMenuFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static RestaurentMenuFragment newInstance(String param1, String param2) {
        RestaurentMenuFragment fragment = new RestaurentMenuFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View dishMenu = inflater.inflate(R.layout.fragment_restaurent_menu, container, false);
        setupToolbar();
        rvMenu = dishMenu.findViewById(R.id.rvMenu);
        List<Dish> dishList = getDishes();
        RestaurentMenuAdapter menuAdapter = new RestaurentMenuAdapter(getActivity(), dishList, rvMenu);
        setRecyclerViewProperty(rvMenu);
        rvMenu.setAdapter(menuAdapter);

        return dishMenu;
    }

    private void setupToolbar() {
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Menus");
        toolbar.setTitleTextColor(getActivity().getResources().getColor(R.color.black));
        AutoCompleteTextView actvSearchMenu = toolbar.findViewById(R.id.actvSearchMenu);
        ImageButton ibFilter = toolbar.findViewById(R.id.ibFilter);
        ImageButton ibSearch = toolbar.findViewById(R.id.ibSearch);
        actvSearchMenu.setVisibility(View.VISIBLE);
        ibSearch.setVisibility(View.VISIBLE);
        ibFilter.setVisibility(View.VISIBLE);
    }

    private List<Dish> getDishes() {
        List<Dish> dishList = new ArrayList<>();
        Dish dish = new Dish();
        dish.setDishName("Sev Bhaji");
        dish.setDishPrice(80.00);
        dish.setDishQuantity(2);
        dish.setDishStartTime("11:00 AM");
        dish.setDishEndTime("10:00 PM");
        dish.setVeg(true);
        dish.setDishImage("");
        dishList.add(dish);
        dishList.add(dish);
        dishList.add(dish);
        dishList.add(dish);
        dishList.add(dish);
        dishList.add(dish);
        dishList.add(dish);
        dishList.add(dish);
        dishList.add(dish);
        dishList.add(dish);
        dishList.add(dish);
        dishList.add(dish);
        dishList.add(dish);
        dishList.add(dish);
        dishList.add(dish);
        dishList.add(dish);
        dishList.add(dish);

        return dishList;
    }

    private void setRecyclerViewProperty(RecyclerView recyclerView) {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
