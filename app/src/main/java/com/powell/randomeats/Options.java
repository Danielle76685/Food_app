package com.powell.randomeats;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.powell.randomeats.R;

public class Options extends AppCompatActivity {

    Button choose, Set, create, Random;
    private static final String TAG = "Options";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        create =(Button) findViewById(R.id.Create);
        Random = (Button) findViewById(R.id.random);






//        random.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                openrandom();
//
//            }
//
//        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openCreateList();

            }

        });
        Random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSetFilters();

            }

        });


    }

    public void openrandom() {
        Intent intent = new Intent(this, Random.class);
        startActivity(intent);
    }

    public void openCreateList() {
        Intent intent = new Intent(this, CreateList.class);
        startActivity(intent);
    }
    public void openSetFilters() {
        Intent intent = new Intent(this, SetFilters.class);
        startActivity(intent);
    }

    //map code for checking services with btn to open map


    }













