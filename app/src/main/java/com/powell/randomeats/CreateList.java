package com.powell.randomeats;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.powell.randomeats.R;

import java.util.ArrayList;

public class CreateList extends AppCompatActivity {

    DatabaseHelper db;
    Button add;
    ArrayList<String> restaurants = new ArrayList<String>();
    EditText txt;
    ListView show;
    ArrayList<String> listItem;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list);


        db = new DatabaseHelper(this);
        txt = (EditText)findViewById(R.id.edit);
        add = (Button)findViewById(R.id.add);
        show = (ListView)findViewById(R.id.restaurants);
        listItem = new ArrayList<>();

        //populateListView();

        show.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String text = show.getItemAtPosition(position).toString();
                Toast.makeText(CreateList.this, ""+text, Toast.LENGTH_SHORT).show();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = txt.getText().toString();

                if(restaurants.contains(getInput))
                {
                    Toast.makeText(getBaseContext(), "Restaurant already added to list", Toast.LENGTH_LONG).show();

                }
                else if (getInput == null || getInput.trim().equals(""))
                {
                    Toast.makeText(getBaseContext(), "Input Field is empty", Toast.LENGTH_LONG).show();
                }
                else
                {
                    restaurants.add(getInput);
                    Boolean insert = db.addRestaurant(getInput);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Restaurant added", Toast.LENGTH_SHORT).show();
                            }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(CreateList.this, android.R.layout.simple_list_item_1, restaurants);
                    show.setAdapter(adapter);
                    ((EditText)findViewById(R.id.edit)).setText("");
                }

            }

        });
    }

    public void populateListView()
    {
        Cursor cursor = db.populate();

        if(cursor.getCount() == 0)
        {
            Toast.makeText(this, "No data to show", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while (cursor.moveToNext())
            {
                listItem.add(cursor.getString(1)); // 0 is id, 1 is name
            }

            ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItem);
            show.setAdapter(adapter);
        }

    }
}