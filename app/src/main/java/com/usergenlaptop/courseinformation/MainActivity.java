package com.usergenlaptop.courseinformation;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends ListActivity {

    private ListView                listView;
    private String                  termSelected; //1-4
    private Intent                  intent;
    private SQLiteDatabase          db;
    private DatabaseHelper          databaseHelper;
    private ArrayList<String>       terms;

    private ArrayList<String> courseDescription = new ArrayList<>();
    private ArrayList<String> courseName = new ArrayList<>();
    private ArrayList<String> courseLabel = new ArrayList<>();
    private ArrayList<String> courseTerms = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jsonRequest();
    }

    private AdapterView.OnItemClickListener termClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            termSelected = (String) parent.getItemAtPosition(position);
            intent.putExtra("termSelected", termSelected);
            startActivity(intent);
        }
    };

    private void getData() {
        db = databaseHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                DatabaseHelper.Course.TERM
        };

        Cursor cursor = db.query(
                true,
                DatabaseHelper.Course.TABLE_NAME,         // The table to query
                projection,                               // The columns to return
                null,                                     // The columns for the WHERE clause
                null,                                     // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null,                                     // The sort order
                null,
                null
        );

        // For each row, you can read a column's value by calling one of the Cursor get methods, such as getString() or getLong().
        // For each of the get methods, you must pass the index position of the column you desire, which you can get by calling getColumnIndex() or getColumnIndexOrThrow().
        try {
            while (cursor.moveToNext()) {
                terms.add(cursor.getString(cursor.getColumnIndex(DatabaseHelper.Course.TERM)));
            }
        }
        finally {
            cursor.close();
            db.close();
        }
    }

    private void initializeDB() {
        //Show all tables in current database
        showTables();

        //Drop Table in current DB
        //dropTable();

        //Check if table is already initalized
        if (verifyDBPopulated() == 0) {
            bulkInsert();
        }
        Log.d("X", "Num of rows:" + verifyDBPopulated());
    }

    private void dropTable() {
        db = databaseHelper.getReadableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseHelper.Course.TABLE_NAME);
        db.close();
    }

    public void showTables() {
        db = databaseHelper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
        if (c.moveToFirst()) {
            while ( !c.isAfterLast() ) {
                Log.d("X", "DB Table: " + c.getString(0));
                c.moveToNext();
            }
        }
        c.close();
        db.close();
    }

    private int verifyDBPopulated() {
        db = databaseHelper.getReadableDatabase();
        int count = (int) DatabaseUtils.queryNumEntries(db, DatabaseHelper.Course.TABLE_NAME);
        db.close();
        return count;
    }

    private void bulkInsert() {
        // Instantiate subclass of SQLiteOpenHelper
        db = databaseHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        for (int i = 0; i < courseLabel.size(); i++) {
            try {
                db.beginTransaction();
                ContentValues values = new ContentValues();
                values.put(DatabaseHelper.Course.COURSE_LABEL, courseLabel.get(i));
                values.put(DatabaseHelper.Course.TERM, courseTerms.get(i));
                values.put(DatabaseHelper.Course.COURSE_NAME, courseName.get(i));
                values.put(DatabaseHelper.Course.COURSE_DESCRIPTION, courseDescription.get(i));
                db.insertOrThrow(DatabaseHelper.Course.TABLE_NAME, null, values);
                db.setTransactionSuccessful();
            } catch (IllegalStateException e) {
                //error
            } finally {
                db.endTransaction();
            }
        }
        db.close();
    }

    public void jsonRequest()
    {
        Ion.with(this).
            load("http://max.bcit.ca/comp.json").
            asJsonObject().
            setCallback(
                new FutureCallback<JsonObject>()
                {
                    @Override
                    public void onCompleted(final Exception ex,
                                            final JsonObject obj)
                    {
                        if(ex != null)
                        {
                            Toast.makeText(MainActivity.this,
                                    "Error: " + ex.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            final JsonArray     jsonTermsArray;

                            jsonTermsArray = obj.getAsJsonArray("terms");

                            for(final JsonElement element : jsonTermsArray)
                            {
                                final JsonObject  jsonTermsObj;
                                final JsonArray   jsonClassesArray;

                                jsonTermsObj = element.getAsJsonObject();
                                String term = jsonTermsObj.get("term").toString();

                                jsonClassesArray = jsonTermsObj.get("classes").getAsJsonArray();
                                for(final JsonElement elementClasses : jsonClassesArray)
                                {
                                    final JsonObject  jsonClassesObj;
                                    String id;
                                    String name;
                                    String description;

                                    jsonClassesObj = elementClasses.getAsJsonObject();

                                    id = jsonClassesObj.get("id").toString();
                                    name = jsonClassesObj.get("name").toString();
                                    description = jsonClassesObj.get("description").toString();

                                    courseTerms.add(term.replace("\"", ""));
                                    courseLabel.add(id.replace("\"", ""));
                                    courseName.add(name.replace("\"", ""));
                                    courseDescription.add(description.replace("\"", ""));

                                    //TODO: Handle double quotes
                                }
                            }

                            //Initialize
                            terms = new ArrayList<>();
                            databaseHelper = DatabaseHelper.getInstance(getApplicationContext());

                            db = databaseHelper.getWritableDatabase();
                            dropTable();

                            db = databaseHelper.getWritableDatabase();
                            db.execSQL(databaseHelper.SQL_CREATE_COURSE);

                            initializeDB();

                            getData();

                            listView = getListView();
                            ArrayAdapter<String> listArrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, terms);

                            listView.setAdapter(listArrayAdapter);
                            listView.setOnItemClickListener(termClickListener);
                            intent = new Intent(getApplicationContext(), CourseActivity.class);
                        }
                    }
                });
    }
}

