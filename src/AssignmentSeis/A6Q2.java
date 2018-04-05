/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentSeis;

import java.util.Scanner;

/**
 * Answering A6Q2
 *
 * @author pritb9521
 */
public class A6Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Allows input
        Scanner input = new Scanner(System.in);

        // Find the number of males and females in the group
        System.out.print("How many people are there in the group?: ");
        int people = input.nextInt();

        // find out the male heights
        System.out.println("What are the heights for the people? (Please answer in cm):");
        int[] heights = new int[people];
        for (int mh = 0; mh < people; mh++) {
            heights[mh] = input.nextInt();
        }

        // determine the average height
        int totalHeight = 0;
        for (int th = 0; th < people; th++) {
            totalHeight = totalHeight + heights[th];
        }
        int average = totalHeight / people;

        // determine how many are above average height
        int aboveAverage = 0;
        for (int aa = 0; aa < people; aa++) {

            if (heights[aa] > average) {
                aboveAverage = aboveAverage + 1;
            }
        }


        // give the result
        System.out.println("In this particular group of people, " + aboveAverage + " are above the average height");
    }
}
