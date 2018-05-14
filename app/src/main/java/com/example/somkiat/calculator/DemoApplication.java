package com.example.somkiat.calculator;

import android.annotation.SuppressLint;
import android.app.Application;

@SuppressLint("Registered")

public class DemoApplication extends Application {
    public String getBaseUrl() {
        return "http://api.mathjs.org";
    }
}



