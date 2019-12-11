package com.hungry.hotel.hungryhoteladmin.restaurentmenu;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.hungry.hotel.hungryhoteladmin.R;


public class RestaurentMenuFragment extends Fragment {

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurent_menu, container, false);
    }

}
