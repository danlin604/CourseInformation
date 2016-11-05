package com.usergenlaptop.courseinformation;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    private ListView listView;
    private String termSelected; //1-4
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        final String[] terms = { "1", "2", "3", "4" };
        listView = getListView();
        ArrayAdapter<String> listArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, terms);

        listView.setAdapter(listArrayAdapter);
        listView.setOnItemClickListener(termClickListener);
        intent = new Intent(this, CourseActivity.class);
    }

    private AdapterView.OnItemClickListener termClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            termSelected = (String) parent.getItemAtPosition(position);
            intent.putExtra("termSelected", termSelected);
            startActivity(intent);
        }
    };
}

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "simple_note_app.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("some sql statement to create table");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("some sql statement to do something");
    }

}
