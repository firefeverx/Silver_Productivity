package com.example.bernard.silver_productivity;

import android.content.Context;
import android.test.RenamingDelegatingContext;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bernard.silver_productivity.entity.Poster;

import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * Created by LEBAO_000 on 12/02/2015.
 */
public class PosterFragmentAdapter extends ArrayAdapter<Poster> {

    private static PosterFragmentAdapter instance = null;
    private ArrayList<Poster> posters = new ArrayList<Poster>();

    public PosterFragmentAdapter(Context context, int resource, ArrayList<Poster> posters){
        super (context, resource);
        this.posters = posters;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null){
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.single_answer_layout, parent, false);
        }


        setLayoutInformation(v);
        return v;
    }

    /**
     * Ser Information layout of adapter
     * @param v
     */
    private void setLayoutInformation(View v){
        setHeadPortrait(v);
        setAnswerLayout(v);
    }

    /**
     * Set the Head Portrait of the answer
     */
    private void setHeadPortrait(View v){
        ImageView headPortraitImage = (ImageView) v.findViewById(R.id.head_portrait_answer);


    }

    private void setAnswerLayout(View v){
        /*
        Content of answer
         */
        TextView contentAnswer = (TextView) v.findViewById(R.id.content_answer_text);

        /*
        Time of submit
         */
        TextView submitTime = (TextView) v.findViewById(R.id.submit_time_text);

        /*
        Number of Like
         */
        TextView numberLikeText = (TextView) v.findViewById(R.id.number_like_number);

        ImageView numberLikeImage = (ImageView) v.findViewById(R.id.number_like_image);
    }

}
