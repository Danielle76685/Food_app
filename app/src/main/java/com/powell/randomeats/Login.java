package com.powell.randomeats;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

//    Button login, signup;
//    EditText username, password;
//    boolean optionsSwitch; //
//    CheckBox remember;
//    DatabaseHelper db;
//    private SharedPreferences mprefs;
//    private static final String PREFS_NAME = "PrefsFile";
//    private int attempts = 0;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        bindWidget();
//        getPreferencesData();
//
//        mprefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
//        db = new DatabaseHelper(this);
//        login = findViewById(R.id.Login);
//        signup = findViewById(R.id.Sign);
//        username = findViewById(R.id.Email);
//        password = findViewById(R.id.Pass);
//      //  remember = findViewById(R.id.Remember);
//
//
//        remember.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            if((username.getText().toString().equals("")) && password.getText().toString().equals(""))
//            {
//                if(remember.isChecked())
//                {
//                    Boolean boolIsChecked = remember.isChecked();
//                    SharedPreferences.Editor editor = mprefs.edit();
//                    editor.putString("pref_name", username.getText().toString());
//                    editor.putString("pref_pass", password.getText().toString());
//                    editor.putBoolean("pref_check", boolIsChecked);
//                    editor.apply();
//                    Toast.makeText(getApplicationContext(), "Settings have been saved.", Toast.LENGTH_SHORT).show(); //8:21
//                }
//                else
//                {
//                    mprefs.edit().clear().apply();
//                }
//                username.getText().clear();
//                password.getText().clear();
//            }
//
//
//            }
//        });
//
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Log();
//                if (optionsSwitch == true) {
//                    openOptions();
//                }
//
//            }
//        });
//        signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                openSignUp();
//
//            }
//        });
//
//        }
//        private void getPreferencesData()
//        {
//            SharedPreferences sp = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
//
//            if(sp.contains("pref_name"))
//            {
//                String u = sp.getString("pref_name", "not found.");
//                username.setText((u.toString()));
//            }
//            if(sp.contains("pref_pass"))
//            {
//                String p = sp.getString("pref_pass", "not found.");
//                password.setText((p.toString()));
//            }
//            if(sp.contains("pref_check"))
//            {
//                Boolean b = sp.getBoolean("pref_check", false);
//                remember.setChecked(b);
//            }
//        }
//
//        private void bindWidget()
//        {
//            login = findViewById(R.id.Login);
//            signup = findViewById(R.id.Sign);
//            remember = findViewById(R.id.Remember);
//        }
//    public void openSignUp() {
//        Intent intent = new Intent(Login.this, SignUp.class);
//        startActivity(intent);
//    }
//    public void openOptions() {
//        Intent intent = new Intent(Login.this, Options.class);
//        startActivity(intent);
//    }
//
//
//    public void Log() {
//        String email = username.getText().toString();
//        String pass = password.getText().toString();
//        Boolean Chkemailpass = db.emailpassword(email,pass); //tells u if it was inserted correctly
//        if(Chkemailpass==true) {
//            Toast.makeText(getApplicationContext(), "Successful Login", Toast.LENGTH_SHORT).show();
//
//            optionsSwitch = true;
//        }
//        else
//        {
//            Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();
//            optionsSwitch = false;
//        }
//
//    }

}

