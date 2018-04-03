/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentSeis;

import java.util.Scanner;

/**
 * Answering A6Q1
 * @author pritb9521
 */
public class A6Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Allows input
        Scanner input = new Scanner(System.in);
        
        // Gain thy knowledge of existing individuals in thyne classroom
        System.out.print("How many students are there in the class? : ");
        int students = input.nextInt();
        
        // Gain thy knowledge of test results
        double[] marks = new double[students];
        System.out.println("Please enter their marks:");
        for (int marksFind = 0; marksFind < students; marksFind++) {
            System.out.println("Input the " + (marksFind + 1) + " test mark");
            double results = input.nextInt();
        }
        
        // Calculated thyne averages
        double average = 0;
        for (int i = 0; i < students; i++) {
            average = average + marks[i];
        }
        System.out.println(average);
        average = average / students;
        
        System.out.println("Thy classroom average is " + average + "%");
        
    }
}
