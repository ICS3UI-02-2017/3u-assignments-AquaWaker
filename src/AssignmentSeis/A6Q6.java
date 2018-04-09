/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentSeis;

import java.util.Scanner;

/**
 * Answering A6Q6
 *
 * @author pritb9521
 */
public class A6Q6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Allows input
        Scanner input = new Scanner(System.in);

        // Gain knowledge of the amount of marks
        System.out.print("How many students are there? : ");
        int handedIn = input.nextInt();

        // Gain thyne knowledge of all the marks
        System.out.println("Please enter the " + handedIn + " marks: ");
        double[] integers = new double[handedIn];
        for (int tInt = 0; tInt < handedIn; tInt++) {
            integers[tInt] = input.nextInt();
        }

        // If the first mark is larger, swap their positon, and repeat for all the marks
        for (int swapP2 = 0; swapP2 < (handedIn - 1); swapP2++) {
            for (int swapP1 = 0; swapP1 < handedIn; swapP1++) {
                double swap = 0;
                if (swapP1 != 0) {
                    if (integers[swapP1 - 1] > integers[swapP1]) {
                        swap = integers[swapP1 - 1];
                        integers[swapP1 - 1] = integers[swapP1];
                        integers[swapP1] = swap;
                    }
                }
            }
        }

        // Find the class average
        double average = 0;
        for (int add = 0; add < handedIn; add++) {
            average = average + integers[add];
        }
        average = average / handedIn;

        // State the highest, the lowest, and the average mark
        System.out.println("The highest mark is " + integers[integers.length - 1] + "% \n"
                + "The lowest mark is " + integers[0] + "% \n"
                + "The average mark is " + average + "%");
    }
}
