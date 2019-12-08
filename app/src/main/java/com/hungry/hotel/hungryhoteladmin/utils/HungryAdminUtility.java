package com.hungry.hotel.hungryhoteladmin.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class HungryAdminUtility {
    public static float getDpFfromPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }
}
