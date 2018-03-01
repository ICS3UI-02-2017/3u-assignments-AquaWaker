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
public class A4Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Allows for system input
        Scanner input = new Scanner(System.in);

        // Get the computer to ask for a name
        System.out.println("Hello individual, it appears that I may not know your name, what is your name?");

        // Create the variable 
        String userName = input.nextLine();

        System.out.println("I was just about to guess " + userName + ", what's up?");

        // Joke of my liiiiife
        String sky = input.nextLine();
        if (sky.equals("the sky")) {
            System.out.println("Ah ha... Ah ha... We have a person who thinks they are funny... I'm just going to terminate myself now...");
        }
    }
}
