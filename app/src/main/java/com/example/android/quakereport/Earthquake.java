package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

class Earthquake {
    private double mMagnitude;
    private String mPlace;
    private String mDate, mTime;


    public Earthquake(double magnitude, String place, long timeInMilli) {
        mMagnitude = magnitude;
        mPlace = place;
        Date date = new Date(timeInMilli);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM DD, yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        mDate = dateFormat.format(date);
        mTime = timeFormat.format(date);
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getPlace() {
        return mPlace;
    }

    public String getTime() {
        return mTime;
    }

    public String getDate() {
        return mDate;
    }
}
