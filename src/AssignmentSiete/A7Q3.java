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
public class A7Q3 {

    // prints out the factors of an entered number
    public static void factors(int integer){
        
        int[] allFactors = new int[integer];
        
        for (int i = 1; i < integer; i++) {
            if (integer % i == 0){
                allFactors[i - 1] = i; 
            }
        }
        System.out.println("The factors of " + integer );
        for (int display = 0; display < 10; display++) {
            
        }
    }
    
    public static void main(String[] args) {
        
        // Allows input
        Scanner input = new Scanner(System.in);
        
        // allows the code to be tested indefinitely 
        while (true) {
            
        }
        
    }
}
