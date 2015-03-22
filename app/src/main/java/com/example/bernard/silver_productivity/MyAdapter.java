package com.example.bernard.silver_productivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.bernard.silver_productivity.R;
import com.example.bernard.silver_productivity.entity.Poster;

import java.util.ArrayList;

class MyAdapter extends ArrayAdapter<Poster> {

    private String[] strPosts = new String[]{"How to cope stress?", "How to communicate with elderly?", "How to do well in studies?"};
    private String[] strLocation = new String[]{"Singapore", "Malaysia", "Singapore"};
    private String[] strComments = new String[]{"5", "4", "3"};
    private String[] strLikes = new String[]{"8", "1", "5"};
    ArrayList<Poster> posters = new ArrayList<Poster>();


    public MyAdapter(Context context, ArrayList<Poster> posters) {
        super(context, R.layout.row_layout);
        this.posters = posters;
        System.out.println (getCount());


    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        //LayoutInflater theInflater = LayoutInflater.from(getContext());
        View theView = convertView;
        if (theView == null){
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            theView = inflater.inflate(R.layout.row_layout, parent, false);
        }


        Poster poster = getItem(position);

        TextView theTextPoster = (TextView) theView.findViewById(R.id.txtPoster);

        TextView theTextLocation = (TextView) theView.findViewById(R.id.txtLocation);

        TextView theTextComments = (TextView) theView.findViewById(R.id.txtnumofcomments);

        TextView theTextLikes = (TextView) theView.findViewById(R.id.txtnumoflikes);

        theTextPoster.setText(poster.getTitle());

        theTextLocation.setText(poster.getLocation());

        theTextComments.setText(String.valueOf(poster.getNumberOfComment()));

        theTextLikes.setText(String.valueOf(poster.getNumberOfLike()));


        return theView;
    }

    @Override
    public int getCount() {
        return posters.size();
    }

    @Override
    public Poster getItem(int position) {
        return posters.get(position);
    }


}