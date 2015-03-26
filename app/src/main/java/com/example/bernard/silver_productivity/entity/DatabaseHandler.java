package com.example.bernard.silver_productivity.entity;

import android.content.Context;
import android.content.SyncRequest;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.SyncHttpClient;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;


/**
 * Created by Bernard on 9/3/2015.
 */
public class DatabaseHandler extends Observable {

//    private static final int DATABASE_VERSION = 1;
//
//    private static final String DATABASE_NAME = "posterManager",
//    TABLE_CONTACTS = "poster",
//    KEY_ID = "id",
//    KEY_NAME = "name",
//    KEY_PHONE = "phone",
//    KEY_EMAIL = "email",
//    KEY_ADDRESS = "address",
//    KEY_IMAGEURL = "imageUri";

    public static final String WEBSERVICE = "http://10.0.2.2/Silver";
    private static final String FILENAME = "C:\\Users\\GuoLong\\Desktop\\ver3\\StraightA_app\\data\\User.txt";
    public static ArrayList<Poster> tmpposterList = new ArrayList<Poster>();

    private Gson gson = new Gson();

    public DatabaseHandler() {
        //super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private void printErrorMessage(int statusCode) {
        String errorMessage = "Error : ";
        if (statusCode == 404) {
            errorMessage += "Requested resource not found";
        } else if (statusCode == 500) {
            errorMessage += "Something went wrong at server end";
        } else {
            errorMessage += "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet or remote server is not up and running]";
        }
        //setChanged();
        //notifyObservers(errorMessage);
    }

