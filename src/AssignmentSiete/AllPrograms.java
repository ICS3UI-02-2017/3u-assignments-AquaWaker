/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentSiete;

import static AssignmentSiete.A7Q8.allDigitsOdd;
import static AssignmentSiete.A7Q7.firstDigit;
import static AssignmentSiete.A7Q6.lastDigit;
import static AssignmentSiete.A7Q5.chaotic;
import static AssignmentSiete.A7Q4.compoundInterest;
import static AssignmentSiete.A7Q3.factors;
import static AssignmentSiete.A7Q2.examGrade;
import static AssignmentSiete.A7Q1.circleArea;
import java.util.Scanner;

/**
 *
 * @author pritb9521
 */
public class AllPrograms {

    public static void main(String[] args) {

        // Allows input
        Scanner input = new Scanner(System.in);
        
        // run everything indefinitedly
        while (true) {
            System.out.println("Which question would you like to run? \nEnter the question number:");

            int question = input.nextInt();
            input.nextLine();

            if (question == 1) {

                // get the radius
                System.out.println("What is the radius of the circle?");

                double radius = input.nextDouble();

                // call on the method
                double answer = circleArea(radius);

                // display answer
                System.out.println("The area is " + answer
                        + "\n------------------------------------------------------");
            } else if (question == 2) {

                // test the code by having a mark entered in
                System.out.println("Enter your mark here");

                double mark = input.nextDouble();

                examGrade(mark);
            } else if (question == 3) {

                System.out.println("Enter a number:");

                int number = input.nextInt();

                factors(number);
            } else if (question == 4) {

                System.out.println("Enter the initial principal:");

                double prince = input.nextDouble();

                System.out.println("Enter the interest rate as a decimal:");

                double interesting = input.nextDouble();

                System.out.println("Enter the time left in the bank:");

                double waiting = input.nextDouble();

                double balance = compoundInterest(interesting, prince, waiting);

                System.out.println("The final balance is " + balance
                        + "\n------------------------------------------------------");
            } else if (question == 5) {

                System.out.println("Enter the number of lines: ");

                int numberOLines = input.nextInt();

                chaotic(numberOLines);

                System.out.println("\n------------------------------------------------------\n");
            } else if (question == 6) {

                System.out.println("Enter a integer: ");

                int digit = input.nextInt();

                int last = lastDigit(digit);

                System.out.println(last + " is the last digit");

                System.out.println("\n------------------------------------------------------\n");
            } else if (question == 7) {

                System.out.println("Enter a integer: ");

                int digit = input.nextInt();

                int first = firstDigit(digit);

                System.out.println(first + " is the first digit");

                System.out.println("\n------------------------------------------------------\n");
            } else if (question == 8) {

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
            } else {
                System.out.println("Not a value number");
            }
        }
    }
}
