package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

public class EarthQuakeAdapter extends ArrayAdapter<Earthquake> {
    private static final String LOG_TAG = EarthQuakeAdapter.class.getSimpleName();
    private Context mContext;
    public EarthQuakeAdapter(@NonNull Context context, int resource, @NonNull List<Earthquake> objects) {
        super(context, resource, objects);
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Earthquake currentEarthquake = getItem(position);

        TextView magTv = (TextView) listItemView.findViewById(R.id.magTv);
        TextView offsetTv = (TextView) listItemView.findViewById(R.id.offsetTv);
        TextView locTv = (TextView) listItemView.findViewById(R.id.locTv);
        TextView dateTv = (TextView) listItemView.findViewById(R.id.dateTv);
        TextView timeTv = (TextView) listItemView.findViewById(R.id.timeTv);

        Double magnitude = currentEarthquake.getMagnitude();
        DecimalFormat formatter = new DecimalFormat("0.0");
        String magnitudeString = formatter.format(magnitude);

        magTv.setText(magnitudeString);
        String place = currentEarthquake.getPlace();
        String[] parts = place.split("of");
        String offset= "";
        String location = "";
        if (place.contains("of")) {
            offset = parts[0] + "of";
            location = parts[1].substring(1);
        } else {
            offset = "Near the";
            location = parts[0];
        }

        offsetTv.setText(offset);
        locTv.setText(location);
        dateTv.setText(currentEarthquake.getDate());
        timeTv.setText(currentEarthquake.getTime());

        GradientDrawable magnitudeCircle = (GradientDrawable) magTv.getBackground();

        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magInt = (int) Math.floor(magnitude);
        int magnitudeColor;
        Log.v(LOG_TAG, "magInt = " + magInt);

        switch (magInt) {
            case 0:
            case 1:
                magnitudeColor = R.color.magnitude1;
                break;
            case 2:
                magnitudeColor = R.color.magnitude2;
                break;
            case 3:
                magnitudeColor = R.color.magnitude3;
                break;
            case 4:
                magnitudeColor = R.color.magnitude4;
                break;
            case 5:
                magnitudeColor = R.color.magnitude5;
                break;
            case 6:
                magnitudeColor = R.color.magnitude6;
                break;
            case 7:
                magnitudeColor = R.color.magnitude7;
                break;
            case 8:
                magnitudeColor = R.color.magnitude8;
                break;
            case 9:
                magnitudeColor = R.color.magnitude9;
                break;
            default:
                magnitudeColor = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColor);
    }
}
