package com.powell.randomeats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.powell.randomeats.R;

import java.util.ArrayList;

public class CreateList extends AppCompatActivity {

    Button add;
    ArrayList<String> restaurants = new ArrayList<String>();
    EditText txt;
    ListView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list);

        txt = (EditText)findViewById(R.id.type);
        add = (Button)findViewById(R.id.Add);
        show = (ListView)findViewById(R.id.list);

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
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(CreateList.this, android.R.layout.simple_list_item_1, restaurants);
                    show.setAdapter(adapter);
                    ((EditText)findViewById(R.id.type)).setText("");                }

            }

        });
    }
}