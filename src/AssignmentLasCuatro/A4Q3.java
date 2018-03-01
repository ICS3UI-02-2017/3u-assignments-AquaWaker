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
public class A4Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Allows for input
        Scanner input = new Scanner(System.in);

        // asks for 4 numbers and then allows input of such 4 numbers
        System.out.println("Select 4 digits, please don't ask why I just need them");
        
        double frtNum = input.nextDouble();
        double scdNum = input.nextDouble();
        double trdNum = input.nextDouble();
        double forNum = input.nextDouble();
        
        System.out.println("You selected the numbers " + frtNum + ", " + scdNum + ", " + trdNum + ", and fianlly " + forNum);

    }
}
