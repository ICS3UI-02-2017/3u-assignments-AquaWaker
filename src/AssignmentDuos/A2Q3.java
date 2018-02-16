/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentDuos;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;

/**
 * Answering A2Q3
 *
 * @author pritb9521
 */
public class A2Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Create a city for the robot
        City pym = new City();

        // Put a robot in pym
        RobotSE arsenis = new RobotSE(pym, 10, 10, Direction.EAST);

        // checking to see if he is on the right street, if he isn't, move to it
        while (!(arsenis.getStreet() == 0)) {

            // if the he is above the origin, and not facing south, turn
            while (arsenis.getAvenue() <= -1 && arsenis.getDirection() != Direction.SOUTH) {
                arsenis.turnLeft();

            }

            // if the he is below the origin, and not facing north, turn
            while (arsenis.getAvenue() >= 1 && arsenis.getDirection() != Direction.NORTH) {
                arsenis.turnRight();

            }
            // move til he is on the origin street
            arsenis.move();
            

        }
        // checking to see if he is on the right avenue, if he isn't, move to it
        while (!(arsenis.getAvenue() == 0)) {

            // if the he is to the left of the origin, and not facing east, turn
            while (arsenis.getStreet() <= 0 && arsenis.getDirection() != Direction.EAST) {
                arsenis.turnLeft();

            }

            // if the he is to the right of the origin, and not facing west, turn
            while (arsenis.getStreet() >= 0 && arsenis.getDirection() != Direction.WEST) {
                arsenis.turnRight();

            }
            // move til he is on the origin avenue
            arsenis.move();

        }

    }
}
