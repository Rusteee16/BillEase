package com.example.gstcalculator;



import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
public class gstcalculator extends AppCompatActivity {
    private RadioGroup type;
    private RadioGroup percent;
    Button calculatebtn;
    EditText amount;
    RadioButton inclusive;
    RadioButton exclusive;
    RadioButton fiveper;
    RadioButton twelweper;
    RadioButton eighteenper;
    RadioButton tfourper;
    TextView netvalue;TextView gstvalue;
    double netval;
    double gstval;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gstcalculator);
        type = (RadioGroup) findViewById(R.id.incluorexclu);
        percent = (RadioGroup) findViewById(R.id.percentage);
        calculatebtn = (Button) findViewById(R.id.gstcalculatebtn);
        amount = (EditText) findViewById(R.id.gstcalcamount);
        inclusive = (RadioButton) findViewById(R.id.inclusive);
        exclusive = (RadioButton) findViewById(R.id.exclusive);
        fiveper = (RadioButton) findViewById(R.id.fiveper);
        twelweper = (RadioButton) findViewById(R.id.twelveper);
        eighteenper = (RadioButton) findViewById(R.id.eighteenper);
        tfourper = (RadioButton) findViewById(R.id.tfourper);
        netvalue=(TextView) findViewById(R.id.networth);
        gstvalue=(TextView) findViewById(R.id.gstworth);
        type.clearCheck();
        percent.clearCheck();

        calculatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(exclusive.isChecked() && fiveper.isChecked()){
                    gstval=Math.round((Float.parseFloat(amount.getText().toString())*5)/100);
                    netval= Math.round(Float.parseFloat(amount.getText().toString()) + gstval);
                    gstvalue.setText(String.valueOf(gstval));
                    netvalue.setText(String.valueOf(netval));
                    System.out.println(netval);
                    System.out.println(gstval);
                }
                else if(exclusive.isChecked() && tfourper.isChecked()){
                    gstval=Math.round((Float.parseFloat(amount.getText().toString())*24)/100);
                    netval= Math.round(Float.parseFloat(amount.getText().toString()) + gstval);
                    gstvalue.setText(String.valueOf(gstval));
                    netvalue.setText(String.valueOf(netval));
                    System.out.println(netval);
                    System.out.println(gstval);
                }
                else if(exclusive.isChecked() && eighteenper.isChecked()){
                    gstval=Math.round((Float.parseFloat(amount.getText().toString())*18)/100);
                    netval= Math.round(Float.parseFloat(amount.getText().toString()) + gstval);
                    gstvalue.setText(String.valueOf(gstval));
                    netvalue.setText(String.valueOf(netval));
                    System.out.println(netval);
                    System.out.println(gstval);
                }
                else if(exclusive.isChecked() && twelweper.isChecked()){
                    gstval=Math.round((Float.parseFloat(amount.getText().toString())*12)/100);
                    netval= Math.round(Float.parseFloat(amount.getText().toString()) + gstval);
                    gstvalue.setText(String.valueOf(gstval));
                    netvalue.setText(String.valueOf(netval));
                    System.out.println(netval);
                    System.out.println(gstval);
                }
                if(inclusive.isChecked() && fiveper.isChecked()){
                    gstval=Math.round(((Float.parseFloat(amount.getText().toString()) )*5)/(100+5));
                    netval= Math.round(Float.parseFloat(amount.getText().toString()) - gstval);
                    gstvalue.setText(String.valueOf(gstval));
                    netvalue.setText(String.valueOf(netval));
                    System.out.println(netval);
                    System.out.println(gstval);
                }
                else if(inclusive.isChecked() && tfourper.isChecked()){
                    gstval=Math.round(((Float.parseFloat(amount.getText().toString()) )*24)/(100+24));
                    netval= Math.round(Float.parseFloat(amount.getText().toString()) - gstval);
                    gstvalue.setText(String.valueOf(gstval));
                    netvalue.setText(String.valueOf(netval));
                    System.out.println(netval);
                    System.out.println(gstval);
                }
                else if(inclusive.isChecked() && eighteenper.isChecked()){
                    gstval=Math.round(((Float.parseFloat(amount.getText().toString()) )*18)/(100+18));
                    netval= Math.round(Float.parseFloat(amount.getText().toString()) - gstval);
                    gstvalue.setText(String.valueOf(gstval));
                    netvalue.setText(String.valueOf(netval));
                    System.out.println(netval);
                    System.out.println(gstval);
                }
                else if(inclusive.isChecked() && twelweper.isChecked()){
                    gstval=Math.round(((Float.parseFloat(amount.getText().toString()) )*12)/(100+12));
                    netval= Math.round(Float.parseFloat(amount.getText().toString()) - gstval);
                    gstvalue.setText(String.valueOf(gstval));
                    netvalue.setText(String.valueOf(netval));
                    System.out.println(netval);
                    System.out.println(gstval);
                }
            }
        });

    }
}