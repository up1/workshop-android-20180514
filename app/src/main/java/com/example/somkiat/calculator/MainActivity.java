package com.example.somkiat.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCalculate(View view) {
        EditText editFirst = findViewById(R.id.edt_first);
        EditText editSecond = findViewById(R.id.edt_second);

        if(editFirst != null) {
            int first = Integer.parseInt(editFirst.getText().toString());
            int second = Integer.parseInt(editSecond.getText().toString());
            Calculator calculator = new Calculator();
            int result = calculator.plus(first, second);

            TextView txvResult = findViewById(R.id.txv_result);
            txvResult.setText("Result = " + result);
        }
    }
}
