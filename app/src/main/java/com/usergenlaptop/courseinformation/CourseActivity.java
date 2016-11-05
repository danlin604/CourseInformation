package com.usergenlaptop.courseinformation;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CourseActivity extends ListActivity {

    private ListView listView;
    private String termSelected;
    private String[] courses;
    private String courseSelected; //1-4
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_course);

        termSelected = getIntent().getStringExtra("termSelected");
        getCoursesByTerm(Integer.parseInt(termSelected));

        listView = getListView();
        ArrayAdapter<String> listArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, courses);

        listView.setAdapter(listArrayAdapter);
        listView.setOnItemClickListener(courseClickListener);

        intent = new Intent(this, CourseDetailActivity.class);
    }

    private void getCoursesByTerm(int term) {
        switch(term) {
            case 1:
                courses = new String[] { "BUSA 2720", "COMM 1116", "COMP 1100", "COMP 1111", "COMP 1113", "COMP 1510", "COMP 1536" };
                break;
            case 2:
                courses = new String[] { "COMM 2216", "COMP 2121", "COMP 2510", "COMP 2526", "COMP 2714", "COMP 2721", "COMP 2910" };
                break;
            case 3:
                courses = new String[] { "COMP 3512", "COMP 3711", "COMP 3721", "COMP 3760", "COMP 3900", "COMP 3920", "COMP 4925" };
                break;
            case 4:
                courses = new String[] { "BLAW 3600", "COMP 4100", "COMP 4735", "COMP 4900", "COMP 3717", "COMP 4560", "COMP 4711", "COMP 4921" };
                break;
            default:
                Log.d("getCoursesByTerm", "No courses initialized");
                break;
        }
    }

    private AdapterView.OnItemClickListener courseClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            courseSelected = (String) parent.getItemAtPosition(position);
            intent.putExtra("courseSelected", courseSelected);
            startActivity(intent);
        }
    };
}
