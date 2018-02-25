package com.md1guy.perceptron;

import java.util.Random;

public class Perceptron {
    private float[] weights;
    private float learnRate = 0.2f;
    private int iterations = 0;
    private int errors = 0;

    Perceptron(int numberOfInputs) {
        Random random = new Random();
        weights = new float[numberOfInputs];

        for (int i = 0; i < weights.length; i++) {

            weights[i] = random.nextFloat() * 2 - 1;
        }
    }

    public int guess(float[] inputs) {
        float sum = 0;

        for (int i = 0; i < weights.length; i++) {
            sum += weights[i] * inputs[i];
        }

        return sign(sum);
    }

    public int train(Point point) {
        float[] inputs = { point.getX(), point.getY(), point.bias};
        int guess = guess(inputs);
        int error = point.getDesired() - guess;

        if (guess != point.getDesired()) {
            errors++;

            for (int i = 0; i < weights.length; i++) {
                weights[i] += learnRate * point.getDesired() * inputs[i];
            }
        }

        iterations++;

        StringBuilder sb = new StringBuilder();

        sb.append((int)iterations)
                .append(". Inputs: {")
                .append(point.getX())
                .append(", ")
                .append(point.getY())
                .append("}; guess: ")
                .append(guess)
                .append("; desired: ")
                .append(point.getDesired())
                .append("; error: ")
                .append(error)
                .append(" | ")
                .append(getErrorPercentage())
                .append("%");

        System.out.println(sb.toString());

          return guess;
    }

    public float getErrorPercentage() {
        return (float)errors * 100f / (float)iterations;
    }

    private int sign(float n) {
        return (n > 0) ? 1 : -1;
    }
}