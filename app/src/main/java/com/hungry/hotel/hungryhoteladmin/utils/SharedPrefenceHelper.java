package com.hungry.hotel.hungryhoteladmin.utils;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class SharedPrefenceHelper {
    public static SharedPreferences.Editor getSharedPreferenceInstance(Context context) {
        SharedPreferences sp = context.getSharedPreferences("USER", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        return editor;
    }

    public static void savePreference(SharedPreferences.Editor editor) {
        editor.commit();
    }
}
