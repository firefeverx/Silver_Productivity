package com.example.bernard.silver_productivity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class listPoster extends Fragment {


    //public static listPoster activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity = this;
        View rootView = inflater.inflate(R.layout.activity_list_poster, container, false);
        // setContentView(R.layout.activity_list_poster);


        //to here.

        //try {

            String[] strPosts = new String[]{"How to cope stress?", "How to communicate with elderly?", "How to do well in studies?"};
            String[] strLocation = new String[]{"Singapore", "Malaysia", "Singapore"};

//            ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strPosts);
//           ListAdapter adapterSec = new ArrayAdapter<String>(this, R.layout.row_layout, R.id.txtLocation, strLocation);

            ListAdapter adapter = new MyAdapter(getActivity(), strPosts);


            //ListAdapter adapterSec = new MyAdapter(this, strLocation);

            ListView ListPost = (ListView) rootView.findViewById(R.id.listItemPosts);


            ListPost.setAdapter(adapter);

//            ListPost.setAdapter(adapterSec);

            ListPost.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    String listPostPicked = "you picked " + String.valueOf(adapterView.getItemAtPosition(position));

                    Toast.makeText(getActivity(), listPostPicked, Toast.LENGTH_SHORT).show();
                }
            });

        //} catch (Exception ex) {
        //    System.out.println(ex.getMessage());
        //}

        return rootView;
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

