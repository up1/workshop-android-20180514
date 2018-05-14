package com.example.somkiat.calculator;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ResultActivityTest {

    @Rule
    public ActivityTestRule<ResultActivity> activityTestRule
            = new ActivityTestRule<>(ResultActivity.class,
                                    true,
                                    false);

    @Test
    public void should_show_10_in_result_from_intent() {
        Intent intent = new Intent();
        intent.putExtra("result", "10");
        activityTestRule.launchActivity(intent);

        onView(withId(R.id.txv_result))
                .check(matches(withText("Result = 10")));
    }


}