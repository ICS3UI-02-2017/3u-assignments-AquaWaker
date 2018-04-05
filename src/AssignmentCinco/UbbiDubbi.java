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
        String gather = input.nextLine();

        // sanitize the input
        gather = gather.toLowerCase();
        String test = gather + " ";

        //get the length of the string
        int length = test.length();


        // Checks for vowels and adds ub in front of them
        for (int vowelCheck = 0; vowelCheck < length; vowelCheck++) {
            System.out.println("vowel: " +vowelCheck);
            if (test.charAt(vowelCheck) == 'u') {
                length = length + 2;
                if (test.charAt(vowelCheck + 1) != 'e' && test.charAt(vowelCheck + 1) != 'a' && test.charAt(vowelCheck + 1) != 'i' && test.charAt(vowelCheck + 1) != 'o' && test.charAt(vowelCheck + 1) != 'u') {
                    test = test.replaceFirst("u", "ubu");
                    vowelCheck = vowelCheck + 2;
                } else if (test.charAt(vowelCheck + 1) == 'e' || test.charAt(vowelCheck + 1) == 'a' || test.charAt(vowelCheck + 1) == 'i' || test.charAt(vowelCheck + 1) == 'o' || test.charAt(vowelCheck + 1) == 'u'){
                    test = test.replaceFirst("u", "ubu");
                    vowelCheck = vowelCheck + 3;
                }
            } else if (test.charAt(vowelCheck) == 'e') {
                length = length + 2;
                if (test.charAt(vowelCheck + 1) != 'e' && test.charAt(vowelCheck + 1) != 'a' && test.charAt(vowelCheck + 1) != 'i' && test.charAt(vowelCheck + 1) != 'o' && test.charAt(vowelCheck + 1) != 'u') {
                    test = test.replaceFirst("e", "ube");
                    vowelCheck = vowelCheck + 2;
                } else if (test.charAt(vowelCheck + 1) == 'e' || test.charAt(vowelCheck + 1) == 'a' || test.charAt(vowelCheck + 1) == 'i' || test.charAt(vowelCheck + 1) == 'o' || test.charAt(vowelCheck + 1) == 'u'){
                    test = test.replaceFirst("e", "ube");
                    vowelCheck = vowelCheck + 3;
                }
            } else if (test.charAt(vowelCheck) == 'a') {
                length = length + 2;
                if (test.charAt(vowelCheck + 1) != 'e' && test.charAt(vowelCheck + 1) != 'a' && test.charAt(vowelCheck + 1) != 'i' && test.charAt(vowelCheck + 1) != 'o' && test.charAt(vowelCheck + 1) != 'u') {
                    test = test.replaceFirst("a", "uba");
                    vowelCheck = vowelCheck + 2;
                } else if (test.charAt(vowelCheck + 1) == 'e' || test.charAt(vowelCheck + 1) == 'a' || test.charAt(vowelCheck + 1) == 'i' || test.charAt(vowelCheck + 1) == 'o' || test.charAt(vowelCheck + 1) == 'u'){
                    test = test.replaceFirst("a", "uba");
                    vowelCheck = vowelCheck + 3;
                }
            } else if (test.charAt(vowelCheck) == 'i') {
                length = length + 2;
                if (test.charAt(vowelCheck + 1) != 'e' && test.charAt(vowelCheck + 1) != 'a' && test.charAt(vowelCheck + 1) != 'i' && test.charAt(vowelCheck + 1) != 'o' && test.charAt(vowelCheck + 1) != 'u') {
                    test = test.replaceFirst("i", "ubi");
                    vowelCheck = vowelCheck + 2;
                } else if (test.charAt(vowelCheck + 1) == 'e' || test.charAt(vowelCheck + 1) == 'a' || test.charAt(vowelCheck + 1) == 'i' || test.charAt(vowelCheck + 1) == 'o' || test.charAt(vowelCheck + 1) == 'u'){
                    test = test.replaceFirst("i", "ubi");
                    vowelCheck = vowelCheck + 3;
                }
            } else if (test.charAt(vowelCheck) == 'o') {
               
                length = length + 2;
                if (test.charAt(vowelCheck + 1) != 'e' && test.charAt(vowelCheck + 1) != 'a' && test.charAt(vowelCheck + 1) != 'i' && test.charAt(vowelCheck + 1) != 'o' && test.charAt(vowelCheck + 1) != 'u') {
                    test = test.replaceFirst("o", "ubo");
                    vowelCheck = vowelCheck + 2;
                } else if (test.charAt(vowelCheck + 1) == 'e' || test.charAt(vowelCheck + 1) == 'a' || test.charAt(vowelCheck + 1) == 'i' || test.charAt(vowelCheck + 1) == 'o' || test.charAt(vowelCheck + 1) == 'u'){
                    test = test.replaceFirst("o", "ubo");
                    vowelCheck = vowelCheck + 3;
                    
                }

            }
            
        }

        System.out.print("Your translation into Ubbi Dubbi is: ");
        System.out.println(test);
    }
}
