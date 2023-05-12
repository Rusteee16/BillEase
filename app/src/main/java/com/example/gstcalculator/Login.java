package com.example.gstcalculator;

import com.example.gstcalculator.data.DatabaseHelper;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.widget.TextView;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import com.example.gstcalculator.SaveSharedPreference;

public class Login extends AppCompatActivity {

    EditText mUsername, mPassword;
    TextView mSignup;
    Button mLoginBtn;
    private String TempPassword;
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);
        mLoginBtn = findViewById(R.id.signinbtn);
        mSignup = findViewById(R.id.register);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mUsername.getText().toString();
                String pass = mPassword.getText().toString().trim();

                if (TextUtils.isEmpty(name)) {
                    mUsername.setError("Email field is empty");
                    return;
                }
                if (pass.length() < 6) {
                    mPassword.setError("Password should contain atleast 6 charecters");
                    return;
                }
//                Checking for the password stored with respect to the username
//                String password = helper.searchPass(name);
                String password = "calculator";
                if(pass.equals(password))
                {
                    SaveSharedPreference.setUserName(Login.this,name);
                    Intent i = new Intent(Login.this, MainActivity.class);
                    i.putExtra("name" , name);
                    startActivity(i);
                    Toast temp = Toast.makeText(Login.this, "Logged In", Toast.LENGTH_LONG);
                    temp.show();
                }
                else
                {
                    Toast temp = Toast.makeText(Login.this, "username & passwords don't match", Toast.LENGTH_LONG);
                    temp.show();
                }

            }
        });
        mSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });

    }

}

