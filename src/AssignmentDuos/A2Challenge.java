/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentDuos;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 * Trying the Challenge question
 *
 * @author pritb9521
 */
public class A2Challenge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        City pym = new City();

        // create a robot
        RobotSE karel = new RobotSE(pym, 0, 2, Direction.SOUTH);
        RobotSE tina = new RobotSE(pym, 0, 2, Direction.SOUTH);

        // create the street
        new Wall(pym, 0, 0, Direction.WEST);
        new Wall(pym, 1, 0, Direction.WEST);
        new Wall(pym, 2, 0, Direction.WEST);
        new Wall(pym, 3, 0, Direction.WEST);
        new Wall(pym, 4, 0, Direction.WEST);
        new Wall(pym, 5, 0, Direction.WEST);
        new Wall(pym, 6, 0, Direction.WEST);
        new Wall(pym, 7, 0, Direction.WEST);
        new Wall(pym, 8, 0, Direction.WEST);
        new Wall(pym, 9, 0, Direction.WEST);

        new Wall(pym, 0, 1, Direction.EAST);
        new Wall(pym, 1, 1, Direction.EAST);
        new Wall(pym, 2, 1, Direction.EAST);
        new Wall(pym, 3, 1, Direction.EAST);
        new Wall(pym, 4, 1, Direction.EAST);
        new Wall(pym, 5, 1, Direction.EAST);
        new Wall(pym, 6, 1, Direction.EAST);
        new Wall(pym, 7, 1, Direction.EAST);
        new Wall(pym, 8, 1, Direction.EAST);
        new Wall(pym, 9, 1, Direction.EAST);

        // create the first driveway
        new Wall(pym, 0, 2, Direction.EAST);
        new Wall(pym, 1, 3, Direction.NORTH);
        new Wall(pym, 1, 4, Direction.NORTH);
        new Wall(pym, 1, 5, Direction.NORTH);
        new Wall(pym, 1, 6, Direction.NORTH);
        new Wall(pym, 1, 6, Direction.EAST);
        new Wall(pym, 2, 6, Direction.EAST);
        new Wall(pym, 2, 6, Direction.SOUTH);
        new Wall(pym, 2, 5, Direction.SOUTH);
        new Wall(pym, 2, 4, Direction.SOUTH);
        new Wall(pym, 2, 3, Direction.SOUTH);
        new Wall(pym, 3, 2, Direction.EAST);

        // create the second driveway
        new Wall(pym, 4, 3, Direction.NORTH);
        new Wall(pym, 4, 4, Direction.NORTH);
        new Wall(pym, 4, 5, Direction.NORTH);
        new Wall(pym, 4, 5, Direction.EAST);
        new Wall(pym, 4, 5, Direction.SOUTH);
        new Wall(pym, 4, 4, Direction.SOUTH);
        new Wall(pym, 4, 3, Direction.SOUTH);
        new Wall(pym, 5, 2, Direction.EAST);

        // create the third driveway
        new Wall(pym, 6, 2, Direction.EAST);
        new Wall(pym, 7, 3, Direction.NORTH);
        new Wall(pym, 7, 4, Direction.NORTH);
        new Wall(pym, 7, 5, Direction.NORTH);
        new Wall(pym, 7, 6, Direction.NORTH);
        new Wall(pym, 7, 7, Direction.NORTH);
        new Wall(pym, 7, 7, Direction.EAST);
        new Wall(pym, 8, 7, Direction.EAST);
        new Wall(pym, 8, 7, Direction.SOUTH);
        new Wall(pym, 8, 6, Direction.SOUTH);
        new Wall(pym, 8, 5, Direction.SOUTH);
        new Wall(pym, 8, 4, Direction.SOUTH);
        new Wall(pym, 8, 3, Direction.SOUTH);
        new Wall(pym, 9, 2, Direction.EAST);
        new Wall(pym, 9, 2, Direction.SOUTH);



        // Create the snow
        new Thing(pym, 1, 2);
        new Thing(pym, 1, 3);
        new Thing(pym, 1, 4);
        new Thing(pym, 1, 5);
        new Thing(pym, 2, 2);
        new Thing(pym, 2, 4);
        new Thing(pym, 2, 6);

        new Thing(pym, 4, 2);
        new Thing(pym, 4, 3);
        new Thing(pym, 4, 4);

        new Thing(pym, 7, 2);
        new Thing(pym, 7, 3);
        new Thing(pym, 7, 7);
        new Thing(pym, 8, 3);
        new Thing(pym, 8, 4);
        new Thing(pym, 8, 6);

        // Get karel to shovel the driveway
        while (true) {
            while (karel.frontIsClear()) {
                karel.turnLeft();
                if (!(karel.frontIsClear())) {
                    karel.turnRight();
                }
                if (karel.canPickThing()) {
                    karel.pickThing();
                }
                karel.move();
                if (karel.getAvenue() == 2) {
                }

            }
            if (!(karel.frontIsClear())) {
                karel.turnRight();
                if (karel.frontIsClear()) {
                    karel.move();
                    if (karel.canPickThing()) {
                        karel.pickThing();
                    }
                } else {
                    karel.turnRight();
                }
            }
            if (karel.getAvenue() == 2) {
                karel.putAllThings();

            }
        }
    }
}
