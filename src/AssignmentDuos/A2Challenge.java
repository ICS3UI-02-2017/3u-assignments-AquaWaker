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
 * @author pritb9521
 */
public class A2Challenge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        City pym = new City();
        
        // create a robot
        RobotSE arsenis = new RobotSE(pym, 2, 1, Direction.EAST);
       
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
        new Wall(pym, 2, 5, Direction.EAST);
        new Wall(pym, 4, 5, Direction.SOUTH);
        new Wall(pym, 4, 0, Direction.WEST);
        new Wall(pym, 2, 0, Direction.NORTH);
        new Wall(pym, 2, 5, Direction.EAST);
        new Wall(pym, 4, 5, Direction.SOUTH);
        new Wall(pym, 4, 0, Direction.WEST);
        new Wall(pym, 2, 0, Direction.NORTH);
        
        // create the third driveway
        new Wall(pym, 2, 5, Direction.EAST);
        new Wall(pym, 4, 5, Direction.SOUTH);
        new Wall(pym, 4, 0, Direction.WEST);
        new Wall(pym, 2, 0, Direction.NORTH);
        new Wall(pym, 2, 5, Direction.EAST);
        new Wall(pym, 4, 5, Direction.SOUTH);
        new Wall(pym, 4, 0, Direction.WEST);
        new Wall(pym, 2, 0, Direction.NORTH);
        new Wall(pym, 2, 5, Direction.EAST);
        new Wall(pym, 4, 5, Direction.SOUTH);
        new Wall(pym, 4, 0, Direction.WEST);
        new Wall(pym, 2, 0, Direction.NORTH);
        new Wall(pym, 2, 5, Direction.EAST);
        new Wall(pym, 4, 5, Direction.SOUTH);
        new Wall(pym, 4, 0, Direction.WEST);
        new Wall(pym, 2, 0, Direction.NORTH);
        
        // Create the snow
        new Thing(pym, 2, 2);
        new Thing(pym, 2, 4);
        
        
    }
}
