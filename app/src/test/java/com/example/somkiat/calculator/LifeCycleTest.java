package com.example.somkiat.calculator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LifeCycleTest {

    @Before
    public void start() {
        System.out.println("start");
    }
    @After
    public void finish() {
        System.out.println("finish");
    }

    @BeforeClass
    public static void startOnce() {
        System.out.println("==== start ====");
    }

    @AfterClass
    public static void finishOnce() {
        System.out.println("==== finish ====");
    }



    @Test public void test01() {
        System.out.println("test01");
    }

    @Test public void test02() {
        System.out.println("test02");
    }
}
