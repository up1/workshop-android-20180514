package com.example.somkiat.calculator;

public class TestDemoApplication extends DemoApplication {
    private String baseUrl;

    @Override
    public String getUrl() {
        return baseUrl;
    }

    public void setUrl(String url) {
        baseUrl = url;
    }
}
