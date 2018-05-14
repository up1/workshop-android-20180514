package com.example.somkiat.calculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Receive data from intent
        Intent intent = getIntent();

        TextView txvResult = findViewById(R.id.txv_result);
        txvResult.setText(
                "Result = " + intent.getStringExtra("result"));
    }
}
