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

        // Get the length of the string
        int length = test.length();

        // Translated word variable
        String translated = new String();

        // Creates a list of vowels
        String vowel = "aeiou";

        // Rebuild the word
        for (int check = 0; check < length; check++) {
            // checks for a non-vowel letter
            if (vowel.indexOf(test.charAt(check)) == -1) {
                char c = test.charAt(check);
                translated = translated + c;

            // if there is a vowel letter at the begining don't check before
            } else if (check > 0) {
                if (vowel.indexOf(test.charAt(check - 1)) != -1) {
                    char v = test.charAt(check);
                    translated = translated + v;
                } else {
                    char v = test.charAt(check);
                    translated = translated + "ub" + v;
                }
            // if the vowel is in the middle of the word
            } else if (vowel.indexOf(test.charAt(check)) != -1) {
                char av = test.charAt(check);
                String ubbi = "ub" + av;
                translated = translated + ubbi;
            }

        }

        // State the translated word
        System.out.println("Your translated word or sequence is: " + translated);
    }
}
