package com.example.bernard.silver_productivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.bernard.silver_productivity.R;

class MyAdapter extends ArrayAdapter<String> {

    private String[] strPosts = new String[]{"How to cope stress?", "How to communicate with elderly?", "How to do well in studies?"};
    private String[] strLocation = new String[]{"Singapore", "Malaysia", "Singapore"};
    private String[] strComments = new String[]{"5", "4", "3"};
    private String[] strLikes = new String[]{"8", "1", "5"};



    public MyAdapter(Context context, String[] values) {
        super(context, R.layout.row_layout, values);


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater theInflater = LayoutInflater.from(getContext());

        View theView = theInflater.inflate(R.layout.row_layout, parent, false);

        String tvShow = getItem(position);

        TextView theTextPoster = (TextView) theView.findViewById(R.id.txtPoster);

        TextView theTextLocation = (TextView) theView.findViewById(R.id.txtLocation);

        TextView theTextComments = (TextView) theView.findViewById(R.id.txtnumofcomments);

        TextView theTextLikes = (TextView) theView.findViewById(R.id.txtnumoflikes);

        theTextPoster.setText(strPosts[position]);

        theTextLocation.setText(strLocation[position]);

        theTextComments.setText(strComments[position]);

        theTextLikes.setText(strLikes[position]);


        return theView;
    }
}