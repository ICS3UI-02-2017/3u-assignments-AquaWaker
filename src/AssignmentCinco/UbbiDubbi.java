/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentCinco;

import java.util.Scanner;

/**
 * Translating Ubbi Dubbi
 *
 * @author pritb9521
 */
public class UbbiDubbi {

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
        
        // Checks for vowels and adds ub in front of them
        for (int vowelCheck = 0; vowelCheck <= length; vowelCheck++) {

            if (test.charAt(vowelCheck) == 'u') {
                if (test.charAt(vowelCheck + 1) != 'e' && test.charAt(vowelCheck + 1) != 'a' && test.charAt(vowelCheck + 1) != 'i' && test.charAt(vowelCheck + 1) != 'o' && test.charAt(vowelCheck + 1) != 'u') {
                    test = test.replace("u", "ubu");
                    length = test.length();
                    vowelCheck = vowelCheck + 2;
                }
            } else if (test.charAt(vowelCheck) == 'e') {
                if (test.charAt(vowelCheck + 1) != 'e' && test.charAt(vowelCheck + 1) != 'a' && test.charAt(vowelCheck + 1) != 'i' && test.charAt(vowelCheck + 1) != 'o' && test.charAt(vowelCheck + 1) != 'u') {
                    test = test.replace("e", "ube");
                    length = test.length();
                    vowelCheck = vowelCheck + 2;
                }
            } else if (test.charAt(vowelCheck) == 'a') {
                if (test.charAt(vowelCheck + 1) != 'e' && test.charAt(vowelCheck + 1) != 'a' && test.charAt(vowelCheck + 1) != 'i' && test.charAt(vowelCheck + 1) != 'o' && test.charAt(vowelCheck + 1) != 'u') {
                    test = test.replace("a", "uba");
                    length = test.length();
                    vowelCheck = vowelCheck + 2;
                }
            } else if (test.charAt(vowelCheck) == 'i') {
                if (test.charAt(vowelCheck + 1) != 'e' && test.charAt(vowelCheck + 1) != 'a' && test.charAt(vowelCheck + 1) != 'i' && test.charAt(vowelCheck + 1) != 'o' && test.charAt(vowelCheck + 1) != 'u') {
                    test = test.replace("i", "ubi");
                    length = test.length();
                    vowelCheck = vowelCheck + 2;
                }
            } else if (test.charAt(vowelCheck) == 'o') {
                if (test.charAt(vowelCheck + 1) != 'e' && test.charAt(vowelCheck + 1) != 'a' && test.charAt(vowelCheck + 1) != 'i' && test.charAt(vowelCheck + 1) != 'o' && test.charAt(vowelCheck + 1) != 'u') {
                    test = test.replace("o", "ubo");
                    length = test.length();
                    vowelCheck = vowelCheck + 2;
                }

            }

        }

        System.out.print("Your translation into Ubbi Dubbi is: ");
        System.out.println(test);
    }
}
