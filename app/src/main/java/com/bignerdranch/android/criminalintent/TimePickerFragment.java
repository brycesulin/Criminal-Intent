package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.TimePicker;
import java.util.Date;
import android.app.Dialog;
import android.view.View;
import android.view.LayoutInflater;
import java.util.Calendar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Activity;
import android.content.Intent;
import android.widget.TimePicker.OnTimeChangedListener;


public class TimePickerFragment extends DialogFragment {
    //private TimePicker mtimePicker;
    private static final String ARG_TIME = "time";
    public static final String EXTRA_TIME = "com.bignerdranch.android.criminalintent.time";


    private Date mTime;


    public static TimePickerFragment newInstance(Date date) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_TIME, date);
        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void sendResult(int resultCode) {
        if (getTargetFragment() == null)
            return;

        Intent i = new Intent();
        i.putExtra(EXTRA_TIME,mTime);

        getTargetFragment().onActivityResult(getTargetRequestCode(),resultCode,i);

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mTime = (Date) getArguments().getSerializable(EXTRA_TIME);


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mTime);
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);


        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_time, null);


        TimePicker mtimePicker = (TimePicker)v.findViewById(R.id.dialog_time_picker);


        mtimePicker.setIs24HourView(true);
        mtimePicker.setCurrentHour(hourOfDay);
        mtimePicker.setCurrentMinute(minute);
        mtimePicker.setOnTimeChangedListener(new OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(mTime);
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calendar.set(Calendar.MINUTE, minute);

                mTime = calendar.getTime();

                getArguments().putSerializable(EXTRA_TIME, mTime);



            }
        });





        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle("Time picker")
                //.setTitle(R.string.time_picker_title);
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        sendResult(Activity.RESULT_OK);

                    }
                })
                .create();
    }
}
