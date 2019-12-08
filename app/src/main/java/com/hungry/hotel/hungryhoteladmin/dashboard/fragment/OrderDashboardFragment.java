package com.hungry.hotel.hungryhoteladmin.dashboard.fragment;


import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.dashboard.adapter.DashboardOrderAdapter;
import com.hungry.hotel.hungryhoteladmin.dashboard.model.OrderDashboard;
import com.hungry.hotel.hungryhoteladmin.orders.fragment.OrderFragment;

import java.util.ArrayList;
import java.util.List;

import android.content.res.Resources;
import android.widget.Toast;

public class OrderDashboardFragment extends Fragment {


    public OrderDashboardFragment() {
        // Required empty public constructor
    }


    public static OrderDashboardFragment newInstance(String param1, String param2) {

        return null;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View dashboardView = inflater.inflate(R.layout.fragment_order_dashboard, container, false);
        TextView tvTodaysStatus = dashboardView.findViewById(R.id.tvTodaysStatus);
        Button btnOtherOrder = dashboardView.findViewById(R.id.btnOtherOrder);
        RecyclerView rvOrderDashboard = dashboardView.findViewById(R.id.rvOrderDashboard);
        List<OrderDashboard> orderList = getOrdersList();
        DashboardOrderAdapter dashboardOrderAdapter = new DashboardOrderAdapter(orderList, new DashboardOrderAdapter.OrderClickListener() {
            @Override
            public void orderOpen(OrderDashboard order) {
                Toast.makeText(dashboardView.getContext(), "Order clicked", Toast.LENGTH_LONG).show();
                OrderFragment orderFragment = OrderFragment.newInstance(order.getOrderName());
                loadFragment(orderFragment, "ORDER_FRAGMENT", true);
            }
        });
        setDashboardProperty(dashboardView, rvOrderDashboard);
        rvOrderDashboard.setAdapter(dashboardOrderAdapter);

        return dashboardView;
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

    private List<OrderDashboard> getOrdersList() {
        List<OrderDashboard> orders = new ArrayList<>();


        orders.add(new OrderDashboard(100, OrderDashboard.TOTAL_ORDER, 100.00, false, R.color.newGreen));
        orders.add(new OrderDashboard(100, OrderDashboard.NEW_ORDER, 100.00, true, R.color.darkGreen));
        orders.add(new OrderDashboard(100, OrderDashboard.ACCEPTED_ORDER, 100.00, false, R.color.purple));
        orders.add(new OrderDashboard(100, OrderDashboard.READY_ORDER, 100.00, false, R.color.blue));
        orders.add(new OrderDashboard(100, OrderDashboard.REJECTED_ORDER, 100.00, false, R.color.brown));
        orders.add(new OrderDashboard(100, OrderDashboard.DELIVERED_ORDER, 100.00, false, R.color.darkpurple));

        return orders;
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
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
}
