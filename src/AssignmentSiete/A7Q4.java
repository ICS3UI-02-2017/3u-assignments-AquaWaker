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
public class A7Q4 {

    /* determines the compound interest of an amount of money left in a bank for 
     * the interest and time entered 
     */
    public static double compoundInterest(double r, double P, double n) {

        // create a variable that holds the final balance
        double balance = P * (Math.pow((1 + r), n));

        return balance;
    }

    public static void main(String[] args) {

        // Allows input
        Scanner input = new Scanner(System.in);

        // allows the code to be tested indefinitely 
        while (true) {
            System.out.println("Enter the initial principal:");

            double prince = input.nextDouble();

            System.out.println("Enter the interest rate as a decimal:");

            double interesting = input.nextDouble();

            System.out.println("Enter the time left in the bank:");

            double waiting = input.nextDouble();

            double balance = compoundInterest(interesting, prince, waiting);

            System.out.println("The final balance is " + balance
                    + "\n------------------------------------------------------");
        }

    }
}
