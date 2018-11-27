package com.powell.randomeats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.powell.randomeats.MainActivity;
import com.powell.randomeats.R;

public class SignUp extends AppCompatActivity {

   DatabaseHelper db;
    EditText email, pass, pass1, first, last, birth;
    Button sign;
    boolean optionsSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        db = new DatabaseHelper(this);
        email = (EditText) findViewById(R.id.Email);
        pass = (EditText) findViewById(R.id.Password);
        first = (EditText) findViewById(R.id.firstName);
        last = (EditText) findViewById(R.id.lastName);
        birth = (EditText) findViewById(R.id.birthday);
        pass1 = (EditText) findViewById(R.id.Confirm);
        sign = (Button) findViewById(R.id.Signup);



        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Works,", Toast.LENGTH_SHORT).show();

            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = email.getText().toString();
                String s2 = pass.getText().toString();
                String s3 = pass1.getText().toString();
                String s4 = first.getText().toString();
                String s5 = last.getText().toString();
                String s6 = birth.getText().toString();
                if (s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("") || s5.equals("") || s6.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();

                } else {
                    if (s2.equals(s3)) {
                        Boolean chkemail = db.chkemail(s1);
                        if (chkemail == true) {
                            Boolean insert = db.add(s1, s2, s4, s5, s6);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Registered Succesfully", Toast.LENGTH_SHORT).show();
                                Log();
                                if (optionsSwitch == true) {
                                    openLog();
                                }

                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Email Already exists,", Toast.LENGTH_SHORT).show();

                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

    public void Log() {
        optionsSwitch = true;
    }

    public void openLog() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
