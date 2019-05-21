package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

class Earthquake {
    private double mMagnitude;
    private String mPlace;
    private String mTimeToDisplay;


    public Earthquake(double magnitude, String place, long timeInMilli) {
        mMagnitude = magnitude;
        mPlace = place;
        Date date = new Date(timeInMilli);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM DD, yyyy");
        mTimeToDisplay = dateFormat.format(date);
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getPlace() {
        return mPlace;
    }

    public String getTime() {
        return mTimeToDisplay;
    }
}
