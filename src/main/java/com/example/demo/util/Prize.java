package com.example.demo.util;

/**
 * @author langshixin
 * @date 2023/4/27
 */
public class Prize {
    private String name;
    private double probability;
    public Prize(String name, double probability) {
        this.name = name;
        this.probability = probability;
    }
    public String getName() {
        return name;
    }
    public double getProbability() {
        return probability;
    }
}