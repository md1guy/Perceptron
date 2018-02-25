package com.md1guy.perceptron;

import java.util.Random;

public class Point {

    private float x;
    private float y;
    final int bias = 1;
    private int desired;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getDesired() {
        return desired;
    }

    Point() {
        Random random = new Random();
        x = random.nextFloat() * 2 - 1;
        y = random.nextFloat() * 2 - 1;

//        x = random.nextInt(2);
//        y = random.nextInt(2);

        desired = (y > f(x)) ? 1 : -1;
    }

    Point(float x, float y) {
        this.x = x;
        this.y = y;

        desired = (y > f(x)) ? 1 : -1;
    }

    public float f(float x) {

        return x;
    }
}