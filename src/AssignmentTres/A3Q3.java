/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentTres;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;

/**
 * Answering A3Q3
 *
 * @author pritb9521
 */
public class A3Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Create a city
        City pym = new City();

        // Tell how many seeds start in the backpack
        int seedsInBackpack = 20;

        // Create a robot in the city
        RobotSE arsenis = new RobotSE(pym, 1, 1, Direction.EAST, seedsInBackpack);

        // While there are still seeds in the backpack, zig zag 
        for (; seedsInBackpack >= 1;) {
            if (arsenis.getAvenue() < 6 && arsenis.getAvenue() > 0) {
                arsenis.putThing();
                seedsInBackpack = seedsInBackpack - 1;
                arsenis.move();
            } else if (arsenis.getAvenue() >= 6) {
                arsenis.turnRight();
                arsenis.move();
            } else {
                arsenis.turnLeft();
                arsenis.move();
            }

        }

        // get arsenis to the spot the assignment wants him to end at
        arsenis.turnLeft();
        arsenis.move();
        arsenis.turnLeft();
        arsenis.move();
    }
}
