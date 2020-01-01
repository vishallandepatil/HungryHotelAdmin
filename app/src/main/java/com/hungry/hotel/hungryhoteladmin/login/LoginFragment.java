package com.hungry.hotel.hungryhoteladmin.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.dashboard.OrderDashboardFragment;
import com.hungry.hotel.hungryhoteladmin.home.MainActivity2;
import com.hungry.hotel.hungryhoteladmin.login.model.User;
import com.hungry.hotel.hungryhoteladmin.utils.OnFragmentInteractionListener;
import com.hungry.hotel.hungryhoteladmin.utils.SharedPreferenceHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class LoginFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    LinearLayout llLoginUserName;
    LinearLayout llLoginOtp;
    TextView tvLoginChange;
    EditText etUserName;
    EditText etPassword;
    Spinner spAccountType;
    EditText etMobileNumber;
    EditText etOtp;

    TextView tvResendOtp;
    LinearLayout llResendOtp;
    Button btnLogin;
    TextView tvPrivacyPolicyLink;
    //    final int LOGIN_WITH_OTP = 1, LOGIN_WITH_USERNAME = 2;
    final int SEND_OTP = 1, VERIFY_OTP = 2;
    int otpChange;
    boolean isOtpVerified = false;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setupToolbar();

        final View loginView = inflater.inflate(R.layout.fragment_login, container, false);
        instantiateView(loginView);
        addLinkToTextView();
//        loginType = LOGIN_WITH_USERNAME;
        showLoginUserLayout();
        otpChange = SEND_OTP;

        List<String> accountTypes = getAccountTypes();
        spAccountType.setAdapter(new ArrayAdapter<String>(loginView.getContext(), R.layout.spinner_item, accountTypes));
