package com.example.bernard.silver_productivity.entity;

/**
 * Created by Bernard on 12/3/2015.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;


public class GetAllPoster  {

    // Progress Dialog
    private ProgressDialog pDialog;

    // Creating JSON Parser object
    //JSONParser jParser = new JSONParser();

    ArrayList<HashMap<String, String>> productsList;

    // url to get all products list
    private static String url_all_products = "http://api.androidhive.info/android_connect/get_all_products.php";

    public static final String WEBSERVICE = "http://10.0.2.2/test";

    private Gson gson = new Gson();

    // JSON Node names
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_PRODUCTS = "products";
    private static final String TAG_PID = "pid";
    private static final String TAG_NAME = "name";

    // products JSONArray
    JSONArray products = null;

    public void retrieveAllPoster() throws IOException
    {
        /*
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        // getting JSON string from URL
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://localhost/test/get_poster_details.php?id=1");
        HttpResponse httpResponse = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
        String result = "";
        while ((result = rd.readLine()) != null){

        }
        try {
            System.out.println("here" + result);
            JSONObject jsonObject = new JSONObject(result);
        } catch (Exception e){

        }
        */


        //private static final String FILENAME = "C:\\Users\\GuoLong\\Desktop\\ver3\\StraightA_app\\data\\User.txt";


//        String url = WEBSERVICE +"/?threadID="+threadID;
        String url = WEBSERVICE +"/?id=1";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, null, new AsyncHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] header, byte[] content, Throwable throwable) {
                //printErrorMessage(statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] header, byte[] content) {
                try {
                    List<Poster> planList = new ArrayList<Poster>();
                    String response = new String(content, "UTF-8");
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    Gson gson = gsonBuilder.create();
                    JsonParser parser = new JsonParser();
                    JsonArray data = parser.parse(response).getAsJsonArray();

                    Iterator<JsonElement> itr = data.iterator();

                    while (itr.hasNext()) {
                        JsonElement jsonElement = itr.next();
                        JsonObject object = jsonElement.getAsJsonObject();

                        Poster plan = gson.fromJson(object.get("poster"), Poster.class);
                        System.out.println("get " + plan.getContent());
                        //planList.add(plan);
                    }
                    //setChanged();
                    //notifyObservers(planList);

                }
                catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });


    }



//    @Override
//        public void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.all_products);
//
//            // Hashmap for ListView
//            productsList = new ArrayList<HashMap<String, String>>();
//
//            // Loading products in Background Thread
//            new LoadAllProducts().execute();
//
//        // Get listview
//        ListView lv = getListView();
//
//        // on seleting single product
//        // launching Edit Product Screen
//        lv.setOnItemClickListener(new OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                // getting values from selected ListItem
//                String pid = ((TextView) view.findViewById(R.id.pid)).getText()
//                        .toString();
//
//                // Starting new intent
//                Intent in = new Intent(getApplicationContext(),
//                        EditProductActivity.class);
//                // sending pid to next activity
//                in.putExtra(TAG_PID, pid);
//
//                // starting new activity and expecting some response back
//                startActivityForResult(in, 100);
//            }
//        });
//
//    }

    // Response from Edit Product Activity
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        // if result code 100
//        if (resultCode == 100) {
//            // if result code 100 is received
//            // means user edited/deleted product
//            // reload this screen again
//            Intent intent = getIntent();
//            finish();
//            startActivity(intent);
//        }
//
//    }


    /**
     * Background Async Task to Load all product by making HTTP Request
     * */

/*     class LoadAllProducts extends AsyncTask<String, String, String> {


          Before starting background thread Show Progress Dialog

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //pDialog = new ProgressDialog(AllProductsActivity.this);
            //pDialog.setMessage("Loading products. Please wait...");
            //pDialog.setIndeterminate(false);
            //pDialog.setCancelable(false);
            //pDialog.show();
        }


        // getting All products from url

        protected String doInBackground(String args) throws IOException {
            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            // getting JSON string from URL
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet("http://localhost/test/get_poster_details.php?id=1");
            HttpResponse httpResponse = client.execute(request);
            BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            String result = "";
            while ((result = rd.readLine()) != null){

            }
            try {
                JSONObject jsonObject = new JSONObject(result);
            } catch (Exception e){

            }

            /*
            // Check your log cat for JSON reponse
            Log.d("All Products: ", json.toString());

            try {
                // Checking for SUCCESS TAG
                int success = json.getInt(TAG_SUCCESS);

                if (success == 1) {
                    // products found
                    // Getting Array of Products
                    products = json.getJSONArray(TAG_PRODUCTS);

                    // looping through All Products
                    for (int i = 0; i < products.length(); i++) {
                        JSONObject c = products.getJSONObject(i);

                        // Storing each json item in variable
                        String id = c.getString(TAG_PID);
                        String name = c.getString(TAG_NAME);

                        // creating new HashMap
                        HashMap<String, String> map = new HashMap<String, String>();

                        // adding each child node to HashMap key => value
                        map.put(TAG_PID, id);
                        map.put(TAG_NAME, name);

                        // adding HashList to ArrayList
                        productsList.add(map);
                    }
                } else {
                    // no products found
                    // Launch Add New product Activity
                    Intent i = new Intent(getApplicationContext(),
                            NewProductActivity.class);
                    // Closing all previous activities
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
         /*
         protected void onPostExecute(String file_url) {
            // dismiss the dialog after getting all products
            pDialog.dismiss();
            // updating UI from Background Thread
            runOnUiThread(new Runnable() {
                public void run() {

                     //Updating parsed JSON data into ListView

                    ListAdapter adapter = new SimpleAdapter(
                            AllProductsActivity.this, productsList,
                            R.layout.list_item, new String[] { TAG_PID,
                            TAG_NAME},
                            new int[] { R.id.pid, R.id.name });
                    // updating listview
                    setListAdapter(adapter);
                }
            });

        }

    }*/
}
