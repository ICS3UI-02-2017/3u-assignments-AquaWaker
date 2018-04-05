/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentSeis;

import java.util.Scanner;

/**
 * Answering A6Q4
 *
 * @author pritb9521
 */
public class A6Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Allows input
        Scanner input = new Scanner(System.in);

        // Gain thyne knowledge of ten integers
        System.out.println("Please enter the ten marks: ");
        int[] integers = new int[10];
        for (int tInt = 0; tInt < 10; tInt++) {
            integers[tInt] = input.nextInt();
        }

        // If the first mark is larger, swap their positon, and repeat for all the marks
        for (int swapP2 = 0; swapP2 < 9; swapP2++) {
            for (int swapP1 = 0; swapP1 < 10; swapP1++) {
                int swap = 0;
                if (swapP1 != 0) {
                    if (integers[swapP1 - 1] > integers[swapP1]) {
                        swap = integers[swapP1 - 1];
                        integers[swapP1 - 1] = integers[swapP1];
                        integers[swapP1] = swap;
                    }
                }
            }
        }
        // Give back the values
        System.out.println("The marks in order are: ");
        for (int present = 0; present < 10; present++) {
            System.out.print(integers[present] + ", ");
        }
    }
}