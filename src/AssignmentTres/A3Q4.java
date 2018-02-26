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
 * Answering A3Q4
 *
 * @author pritb9521
 */
public class A3Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Create a city
        City pym = new City();

        // Create a robot in the city
        RobotSE arsenis = new RobotSE(pym, 3, 3, Direction.SOUTH);

        // create block 1
        new Wall(pym, 4, 4, Direction.NORTH);
        new Wall(pym, 4, 5, Direction.NORTH);
        new Wall(pym, 4, 5, Direction.EAST);
        new Wall(pym, 5, 5, Direction.EAST);
        new Wall(pym, 5, 5, Direction.SOUTH);
        new Wall(pym, 5, 4, Direction.SOUTH);
        new Wall(pym, 5, 4, Direction.WEST);
        new Wall(pym, 4, 4, Direction.WEST);

        // create block 2
        new Wall(pym, 4, 1, Direction.NORTH);
        new Wall(pym, 4, 2, Direction.NORTH);
        new Wall(pym, 4, 2, Direction.EAST);
        new Wall(pym, 5, 2, Direction.EAST);
        new Wall(pym, 5, 2, Direction.SOUTH);
        new Wall(pym, 5, 1, Direction.SOUTH);
        new Wall(pym, 5, 1, Direction.WEST);
        new Wall(pym, 4, 1, Direction.WEST);

        // create block 3
        new Wall(pym, 1, 1, Direction.NORTH);
        new Wall(pym, 1, 2, Direction.NORTH);
        new Wall(pym, 1, 2, Direction.EAST);
        new Wall(pym, 2, 2, Direction.EAST);
        new Wall(pym, 2, 2, Direction.SOUTH);
        new Wall(pym, 2, 1, Direction.SOUTH);
        new Wall(pym, 2, 1, Direction.WEST);
        new Wall(pym, 1, 1, Direction.WEST);

        // create block 4
        new Wall(pym, 1, 4, Direction.NORTH);
        new Wall(pym, 1, 5, Direction.NORTH);
        new Wall(pym, 1, 5, Direction.EAST);
        new Wall(pym, 2, 5, Direction.EAST);
        new Wall(pym, 2, 5, Direction.SOUTH);
        new Wall(pym, 2, 4, Direction.SOUTH);
        new Wall(pym, 2, 4, Direction.WEST);
        new Wall(pym, 1, 4, Direction.WEST);

        // make arsenis loop around the four blocks and end in his starting position
        for (int blockesMoved = 0; blockesMoved < 4; blockesMoved++) {
            for (int streetMoved = 0; streetMoved < 3; streetMoved++) {
                arsenis.move(3);
                arsenis.turnLeft();
            }
            arsenis.move(3);

        }

    }
}
