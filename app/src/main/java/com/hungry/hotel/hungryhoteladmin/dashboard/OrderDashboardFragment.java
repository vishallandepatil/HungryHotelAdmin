package com.hungry.hotel.hungryhoteladmin.dashboard;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.dashboard.adapter.DashboardOrderAdapter;
import com.hungry.hotel.hungryhoteladmin.dashboard.api.DashboardApi;
import com.hungry.hotel.hungryhoteladmin.dashboard.model.Dashboard;
import com.hungry.hotel.hungryhoteladmin.dashboard.model.DashboardResponse;
import com.hungry.hotel.hungryhoteladmin.dashboard.viewmodel.DashboardViewModel;
import com.hungry.hotel.hungryhoteladmin.home.HomeActivity;
import com.hungry.hotel.hungryhoteladmin.login.model.User;
import com.hungry.hotel.hungryhoteladmin.menudetails.AddUpdateMenuFragment;
import com.hungry.hotel.hungryhoteladmin.orders.OrderFragment;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.adapter.RestaurantMenuAdapter;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.api.RestaurantMenuApi;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.Dish;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.DishResponse;
import com.hungry.hotel.hungryhoteladmin.retrofit.RetrofitClientInstance;
import com.hungry.hotel.hungryhoteladmin.utils.OnFragmentInteractionListener;
import com.hungry.hotel.hungryhoteladmin.utils.PrefManager;
import com.hungry.hotel.hungryhoteladmin.utils.SharedPreferenceHelper;
import com.hungry.hotel.hungryhoteladmin.utils.Utilities;

import java.util.ArrayList;
import java.util.List;

