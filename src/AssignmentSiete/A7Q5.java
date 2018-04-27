/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentSiete;

import java.util.Scanner;

/**
 *
 * @author pritb9521
 */
public class A7Q5 {

    // create a number of lines each with a random amount of asterisks between 1 and 5
    public static void chaotic(int a) {

        // Creates a random number
        int asterisks = (int) (Math.random() * (5)) + 1;

        // prints out the lines of asterisks
        for (int lines = 0; lines < a; lines++) {
            for (int stars = 0; stars < asterisks; stars++) {
                System.out.print("*");
            }
            System.out.println();
            // Creates a new random number
            asterisks = (int) (Math.random() * (5)) + 1;

        }
    }

    public static void main(String[] args) {

        // Allows input
        Scanner input = new Scanner(System.in);

        // allows the code to be tested indefinitely 
        while (true) {
            System.out.println("Enter the number of lines: ");

            int numberOLines = input.nextInt();

            chaotic(numberOLines);

            System.out.println("\n------------------------------------------------------\n");
        }
    }
}
