package com.example.bernard.silver_productivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bernard.silver_productivity.entity.Comment;

import java.util.ArrayList;


/**
 * Created by LEBAO_000 on 12/02/2015.
 */
public class CommentAnswerAdapter extends ArrayAdapter<Comment> {
//
    private static CommentAnswerAdapter instance = null;
    private ArrayList<Comment> comments = new ArrayList<Comment>();
    private Comment comment;

    public CommentAnswerAdapter(Context context, int resource, ArrayList<Comment> comments){
        super (context, resource);
        this.comments = comments;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null){
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.single_answer_layout, parent, false);
        }

        comment = comments.get(position);
       // Toast.makeText(MainActivity.activity, "ADAPTER", Toast.LENGTH_LONG).show();
        setLayoutInformation(v);
        return v;
    }

    /**
     * Ser Information layout of adapter
     * @param v
     */
    private void setLayoutInformation(View v){

        int height;
        RelativeLayout commentLayout = (RelativeLayout) v.findViewById(R.id.single_answer_layout);
        commentLayout.getLayoutParams().height = MainActivity.screenHeight/3;

        setHeadPortrait(v);
        setAnswerLayout(v);
    }

    /**
     * Set the Head Portrait of the answer
     */
    private void setHeadPortrait(View v){
        ImageView headPortraitImage = (ImageView) v.findViewById(R.id.head_portrait_answer);
        //headPortraitImage.setImageResource(R.drawable.header_image);
        headPortraitImage.getLayoutParams().height = MainActivity.screenHeight/6;
        headPortraitImage.getLayoutParams().height = MainActivity.screenHeight/6;

    }

    private void setAnswerLayout(View v){
        /*
        Content of answer
         */
        TextView contentAnswer = (TextView) v.findViewById(R.id.content_answer_text);
        contentAnswer.setText(comment.getContent());
       // contentAnswer.setText("Content of Comment");

        /*
        Time of submit
         */
        TextView submitTime = (TextView) v.findViewById(R.id.answer_time_submit);
        submitTime.setText(comment.getSubmitTime());

        /*
        Number of Like
         */
        TextView numberLikeText = (TextView) v.findViewById(R.id.number_like_number);
        numberLikeText.setText(String.valueOf(comment.getNumberOfLike()));
        ImageView numberLikeImage = (ImageView) v.findViewById(R.id.number_like_image);
    }

    @Override
    public int getCount() {
        return comments.size();
    }

    @Override
    public Comment getItem(int position) {
        return comments.get(position);
    }


}
