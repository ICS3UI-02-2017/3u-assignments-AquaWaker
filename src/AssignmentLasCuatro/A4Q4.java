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
public class A4Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // allows input
        Scanner input = new Scanner(System.in);
        
        // Ask questions to determine the total cost of prom
        System.out.println("hey prom is happening, we need to figure out how much it costs!\n"
                + "How much does the food for prom cost?");
        double food = input.nextDouble();
        
        System.out.println("Ok I see... How much does the DJ cost?");
        double dj = input.nextDouble();

        System.out.println("Alright!  How much does the hall cost to rent?");
        double hall = input.nextDouble();
        
        System.out.println("I understand... How much do the decorations cost?");
        double decor = input.nextDouble();
        
        System.out.println("Almost everything... How much does it cost to hire the staff?");
        double staff = input.nextDouble();
        
        System.out.println("Last but not least!  How much for the other miscellaneous");
        double mis = input.nextDouble();
        
        // Determine the total cost and the number of tickets needed to break even
        double totalCost = food + dj + hall + decor + staff + mis;
        
        double ticketsNeeded = totalCost/35;
        
        
        
    }
}
