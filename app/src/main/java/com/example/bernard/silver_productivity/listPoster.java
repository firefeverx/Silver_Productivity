package com.example.bernard.silver_productivity;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bernard.silver_productivity.entity.DatabaseHandler;
import com.example.bernard.silver_productivity.entity.Poster;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class listPoster extends Fragment implements Observer, AdapterView.OnItemClickListener {


    //public static listPoster activity;
    private static boolean refreshstatus = false;
    private List<Poster> posterList;
    private MyAdapter adapter;
    DatabaseHandler db = new DatabaseHandler();
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            //activity = this;
            rootView = inflater.inflate(R.layout.activity_list_poster, container, false);
            // setContentView(R.layout.activity_list_poster);

            if(refreshstatus == false) {
            //to here.

            //try {
            ArrayList<Poster> posters = new ArrayList<Poster>();
//            Poster poster1 = new Poster("How to cope stress?", "Singapore", 5, 8);
//            Poster poster2 = new Poster("How to communicate with elderly?", "Malaysia", 4, 1);
//            Poster poster3 = new Poster("How to do well in studies?", "Singapore", 3, 5);
//            Poster poster4 = new Poster("How to do well in studies?", "Singapore", 3, 5);
//            Poster poster5 = new Poster("How to do well in studies?", "Singapore", 3, 5);
//            Poster poster6 = new Poster("How to do well in studies?", "Singapore", 3, 5);
//            Poster poster7 = new Poster("How to do well in studies?", "Singapore", 3, 5);
//            Poster poster8 = new Poster("How to do well in studies?", "Singapore", 3, 5);
//            Poster poster9 = new Poster("How to do well in studies?", "Singapore", 3, 5);
//            posters.add(poster1);
//            posters.add(poster2);
//            posters.add(poster3);
//            posters.add(poster4);
//            posters.add(poster5);
//            posters.add(poster6);
//            posters.add(poster7);
//            posters.add(poster8);
//            posters.add(poster9);

            String[] strPosts = new String[]{"How to cope stress?", "How to communicate with elderly?", "How to do well in studies?"};
            String[] strLocation = new String[]{"Singapore", "Malaysia", "Singapore"};

//            ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strPosts);
//           ListAdapter adapterSec = new ArrayAdapter<String>(this, R.layout.row_layout, R.id.txtLocation, strLocation);

            //ListAdapter adapter = new MyAdapter(getActivity(), posters);
            ListView listPosters = (ListView) rootView.findViewById(R.id.listItemPosts);
//        MyAdapter adapter = new MyAdapter(getActivity(),R.layout.activity_list_poster, posters);


                DatabaseHandler db = new DatabaseHandler();
                db.addObserver(this);

            //List<Poster> tmp = db.getForumPostByThread(1);
                //String returned = null;
                try {
                    //db.getForumPostByThread(1);
                    db.getAllPoster();

                    System.out.println("i am here size " + DatabaseHandler.tmpposterList.get(0).getContent());

//                    MyAdapter adapter = new MyAdapter(getActivity(), DatabaseHandler.tmpposterList);
//
//                    listPosters.setAdapter(adapter);
                    //System.out.println("testing " + returned);
                }catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }





            //refreshstatus = true;

//                for(int i = 0; i< db.tmpposterList.size(); i++)
//                {
//                    Poster post = new Poster(db.tmpposterList.get(i).getContent().toString(), db.tmpposterList.get(i).getLocation(), db.tmpposterList.get(i).getNumberOfComment(), db.tmpposterList.get(i).getNumberOfLike());
//                    posters.add(post);
//                    System.out.println(db.tmpposterList.get(i).getContent().toString());
//                }

            //System.out.print("tmp " + tmp.get(0).getAuthor());
            //MyAdapter adapter = new MyAdapter(getActivity(), posters);


//            MyAdapter adapter = new MyAdapter(getActivity(), posters);
//
//            listPosters.setAdapter(adapter);


            listPosters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            });
        }

        //ListAdapter adapterSec = new MyAdapter(this, strLocation);

        //ListView ListPost = (ListView) rootView.findViewById(R.id.list_poster);




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

    @Override
    public void update(Observable observable, Object data) {
        try {
            if (data instanceof String){
                String result = (String)data;
                Toast.makeText(getActivity().getApplicationContext(), result, Toast.LENGTH_LONG).show();
            }
            else {
                if (data != null  ) {
                    posterList = (List<Poster>)data;

                    if (posterList != null) {
                        //this.forumPostList = listForumPost;
                        //for(Object o: forumPostList) {
                        //Toast.makeText(getActivity().getApplicationContext(), ((ForumPost)o).toString(), Toast.LENGTH_LONG).show();
                        //}
                        adapter =  new MyAdapter(getActivity(), DatabaseHandler.tmpposterList);

                        ListView listPosters = (ListView) rootView.findViewById(R.id.listItemPosts);
                        listPosters.setAdapter(adapter);
                        listPosters.setOnItemClickListener(this);
//                        ListView listView = (ListView) getView().findViewById(R.id.listForum);
//                        listView.setAdapter(customAdapter);
                        //listView.setOnItemClickListener(this);
                    }
                }
            }
        }
        catch (Exception ex) {
            Toast.makeText(getActivity().getApplicationContext(), "Something went wrong while processing request..", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

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

    private class loadDataBackground extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... params) {
            try {
                db.getForumPostByThread(1);
                //System.out.println("testing " + returned);
            }catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            return null;
        }
    }
}

