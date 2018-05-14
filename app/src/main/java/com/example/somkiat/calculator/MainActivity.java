package com.example.somkiat.calculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static String HTTP_API_MATHJS_ORG = "http://api.mathjs.org";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCalculate(View view) {
        EditText editFirst = findViewById(R.id.edt_first);
        EditText editSecond = findViewById(R.id.edt_second);

        int first = Integer.parseInt(editFirst.getText().toString());
        int second = Integer.parseInt(editSecond.getText().toString());
        calculateAddFromRestApi(first, second);
    }
    @SuppressLint("DefaultLocale")

    private void calculateAddFromRestApi(int first, int second) {
        // Prepare value
        String expression = String.format("%d+%d", first, second);

        // Call service with retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HTTP_API_MATHJS_ORG)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpProvider.getOkHttpInstance())
                .build();
        MathJsService mathJsService
                = retrofit.create(MathJsService.class);

        // Callback from service
        final Call<String> call = mathJsService.calculate(expression);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                sendResult(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

    private void sendResult(String result) {
        // Send data to Result Activity
        Intent intent =
                new Intent(this,
                        ResultActivity.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }
}
