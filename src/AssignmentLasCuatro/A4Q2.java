/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentLasCuatro;

import java.util.Scanner;

/**
 *
 * @author pritb9521
 */
public class A4Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Allows for user input!
        Scanner input = new Scanner(System.in);
        
        // The computer greets the person and tells them it's purpose
        System.out.println("Hello individual, I am your inches to centimetre calculator.  Please enter a value of inches");
        
        // Create the variable 
        double inches = input.nextDouble();
        
        // Perform the calculations
        double centi = 2.54 * inches;
        
        System.out.println("Your answer is " + centi + " centimetres");
    }
}
