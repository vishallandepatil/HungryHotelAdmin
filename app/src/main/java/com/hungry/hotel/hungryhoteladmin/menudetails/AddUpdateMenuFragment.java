package com.hungry.hotel.hungryhoteladmin.menudetails;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;
import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.home.MainActivity2;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.Dish;
import com.hungry.hotel.hungryhoteladmin.utils.HungryAdminUtility;
import com.hungry.hotel.hungryhoteladmin.utils.OnFragmentInteractionListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link AddUpdateMenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddUpdateMenuFragment extends Fragment {
    TextInputLayout tilDishName, tilDishAmount, tilDishQuantity, tilDishDescription;
    EditText etDishName, etDishAmount, etDishQuantity, etDishDescription, etStartTime, etEndTime;
    Spinner spDishType, spDishCategory;
    List<String> menuTypes, menuCategory;
    private final int START_TIME = 1;
    private final int END_TIME = 2;
    private Dish dish;


    private OnFragmentInteractionListener mListener;

    public AddUpdateMenuFragment() {
        // Required empty public constructor
    }


    public static AddUpdateMenuFragment newInstance(Dish dish) {
        AddUpdateMenuFragment fragment = new AddUpdateMenuFragment();
        Bundle args = new Bundle();
        args.putParcelable("DISH", dish);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            dish = args.getParcelable("DISH");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_update_menu, container, false);
        setupToolbar();
        instantiateView(view);
        menuTypes = getMenuTypes();
        menuCategory = getMenuCategory();
        spDishType.setAdapter(new ArrayAdapter<String>(view.getContext(), R.layout.spinner_item, menuTypes));
        spDishCategory.setAdapter(new ArrayAdapter<String>(view.getContext(), R.layout.spinner_item, menuCategory));
        etStartTime.setOnClickListener((v) -> {
            setTime(START_TIME);
        });
        etStartTime.setOnClickListener((v) -> {
            setTime(END_TIME);
        });
        setValues();
        return view;
    }

    private void setValues() {
        etDishName.setText(dish.getDishName());
        etDishAmount.setText(HungryAdminUtility.getFormattedPrice(dish.getDishPrice()));
        etDishQuantity.setText("" + dish.getDishQuantity());
        etDishDescription.setText(dish.getDishDescription());
        for (int i = 0; i < menuTypes.size(); i++) {
            if (menuTypes.get(i).equalsIgnoreCase(dish.getDishType())) {
                spDishType.setSelected(true);
            } else {
                spDishType.setSelected(false);
            }
        }
        for (int i = 0; i < menuCategory.size(); i++) {
            if (menuCategory.get(i).equalsIgnoreCase(dish.getDishType())) {
                spDishCategory.setSelected(true);
            } else {
                spDishCategory.setSelected(false);
            }
        }


    }

    private void setTime(int timeConstant) {
        // Create an instance of the dialog fragment and show it

    }

    public List<String> getMenuTypes() {
        List<String> menuTypes = new ArrayList<>();
        menuTypes.add("Select Dish type");
        menuTypes.add("Indian");
        menuTypes.add("Chinese");
        menuTypes.add("Mughlai");
        return menuTypes;
    }

    public List<String> getMenuCategory() {
        List<String> menuCategory = new ArrayList<>();
        menuCategory.add("Select Category");
        menuCategory.add("VEG");
        menuCategory.add("NON VEG");
        return menuCategory;
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

    private void instantiateView(View view) {
        tilDishName = view.findViewById(R.id.tilDishName);
        tilDishAmount = view.findViewById(R.id.tilDishAmount);
        tilDishQuantity = view.findViewById(R.id.tilDishQuantity);
        tilDishDescription = view.findViewById(R.id.tilDishDescription);
        etDishName = view.findViewById(R.id.etDishName);
        etDishAmount = view.findViewById(R.id.etDishAmount);
        etDishQuantity = view.findViewById(R.id.etDishQuantity);
        etDishDescription = view.findViewById(R.id.etDishDescription);
        etStartTime = view.findViewById(R.id.etStartTime);
        etEndTime = view.findViewById(R.id.etEndTime);
        spDishType = view.findViewById(R.id.spDishType);
        spDishCategory = view.findViewById(R.id.spDishCategory);
    }

    private void setupToolbar() {
        Toolbar toolbar;
        ActionBar actionBar;
        ActionBarDrawerToggle toggle;
        DrawerLayout drawer;
        toolbar = ((MainActivity2) getActivity()).findViewById(R.id.toolbar);
        actionBar = ((MainActivity2) getActivity()).getSupportActionBar();
        drawer = ((MainActivity2) getActivity()).findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(false);
        // Show back button
        actionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        ((MainActivity2) getActivity()).setDrawerLocked(true);
        TextView tvToolbarTitle = toolbar.findViewById(R.id.tvToolbarTitle);
        tvToolbarTitle.setText("Add/Update Menu");
        toggle.syncState();
//        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
      /*  Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Delivery Boy");
        toolbar.setTitleTextColor(getActivity().getResources().getColor(R.color.black));

        AutoCompleteTextView actvSearchMenu = toolbar.findViewById(R.id.actvSearchMenu);
        ImageButton ibFilter = toolbar.findViewById(R.id.ibFilter);
        ImageButton ibSearch = toolbar.findViewById(R.id.ibSearch);
        actvSearchMenu.setVisibility(View.GONE);
        ibSearch.setVisibility(View.GONE);
        ibFilter.setVisibility(View.GONE);*/
        /*Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Delivery Boy");
        toolbar.setTitleTextColor(getActivity().getResources().getColor(R.color.black));
        AutoCompleteTextView actvSearchMenu = toolbar.findViewById(R.id.actvSearchMenu);
        ImageButton ibFilter = toolbar.findViewById(R.id.ibFilter);
        ImageButton ibSearch = toolbar.findViewById(R.id.ibSearch);
        actvSearchMenu.setVisibility(View.GONE);
        ibSearch.setVisibility(View.GONE);
        ibFilter.setVisibility(View.GONE);*/
    }
    /*public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }*/
}
