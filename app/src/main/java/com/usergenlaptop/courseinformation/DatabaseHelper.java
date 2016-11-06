package com.usergenlaptop.courseinformation;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    private static final String     DATABASE_NAME           = "COURSE_DB.DB";
    private static final int        DATABASE_VERSION        = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Inner class that defines the table contents
    public static class Course implements BaseColumns {
        public static final String     TABLE_NAME              = "COURSE";
        public static final String     COURSE_LABEL            = "NAME";
        public static final String     TERM                    = "TERM";
        public static final String     COURSE_NAME             = "COURSE_NAME";
        public static final String     COURSE_DESCRIPTION      = "COURSE_DESCRIPTION";
    }
    private static final String     SQL_CREATE_COURSE =
            "CREATE TABLE IF NOT EXISTS "                                                     +
                    Course.TABLE_NAME                                                         +
                    " ("                                                                      +
                    Course._ID                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "    +
                    Course.COURSE_LABEL           + " TEXT NOT NULL, "                        +
                    Course.TERM                   + " TEXT NOT NULL, "                        +
                    Course.COURSE_NAME            + " TEXT NOT NULL, "                        +
                    Course.COURSE_DESCRIPTION     + " TEXT NOT NULL "                         +
                    ")";

    private static final String     SQL_DELETE_COURSE =
            "DROP TABLE IF EXISTS " + Course.TABLE_NAME;

    @Override
    public void onConfigure(final SQLiteDatabase db) {
        super.onConfigure(db);
        //setWriteAheadLoggingEnabled(true);
        //db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_COURSE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_COURSE);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}