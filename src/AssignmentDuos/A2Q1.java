/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentDuos;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;

/**
 *
 * @author pritb9521
 */
public class A2Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Create a city for the robot
        City pym = new City();

        // Put a robot in pym
        RobotSE arsenis = new RobotSE(pym, 1, 1, Direction.EAST);

        // Create ten things for arsenis to pick up
        new Thing(pym, 1, 2);
        new Thing(pym, 1, 3);
        new Thing(pym, 1, 4);
        new Thing(pym, 1, 5);
        new Thing(pym, 1, 6);
        new Thing(pym, 1, 7);
        new Thing(pym, 1, 8);
        new Thing(pym, 1, 9);
        new Thing(pym, 1, 10);
        new Thing(pym, 1, 11);

        // Check to see if arsenis is not at avenue 12
        while (!(arsenis.getAvenue() == 12)) {

            // if he isn't move 1 space
            arsenis.move();

            // check to see if arsenis has 7 things in his backpack, if he
            // doesn't, pick up a thing
            if (!(arsenis.countThingsInBackpack() == 7)) {
                arsenis.pickThing();
            }

        }

    }
}
