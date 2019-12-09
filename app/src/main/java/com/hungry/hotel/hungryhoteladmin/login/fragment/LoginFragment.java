package com.hungry.hotel.hungryhoteladmin.login.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.home.MainActivity2;
import com.hungry.hotel.hungryhoteladmin.login.model.User;
import com.hungry.hotel.hungryhoteladmin.utils.SharedPreferenceHelper;

import java.util.ArrayList;
import java.util.List;


public class LoginFragment extends Fragment {

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
        // Inflate the layout for this fragment
        String accountType = "";
        final View loginView = inflater.inflate(R.layout.fragment_login, container, false);
        EditText etUserName = loginView.findViewById(R.id.etUserName);
        EditText etPassword = loginView.findViewById(R.id.etPassword);
        Spinner spAccountType = loginView.findViewById(R.id.spAccountType);

        Button btnLogin = loginView.findViewById(R.id.btnLogin);
        List<String> accountTypes = new ArrayList<>();
        accountTypes.add("Select Account Type");
        accountTypes.add(User.DELIVERY_BOY);
        accountTypes.add(User.HOTEL_ADMIN);
        spAccountType.setAdapter(new ArrayAdapter<String>(loginView.getContext(), android.R.layout.simple_spinner_dropdown_item, accountTypes));
        String userName = etUserName.getText().toString();
        String password = etPassword.getText().toString();
        String account = spAccountType.getSelectedItem().toString();
        final User user = new User();
        user.setName(userName);
        user.setPassword(password);
        user.setAccountType(account);
        spAccountType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        accountType = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(loginView.getContext(), "LoginClicked", Toast.LENGTH_SHORT).show();
                showHomePage(loginView, user);
            }
        });
        return loginView;
    }

    private void showHomePage(View loginView, User user) {
        boolean isValidUser = true;
        if (isValidUser) {
            saveDetailsToPreferences(user);
            Intent intent = new Intent(loginView.getContext()
                    , MainActivity2.class);
            startActivity(intent);
        }
    }

    private void saveDetailsToPreferences(User user) {
        SharedPreferences.Editor spEditor = SharedPreferenceHelper.getEditorInstance(getActivity(), "USER");
        spEditor.putString(User.ACCOUNT_TYPE, user.getAccountType());
        SharedPreferenceHelper.savePreference(spEditor);
    }

}
