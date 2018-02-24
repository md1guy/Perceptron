package com.md1guy.perceptron;

public class Main {

    public static void main(String[] args) {

        Perceptron perceptron = new Perceptron();

        Point[] points = new Point[10000];

        for (Point point : points) {
            point = new Point();
            perceptron.train(point);
        }
        System.out.println("Done, error percentage: " + perceptron.getErrorPercentage() + "%");
    }
}