    public void getForumPostByThread(int threadID) throws Exception {
        System.out.println("1 getforum");
        String url = WEBSERVICE + "/get_poster_details.php?id=" + threadID;
        //AsyncHttpClient client = new AsyncHttpClient();

//        HttpClient client = new DefaultHttpClient();
//        System.out.println("before request ");
//        HttpGet request = new HttpGet("http://localhost/Silver/get_poster_details.php?id=1");
//
//        HttpResponse httpResponse = null;
//        //HttpGet request = new HttpGet(url);
//        try {
//            httpResponse = client.execute(request);
//        }catch (Exception e)
//        {
//            System.out.println("httpres error " + e.getMessage());
//        }
//        System.out.println("after request ");
//        BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
//        String result = "";
//        System.out.println("before read");
//        while ((result = rd.readLine()) != null){
//            System.out.println(result);
//        }
//        try {
//            JSONObject jsonObject = new JSONObject("stop " + result);
//        } catch (Exception e){
//            System.out.println("error " + e.getMessage());
//        }

//        HttpClient client = new DefaultHttpClient();
//
//        try
//        {
//            String SetServerString = "";
//
//            // Create Request to server and get response
//
//            System.out.println("2 request");
//            HttpGet httpget = new HttpGet("http://localhost/Silver/get_poster_details.php?id=1");
//            ResponseHandler<String> responseHandler = new BasicResponseHandler();
//            SetServerString = client.execute(httpget, responseHandler);
//
//            System.out.println("here " + SetServerString);
//
//        }
//        catch(Exception ex)
//        {
//            System.out.println("Fail! " + ex.getMessage());
//        }

//        List<NameValuePair> params = new ArrayList<NameValuePair>();
//        // getting JSON string from URL
//        HttpClient client = new DefaultHttpClient();
//        HttpGet request = new HttpGet("http://10.0.2.2/Silver/get_poster_details.php?id=1");
//        HttpResponse httpResponse = client.execute(request);
//        BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
//        String result = "";
//        while ((result = rd.readLine()) != null){
//            System.out.println("reading " + result);
//        }
//        try {
//
//            JSONObject jsonObject = new JSONObject(result);
//        } catch (Exception e){
//
//        }


        AsyncHttpClient client = new AsyncHttpClient();

        client.get(url, null, new AsyncHttpResponseHandler() {


            @Override
            public void onFailure(int statusCode, Header[] header, byte[] content, Throwable throwable) {
                System.out.println("2 " + statusCode);
                printErrorMessage(statusCode);


            }

            @Override
            public void onSuccess(int statusCode, Header[] header, byte[] content) {
                System.out.println("3");
                System.out.println(" success ");


                try {
                    //List<ForumPost> planList = new ArrayList<ForumPost>();
                    List<Poster> posterList = new ArrayList<Poster>();
                    String response = new String(content, "UTF-8");
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    Gson gson = gsonBuilder.create();
                    JsonParser parser = new JsonParser();
                    System.out.println("here " + response);
                    JsonArray data = parser.parse(response).getAsJsonArray();
                    //Poster poster = null;
                    //ArrayList<Comment> listcomment = null;

                    System.out.println("testget " + data.size());

                    if(data != null)
                    {
                        for (int i = 0; i < data.size(); i++)
                        {
                            System.out.println("looping ");
                            JsonObject jObject = data.get(i).getAsJsonObject();
                            //System.out.println("output: " + jObject.get("poster").getAsJsonObject().get("title"));
                           Poster poster = new Poster();
//
//                            System.out.print("before ");
//                        //jObject
                        poster.setId(jObject.get("poster").getAsJsonObject().get("id").toString());
//                            System.out.print("after ");
                        poster.setTitle(jObject.get("poster").getAsJsonObject().get("title").toString());
//
                        poster.setContent(jObject.get("poster").getAsJsonObject().get("content").toString());
//                        //poster.setComments(jObject.get(""));
//
                        poster.setAuthor(jObject.get("poster").getAsJsonObject().get("author").toString());
                        poster.setLocation(jObject.get("poster").getAsJsonObject().get("location").toString());
                        poster.setTime(jObject.get("poster").getAsJsonObject().get("time").toString());
                        poster.setNumberOfLike(Integer.parseInt(jObject.get("poster").getAsJsonObject().get("likes").getAsString()));
                        poster.setNumberOfComment(Integer.parseInt(jObject.get("poster").getAsJsonObject().get("comments").getAsString()));
//
                        ArrayList <Comment> listcomment = new ArrayList<Comment>();
                        Comment comment = new Comment();
                        comment.setContent(jObject.get("poster").getAsJsonObject().get("comments").toString());

                        listcomment.add(comment);

                        poster.setComments(listcomment);

//
                        posterList.add(poster);

                        tmpposterList.add(poster);
                            System.out.println("before exit loop " + tmpposterList.get(0).getContent());


                        }
                        System.out.println("exit loop " + posterList.get(0).getId());
                    }
//                    for (JsonElement element : data){
//                        System.out.print("entering ");
//                        poster = new Poster();
//                        JsonObject jObject = element.getAsJsonObject();
//                        //System.out.println ("OBJECT " + jObject.get("poster").getAsJsonObject().get("id"));
//                        //jObject
//                        poster.setId(jObject.get("poster").getAsJsonObject().get("id").toString());
//                        poster.setTitle(jObject.get("poster").getAsJsonObject().get("title").toString());
//
//                        poster.setContent(jObject.get("poster").getAsJsonObject().get("content").toString());
//                        //poster.setComments(jObject.get(""));
//
//                        poster.setAuthor(jObject.get("poster").getAsJsonObject().get("author").toString());
//                        poster.setLocation(jObject.get("poster").getAsJsonObject().get("location").toString());
//                        poster.setTime(jObject.get("poster").getAsJsonObject().get("time").toString());
//
//                        listcomment = new ArrayList<Comment>();
//                        Comment comment = new Comment();
//                        comment.setContent(jObject.get("poster").getAsJsonObject().get("comments").toString());
//                        listcomment.add(comment);
//
//                        posterList.add(poster);
//                        tmpposterList.add(poster);
//
//                        System.out.print("looping ");
//                    }

//                    Iterator<JsonElement> itr = data.iterator();
//                    //System.out.println("inside");
//                    while (itr.hasNext()) {
//                        JsonElement jsonElement = itr.next();
//                        JsonObject object = jsonElement.getAsJsonObject();
//                        Poster poster = gson.fromJson(object.get("poster"), Poster.class);
//                        posterList.add(poster);
//                        System.out.println("testget " + poster.getContent());
//                    }

                    //tmpposterList = posterList;
                    System.out.println("size " + tmpposterList.size());

                    setChanged();
                    notifyObservers(posterList);
                    }
                    catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }


            }

        }
        );


//Select * from forumpost where userName=?
//Select * from forumthread where category=?

//        List<ForumPost> result = new ArrayList<ForumPost>();
//        ForumDAO forumDAO = new ForumDAO();
//        result = forumDAO.getPost(threadID);
        //return tmpposterList;


    }


}