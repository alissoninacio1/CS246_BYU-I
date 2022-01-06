package com.company;

import java.util.Scanner;

public class CircleCalculator {
    //scanner for getting input from user
    private static final Scanner input = new Scanner(System.in);

    private double getRadius() {
        System.out.print("Enter the radius: ");
        double r = input.nextDouble();
        return r;
    }

    private void displayCircumference(double radius) {
        double circumference = Math.PI * radius * 2;
        System.out.printf("\tThe circumference is %.2f.\n", circumference);
    }

    public  void displayArea(double radius) {
        double area = Math.PI * radius * radius;
        System.out.printf("\tThe circle area is %.2f.\n", area);
    }

    public static void main(String[] args) {
        CircleCalculator circle = new CircleCalculator();

        double r = circle.getRadius();
        circle.displayArea(r);
        circle.displayCircumference(r);

    }
}
