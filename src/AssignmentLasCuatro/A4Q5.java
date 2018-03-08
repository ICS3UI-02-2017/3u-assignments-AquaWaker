/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentLasCuatro;

import java.util.Scanner;

/**
 *
 * @author pritb9521
 */
public class A4Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // allows input
        Scanner input = new Scanner(System.in);

        // Gets the student's name
        System.out.println("What is your name student?");

        String name = input.nextLine();

        // Checks for first test scores
        System.out.println("");
        System.out.print("What was the first test out of?: ");
        double outOfOne = input.nextInt();

        System.out.print("What mark did you get?: ");
        double scoreOne = input.nextInt();

        // Checks for second test scores
        System.out.println("");
        System.out.print("What was the second test out of?: ");
        double outOfTwo = input.nextInt();

        System.out.print("What mark did you get?: ");
        double scoreTwo = input.nextInt();

        // Checks for third test scores
        System.out.println("");
        System.out.print("What was the third test out of?: ");
        double outOfThree = input.nextInt();

        System.out.print("What mark did you get?: ");
        double scoreThree = input.nextInt();

        // Checks for four test scores
        System.out.println("");
        System.out.print("What was the fourth test out of?: ");
        double outOfFour = input.nextInt();

        System.out.print("What mark did you get?: ");
        double scoreFour = input.nextInt();

        // Checks for five test scores
        System.out.println("");
        System.out.print("What was the fifth test out of?: ");
        double outOfFive = input.nextInt();

        System.out.print("What mark did you get?: ");
        double scoreFive = input.nextInt();

        System.out.println("");

        // Lists all the averages for the student
        System.out.println("Test score averages for " + name);

        double testAvOne = scoreOne / outOfOne;
        testAvOne = testAvOne * 100;
        System.out.println("Test 1: " + testAvOne + "%");

        double testAvTwo = (scoreTwo / outOfTwo) * 100;
        System.out.println("Test 2: " + testAvTwo + "%");

        double testAvThree = (scoreThree / outOfThree) * 100;
        System.out.println("Test 3: " + testAvThree + "%");

        double testAvFour = (scoreFour / outOfFour) * 100;
        System.out.println("Test 4: " + testAvFour + "%");

        double testAvFive = (scoreFive / outOfFive) * 100;
        System.out.println("Test 5: " + testAvFive + "%");

        double testOfAll = ((scoreOne + scoreTwo + scoreThree + scoreFour + scoreFive) / (outOfOne + outOfTwo + outOfThree + outOfFour + outOfFive)) * 100;
        System.out.println("Total Average: " + testOfAll + "%");
    }
}
