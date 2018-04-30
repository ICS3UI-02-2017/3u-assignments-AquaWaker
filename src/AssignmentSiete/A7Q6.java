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
public class A7Q6 {

    // Using modular, it determines the last number in a sequence of digits
    public static int lastDigit(int integer) {

        // determine the last digit
        int last = integer % 10;

        // make it positive
        if (last < 0) {
            last = last * -1;
        }

        // give the answer
        return last;
    }

    public static void main(String[] args) {
        // Allows input
        Scanner input = new Scanner(System.in);

        // allows the code to be tested indefinitely 
        while (true) {
            System.out.println("Enter a integer: ");

            int digit = input.nextInt();

            int last = lastDigit(digit);

            System.out.println(last + " is the last digit");

            System.out.println("\n------------------------------------------------------\n");
        }
    }
}
