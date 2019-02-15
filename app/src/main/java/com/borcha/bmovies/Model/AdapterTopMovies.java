package com.borcha.bmovies.Model;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public class AdapterTopMovies extends ArrayAdapter<MyMovie> {


    public AdapterTopMovies(Context context, int resource, List<MyMovie> objects) {
        super(context, resource, objects);
    }
}
