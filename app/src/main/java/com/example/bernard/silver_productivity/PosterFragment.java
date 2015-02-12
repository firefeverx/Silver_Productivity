package com.example.bernard.silver_productivity;

import android.app.Activity;

import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


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
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
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
