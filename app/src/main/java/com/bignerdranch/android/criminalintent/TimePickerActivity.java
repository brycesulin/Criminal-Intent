package com.bignerdranch.android.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import java.util.Date;

public class TimePickerActivity extends SingleFragmentActivity {
    private static final String EXTRA_DATE =
            "com.bignerdranch.android.criminalintent.date";
    @Override
    protected Fragment createFragment() {
        Date date = (Date) getIntent().getSerializableExtra(EXTRA_DATE);
        return TimePickerFragment
                .newInstance(date);
    }

    public static Intent newIntent(Context packageContext, Date date) {
        Intent i = new Intent(packageContext, TimePickerActivity.class);
        i.putExtra(EXTRA_DATE, date);
        return i;
    }
}
