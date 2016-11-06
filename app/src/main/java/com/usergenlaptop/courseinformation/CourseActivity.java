package com.usergenlaptop.courseinformation;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CourseActivity extends ListActivity {

    private ListView                listView;
    private String                  termSelected;
    private String                  courseSelected; //1-4
    private Intent                  intent;
    private SQLiteDatabase          db;
    private DatabaseHelper          databaseHelper;
    private ArrayList<String>       courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Init
        courses = new ArrayList<>();
        termSelected = getIntent().getStringExtra("termSelected");
        databaseHelper = new DatabaseHelper(this);

        getData(termSelected);

        listView = getListView();
        ArrayAdapter<String> listArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courses);
        listView.setAdapter(listArrayAdapter);
        listView.setOnItemClickListener(courseClickListener);

        intent = new Intent(this, CourseDetailActivity.class);
    }

    private AdapterView.OnItemClickListener courseClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            courseSelected = (String) parent.getItemAtPosition(position);
            intent.putExtra("courseSelected", courseSelected);
            startActivity(intent);
        }
    };

    private void getData(String term) {
        db = databaseHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                DatabaseHelper.Course.COURSE_LABEL
        };

        // Filter results WHERE "title" = 'my title'
        String      selection = DatabaseHelper.Course.TERM + " = ?";
        String[]    selectionArgs = { term };

        Cursor cursor = db.query(
                DatabaseHelper.Course.TABLE_NAME,         // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                      // The sort order
        );

        // For each row, you can read a column's value by calling one of the Cursor get methods, such as getString() or getLong().
        // For each of the get methods, you must pass the index position of the column you desire, which you can get by calling getColumnIndex() or getColumnIndexOrThrow().
        try {
            while (cursor.moveToNext()) {
                courses.add(cursor.getString(cursor.getColumnIndex(DatabaseHelper.Course.COURSE_LABEL)));
            }
        }
        finally {
            cursor.close();
            db.close();
        }
    }
}
