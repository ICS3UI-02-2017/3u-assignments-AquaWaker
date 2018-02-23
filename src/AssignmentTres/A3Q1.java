/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentTres;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Wall;

/**
 * Answering A3Q1
 *
 * @author pritb9521
 */
public class A3Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Create a city
        City pym = new City();

        // Create a robot in the city
        RobotSE arsenis = new RobotSE(pym, 0, 2, Direction.WEST);

        // Create the square for the robot to move around
        new Wall(pym, 1, 1, Direction.WEST);
        new Wall(pym, 2, 1, Direction.WEST);
        new Wall(pym, 2, 1, Direction.SOUTH);
        new Wall(pym, 2, 2, Direction.SOUTH);
        new Wall(pym, 2, 2, Direction.EAST);
        new Wall(pym, 1, 2, Direction.EAST);
        new Wall(pym, 1, 2, Direction.NORTH);
        new Wall(pym, 1, 1, Direction.NORTH);

        // Make arsenis move around the box twice by counting how many times he moves
        for (int movesAroundBox = 0; movesAroundBox < 24; movesAroundBox++) {
            arsenis.turnLeft();
            if (arsenis.frontIsClear()) {
                arsenis.move();
            } else {
                arsenis.turnRight();
                arsenis.move();
            }
        }

    }
}
