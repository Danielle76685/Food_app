package com.powell.randomeats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SetFilters extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_filters);
        Button btnMap = (Button) findViewById(R.id.map1);
        Button wheel1 = (Button) findViewById(R.id.button2);

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetFilters.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        wheel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetFilters.this, Wheel.class);
                startActivity(intent);
            }
        });
    }
}
