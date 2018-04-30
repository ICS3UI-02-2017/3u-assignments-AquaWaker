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
public class A7Q7 {

    // determines the first digit in a sequence of digits
    public static int firstDigit(int integer) {

        // makes the digit positive
        if (integer < 0) {
            integer = integer * -1;
        }

        // determines the length of the integer
        int intLength = String.valueOf(integer).length();

        // used to get the first digit
        double findFirst = integer;

        // divided out the numbers that aren't needed 
        for (int mod = 0; mod < (intLength - 1); mod++) {
            findFirst = findFirst / 10;
            findFirst = Math.floor(findFirst);
        }

        // converted back to int
        int first = (int) findFirst;

        // send back
        return first;
    }

    public static void main(String[] args) {

        // Allows input
        Scanner input = new Scanner(System.in);

        // allows the code to be tested indefinitely 
        while (true) {
            System.out.println("Enter a integer: ");

            int digit = input.nextInt();

            int first = firstDigit(digit);

            System.out.println(first + " is the first digit");

            System.out.println("\n------------------------------------------------------\n");
        }

    }
}
