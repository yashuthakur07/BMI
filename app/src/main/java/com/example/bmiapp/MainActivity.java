package com.example.bmiapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    EditText edtweight, edtHeight, edtHeightIn;
    Button btn;
    TextView txt;
    LinearLayout main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtweight = findViewById(R.id.edtweight);
        edtHeight = findViewById(R.id.edtHeight);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        btn = findViewById(R.id.btn);
        txt = findViewById(R.id.txt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edtweight.getText().toString());
                int ft = Integer.parseInt(edtHeight.getText().toString());
                int in = Integer.parseInt(edtHeightIn.getText().toString());

                // Swap ft and in assignments for correct representation
                int totalIn = ft * 12 + in;

                double totalCm = totalIn * 2.54; // Corrected to 2.54 for conversion from inches to centimeters
                double totalM = totalCm / 100;

                double bmi = (double) wt / (totalM * totalM);
                if (bmi > 25) {
                    txt.setText("You're overweight");
                } else if (bmi < 18.5) {
                    txt.setText("You are underweight");
                } else {
                    txt.setText("You're healthy");

                }
            }
        });
    }
}
