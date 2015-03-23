package com.example.bernard.silver_productivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.app.AlertDialog;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    /**
     * Screen's Size
     */
    public static int screenHeight;
    public static int screenWidth;
    public static MainActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.container_layout);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new PlaceholderFragment())
                    .commit();
        }


        /*
		 * get Screen size
		 */
        getScreesize();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        View rootView = null;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            if (rootView == null) {
                rootView = inflater.inflate(R.layout.activity_main, container, false);
            }
            configButton(rootView);
            return rootView;
        }

        private void configButton(View rootView) {
            ImageView nextPageButton = (ImageView) rootView.findViewById(R.id.to_page_2);
            nextPageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goNextPage(v);
                }
            });
        }

        public void goNextPage(View v)
        {
            int phoneNum = 0;
            boolean NumDigitsStatus;
            // Intent i = new Intent(getApplicationContext(), listPoster.class);
            //Intent i = new Intent(getApplicationContext(), listPosters.class);

            //System.out.println("hihi");


            EditText eTextPhoneNum = (EditText) rootView.findViewById(R.id.txtPhoneNum);
            try {
                phoneNum = Integer.parseInt(eTextPhoneNum.getText().toString().trim());

                NumDigitsStatus = CheckNumOfDigits(phoneNum);
            }catch (Exception e){
                Toast.makeText(getActivity(), "Wrong format", Toast.LENGTH_LONG).show();
            }

            //System.out.println("Phone Num status" + NumDigitsStatus);
//            if(NumDigitsStatus == true)
//            {
            Fragment listPosterFragment = new listPoster();
            getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("page2")
                    .replace(R.id.container, listPosterFragment)
                    .commit();
//
//            }



        }

        private boolean CheckNumOfDigits(int phoneNum)
        {
            AlertDialog alert = new AlertDialog.Builder(getActivity()).create();

            if(phoneNum >= 80000000 && phoneNum <= 99999999)
            {
                return true;
            }
            else
            {

                alert.setTitle("Error");
                alert.setMessage("Please enter your 8 digits phone number.");
                alert.setButton("OK", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int which)
                    {


                    }

                });
                //alert.setIcon(R.drawable.icon);
                alert.show();
            }


            return false;
        }
    }

    /**
     * get screen's size;
     */
    private void getScreesize() {
        // Get the width and length of the screen
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenHeight = displayMetrics.heightPixels;
        screenWidth = displayMetrics.widthPixels;
    }
}
