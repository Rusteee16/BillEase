package com.example.gstcalculator;


import android.content.Intent;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.gstcalculator.SaveSharedPreference;

public class MainActivity extends AppCompatActivity {

    Button gstcalcbtn;
    Button signout;
    Button infogst;
    Button newbill;
    Button viewbill;
    protected void onCreate(Bundle savedInstanceState) {
        if(SaveSharedPreference.getUserName(MainActivity.this).length() == 0)
        {
            startActivity(new Intent(getApplicationContext(),Login.class));
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gstcalcbtn=findViewById(R.id.gstcalc);
        signout= findViewById(R.id.signout);
        infogst= findViewById(R.id.knowmore);
        newbill= findViewById(R.id.nbill);
        viewbill= findViewById(R.id.recbill);
        gstcalcbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,gstcalculator.class));
            }
        });
        infogst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,infogst.class));
            }
        });
        newbill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SetupPasswordActivity.class));
            }
        });
        viewbill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BillsActivity.class));
            }
        });
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveSharedPreference.clearUserName(MainActivity.this);
                Toast.makeText(MainActivity.this,"successfully logged out",Toast.LENGTH_SHORT);
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });

    }
}