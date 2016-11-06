package com.usergenlaptop.courseinformation;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CourseDetailActivity extends AppCompatActivity {

    private String                  courseSelected;
    private TextView                courseName;
    private TextView                courseDesc;
    private SQLiteDatabase          db;
    private DatabaseHelper          databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        courseName = (TextView) findViewById(R.id.course_detail_title);
        courseDesc = (TextView) findViewById(R.id.course_detail_desc);
        courseSelected = getIntent().getStringExtra("courseSelected");

        databaseHelper = new DatabaseHelper(this);
        getData(courseSelected);
    }

    private void getData(String course) {
        db = databaseHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                DatabaseHelper.Course.COURSE_NAME,
                DatabaseHelper.Course.COURSE_DESCRIPTION
        };

        // Filter results WHERE "title" = 'my title'
        String      selection = DatabaseHelper.Course.COURSE_LABEL + " = ?";
        String[]    selectionArgs = { courseSelected };

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
        cursor.moveToFirst();

        String COURSE_NAME = cursor.getString(cursor.getColumnIndex(DatabaseHelper.Course.COURSE_NAME));
        String COURSE_DESCRIPTION = cursor.getString(cursor.getColumnIndex(DatabaseHelper.Course.COURSE_DESCRIPTION));

        courseName.setText(COURSE_NAME);
        courseDesc.setText(COURSE_DESCRIPTION);

        cursor.close();
        db.close();
    }
}
