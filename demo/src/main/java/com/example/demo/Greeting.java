package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "greeting")
public class Greeting {
    private String name;
    private String coffee;

    public String getName() {
        return name;
    }

    public String getCoffee() {
        return coffee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoffee(String coffee) {
        this.coffee = coffee;
    }
}
