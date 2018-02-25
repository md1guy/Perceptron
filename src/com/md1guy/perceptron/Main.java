package com.md1guy.perceptron;

public class Main {

    public static void main(String[] args) {

        Perceptron perceptron = new Perceptron(3);

        for (int i = 0; i < 10000000; i++) {
            perceptron.train(new Point());
        }

        System.out.println("Done, error percentage: " + perceptron.getErrorPercentage() + "%");
    }
}