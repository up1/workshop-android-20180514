package com.example.somkiat.calculator;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class MyRandomTest {

    @Test
    public void getNumber() {
        MyRandom myRandom = new MyRandom();
        myRandom.setRandom(new StubRandom5());
        assertEquals(5, myRandom.getNumber());
    }
}

class StubRandom5 implements IRandom {

    @Override
    public int nextInt(int bound) {
        return 5;
    }
}