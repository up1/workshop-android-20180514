package com.example.somkiat.calculator;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class CalculatorPage {

    public static void กรอกเลขตัวแรก(String input) {
        onView(withId(R.id.edt_first))
                .perform(
                        replaceText(input),
                        closeSoftKeyboard());
    }

    public static void กรอกเลขตัวสอง(String input) {
        onView(withId(R.id.edt_second))
                .perform(
                        replaceText(input),
                        closeSoftKeyboard());
    }

}
