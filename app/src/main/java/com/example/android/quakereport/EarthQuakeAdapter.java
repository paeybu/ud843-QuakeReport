package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

public class EarthQuakeAdapter extends ArrayAdapter<Earthquake> {
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
        Earthquake earthQuake = getItem(position);

        TextView magTv = (TextView) listItemView.findViewById(R.id.magTv);
        TextView offsetTv = (TextView) listItemView.findViewById(R.id.offsetTv);
        TextView locTv = (TextView) listItemView.findViewById(R.id.locTv);
        TextView dateTv = (TextView) listItemView.findViewById(R.id.dateTv);
        TextView timeTv = (TextView) listItemView.findViewById(R.id.timeTv);

        Double magnitude = earthQuake.getMagnitude();
        DecimalFormat formatter = new DecimalFormat("0.0");
        String magnitudeString = formatter.format(magnitude);

        magTv.setText(magnitudeString);
        String place = earthQuake.getPlace();
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
        dateTv.setText(earthQuake.getDate());
        timeTv.setText(earthQuake.getTime());

        return listItemView;
    }
}
