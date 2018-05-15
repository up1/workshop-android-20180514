package com.example.somkiat.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Receive result from MainActivity
        Intent intent = getIntent();
        String result = intent.getStringExtra("result");

        TextView txvResult = findViewById(R.id.txv_result);
        txvResult.setText("Result = " + result);
    }
}
