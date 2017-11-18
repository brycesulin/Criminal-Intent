package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

public class Utils {
    private static Utils ourInstance;
    private Boolean mIsPhone;

    public static Utils getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new Utils(context);
        }
        return ourInstance;
    }

    private Utils(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(metrics);

        float widthInches = metrics.widthPixels / metrics.xdpi;
        float heightInches =  metrics.heightPixels / metrics.ydpi;

        double diagonalInches = Math.sqrt(
                (widthInches*widthInches) + (heightInches*heightInches));

        mIsPhone = (diagonalInches < 7);
    }

    public Boolean isPhone() {
        return mIsPhone;
    }
}
