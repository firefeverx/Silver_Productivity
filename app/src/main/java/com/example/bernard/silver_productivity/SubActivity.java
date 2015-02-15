package com.example.bernard.silver_productivity;

import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class SubActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_layout);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

//        try {
//            ListOutPost();
//        }catch (Exception ex)
//        {
//            System.out.println(ex.getMessage());
//        }

        try {

        String[] strPosts = new String[]{"1sdfsdf", "2.dfsdfsdf"};

        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strPosts);

        ListView ListPost = (ListView) findViewById(R.id.listPost);

        ListPost.setAdapter(adapter);

        ListPost.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String listPostPicked = "you picked " + String.valueOf(adapterView.getItemAtPosition(position));

                Toast.makeText(SubActivity.this, listPostPicked, Toast.LENGTH_SHORT).show();
            }
        });

        }catch (Exception ex)
        {

        }

//        theListPost.setOnClickListener(new AdapterView.OnItemClickListener() {
//
//        }
//
//        @Override
//        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//
//            String listPostPicked = "you picked " + String.valueOf(adapterView.getItemAtPosition(position));
//
//            Toast.makeText(SubActivity.this, listPostPicked, Toast.LENGTH_SHORT).show();
//        }
//    });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sub, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_sub, container, false);

            /*
            Config Friend Button
             */
            Button buttonFriend = (Button) rootView.findViewById(R.id.btnfriends);
            buttonFriend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Fragment posterFragment = new PosterFragment();
                    FragmentTransaction fragmentTransaction = getActivity()
                            .getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container, posterFragment).commit();
                }
            });
            return rootView;
        }
    }
}

    //public void GoFriendsPage(View v) {
        //Intent i = new Intent(getApplicationContext(), PosterFragment.class);
        //startActivity(i);

//        Fragment posterFragment = new Fragment();
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.container, posterFragment).commit();

//        Fragment posterFragment = new Fragment();
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.activity_sub, posterFragment).commit();
//>>>>>>> origin/master

    //}

//    public void ListOutPost() {
//
//
//
//}




