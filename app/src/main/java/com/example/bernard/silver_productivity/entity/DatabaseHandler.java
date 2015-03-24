package com.example.bernard.silver_productivity.entity;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Bernard on 9/3/2015.
 */
public class DatabaseHandler  {

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
    private static List<Poster> tmpposterList  = new ArrayList<Poster>();
    private Gson gson = new Gson();

    public DatabaseHandler() {
        //super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private void printErrorMessage(int statusCode) {
        String errorMessage = "Error : ";
        if(statusCode == 404) {
            errorMessage += "Requested resource not found";
        }
        else if(statusCode == 500) {
            errorMessage += "Something went wrong at server end";
        }
        else {
            errorMessage += "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet or remote server is not up and running]";
        }
        //setChanged();
        //notifyObservers(errorMessage);
    }

    public void getForumPostByThread(int threadID)
    {
        System.out.println("1 getforum");
        String url = WEBSERVICE +"/get_poster_details.php?id="+threadID;
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


                    Iterator<JsonElement> itr = data.iterator();

                    //while (itr.hasNext()) {
                        JsonElement jsonElement = itr.next();
                        JsonObject object = jsonElement.getAsJsonObject();
                        Poster poster = gson.fromJson(object.get("poster"), Poster.class);
                        posterList.add(poster);
                        System.out.println("testget " + itr.next().toString());
                    //}

                    //tmpposterList = posterList;
                    //setChanged();
                    //notifyObservers(planList);


                }
                catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });
//Select * from forumpost where userName=?
//Select * from forumthread where category=?

//        List<ForumPost> result = new ArrayList<ForumPost>();
//        ForumDAO forumDAO = new ForumDAO();
//        result = forumDAO.getPost(threadID);
            //return tmpposterList;
    }


}
