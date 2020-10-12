package com.hungry.hotel.hungryhoteladmin.menudetails;

import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.textfield.TextInputLayout;
import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.home.HomeActivity;
import com.hungry.hotel.hungryhoteladmin.menudetails.api.MenuDetailsApi;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.RestaurantMenuFragment;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.adapter.RestaurantMenuAdapter;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.api.RestaurantMenuApi;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.Dish;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.DishResponse;
import com.hungry.hotel.hungryhoteladmin.retrofit.RetrofitClientInstance;
import com.hungry.hotel.hungryhoteladmin.utils.HungryAdminUtility;
import com.hungry.hotel.hungryhoteladmin.utils.OnFragmentInteractionListener;
import com.hungry.hotel.hungryhoteladmin.utils.PrefManager;
import com.hungry.hotel.hungryhoteladmin.utils.Utilities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link AddUpdateMenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddUpdateMenuFragment extends Fragment {
    TextInputLayout tilDishName, tilDishAmount, tilDishQuantity, tilDishDescription;
    EditText etDishName, etDishAmount, etDishQuantity, etDishDescription;
    TextView etStartTime, etEndTime;
    Spinner spDishType, spDishCategory;
    List<String> menuTypes, menuCategory;
    private final int START_TIME = 1;
    private final int END_TIME = 2;
    private Dish dish;
    Button btnAddDish;
    Switch swIsShown;
    ProgressDialog progressDialog;
    PrefManager prefManager;
    RelativeLayout layout1, layout2;
    TextView txt_error;

    String dishtype="", dishcategory="", isshown="N";
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
        setValues();

        etEndTime.setOnClickListener((v) -> {
            setTime(etEndTime);
        });
        etStartTime.setOnClickListener((v) -> {
            setTime(etStartTime);
        });

        btnAddDish.setOnClickListener((v) -> {

            if(etDishName.getText().toString().length()==0 ||
               etDishAmount.getText().toString().length()==0 ||
               etDishQuantity.getText().toString().length()==0 ||
               etDishDescription.getText().toString().length()==0 ||
               etStartTime.getText().toString().length()==0 ||
               etEndTime.getText().toString().length()==0 ||
               dishtype.length()==0 ||
               dishcategory.length()==0 )
            {
                Toast.makeText(getActivity(), getResources().getString(R.string.check_internet), Toast.LENGTH_SHORT).show();
            }
            else {
                if (dish != null) {

                    Log.e( "onCreateView: ",  dish.getMENU_MA_ID());
                    editMenu(etDishName.getText().toString(), etDishAmount.getText().toString(),
                            dishtype, etDishQuantity.getText().toString(), etDishDescription.getText().toString(),
                            dishcategory, etStartTime.getText().toString(),
                            etEndTime.getText().toString(),
                            String.valueOf(prefManager.getUSERID()), String.valueOf(prefManager.getUSERID()) ,
                            RetrofitClientInstance.API_KEY,
                            isshown, dish.getMENU_MA_ID(), "1");
                }
                else {
                    addMenu(etDishName.getText().toString(), etDishAmount.getText().toString(),
                            dishtype, etDishQuantity.getText().toString(), etDishDescription.getText().toString(),
                            dishcategory, etStartTime.getText().toString(),
                            etEndTime.getText().toString(),
                            String.valueOf(prefManager.getUSERID()),  String.valueOf(prefManager.getUSERID()), RetrofitClientInstance.API_KEY,
                            isshown, "1");
                }

            }

        });


        // Set a checked change listener for toggle button
        swIsShown.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    isshown="Y";

                    }
                else{

                    isshown="N";
                }
            }
        });

        spDishType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View view, int position, long id) {
                dishtype=spDishType.getSelectedItem().toString();

            }
            public void onNothingSelected(AdapterView<?> arg0) { }
        });
         spDishCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View view, int position, long id) {
                dishcategory=spDishCategory.getSelectedItem().toString();

            }
            public void onNothingSelected(AdapterView<?> arg0) { }
        });

        return view;
    }

    private void setValues() {
       // Log.e( "setValues: ",dish.toString() );
//        Log.e( "setValues: ",dish.getCATEGORY() );
        if (dish != null) {
            etDishName.setText(dish.getNAME());
            etDishAmount.setText(HungryAdminUtility.getFormattedPrice(Double.parseDouble(dish.getAMOUNT())));
            etDishQuantity.setText( dish.getQUNTITY());
            etDishDescription.setText(dish.getDESCRIPTION());
            etStartTime.setText(dish.getSTART_TIME());
            etEndTime.setText(dish.getEND_TIME());
            Log.e( "setValues: ", dish.getTYPE());

            if(dish.getIS_SHOWN().equals("Y"))
            {
                swIsShown.setChecked(true);
            }
            else {
                swIsShown.setChecked(false);
            }
            for (int i = 0; i < menuTypes.size(); i++) {
                if (menuTypes.get(i).equalsIgnoreCase(dish.getTYPE())) {
                    spDishType.setSelected(true);
                } else {
                    spDishType.setSelected(false);
                }
            }


            for (int i = 0; i < menuCategory.size(); i++) {
                Log.e( "setValueslist1: ", String.valueOf(menuCategory.get(i)));

                if (menuCategory.get(i).equals(dish.getCATEGORY())) {
                    spDishCategory.setSelection(i);
                    spDishCategory.setSelected(true);
                } else {
                    spDishCategory.setSelected(false);
                }
            }
        }
    }

    private void setTime(TextView textView) {
        // Create an instance of the dialog fragment and show it
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                textView.setText( selectedHour + ":" + selectedMinute);
            }
        }, hour, minute, false);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }

    public List<String> getMenuTypes() {
        List<String> menuTypes = new ArrayList<>();
        menuTypes.add("Select Dish type");
        menuTypes.add("VEG");
        menuTypes.add("NON_VEG");
        return menuTypes;
    }

    public List<String> getMenuCategory() {
        List<String> menuCategory = new ArrayList<>();
        menuCategory.add("Select Category");
        menuCategory.add("Indian");
        menuCategory.add("Chinese");
        menuCategory.add("Mughlai");
        menuCategory.add("South Indian");
        menuCategory.add("Dinner");
        menuCategory.add("Breakfast");
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
        btnAddDish = view.findViewById(R.id.btnAddDish);
        swIsShown =  view.findViewById(R.id.swIsShown);
        layout1 = view.findViewById(R.id.layout1);
        layout2 = view.findViewById(R.id.layout2);
        txt_error = view.findViewById(R.id.txt_error);

        progressDialog=new ProgressDialog(getActivity());
        prefManager=new PrefManager(getActivity());
    }

    private void setupToolbar() {
        Toolbar toolbar;
        ActionBar actionBar;
        ActionBarDrawerToggle toggle;
        DrawerLayout drawer;
        toolbar = ((HomeActivity) getActivity()).findViewById(R.id.toolbar);
        actionBar = ((HomeActivity) getActivity()).getSupportActionBar();
        drawer = ((HomeActivity) getActivity()).findViewById(R.id.drawer_layout);
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
        ((HomeActivity) getActivity()).setDrawerLocked(true);
        TextView tvToolbarTitle = toolbar.findViewById(R.id.tvToolbarTitle);

        if (dish != null) {
            tvToolbarTitle.setText("Update Menu");
        }
        else {
            tvToolbarTitle.setText("Add Menu");
        }
        AppBarLayout.LayoutParams params =
                (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        params.setScrollFlags(0);
        toggle.syncState();

    }

    void addMenu(String NAME, String AMOUNT,String TYPE,String QUNTITY,String DESCRIPTION,String CATEGORY,
            String START_TIME,String END_TIME,String HOT_MA_ID,String ADDED_BY,String api_key,String IS_SHOWN,String PRIORITY_ID)
    {
        if(Utilities.isNetworkAvailable(getActivity()))
        {

            MenuDetailsApi menuDetailsApi = RetrofitClientInstance.getRetrofitInstanceServer().
                    create(MenuDetailsApi.class);

            progressDialog.setMessage("Please Wait...");
            progressDialog.setCancelable(false);
            // pbLoading.setProgressStyle(R.id.abbreviationsBar);
            progressDialog.show();
            menuDetailsApi.addMenus(NAME,AMOUNT,TYPE,QUNTITY
                    ,DESCRIPTION,CATEGORY,START_TIME,END_TIME,HOT_MA_ID,ADDED_BY,RetrofitClientInstance.API_KEY, IS_SHOWN,PRIORITY_ID).
                    enqueue(new Callback<DishResponse>() {

                        @Override
                        public void onResponse(Call<DishResponse> call, Response<DishResponse> response) {

                            DishResponse dishResponse = response.body();
                            Log.e("onResponseckhk: ", dishResponse.getResult().toString());

                            if(dishResponse.getStatus()==200)
                            {
                                openEditMenuFragment();

                            }
                            else {

                                Utilities.setError(layout1,layout2,txt_error,dishResponse.getMessage());

                            }
                            progressDialog.dismiss();
                        }

                        @Override
                        public void onFailure(Call<DishResponse> call, Throwable t) {

                            progressDialog.dismiss();
                            Utilities.setError(layout1,layout2,txt_error,getResources().getString(R.string.something_went_wrong));
                            Log.d("errorchk",t.getMessage());

                        }
                    });
        }
        else {
            Utilities.setError(layout1,layout2,txt_error,getResources().getString(R.string.check_internet));

        }
    }

    void editMenu(String NAME, String AMOUNT,String TYPE,String QUNTITY,String DESCRIPTION,String CATEGORY,
            String START_TIME,String END_TIME,String HOT_MA_ID,String ADDED_BY,String api_key,String IS_SHOWN, String MENU_MA_ID,
                  String PRIORITY_ID)
    {
        if(Utilities.isNetworkAvailable(getActivity()))
        {

            MenuDetailsApi menuDetailsApi = RetrofitClientInstance.getRetrofitInstanceServer().
                    create(MenuDetailsApi.class);
            progressDialog.setMessage("Please Wait...");
            progressDialog.setCancelable(false);
            progressDialog.show();
            menuDetailsApi.editMenus(NAME,AMOUNT,TYPE,QUNTITY
                    ,DESCRIPTION,CATEGORY,START_TIME,END_TIME,HOT_MA_ID,ADDED_BY,RetrofitClientInstance.API_KEY,
                    IS_SHOWN,MENU_MA_ID,PRIORITY_ID).
                    enqueue(new Callback<DishResponse>() {

                        @Override
                        public void onResponse(Call<DishResponse> call, Response<DishResponse> response) {

                            DishResponse dishResponse = response.body();
                            Log.e("onResponseckhk: ", dishResponse.getResult().toString());
                            if(dishResponse.getStatus()==200)
                            {
                                openEditMenuFragment();

                            }
                            else {

                                Utilities.setError(layout1,layout2,txt_error,dishResponse.getMessage());

                            }
                            progressDialog.dismiss();

                        }

                        @Override
                        public void onFailure(Call<DishResponse> call, Throwable t) {

                            progressDialog.dismiss();
                            Utilities.setError(layout1,layout2,txt_error,getResources().getString(R.string.something_went_wrong));


                        }
                    });
        }
        else {
            Utilities.setError(layout1,layout2,txt_error,getResources().getString(R.string.check_internet));
        }
    }

    public  void openEditMenuFragment() {
        RestaurantMenuFragment fragment;
        fragment = new RestaurantMenuFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.clHomePageContainer, fragment);
        fragmentTransaction.addToBackStack("ADD_UPDATE_MENU");
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }
}
