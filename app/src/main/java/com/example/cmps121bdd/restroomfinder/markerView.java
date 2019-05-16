package com.example.cmps121bdd.restroomfinder;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class markerView implements GoogleMap.InfoWindowAdapter {

    Context context;
    LayoutInflater inflater;

    public markerView(Context context) {
        this.context = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // R.layout.echo_info_window is a layout in my
        // res/layout folder. You can provide your own
        View v = inflater.inflate(R.layout.activity_marker_view, null);

        TextView title = (TextView) v.findViewById(R.id.info_window_title);
        TextView subtitle = (TextView) v.findViewById(R.id.info_window_subtitle);
        title.setText(marker.getTitle());
        subtitle.setText(marker.getTitle());
        return v;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
}
