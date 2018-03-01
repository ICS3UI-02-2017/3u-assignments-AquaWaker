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

        System.out.println("Hello User");

        // Same something I'm giving up on you
        /**
         * int count = 10; double number = 3.12456425352;
         * System.out.println("count = " + count + ". blah blah");
         * System.out.printf("number = %.2f . blah blah blah \n", number);
         */
        // "\t = tab"
        // Allows input
        Scanner input = new Scanner(System.in);

        // Asks for number input before giving answer
        System.out.println("How old are you?");
        int age = input.nextInt();
        System.out.println("You are " + age + " years old");

        input.nextLine(); // clear the enter key

        // Asks for word input before giving answer
        System.out.println("What is your name? \n");
        String name = input.nextLine();
        System.out.println("Hello " + name + ", welcome back to the java code. \n");

        System.out.println("Please enter your password:");
        
        String password = input.nextLine();
        input.nextLine(); // clear the enter key
        System.out.println("Code name Xx_PvP_Elite_Edgy_Username_xX has successfully logged in. \n");

        System.out.println("What would you like to do? \n");

        String action = input.nextLine();

        if (action.equals("nuke")) {
            System.out.println("");
            System.out.println("Please select a city to nuke");

            String city = input.nextLine();

            System.out.println("Now nuking city " + city);
        } else if (action.equals("yes")){
            System.out.println("");
            System.out.println("Y-yes?  Just yes?  You realise I can't do anything with just.... yes\n");
        
            String yes = input.nextLine();
            System.out.println("");
            
            if(yes.equals("yes")){
                System.out.println("Now we can all get al-- Hey wait are you trying to be a funny guy?\n");
                
                String yesTwo = input.nextLine();
                System.out.println("");
                
                if(yesTwo.equals("yes")){
                    System.out.println("");
                    System.out.println("Man... I don't know how to stop you... Let's just... leave it at this...");
                }
            }
            
        }


    }
}
