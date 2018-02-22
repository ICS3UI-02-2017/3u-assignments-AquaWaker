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
import java.awt.Color;

/**
 *
 * @author pritb9521
 */
public class A2ChallengeNoWallCheck {

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
        new Wall(pym, 10, 0, Direction.WEST);

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
        new Wall(pym, 10, 1, Direction.EAST);

        // create the first driveway
        new Wall(pym, 0, 2, Direction.EAST);
        new Wall(pym, 1, 3, Direction.NORTH);
        new Wall(pym, 1, 4, Direction.NORTH);
        new Wall(pym, 1, 5, Direction.NORTH);
        new Wall(pym, 1, 6, Direction.NORTH);
        new Wall(pym, 1, 6, Direction.EAST);
        new Wall(pym, 2, 6, Direction.EAST);
        new Wall(pym, 3, 6, Direction.SOUTH);
        new Wall(pym, 3, 5, Direction.SOUTH);
        new Wall(pym, 3, 4, Direction.SOUTH);
        new Wall(pym, 3, 3, Direction.SOUTH);
        new Wall(pym, 4, 2, Direction.EAST);

        new Wall(pym, 3, 6, Direction.EAST);

        // create the second driveway
        new Wall(pym, 5, 3, Direction.NORTH);
        new Wall(pym, 5, 4, Direction.NORTH);
        new Wall(pym, 5, 5, Direction.NORTH);
        new Wall(pym, 5, 5, Direction.EAST);
        new Wall(pym, 5, 5, Direction.SOUTH);
        new Wall(pym, 5, 4, Direction.SOUTH);
        new Wall(pym, 5, 3, Direction.SOUTH);
        new Wall(pym, 6, 2, Direction.EAST);

        // create the third driveway
        new Wall(pym, 7, 2, Direction.EAST);
        new Wall(pym, 8, 3, Direction.NORTH);
        new Wall(pym, 8, 4, Direction.NORTH);
        new Wall(pym, 8, 5, Direction.NORTH);
        new Wall(pym, 8, 6, Direction.NORTH);
        new Wall(pym, 8, 7, Direction.NORTH);
        new Wall(pym, 8, 7, Direction.EAST);
        new Wall(pym, 9, 7, Direction.EAST);
        new Wall(pym, 9, 7, Direction.SOUTH);
        new Wall(pym, 9, 6, Direction.SOUTH);
        new Wall(pym, 9, 5, Direction.SOUTH);
        new Wall(pym, 9, 4, Direction.SOUTH);
        new Wall(pym, 9, 3, Direction.SOUTH);
        new Wall(pym, 10, 2, Direction.EAST);
        new Wall(pym, 10, 2, Direction.SOUTH);



        // Create the snow
        Thing snow1 = new Thing(pym, 1, 2);
        Thing snow2 = new Thing(pym, 1, 3);
        Thing snow3 = new Thing(pym, 1, 4);
        Thing snow4 = new Thing(pym, 1, 5);
        Thing snow5 = new Thing(pym, 3, 2);
        Thing snow6 = new Thing(pym, 2, 4);
        Thing snow7 = new Thing(pym, 2, 6);

        Thing snow8 = new Thing(pym, 5, 2);
        Thing snow9 = new Thing(pym, 5, 3);
        Thing snow10 = new Thing(pym, 5, 4);

        Thing snow11 = new Thing(pym, 8, 2);
        Thing snow12 = new Thing(pym, 8, 3);
        Thing snow13 = new Thing(pym, 8, 7);
        Thing snow14 = new Thing(pym, 9, 3);
        Thing snow15 = new Thing(pym, 9, 4);
        Thing snow16 = new Thing(pym, 9, 6);

        // Make all the snow white
        snow1.setColor(Color.white);
        snow2.setColor(Color.white);
        snow3.setColor(Color.white);
        snow4.setColor(Color.white);
        snow5.setColor(Color.white);
        snow6.setColor(Color.white);
        snow7.setColor(Color.white);
        snow8.setColor(Color.white);
        snow9.setColor(Color.white);
        snow10.setColor(Color.white);
        snow11.setColor(Color.white);
        snow12.setColor(Color.white);
        snow13.setColor(Color.white);
        snow14.setColor(Color.white);
        snow15.setColor(Color.white);
        snow16.setColor(Color.white);

        while (karel.getStreet() != 10) {
            /**
             * make karel check for a driveway, if there is one, move onto it if
             * there is a wall, turn left
             */
            while (karel.getAvenue() == 2 && karel.getStreet() != 10) {
                if (karel.frontIsClear()) {
                    if (karel.countThingsInBackpack() > 0) {
                        karel.putAllThings();
                    }
                    karel.move();
                    karel.turnLeft();
                    if (karel.frontIsClear()) {
                        karel.move();
                    } else {
                        karel.turnRight();
                    }
                } else {
                    karel.turnLeft();
                }

            }
            /**
             * Once karel is on a driveway, move up and down it to shovel all
             * the snow up and move it to the sidewalk
             */
            while (karel.getAvenue() > 2) {
                if (karel.canPickThing()) {
                    karel.pickAllThings();
                }
                if (karel.frontIsClear()) {
                    karel.move();
                } else {
                    karel.turnRight();
                    if (!(karel.frontIsClear())) {
                        karel.turnRight();
                    } else {
                        karel.move();
                        karel.turnRight();
                    }
                }
            }
        }
        // once karel is done shovelling everything to the 
        while (tina.getStreet() != 10) {
            if (tina.canPickThing()) {
                tina.pickAllThings();
            }
            tina.move();
        }
        // Place all the snow down in the final spot
        if (tina.getStreet() == 10) {
            tina.putAllThings();
        }
    }
}
