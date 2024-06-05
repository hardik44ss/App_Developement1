package com.example.proj3_java;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtResult;
        EditText edtWeight;
        EditText edtHeightIn , edtHeightFt;
        Button btnCalc;
        LinearLayout main;

        txtResult = findViewById(R.id.txtResult);
        edtWeight = findViewById(R.id.edtWeight);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        btnCalc = findViewById(R.id.btnCalc);
        main = findViewById(R.id.main);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
               int wt =  Integer.parseInt(edtWeight.getText().toString());
               int hft =  Integer.parseInt(edtHeightFt.getText().toString());
               int hit =  Integer.parseInt(edtHeightIn.getText().toString());

               int totalIn = (hft * 12) + hit;
               double totalMt = totalIn * 2.54/100;
               double bmi = wt / (totalMt * totalMt);

               if(bmi>25){
                   txtResult.setText(R.string.overweight);
                   main.setBackgroundColor(getResources().getColor(R.color.redOW));
               } else if (bmi < 18) {
                   txtResult.setText(R.string.underweight);
                   main.setBackgroundColor(getResources().getColor(R.color.yellowUW));
               } else {
                   txtResult.setText(R.string.normal);
                   main.setBackgroundColor(getResources().getColor(R.color.greenNm));
               }
            }
        });

    }
}