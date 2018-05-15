package com.example.somkiat.calculator;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MathJsService {

    @GET("/v4")
    Call<String> calculate(@Query("expr") String expression);
}
