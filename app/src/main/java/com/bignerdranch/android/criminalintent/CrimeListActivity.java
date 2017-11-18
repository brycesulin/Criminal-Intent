package com.bignerdranch.android.criminalintent;

import android.support.v4.app.Fragment;


/**
 * Created by brycesulin on 9/28/17.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
