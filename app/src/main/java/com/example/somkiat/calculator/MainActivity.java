package com.example.somkiat.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import okhttp3.OkHttpClient;
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

        if(editFirst != null) {
            int first = Integer.parseInt(editFirst.getText().toString());
            int second = Integer.parseInt(editSecond.getText().toString());
            plusFromApi(first, second);
//            Calculator calculator = new Calculator();
//            int result = calculator.plus(first, second);
//            sendResult(result);


//            TextView txvResult = findViewById(R.id.txv_result);
//            txvResult.setText("Result = " + result);
        }
    }

    private void sendResult(String result) {
        //Send result to ResultActivity
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("result", String.valueOf(result));
        startActivity(intent);
    }

    private void plusFromApi(int first, int second) {

        DemoApplication demoApplication =
                (DemoApplication) getApplication();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(demoApplication.getUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttp.getInstance())
                .build();

        MathJsService service = retrofit.create(MathJsService.class);
        final Call<String> call = service.calculate(
                String.format("%d+%d", first, second)
        );
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

}
