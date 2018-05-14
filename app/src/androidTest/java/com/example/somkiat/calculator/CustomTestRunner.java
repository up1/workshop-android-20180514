package com.example.somkiat.calculator;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

public class CustomTestRunner extends AndroidJUnitRunner {
    @Override
    public Application newApplication(
            ClassLoader cl, String className, Context context)
            throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        return super.newApplication(cl, TestDemoApplication.class.getName(), context);
    }
}
