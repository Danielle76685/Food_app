package com.powell.randomeats;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.powell.randomeats.R;

public class Options extends AppCompatActivity {

    Button choose, set, create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        create =(Button) findViewById(R.id.Create);
        set = (Button) findViewById(R.id.Set);
        choose = (Button) findViewById(R.id.Choose);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openCreateList();

            }

        });
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSetFilters();

            }

        });

    }
    public void openCreateList() {
        Intent intent = new Intent(this, CreateList.class);
        startActivity(intent);
    }
    public void openSetFilters() {
        Intent intent = new Intent(this, SetFilters.class);
        startActivity(intent);
    }


}
