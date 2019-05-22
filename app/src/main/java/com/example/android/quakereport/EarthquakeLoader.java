package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private String mRequestUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mRequestUrl = url;
    }

    @Override
    public List<Earthquake> loadInBackground() {
        return QueryUtils.feathEarthquakeData(mRequestUrl);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
