package com.hungry.hotel.hungryhoteladmin.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.text.DecimalFormat;

public class HungryAdminUtility {
    public static float getDpFfromPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    public static String getFormattedPrice(double price) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
        return decimalFormat.format(price);
    }

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.length() == 0 || string.equalsIgnoreCase("null");
    }
}
