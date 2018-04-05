/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentSeis;

import java.util.Scanner;

/**
 * Answering A6Q3
 *
 * @author pritb9521
 */
public class A6Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Allows input
        Scanner input = new Scanner(System.in);

        // Gain thyne knowledge of two integers
        System.out.print("Please enter two integers: ");
        int[] integers = new int[2];
        for (int tInt = 0; tInt < 2; tInt++) {
            integers[tInt] = input.nextInt();
        }

        // If the first integer is larger, swap their positon
        int swap = 0;
        if (integers[0] > integers[1]) {
            swap = integers[0];
            integers[0] = integers[1];
            integers[1] = swap;
        }

        // give the result back to the person
        System.out.println("the integers in accending order are " + integers[0] + " and " + integers[1]);
    }
}