//        final User user = getUserDetails();
        tvLoginChange.setOnClickListener(v -> {
            changeLoginLayout();
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(loginView.getContext(), "LoginClicked", Toast.LENGTH_SHORT).show();
                /*if (loginType == LOGIN_WITH_OTP) {
                    if (otpChange == SEND_OTP) {
                        otpChange = VERIFY_OTP;
                        btnLogin.setText("Send OTP");
                    } else {
                        btnLogin.setText("Verify OTP");
                        showHomePage(loginView, user);

                    }
                } else {
                    btnLogin.setText("Login");
                    showHomePage(loginView, user);
                }*/
                final User user = getUserDetails();
                showHomePage(user);


            }
        });
        return loginView;
    }

    private void addLinkToTextView() {
        Pattern pattern = Pattern.compile("privacy policy");
        tvPrivacyPolicyLink.setText("This number will not used for any kind of promotional activity, it will kept confidential. For more please refer to our privacy policy");
        Linkify.addLinks(tvPrivacyPolicyLink,pattern, "http://www.google.ie/search?q=");
    }

    private void setupToolbar() {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        ((MainActivity2) getActivity()).setDrawerLocked(true);
    }

    private List<String> getAccountTypes() {
        List<String> accountTypes = new ArrayList<>();
        accountTypes.add("Select Account Type");
        accountTypes.add(User.DELIVERY_BOY);
        accountTypes.add(User.HOTEL_ADMIN);
        return accountTypes;
    }

    private User getUserDetails() {
        String userName;
        String password;
        String account;
        String mobileNumber;
        String otp;
        User user = new User();

        if (llLoginUserName.getVisibility() == View.VISIBLE) {
            userName = etUserName.getText().toString();
            password = etPassword.getText().toString();
            account = spAccountType.getSelectedItem().toString();
            user.setName(userName);
            user.setPassword(password);
            user.setAccountType(account);
            Log.d("account_type", spAccountType.getSelectedItem().toString());
            Log.d("account", user.getAccountType());
        } else {
            mobileNumber = etMobileNumber.getText().toString();
            otp = etOtp.getText().toString();
            user.setMobileNumber(mobileNumber);
            user.setOtp(otp);
        }
        /*if (loginType == LOGIN_WITH_USERNAME) {
            userName = etUserName.getText().toString();
            password = etPassword.getText().toString();
            account = spAccountType.getSelectedItem().toString();
            user.setName(userName);
            user.setPassword(password);
            user.setAccountType(account);
            Log.d("account_type", spAccountType.getSelectedItem().toString());
            Log.d("account", user.getAccountType());
        } else {
            mobileNumber = etMobileNumber.getText().toString();
            otp = etOtp.getText().toString();
            user.setMobileNumber(mobileNumber);
            user.setOtp(otp);
        }*/
        return user;
    }

    private void instantiateView(View loginView) {
        etUserName = loginView.findViewById(R.id.etUserName);
        etPassword = loginView.findViewById(R.id.etPassword);
        spAccountType = loginView.findViewById(R.id.spAccountType);
        llLoginOtp = loginView.findViewById(R.id.llLoginOtp);
        llLoginUserName = loginView.findViewById(R.id.llLoginUserName);
        tvLoginChange = loginView.findViewById(R.id.tvLoginChange);
        btnLogin = loginView.findViewById(R.id.btnLogin);
        etMobileNumber = loginView.findViewById(R.id.etMobileNumber);
        tvResendOtp = loginView.findViewById(R.id.tvResendOtp);
        etOtp = loginView.findViewById(R.id.etOtp);
        tvPrivacyPolicyLink = loginView.findViewById(R.id.tvPrivacyPolicyLink);

    }

    private void changeLoginLayout() {
        if (llLoginUserName.getVisibility() == View.VISIBLE) {
//            showLoginUserLayout();
            llLoginUserName.setVisibility(View.GONE);
            llLoginOtp.setVisibility(View.VISIBLE);
            tvLoginChange.setText("Login with Otp");
            btnLogin.setText("Login");
        } else {
            tvLoginChange.setText("Login with username");
            llLoginUserName.setVisibility(View.VISIBLE);
            llLoginOtp.setVisibility(View.GONE);
            if (isOtpVerified) {
                btnLogin.setText("Verify OTp");
            } else {
                btnLogin.setText("Send OTP");
            }

//            shoLoginOtpLayout();
        }
//        Log.d("Login_TYPE", String.valueOf(loginType));
    }

    private void shoLoginOtpLayout() {
        llLoginOtp.setVisibility(View.VISIBLE);
        llLoginUserName.setVisibility(View.GONE);
        tvLoginChange.setText("Login with username");
        if (otpChange == SEND_OTP) {
            btnLogin.setText("Send OTP");
            isOtpVerified = false;
        } else {
            btnLogin.setText("Verify OTp");
            isOtpVerified = true;
        }
        Log.d("Login", "OTP login loaded");
    }

    private void showLoginUserLayout() {
        llLoginOtp.setVisibility(View.GONE);
        llLoginUserName.setVisibility(View.VISIBLE);
//
        tvLoginChange.setText("Login with Otp");
        btnLogin.setText("Login");
        Log.d("Login", "User login loaded");
//        loginType = LOGIN_WITH_USERNAME;
    }

    private void showHomePage(User user) {
        boolean isValidUser = verifyUser(user);
        if (isValidUser) {
            saveDetailsToPreferences(user);
            loadFragment(new OrderDashboardFragment(), "ORDER_DASHBOARD", true);
        }
    }

    private boolean verifyUser(User user) {
        if (llLoginUserName.getVisibility() == View.VISIBLE) {
            return true;
        }
        /*if (isOtpVerified) {

            return true;
        } else {
            return false;

        }*/
        return true;
    }

    private void saveDetailsToPreferences(User user) {
        SharedPreferences.Editor spEditor = SharedPreferenceHelper.getEditorInstance(getActivity(), "USER");
        spEditor.clear();
        spEditor.putString(User.ACCOUNT_TYPE, user.getAccountType());
        Log.d("ACC_", user.getAccountType());
        SharedPreferenceHelper.savePreference(spEditor);
        /*SharedPreferences sp = getActivity().getSharedPreferences("ACCOUNT", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(User.ACCOUNT_TYPE, user.getAccountType());
        editor.apply();
        Log.d("ACC_TYPE_SP", user.getAccountType());*/
    }

    private void loadFragment(Fragment fragment, String fragmentName, boolean needToBackStack) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.clHomePageContainer, fragment);
        if (needToBackStack) {
            fragmentTransaction.addToBackStack(fragmentName);
        }
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
