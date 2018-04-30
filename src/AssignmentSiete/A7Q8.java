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
public class A7Q8 {

    // determines whether a series of digits are all odd or have an even digit
    public static boolean allDigitsOdd(String odd) {

        // creates the boolean that carries the result
        boolean allOdd = true;

        // creates a string with all the even digits
        String even = "02468";

        // looks for an even digit, if it finds one, it returns a false
        for (int findEven = 0; findEven < odd.length(); findEven++) {
            if (even.indexOf(odd.charAt(findEven)) != -1) {
                allOdd = false;
                // stop the for loop
                break;
            }
        }

        // return true or false
        return allOdd;
    }

    public static void main(String[] args) {

        // Allows input
        Scanner input = new Scanner(System.in);

        // allows the code to be tested indefinitely 
        while (true) {
            System.out.println("Enter a integer: ");

            String digit = input.nextLine();

            boolean allOdd = allDigitsOdd(digit);

            /* if the return is true, tell user the integer has all odd digit
             * if the return is false, tell use the integer has an even digit
             */
            if (allOdd == true) {
                System.out.println(digit + " has all odd integers");
            } else {
                System.out.println(digit + " has at least one even digit");
            }

            System.out.println("\n------------------------------------------------------\n");
        }


    }
}
