package com.bignerdranch.android.criminalintent;

import java.util.UUID;
import java.util.Date;
import android.text.format.DateFormat;

/**
 * Created by brycesulin on 9/28/17.
 */

public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private Date mTime;
    private boolean mSolved;
    private boolean mRequiresPolice;
    private String mSuspect;

    private String suspectNumber;








    public Crime() {
        this(UUID.randomUUID());
    }

    public Crime(UUID id) {
        mId = id;
        mDate = new Date();
        mTime = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public Date getTime() {
        return mTime;
    }

    public void setTime(Date time) {
        mTime = time;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public String getSuspect() {
        return mSuspect;
    }

    public void setSuspect(String suspect) {
        mSuspect = suspect;
    }

    public boolean isSeriousCrime() {
        return mRequiresPolice;
    }

    public void setSeriousCrime(boolean seriousCrime) {
        mRequiresPolice = seriousCrime;
    }

    public String getPhotoFilename() {
        return "IMG_" + getId().toString() + ".jpg";
    }



    public String getSuspectNumber() {
        return suspectNumber;
    }

    public void setSuspectNumber(String suspectNumber) {
        this.suspectNumber = suspectNumber;
    }






}
