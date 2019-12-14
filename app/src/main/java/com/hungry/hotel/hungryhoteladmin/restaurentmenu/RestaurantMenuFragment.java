package com.hungry.hotel.hungryhoteladmin.restaurentmenu;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.menudetails.AddUpdateMenuFragment;
import com.hungry.hotel.hungryhoteladmin.orderdetail.OrderDetailsFragment;
import com.hungry.hotel.hungryhoteladmin.orders.model.Order;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.adapter.RestaurantMenuAdapter;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.Dish;
import com.hungry.hotel.hungryhoteladmin.utils.OnFragmentInteractionListener;

import java.util.ArrayList;
import java.util.List;


public class RestaurantMenuFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    RecyclerView rvMenu;

    public RestaurantMenuFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static RestaurantMenuFragment newInstance(String param1, String param2) {
        RestaurantMenuFragment fragment = new RestaurantMenuFragment();
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
        RestaurantMenuAdapter menuAdapter = new RestaurantMenuAdapter(getActivity(), dishList, rvMenu, (dish) -> {
            openEditMenuFragment(dish);
        });
//        loadFragment(new AddUpdateMenuFragment(), "ADD_EDIT_MENU", true);

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
        ibFilter.setOnClickListener((v) -> {
            showMenuFilter();
        });
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

    private void showMenuFilter() {
        String[] listItems = {"Less price ", "Max price ", "Rating", "Veg only", "Non_veg only"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Choose item");

        int checkedItem = 0; //this will checked the item when user open the dialog
        builder.setSingleChoiceItems(listItems, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), "Position: " + which + " Value: " + listItems[which], Toast.LENGTH_LONG).show();
            }
        });

        builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void openEditMenuFragment(Dish dish) {
        AddUpdateMenuFragment fragment = AddUpdateMenuFragment.newInstance(dish);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.clHomePageContainer, fragment);
        fragmentTransaction.addToBackStack("ORDER_DETAILS");
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
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
}
