package com.powell.randomeats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button login, signup;
    EditText username, password;
    boolean optionsSwitch; //
    CheckBox remember;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        login = findViewById(R.id.Login);
        signup = findViewById(R.id.Sign);
        username = findViewById(R.id.Email);
        password = findViewById(R.id.Pass);
        remember = findViewById(R.id.Remember);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log();
                if (optionsSwitch == true) {
                    openOptions();
                }

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSignUp();

            }
        });

        }
    public void openSignUp() {
        Intent intent = new Intent(Login.this, SignUp.class);
        startActivity(intent);
    }
    public void openOptions() {
        Intent intent = new Intent(Login.this, Options.class);
        startActivity(intent);
    }


    public void Log() {
        String email = username.getText().toString();
        String pass = password.getText().toString();
        Boolean Chkemailpass = db.emailpassword(email,pass); //tells u if it was inserted correctly
        if(Chkemailpass==true) {
            Toast.makeText(getApplicationContext(), "Successful Login", Toast.LENGTH_SHORT).show();

            optionsSwitch = true;
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();
            optionsSwitch = false;
        }

//        String user = username.getText().toString().trim();
//        String pass = password.getText().toString().trim();
//
//        if(user.equals("dukes.nyaja9") && pass.equals("dani1234")) {
//            Toast.makeText(Login.this, "username and password matched", Toast.LENGTH_LONG).show();
//            optionsSwitch = true;
//        }
//        else {
//            Toast.makeText(Login.this, "username or password incorrect", Toast.LENGTH_LONG).show();
//            optionsSwitch = false;
//        }
    }

}

