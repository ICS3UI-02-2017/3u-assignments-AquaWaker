/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentSiete;

import java.util.Scanner;

/**
 * Answering A7Q1
 *
 * @author pritb9521
 */
public class A7Q1 {

    // method to determine the area of a circle
    public static double circleArea(double r) {

        // the formula 
        double area = Math.PI * Math.pow(r, 2);

        // send back the result
        return area;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Allows input
        Scanner input = new Scanner(System.in);

        // allows the code to be tested indefinitely 
        while (true) {
            // get the radius
            System.out.println("What is the radius of the circle?");

            double radius = input.nextDouble();

            // call on the method
            double answer = circleArea(radius);

            // display answer
            System.out.println("The area is " + answer);
        }

    }
}
