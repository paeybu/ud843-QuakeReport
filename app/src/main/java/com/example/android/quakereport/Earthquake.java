package com.example.android.quakereport;

class Earthquake {
    private double mMagnitude;
    private String mPlace;
    private int mTime;


    public Earthquake(double magnitude, String place, int time) {
        mMagnitude = magnitude;
        mPlace = place;
        mTime = time;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getPlace() {
        return mPlace;
    }

    public int getTime() {
        return mTime;
    }
}
