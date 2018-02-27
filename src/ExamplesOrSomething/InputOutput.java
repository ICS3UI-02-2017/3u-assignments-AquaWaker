/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamplesOrSomething;

import java.util.Scanner;

/**
 *
 * @author pritb9521
 */
public class InputOutput {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Same something I'm giving up on you
        /**int count = 10;
        double number = 3.12456425352;
        System.out.println("count = " + count + ". blah blah");
        System.out.printf("number = %.2f . blah blah blah \n", number);
        */
        
        // Allows input
        Scanner input = new Scanner(System.in);
        
        // Asks for number input before giving answer
        System.out.println("How old are you?");
        int age = input.nextInt();
        System.out.println("You are " + age + " years old");
        
        input.nextLine(); // clear the enter key
        
        // Asks for word input before giving answer\
        System.out.println("What is your name? \n");
        String name = input.nextLine();
        System.out.println("Hello " + name + ", welcome back to the java code. \n");
        
        System.out.println("Please enter your password:");
        String password = input.nextLine();
        input.nextLine(); // clear the enter key
        System.out.println("Code name Xx_PvP_Elite_Edgy_Username_xX has successfully logged in. \n");
        
        System.out.println("What would you like to do? \n");
        
        String action = input.nextLine();
        
        System.out.println("Please select a city to " + action);
        
        input.nextLine(); // clear the enter key
        
        String city = input.nextLine();
        
        System.out.println("Now " + action + " city " + city);
    }
}
