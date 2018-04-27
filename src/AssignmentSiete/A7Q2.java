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
public class A7Q2 {

    // determines the appropriate grade to the mark
    public static void examGrade(double g) {

        // create the grade variable
        char grade = 'i';

        // determines the grade of the mark
        if (g >= 0 && g < 50) {
            grade = 'F';

        } else if (g >= 50 && g < 60) {
            grade = 'D';
        } else if (g >= 60 && g < 70) {
            grade = 'C';
        } else if (g >= 70 && g < 80) {
            grade = 'B';
        } else if (g >= 80 && g <= 100) {
            grade = 'A';
        }


        if (grade != 'i') {
            System.out.println("The mark received would be " + grade
                    + "\n------------------------------------------------------");
        } else {
            System.out.println("The mark entered is invald"
                    + "\n------------------------------------------------------");
        }
    }

    public static void main(String[] args) {

        // Allows input
        Scanner input = new Scanner(System.in);

        // Allows the program to be run indefinitely 
        while (true) {
            // test the code by having a mark entered in
            System.out.println("Enter your mark here");

            double mark = input.nextDouble();

            examGrade(mark);
        }
    }
}
