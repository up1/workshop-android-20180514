package com.example.somkiat.calculator;

import java.util.Random;

public class MyRandom {

    IRandom random;

    public void setRandom(IRandom random) {
        this.random = random;
    }

    public int getNumber() {
        return random.nextInt(10);
    }
}
