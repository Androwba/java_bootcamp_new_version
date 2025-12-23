package edu.school21;

import java.util.Scanner;

public class TrianglePerimeter {
    public static void main(String[] args) {

        double ax, ay, bx, by, cx, cy;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the triangle's coordinates (ax ay bx by cx cy):");
        ax = verifyValue(input);
        ay = verifyValue(input);
        bx = verifyValue(input);
        by = verifyValue(input);
        cx = verifyValue(input);
        cy = verifyValue(input);

        double distanceAB = distance(ax, ay, bx, by);
        double distanceAC = distance(ax, ay, cx, cy);
        double distanceBC = distance(bx, by, cx, cy);

        checkIfFormsTriangle(distanceAB, distanceAC, distanceBC);
    }

    public static void checkIfFormsTriangle(double a, double b, double c) {
        if (a + b <= c || a + c <= b || b + c <= a) {
            System.out.println("It's not a triangle");
        } else {
            String perimeter = String.format("%.3f", (a + b + c));
            System.out.println("Perimeter is: " + perimeter);
        }
    }

    public static double verifyValue(Scanner input) {
        while (!input.hasNextDouble()) {
            System.out.println("Could not parse a number. Please try again");
            input.next();
        }
        return input.nextDouble();
    }

    public static double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