import android.content.res.Resources;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderDashboardFragment extends Fragment {
    private OrderDashboardFragmentListener orderDashboardFragmentListener;
    private OnFragmentInteractionListener mListener;
    Toolbar toolbar;
    ActionBar actionBar;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    ProgressDialog progressDialog;
    RecyclerView rvOrderDashboard;
    DashboardOrderAdapter dashboardOrderAdapter;
    PrefManager prefManager;
    RelativeLayout layout1, layout2;
    Button btnOtherOrder;
    TextView txt_error;
    public OrderDashboardFragment() {
        // Required empty public constructor
    }

    public void setOrderDashboardFragmentListener(OrderDashboardFragmentListener orderDashboardFragmentListener) {
        this.orderDashboardFragmentListener = orderDashboardFragmentListener;
    }

    public static OrderDashboardFragment newInstance(String param1, String param2) {

        return null;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setupToolbar();
        progressDialog=new ProgressDialog(getActivity());
        prefManager=new PrefManager(getActivity());

        final View dashboardView = inflater.inflate(R.layout.fragment_order_dashboard, container, false);
        SharedPreferences sharedPreferences = SharedPreferenceHelper.getSharedPreferenceInstance(getActivity(), "USER");
        String accountType = sharedPreferences.getString(User.ACCOUNT_TYPE, "NONE");
        Log.d("Dashboard", accountType);

        instantiateView(dashboardView);
        setDashboardList();

       DashboardOrderAdapter dashboardOrderAdapter = new DashboardOrderAdapter(getActivity(),
                new DashboardOrderAdapter.OrderClickListener() {
            @Override
            public void orderOpen(Dashboard order) {
                Toast.makeText(dashboardView.getContext(), "Order clicked", Toast.LENGTH_LONG).show();
                OrderFragment orderFragment = OrderFragment.newInstance(order.getTitle());
                loadFragment(orderFragment, "ORDER_FRAGMENT", true);
            }
        });

        btnOtherOrder.setOnClickListener(v -> {

        });
        return dashboardView;
    }

    private void instantiateView(View dashboardView) {

        rvOrderDashboard=dashboardView.findViewById(R.id.rvOrderDashboard);
        btnOtherOrder = dashboardView.findViewById(R.id.btnOtherOrder);
        layout1 = dashboardView.findViewById(R.id.layout1);
        layout2 = dashboardView.findViewById(R.id.layout2);
        txt_error = dashboardView.findViewById(R.id.txt_error);

    }
        private void setDashboardProperty(View dashboardView, RecyclerView rvOrderDashboard) {
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(dashboardView.getContext(), 2);
        rvOrderDashboard.setLayoutManager(mLayoutManager);
        rvOrderDashboard.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        rvOrderDashboard.setItemAnimator(new DefaultItemAnimator());
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {


        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }

        }


    }

    private void loadFragment(Fragment fragment, String fragmentName, boolean needToBackStack) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.clHomePageContainer, fragment);
        fragmentTransaction.addToBackStack(fragmentName);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

    public interface OrderDashboardFragmentListener {
        void onDashboardOpen();
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

    private void setupToolbar() {
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        toolbar = ((HomeActivity) getActivity()).findViewById(R.id.toolbar);
        actionBar = ((HomeActivity) getActivity()).getSupportActionBar();
        drawer = ((HomeActivity) getActivity()).findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(true);
        // Show back button
        actionBar.setDisplayHomeAsUpEnabled(false);
        ((HomeActivity) getActivity()).setDrawerLocked(false);
        TextView tvToolbarTitle = toolbar.findViewById(R.id.tvToolbarTitle);
        tvToolbarTitle.setText("Dashboard");
        AppBarLayout.LayoutParams params =
                (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        params.setScrollFlags(0);
        toggle.syncState();

    }

    void setDashboardList()
    {
        //http://hungryindia.co.in/index.php/api/Order/Dashboard?api_key=kjashdkahdkhaksjdhweshkhskjdhkj&HOT_MS_ID=1&DL_BO_MA_ID=2
        if(Utilities.isNetworkAvailable(getActivity()))
        {
            DashboardApi dashboardApi = RetrofitClientInstance.getRetrofitInstanceServer().
                    create(DashboardApi.class);

            progressDialog.setMessage("Please Wait...");
            progressDialog.setCancelable(false);

            String hotelid= String.valueOf(prefManager.getUSERID());
            String dbid=String.valueOf(prefManager.getUSERID());
            if(prefManager.getROLEID()==1)
            {
                dbid=null;
            }
            else {
                hotelid=null;
            }
            // pbLoading.setProgressStyle(R.id.abbreviationsBar);
            progressDialog.show();
            dashboardApi.getDashboardDetails(RetrofitClientInstance.API_KEY,hotelid,dbid).
                    enqueue(new Callback<DashboardResponse>()
                    {
                        @Override
                        public void onResponse(Call<DashboardResponse> call, Response<DashboardResponse> response) {


                            DashboardResponse dashboardResponse = response.body();
                            if(dashboardResponse.getStatus()==200)
                            {
                                bindDashboard(dashboardResponse.getResult());

                            }
                            else {

                                Utilities.setError(layout1,layout2,txt_error,dashboardResponse.getMessage());

                            }

                            progressDialog.dismiss();
                        }
                        @Override
                        public void onFailure(Call<DashboardResponse> call, Throwable t) {

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

     void bindDashboard(final ArrayList<Dashboard> levelwiseQuizArrayList)
    {
        Log.e( "seta: ", levelwiseQuizArrayList.toString() );
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        rvOrderDashboard.setLayoutManager(gridLayoutManager);
        rvOrderDashboard.setItemAnimator(new DefaultItemAnimator());
        rvOrderDashboard.setHasFixedSize(true);

        dashboardOrderAdapter = new DashboardOrderAdapter( levelwiseQuizArrayList, new DashboardOrderAdapter.OrderClickListener() {
            @Override
            public void orderOpen(Dashboard order) {
                Toast.makeText(getActivity(), "Order clicked"+ order.getTitle(), Toast.LENGTH_LONG).show();
                OrderFragment orderFragment = OrderFragment.newInstance(order.getSTATUS());
                loadFragment(orderFragment, "ORDER_FRAGMENT", true);
            }
        });
        rvOrderDashboard.setAdapter(dashboardOrderAdapter);
        dashboardOrderAdapter.notifyDataSetChanged();
    }
}
    /*DashboardOrderAdapter dashboardOrderAdapter = new DashboardOrderAdapter(getActivity(),
            new DashboardOrderAdapter.OrderClickListener() {
                @Override
                public void orderOpen(Dashboard order) {
                    Toast.makeText(dashboardView.getContext(), "Order clicked", Toast.LENGTH_LONG).show();
                    OrderFragment orderFragment = OrderFragment.newInstance(order.getTitle());
                    loadFragment(orderFragment, "ORDER_FRAGMENT", true);
                }
            });*/