package com.example.bernard.silver_productivity;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.bernard.silver_productivity.entity.Poster;

import java.util.List;

/**
 * Created by ngolebaoloc on 26/03/15.
 */
public class ListPosterAdapter extends ArrayAdapter<Poster> {
    public ListPosterAdapter(Context context, int resource, List<Poster> objects) {
        super(context, resource, objects);
    }
}
