package com.example.bernard.silver_productivity;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bernard.silver_productivity.entity.Comment;
import com.example.bernard.silver_productivity.entity.DatabaseHandler;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Page4.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Page4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Page4 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final int MAX_TEXT_COUNT = 150;

    String result;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String questionId;

    //private OnFragmentInteractionListener mListener;

    EditText inputText;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Page4.
     */
    // TODO: Rename and change types and number of parameters
    public static Page4 newInstance(String param1, String param2) {
        Page4 fragment = new Page4();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Page4() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            questionId = getArguments().getString("qid");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_page4, container, false);

        configInputText (rootView);
        configButton (rootView);



        return rootView;
    }

    /**
     * Config Button
     * 1. Cancel button
     * 2. Submit button
     * @param rootView
     */
    private void configButton(View rootView) {
        /*
        Cancel Button
         */
        Button cancelButton  = (Button) rootView.findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

        /*
        Submit Button
         */
        Button submitButton = (Button) rootView.findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contentInput = inputText.getText().toString();
                DatabaseHandler databaseHandler = DatabaseHandler.getInstance();
                Comment comment = new Comment();
                comment.setContent(result);
                try {
                    questionId = questionId.replace("\"","");
                    databaseHandler.addComments(comment,questionId);
                    PosterFragment posterFragment = new PosterFragment();
                    int objectPosition = getArguments().getInt("position");
                    Bundle bundle = new Bundle();
                    bundle.putInt("postion",objectPosition);
                    posterFragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.container,posterFragment)
                            .addToBackStack("posterFragment").commit();
                    Toast.makeText(getActivity(),"CLIKED", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
              //  Toast.makeText(MainActivity.activity, "Submit: " + contentInput.Toast.LENGTH_LONG).show();
            }
        });


    }

    /**
     * Config Input text
     * 1. Edit Text
     * 2. Remaining Text Count
     * @param rootView
     */
    private void configInputText (View rootView){

        /*
        Remain TextCount
         */
        final TextView remainTextCount = (TextView) rootView.findViewById(R.id.remain_count_text);

        /*
        Input text
         */
        InputMethodManager imgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imgr.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        inputText = (EditText) rootView.findViewById(R.id.content_input);
        inputText.requestFocus();   
        inputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                   remainTextCount.setText(String.valueOf(MAX_TEXT_COUNT-count) + "characters remaining");
                    result = String.valueOf(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });





    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
//
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        try {
//            mListener = (OnFragmentInteractionListener) activity;
//        } cif (mListener != null) {
////            mListener.onFragmentInteraction(uri);
////        }atch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
 //                   + " must implement OnFragmentInteractionListener");
   //     }
    }

    @Override
    public void onDetach() {
        super.onDetach();
       // mListener = null;
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
