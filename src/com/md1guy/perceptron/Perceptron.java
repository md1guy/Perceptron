package com.md1guy.perceptron;

import java.util.Random;

public class Perceptron {
    private final Random random = new Random();
    private float weights[] = new float[2];
    private float learningRate = 1f;
    private float bias = 1;
    private float iterations = 0;
    private float errors = 0;

    public void setLearningRate(float learningRate) {
        this.learningRate = learningRate;
    }

    public float getErrorPercentage() {
        return errors * 100 / iterations;
    }

    Perceptron() {
        for (int i = 0; i < weights.length; i++) {
            weights[i] = random.nextFloat() * 2 - 1;
        }
    }

    private int sign(float n) {
        return (n < 0) ? -1 : 1;
    }

    public int guess(float[] inputs) {
        float sum = 0;

        for (int i = 0; i < weights.length; i++) {
            sum += weights[i] * inputs[i];
        }

        return sign(sum);
    }

    public void train(Point point) {

        int error = point.desired - guess(point.coords);

        if(error != 0) errors++;

        iterations++;

        StringBuilder sb = new StringBuilder();

        sb.append((int)iterations)
                .append(". Inputs: {")
                .append(point.coords[0])
                .append(", ")
                .append(point.coords[1])
                .append("}; guess: ")
                .append(guess(point.coords))
                .append("; desired: ")
                .append(point.desired)
                .append("; error: ")
                .append(error)
                .append(" | ")
                .append(getErrorPercentage())
                .append("%");

        System.out.println(sb.toString());

        for (int i = 0; i < weights.length; i++) {
            weights[i] += error * point.coords[i] * learningRate + bias;
        }
    }
}
