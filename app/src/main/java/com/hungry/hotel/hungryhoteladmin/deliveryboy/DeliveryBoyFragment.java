package com.hungry.hotel.hungryhoteladmin.deliveryboy;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.deliveryboy.model.DeliveryBoy;
import com.hungry.hotel.hungryhoteladmin.deliveryboy.viewmodel.DeliveryBoyViewModel;
import com.hungry.hotel.hungryhoteladmin.home.MainActivity2;
import com.hungry.hotel.hungryhoteladmin.utils.FragmentUtils;
import com.hungry.hotel.hungryhoteladmin.utils.OnFragmentInteractionListener;

import de.hdodenhof.circleimageview.CircleImageView;


public class DeliveryBoyFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    Toolbar toolbar;
    ActionBar actionBar;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    CircleImageView civDeliveryBoyImage;
    TextView tvDeliveryBoyName, tvFrenchayName, tvDeliveryBoyAddress, tvDeliveryBoyMobileNumber;
    Switch swActivateDeliveryBoy;
    Button btnLoginOut;


    public DeliveryBoyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DeliveryBoyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DeliveryBoyFragment newInstance(String param1, String param2) {
        DeliveryBoyFragment fragment = new DeliveryBoyFragment();
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


        setupToolbar();
        View deliveryBoyView = inflater.inflate(R.layout.fragment_delivery_boy, container, false);
        instantiateView(deliveryBoyView);

        DeliveryBoyViewModel deliveryBoyViewModel = ViewModelProviders.of(getActivity()).get(DeliveryBoyViewModel.class);
        deliveryBoyViewModel.getDeliveryBoyDetails().observe(getActivity(), new Observer<DeliveryBoy>() {
            @Override
            public void onChanged(DeliveryBoy deliveryBoy) {
                setDeliveryBoyDetails(deliveryBoy);
            }
        });
        return deliveryBoyView;
    }

    private void setDeliveryBoyDetails(DeliveryBoy deliveryBoy) {
        Glide.with(getActivity())
                .load(R.drawable.food)
                .centerCrop()
                .placeholder(R.drawable.ic_user)
                .into(civDeliveryBoyImage);
        tvDeliveryBoyName.setText(deliveryBoy.getDeliveryBoyName());
        tvDeliveryBoyMobileNumber.setText(deliveryBoy.getDeliveryBoyMobile());
        tvDeliveryBoyAddress.setText(deliveryBoy.getDeliveryBoyAddress());
        tvFrenchayName.setText(deliveryBoy.getFranchayName());
        if (deliveryBoy.isActivated()) {
            swActivateDeliveryBoy.setChecked(true);
        } else {
            swActivateDeliveryBoy.setChecked(false);
        }

    }


    private void instantiateView(View deliveryBoyView) {
        civDeliveryBoyImage = deliveryBoyView.findViewById(R.id.civDeliveryBoyImage);
        tvDeliveryBoyName = deliveryBoyView.findViewById(R.id.tvDeliveryBoyName);
        tvFrenchayName = deliveryBoyView.findViewById(R.id.tvFrenchayName);
        tvDeliveryBoyAddress = deliveryBoyView.findViewById(R.id.tvDeliveryBoyAddress);
        tvDeliveryBoyMobileNumber = deliveryBoyView.findViewById(R.id.tvDeliveryBoyMobileNumber);
        swActivateDeliveryBoy = deliveryBoyView.findViewById(R.id.swActivateDeliveryBoy);
        btnLoginOut = deliveryBoyView.findViewById(R.id.btnLoginOut);
    }

    private void setupToolbar() {
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
        tvToolbarTitle.setText("Delivery Boy");
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
            mListener.onFragmentInteraction(this);
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
