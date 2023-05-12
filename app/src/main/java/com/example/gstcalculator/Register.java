package com.example.gstcalculator;

import com.example.gstcalculator.data.Contact;
import com.example.gstcalculator.data.DatabaseHelper;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;import com.google.android.gms.tasks.OnCompleteListener;

public class Register extends AppCompatActivity {
    EditText mUsername, mPassword;
    TextView nSignin;
    Button mRegisterBtn;
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);
        mRegisterBtn = findViewById(R.id.signupbtn);
        nSignin = findViewById(R.id.signintext);

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mUsername.getText().toString().trim();
                String pass = mPassword.getText().toString().trim();

                if (TextUtils.isEmpty(name)) {
                    mUsername.setError("Email field is empty");
                    return;
                }
                if (pass.length() < 6) {
                    mPassword.setError("Password should contain atleast 6 charecters");
                    return;
                }
//                Adding new contact details to the users database
//                Contact c = new Contact();
//                c.setName(name);
//                c.setPass(pass);
//
//                helper.insertContact(c);
                SaveSharedPreference.setUserName(Register.this,name);
                startActivity(new Intent(Register.this, MainActivity.class));

            }
        });
        nSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this, Login.class));
            }
        });
    }
}



