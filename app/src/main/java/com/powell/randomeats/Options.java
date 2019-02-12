package com.powell.randomeats;

import android.app.Dialog;
import android.content.Intent;
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

    Button choose, Set, create, random;
    private static final String TAG = "Options";
    private static final int ERROR_DIALOG_REQUEST = 9001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        create =(Button) findViewById(R.id.Create);
        Set = (Button) findViewById(R.id.set);





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
        Set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSetFilters();

            }

        });
        if(isServicesOK())
        {
            init();
        }
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

    private  void init()
    {
        Button btnMap = (Button) findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Options.this, MapsActivity.class);
                startActivity(intent);
            }
        });
    }
    //checks to see if the user has the correct version of google play
    public boolean isServicesOK()
    {
        Log.d(TAG, "isServicesOK: checking google services version");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(Options.this);

        if(available == ConnectionResult.SUCCESS)
        {
            //everything is fine
            Log.d(TAG, "isServicesOK: Google Play services is working");
            return true;
        }else if(GoogleApiAvailability.getInstance().isUserResolvableError(available))
        {
            //an error occurred but we can fix it
            Log.d(TAG, "isServicesOK: an error occurred, but we can fix it");
            //allows you to get dialog right from google for error
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(Options.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }else
        {
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();

        }
        return false;
    }



}
