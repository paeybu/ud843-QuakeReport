package com.example.android.quakereport;

class EarthQuake {
    private String mLocation, mDate;
    private double mMagnitude;


    public EarthQuake(String location, String date, double magnitude) {
        mLocation = location;
        mDate = date;
        mMagnitude = magnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getDate() {
        return mDate;
    }

    public double getMagnitude() {
        return mMagnitude;
    }
}
