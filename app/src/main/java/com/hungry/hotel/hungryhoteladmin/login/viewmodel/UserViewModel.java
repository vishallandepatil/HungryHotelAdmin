package com.hungry.hotel.hungryhoteladmin.login.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.hungry.hotel.hungryhoteladmin.login.model.User;
import com.hungry.hotel.hungryhoteladmin.login.repository.LoginRepository;
import com.hungry.hotel.hungryhoteladmin.utils.HungryAdminApiListener;

public class UserViewModel extends AndroidViewModel {
    public UserViewModel(@NonNull Application application) {
        super(application);
    }

    public void getUser(User user, HungryAdminApiListener apiListener){

    }
}
