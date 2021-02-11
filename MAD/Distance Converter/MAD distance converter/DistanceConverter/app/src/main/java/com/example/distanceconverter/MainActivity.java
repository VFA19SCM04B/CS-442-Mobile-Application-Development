package com.example.distanceconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;
import java.lang.*;
import android.text.method.ScrollingMovementMethod;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public double result, inp2;
    public String inp1 = "", str= " ";
    private EditText inp;
    private TextView out, milevalue, kmvalue, hist;
    private RadioGroup rg;
    private RadioButton radioButton1, radioButton2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inp = findViewById(R.id.editText);
        out= findViewById(R.id.textView6);
        milevalue = findViewById(R.id.textView2);
        kmvalue = findViewById(R.id.textView3);
        hist = findViewById(R.id.textView5);
        radioButton1 = findViewById((R.id.radioButton1));
        radioButton2 = findViewById(R.id.radioButton2);
        rg = findViewById(R.id.radioGroup);

    }


    public void radioButton(View v)
    {
        int currentid = rg.getCheckedRadioButtonId();


        if(currentid == radioButton1.getId()) {
            milevalue.setText("Miles to Kilometers:");
            kmvalue.setText("Kilometers to Miles:");
        }

        else if(currentid == radioButton2.getId()) {
            milevalue.setText("Miles to Kilometers:");
            kmvalue.setText("Kilometers to Miles:");

        }

    }


    public void distanceConvert(View v) {


        inp1 = inp.getText().toString();

        if(inp1.isEmpty())
            Toast.makeText(this,"Enter miles to Convert", Toast.LENGTH_SHORT).show();

        else
        {
            try {
                inp2 = Double.parseDouble(inp1);
            } catch (Exception e) {

                Toast.makeText(this, "Enter Number", Toast.LENGTH_SHORT).show();
            }

            int currentid = rg.getCheckedRadioButtonId();
            if (currentid == radioButton1.getId()) {

                result = inp2 *1.60934;
                out.setText(String.format("% .1f", result));
                str = inp1 + " Mi" + " ======> " + String.format("% .1f", result) + " Km" + "\n" + str;
            }
            else {
                result = inp2 * 0.621371 ;
                out.setText(String.format("%.1f", result));
                str = inp1 + " Km" + " ======> " + String.format("% .1f", result) + " Mi" + "\n" + str;


            }

            hist.setMovementMethod(new ScrollingMovementMethod());
            hist.setText(str);
        }


    }

    public void clear(View v) {
        str = "";
        hist.setText("");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        outState.putString("History",hist.getText().toString());
        outState.putString("Output",out.getText().toString());
        outState.putString("MtoK",milevalue.getText().toString());
        outState.putString("KtoM",kmvalue.getText().toString());
        outState.putString("str",str);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        hist.setText(savedInstanceState.getString("History"));
        out.setText(savedInstanceState.getString("Output"));
        milevalue.setText(savedInstanceState.getString("MtoK"));
        kmvalue.setText(savedInstanceState.getString("KtoM"));
        str = savedInstanceState.getString("str");

    }


}
