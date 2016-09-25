package com.example.mike.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Mike on 25-Sep-16.
 */
public class criminalsListActivity extends AppCompatActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criminals);
        //Get a reference to the listview
        ListView listview = (ListView) findViewById(R.id.listView);
        //Get a reference to the list with names
        final String[] criminals = getResources().getStringArray(R.array.names);
        //Create an adapter that feeds the data to the listview
        listview.setAdapter(
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        criminals
                )
        );

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Get the name from the array that is in the same position as the chosen listitem.
                String name = criminals[position];

                Intent intent = new Intent(criminalsListActivity.this, MainActivity.class);
                intent.putExtra("name", name);

                startActivity(intent);
            }
        });

    }

}
