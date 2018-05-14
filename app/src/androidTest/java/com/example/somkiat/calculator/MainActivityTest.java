package com.example.somkiat.calculator;

import android.support.test.rule.ActivityTestRule;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import tools.fastlane.screengrab.Screengrab;
import tools.fastlane.screengrab.locale.LocaleTestRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;


public class MainActivityTest {

    @ClassRule
    public static final LocaleTestRule localeTestRule =
            new LocaleTestRule();

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void plus_1_and_1_should_result_2() {
        onView(withId(R.id.edt_first))
                .perform(
                        replaceText("1"),
                        closeSoftKeyboard());
        Screengrab.screenshot("step01");

        onView(withId(R.id.btn_plus)).perform(click());

        onView(withId(R.id.edt_second))
                .perform(replaceText("1"),
                        closeSoftKeyboard());
        Screengrab.screenshot("step02");

        onView(withId(R.id.btn_calculate)).perform(click());

        onView(withId(R.id.txv_result))
                .check(matches(withText("Result = 2")));
        Screengrab.screenshot("step03");

    }

}