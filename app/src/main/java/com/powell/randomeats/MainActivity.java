package com.powell.randomeats;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent homeintent = new Intent(MainActivity.this, Options.class);
                startActivity(homeintent);
                finish();
            }

    },SPLASH_TIME_OUT);

    }

//     new Handler().postDelayed(new Runnable()
//    {
//        @Override
//        public void run()
//        {
//            Intent homeintent = new Intent(MainActivity.this, Login.class);
//            startActivity(homeIntent);
//            finish();
//        }
//    },SPLASH_TIME_OUT;

}
