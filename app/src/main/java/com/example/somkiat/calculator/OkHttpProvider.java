package com.example.somkiat.calculator;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public abstract class OkHttpProvider {
    private static OkHttpClient instance = null;

    public static OkHttpClient getOkHttpInstance() {
        if (instance == null) {
            instance = new OkHttpClient.Builder()
                    .readTimeout(1, TimeUnit.SECONDS)
                    .connectTimeout(1, TimeUnit.SECONDS)
                    .build();
        }
        return instance;
    }
}

