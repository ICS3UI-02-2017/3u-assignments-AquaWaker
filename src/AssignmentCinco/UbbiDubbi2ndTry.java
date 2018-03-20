/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentCinco;

import java.util.Scanner;

/**
 *
 * @author pritb9521
 */
public class UbbiDubbi2ndTry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Allows input
        Scanner input = new Scanner(System.in);

        System.out.println("Input the text to translate to Ubbi Dubbi");
        String test = input.nextLine();

        // sanitize the input
        test = test.toLowerCase();
        
        //get the length of the string
        int length = test.length();
        
        for (int check = 0; check < length; check++) {
            
        }
        
    }
}
