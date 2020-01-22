package com.hungry.hotel.hungryhoteladmin.utils;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;


public class SharedPreferenceHelper {
    static SharedPreferences sharedPreferences;
    static SharedPreferences.Editor editor;

    public static SharedPreferences.Editor getEditorInstance(Context context, String preferenceName) {
        sharedPreferences = getSharedPreferenceInstance(context, preferenceName);
        if (editor == null) {
            editor = sharedPreferences.edit();
        }
        return editor;
    }

    public static boolean savePreference(SharedPreferences.Editor editor) {
        return editor.commit();
    }

    public static SharedPreferences getSharedPreferenceInstance(Context context, String sharedPreferenceName) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(sharedPreferenceName, MODE_PRIVATE);
        }
        return sharedPreferences;
    }
}
