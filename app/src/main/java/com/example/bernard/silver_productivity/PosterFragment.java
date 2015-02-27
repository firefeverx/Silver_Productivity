package com.example.bernard.silver_productivity;

import android.app.Activity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bernard.silver_productivity.entity.Comment;
import com.example.bernard.silver_productivity.entity.Poster;

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PosterFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PosterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PosterFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

   // private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment PosterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PosterFragment newInstance() {
        PosterFragment fragment = new PosterFragment();
        return fragment;
    }

    public PosterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_poster, container,false);

        createTopLayout (rootView);
        createPostContentLayout (rootView);
        createAnswerLayout(rootView);
        createBottomLayout (rootView);
        return rootView;


    }

    /**
     * Create Answer Part
     * 1. List of answers
     * 1.1 Content of answers
     * 1.2 Time of submit
     * 1.3 Number of like
     * 1.4 Avatar
     * @param rootView
     */
    private void createAnswerLayout(View rootView) {
        ListView listAnswers = (ListView)rootView.findViewById(R.id.list_answer);

        ArrayList<Comment> comments = new ArrayList<Comment>();

        RelativeLayout contentAnswerLayout = (RelativeLayout) rootView.findViewById(R.id.content_answer_layout);
        contentAnswerLayout.getLayoutParams().height = MainActivity.screenHeight/2;

        //Toast.makeText(getActivity(), "ANSWER", Toast.LENGTH_LONG).show();
        Comment comment1 = new Comment();
        comment1.setContent("Content of comment 1");
        comment1.setNumberOfLike(1);
        comment1.setSubmitTime("Time 1");
        comments.add(comment1);


        Comment comment2 = new Comment();
        comment2.setContent("Content of comment 2");
        comment2.setNumberOfLike(2);
        comment2.setSubmitTime("Time 2");
        comments.add(comment2);

        Comment comment3 = new Comment();
        comment3.setContent("Content of comment 3");
        comment3.setNumberOfLike(3);
        comment3.setSubmitTime("Time 3");
        comments.add(comment3);

        Toast.makeText(getActivity(), String.valueOf(comments.size()), Toast.LENGTH_LONG).show();
        PosterFragmentAdapter adapter = new PosterFragmentAdapter(getActivity(),R.layout.fragment_poster,comments);
        listAnswers.setAdapter(adapter);


        listAnswers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }

    /**
     * Create Content of Poster Part
     * 1. Content of poster
     * 2. Number of likes
     * 3. Location of poster
     * 3. Time of submit
     * 4. Number of answers
     */
    private void createPostContentLayout(View rootView) {

        RelativeLayout postContentLayout = (RelativeLayout) rootView.findViewById(R.id.content_poster_layout);

        /*
        Set height of layout
         */
        postContentLayout.getLayoutParams().height = MainActivity.screenHeight/5;

        /*
        Create sample Poster
         */
        Poster poster = new Poster();
        poster.setNumberOfLike(14);
        poster.setContent("Sample Content of poster");
        poster.setAuthor("Sample Author of poster");
        poster.setNumberOfComment(3);
        poster.setTitle("Sample title of poster");
        poster.setLocation ("Sample Location of poster");
        poster.setTime ("14/2/2015");

        /*
        Number of Like layout
         */
        RelativeLayout numberLikeLayout = (RelativeLayout) rootView.findViewById(R.id.number_like_layout);
        numberLikeLayout.getLayoutParams().width = MainActivity.screenWidth/5;
        //Number of like
        TextView numberOfLike  = (TextView) rootView.findViewById(R.id.text_number_like);
        numberOfLike.setText(String.valueOf(poster.getNumberOfLike()));

        /*
        Content of poster layout
         */

        //numberLikeLayout.getLayoutParams().width = MainActivity.screenWidth/5;
        //Content
        TextView content = (TextView) rootView.findViewById(R.id.content_poster);
        content.setText(poster.getContent());

        //Location
        TextView location = (TextView) rootView.findViewById(R.id.location_text );
        location.getLayoutParams().width = MainActivity.screenWidth/5;
       // location.getLayoutParams().width = MainActivity.screenWidth/3;
        location.setText(poster.getLocation());

        //Time of submit
        TextView submitTime = (TextView) rootView.findViewById(R.id.submit_time_text);
        submitTime.getLayoutParams().width  = MainActivity.screenWidth/3;
        submitTime.setText(poster.getTime());

        //Number of answer
        TextView numberAnswer = (TextView) rootView.findViewById(R.id.num_answer);
        numberAnswer.getLayoutParams().width  = MainActivity.screenWidth/5;
        numberAnswer.setText(String.valueOf(poster.getNumberOfComment()));



    }

    /**
     * Create bottom layout of the fragment
     * 1. Comment Field
     * 2. Post Button
     * @param rootView
     */

    private void createBottomLayout(View rootView) {
        /*
        Comment Field
         */
        final EditText commentField = (EditText) rootView.findViewById(R.id.comment_poster);
        commentField.getLayoutParams().width = MainActivity.screenWidth/5*4;

        /*
        Post button
         */
        Button postButton = (Button) rootView.findViewById(R.id.submit_poster);

        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = commentField.getText().toString();
                sendResultToDatabase();
            }
        });
    }

    /*
    Send the result to database. Use some function from API
     */
    private void sendResultToDatabase() {


    }

    /**
     * Create top layout of the fragment
     * 1. Back button
     * 2. Title of fragment
     * 3. Response button
     * @param rootView
     *
     *
     */
    private void createTopLayout(View rootView) {

        /*
        Back Button
        When button clicked , go back to general poster page
         */
        ImageView backButton = (ImageView) rootView.findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        /*
        Title of fragment
         */

        TextView title = (TextView) rootView.findViewById(R.id.location_poster);

        /*
        Response Button
        When button click, go to fragment response (page 4)
         */
        ImageView responseButton = (ImageView) rootView.findViewById(R.id.response_poster_button);
        responseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Go to Response Fragment
                 */
                Page4 responseFragment = new Page4();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("page4");
                fragmentTransaction.replace(R.id.container, responseFragment).commit();
            }
        });


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        try {
//            mListener = (OnFragmentInteractionListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
