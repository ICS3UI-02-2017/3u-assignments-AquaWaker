/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentDuos;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Wall;

/**
 * Answering A2Q4
 *
 * @author pritb9521
 */
public class A2Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Create a city for the robot
        City pym = new City();

        // Put a robot in pym
        RobotSE arsenis = new RobotSE(pym, 0, 0, Direction.EAST);

        // Create the castle

        // top left tower
        new Wall(pym, 1, 1, Direction.SOUTH);
        new Wall(pym, 1, 1, Direction.NORTH);
        new Wall(pym, 1, 1, Direction.EAST);
        new Wall(pym, 1, 1, Direction.WEST);

        // top right tower
        new Wall(pym, 4, 1, Direction.SOUTH);
        new Wall(pym, 4, 1, Direction.NORTH);
        new Wall(pym, 4, 1, Direction.EAST);
        new Wall(pym, 4, 1, Direction.WEST);

        // bottom left tower
        new Wall(pym, 1, 4, Direction.SOUTH);
        new Wall(pym, 1, 4, Direction.NORTH);
        new Wall(pym, 1, 4, Direction.EAST);
        new Wall(pym, 1, 4, Direction.WEST);

        // bottom right tower
        new Wall(pym, 4, 4, Direction.SOUTH);
        new Wall(pym, 4, 4, Direction.NORTH);
        new Wall(pym, 4, 4, Direction.EAST);
        new Wall(pym, 4, 4, Direction.WEST);

        // Main castle
        new Wall(pym, 2, 2, Direction.NORTH);
        new Wall(pym, 2, 2, Direction.WEST);
        new Wall(pym, 3, 2, Direction.SOUTH);
        new Wall(pym, 3, 2, Direction.WEST);
        new Wall(pym, 2, 3, Direction.NORTH);
        new Wall(pym, 2, 3, Direction.EAST);
        new Wall(pym, 3, 3, Direction.SOUTH);
        new Wall(pym, 3, 3, Direction.EAST);

        // repeat this staightment
        while (true) {
            // along the side of the castle
            arsenis.move(2);
            arsenis.turnRight();
            arsenis.move();
            arsenis.turnLeft();
            arsenis.move();
            arsenis.turnLeft();
            arsenis.move();
            arsenis.turnRight();
            arsenis.move(2);
            arsenis.turnRight();
        }
    }
}
