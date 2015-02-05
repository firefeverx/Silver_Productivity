package com.example.bernard.silver_productivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.app.AlertDialog;



public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_layout);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
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

    public void GoNextPage(View v)
    {
        int phoneNum = 0;
        boolean NumDigitsStatus;
        Intent i = new Intent(getApplicationContext(), SubActivity.class);


        //System.out.println("hihi");

        try {
            EditText eTextPhoneNum = (EditText) findViewById(R.id.txtPhoneNum);
            phoneNum = Integer.parseInt(eTextPhoneNum.getText().toString());
            NumDigitsStatus = CheckNumOfDigits(phoneNum);

            System.out.println("Phone Num status" + NumDigitsStatus);
            if(NumDigitsStatus == true)
            {
                startActivity(i);

            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());

        }


    }

    private boolean CheckNumOfDigits(int phoneNum)
    {
        AlertDialog alert = new AlertDialog.Builder(this).create();

        if(phoneNum >= 90000000 && phoneNum <= 99999999)
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
    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_main, container, false);
            return rootView;
        }
    }
}
