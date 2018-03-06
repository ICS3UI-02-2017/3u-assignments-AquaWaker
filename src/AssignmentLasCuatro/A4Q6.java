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
public class A4Q6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // allows input
        Scanner input = new Scanner(System.in);

        // Gain the inteligence of the car's speed and speed limit
        System.out.print("Enter the speed limit: ");

        int speedLimit = input.nextInt();

        System.out.print("Enter your speed: ");

        int currentSpeed = input.nextInt();

        // Figure out if the car is speeding
        int speeding = currentSpeed - speedLimit;

        // Tell the driver their fine if they are speeding, adn congradulate if they aren't
        if (1 <= speeding && speeding <= 20) {
            System.out.println("Sorry bud... You're speeding a bit and you were caught.  "
                    + "You owe a fine of $100 now.");
        } else if (21 <= speeding && speeding <= 30) {
            System.out.println("It was a bit of an effort to catch you, but there is no escaping "
                    + "the police, you now owe a fine of $270");
        } else if (speeding > 30) {
            System.out.println("Glad we caught you before someone was hurt, that is reckless driving"
                    + "\nand if I were more then a computer program I'd charge you for more, but your"
                    + "\ncurrent fine is $500");
        } else {
            System.out.println("Congradulations!  You're driving safely!");
        }
    }
}
