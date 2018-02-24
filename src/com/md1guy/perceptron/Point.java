package com.md1guy.perceptron;

import java.util.Random;

public class Point {

    private final Random random = new Random();

    float[] coords = new float[2];
    int desired;

    Point() {
        for (int i = 0; i < coords.length; i++) {
            coords[i] = random.nextFloat() * 100;
        }

        desired = (coords[0] >= coords[1]) ? 1 : -1;
    }
}