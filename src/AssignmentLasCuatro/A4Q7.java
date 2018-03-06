/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentLasCuatro;

import java.util.Scanner;

/**
 * Answering A4Q7
 *
 * @author pritb9521
 */
public class A4Q7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // allows input
        Scanner input = new Scanner(System.in);

        // Puts the player on the first spot
        int playerPosition = 1;

        // Plays the game
        while (playerPosition != 100) {
            // roll the dice and move
            System.out.print("Enter sum of your dice: ");
            int diceRoll = input.nextInt();

            // Stops the player from rolling unreal numbers
            if (diceRoll == 1 || diceRoll >= 13) {
                System.out.println("Nice try... you're rolling two dice, it has to be between 2 and 12");
                System.out.print("Enter sum of your dice: ");
                diceRoll = input.nextInt();
            } else if (diceRoll == 0) { // Allows the player to quit the game
                System.out.println("You quit!");
                System.exit(0);
            }
            playerPosition = playerPosition + diceRoll;

            // Sets up all snakes and ladders
            if (playerPosition == 54) {
                System.out.println("Oh no!  You hit a snake!");
                playerPosition = 19;
            } else if (playerPosition == 90) {
                System.out.println("Oh no!  You hit a snake!");
                playerPosition = 48;
            } else if (playerPosition == 99) {
                System.out.println("Oh no!  You hit a snake!");
                playerPosition = 77;
            } else if (playerPosition == 9) {
                System.out.println("Congradulations!  You hit a ladder!");
                playerPosition = 34;
            } else if (playerPosition == 40) {
                System.out.println("Congradulations!  You hit a ladder!");
                playerPosition = 64;
            } else if (playerPosition == 67) {
                System.out.println("Congradulations!  You hit a ladder!");
                playerPosition = 86;
            }
                while (playerPosition > 100) {
                    System.out.println("Seems you reached too big of a position, please reroll");
                    playerPosition = playerPosition - diceRoll;

                    // roll the dice and move
                    System.out.print("Enter sum of your dice: ");
                    diceRoll = input.nextInt();

                    // Move the player
                    playerPosition = playerPosition + diceRoll;
                }
                // Tells the player where they are
                System.out.println("You are now on square " + playerPosition);
            }
            // When the player reaches the final position they get congradulated
            System.out.println("Congradulations!  You won!");
        }
    }
