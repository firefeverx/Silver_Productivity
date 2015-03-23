package com.example.bernard.silver_productivity.entity;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Bernard on 9/3/2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "posterManager",
    TABLE_CONTACTS = "poster",
    KEY_ID = "id",
    KEY_NAME = "name",
    KEY_PHONE = "phone",
    KEY_EMAIL = "email",
    KEY_ADDRESS = "address",
    KEY_IMAGEURL = "imageUri";

    public DatabaseHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
}
