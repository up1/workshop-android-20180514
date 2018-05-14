package com.example.somkiat.calculator;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.jakewharton.espresso.OkHttp3IdlingResource;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

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


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @ClassRule
    public static final LocaleTestRule localeTestRule =
            new LocaleTestRule();

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class, true, false);

    @Test
    public void plus_1_and_1_should_result_2() throws InterruptedException {


        IdlingResource idlingResource
                = OkHttp3IdlingResource.create(
                "okhttp", OkHttpProvider.getOkHttpInstance());

        IdlingRegistry.getInstance().register(idlingResource);


        TestDemoApplication app = (TestDemoApplication)
                InstrumentationRegistry.getTargetContext().getApplicationContext();
        app.setBaseUrl("http://api.mathjs.org");

        activityTestRule.launchActivity(null);

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

//        Thread.sleep(2000);

        onView(withId(R.id.txv_result))
                .check(matches(withText("Result = 2")));
        Screengrab.screenshot("step03");


        IdlingRegistry.getInstance().unregister(idlingResource);

    }

}