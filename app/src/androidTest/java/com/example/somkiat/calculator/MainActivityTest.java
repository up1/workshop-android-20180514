package com.example.somkiat.calculator;

import android.support.annotation.NonNull;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;

import com.jakewharton.espresso.OkHttp3IdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import tools.fastlane.screengrab.Screengrab;
import tools.fastlane.screengrab.UiAutomatorScreenshotStrategy;
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

    private OkHttp3IdlingResource idlingResource;

    @Test
    public void plus_1_and_1_should_result_2() throws InterruptedException, IOException {

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setBody("2"));
        server.start();

        String url = server.url("/").toString();
        TestDemoApplication application =
                (TestDemoApplication)
                        InstrumentationRegistry.getTargetContext().getApplicationContext();
        application.setUrl(url);

        Screengrab.setDefaultScreenshotStrategy(new UiAutomatorScreenshotStrategy());
        CalculatorPage.กรอกเลขตัวแรก("1");
        Screengrab.screenshot("step01");

        onView(withId(R.id.btn_plus)).perform(click());

        CalculatorPage.กรอกเลขตัวสอง("1");
        Screengrab.screenshot("step02");

        onView(withId(R.id.btn_calculate)).perform(click());

//        Thread.sleep(2000);

        onView(withId(R.id.txv_result))
                .check(matches(withText("Result = 2")));
        Screengrab.screenshot("step03");

        server.shutdown();
    }

    @Before
    public void startTest() {
        idlingResource =
                OkHttp3IdlingResource.create("okhttp", OkHttp.getInstance());
        IdlingRegistry.getInstance().register(idlingResource);
    }

    @After
    public void clean() {
        IdlingRegistry.getInstance().unregister(idlingResource);
    }

}