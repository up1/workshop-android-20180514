package com.example.somkiat.calculator;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.jakewharton.espresso.OkHttp3IdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import tools.fastlane.screengrab.Screengrab;
import tools.fastlane.screengrab.locale.LocaleTestRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


public class MainActivityWithMockWebServerTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class, true, false);

    private IdlingResource idlingResource;

    @Before
    public void start() {
        IdlingResource idlingResource
                = OkHttp3IdlingResource.create(
                "okhttp", OkHttpProvider.getOkHttpInstance());

        IdlingRegistry.getInstance().register(idlingResource);
    }

    @After
    public void finish() {
        IdlingRegistry.getInstance().unregister(idlingResource);
    }

    @Test
    public void success() throws InterruptedException, IOException {

        // 1. Setup MockWebServer
        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setBody("2"));
        server.start();
        String url = server.url("/").toString();

        // 2. Replace URL of REST API with MockWebServer
        TestDemoApplication app = (TestDemoApplication)
                InstrumentationRegistry.getTargetContext().getApplicationContext();
        app.setBaseUrl(server.url("/").toString());

        activityTestRule.launchActivity(null);

        onView(withId(R.id.edt_first))
                .perform(
                        replaceText("1"),
                        closeSoftKeyboard());

        onView(withId(R.id.btn_plus)).perform(click());

        onView(withId(R.id.edt_second))
                .perform(replaceText("1"),
                        closeSoftKeyboard());

        onView(withId(R.id.btn_calculate)).perform(click());

        onView(withId(R.id.txv_result))
                .check(matches(withText("Result = 2")));

        server.shutdown();
    }

    @Test
    public void failure_404() throws Exception {

        // 1. Setup MockWebServer
        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(404));

        server.start();
        String url = server.url("/").toString();

        // 2. Replace URL of REST API with MockWebServer
        MainActivity.HTTP_API_MATHJS_ORG = url;

        activityTestRule.launchActivity(null);

        onView(withId(R.id.edt_first))
                .perform(
                        replaceText("1"),
                        closeSoftKeyboard());

        onView(withId(R.id.btn_plus)).perform(click());

        onView(withId(R.id.edt_second))
                .perform(replaceText("1"),
                        closeSoftKeyboard());

        onView(withId(R.id.btn_calculate)).perform(click());

        server.shutdown();
    }

    @Test
    public void failure_timeout() throws Exception {

        // 1. Setup MockWebServer
        MockWebServer server = new MockWebServer();
        server.enqueue(
                new MockResponse()
                        .setBody("2")
                        .throttleBody(1, 1, TimeUnit.SECONDS));

        server.start();
        String url = server.url("/").toString();

        // 2. Replace URL of REST API with MockWebServer
        MainActivity.HTTP_API_MATHJS_ORG = url;

        activityTestRule.launchActivity(null);

        onView(withId(R.id.edt_first))
                .perform(
                        replaceText("1"),
                        closeSoftKeyboard());

        onView(withId(R.id.btn_plus)).perform(click());

        onView(withId(R.id.edt_second))
                .perform(replaceText("1"),
                        closeSoftKeyboard());

        onView(withId(R.id.btn_calculate)).perform(click());

        server.shutdown();
    }

}