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
 * Answering A2Q2
 * @author pritb9521
 */
public class A2Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create a city for the robot
        City pym = new City();
        
        // Put a robot in pym
        RobotSE arsenis = new RobotSE(pym, 4, 0, Direction.EAST);
        
        // Create the track
        new Wall(pym, 4, 0, Direction.SOUTH);
        new Wall(pym, 4, 1, Direction.SOUTH);
        new Wall(pym, 4, 2, Direction.SOUTH);
        new Wall(pym, 4, 3, Direction.SOUTH);
        new Wall(pym, 4, 4, Direction.SOUTH);
        new Wall(pym, 4, 5, Direction.SOUTH);
        new Wall(pym, 4, 6, Direction.SOUTH);
        new Wall(pym, 4, 7, Direction.SOUTH);
        new Wall(pym, 4, 8, Direction.SOUTH);
        
        // Create the hurdles
        new Wall(pym, 4, 0, Direction.EAST);
        new Wall(pym, 4, 1, Direction.EAST);
        new Wall(pym, 4, 3, Direction.EAST);
        new Wall(pym, 4, 6, Direction.EAST);

        // Create the finish line
        new Thing(pym, 4, 8);
        
        // Check to see if he has reached the finish line
        while(arsenis.canPickThing() == false){
            
            // If there is a hurdle in front of him, jump over it
            while(arsenis.frontIsClear() == false){
                arsenis.turnLeft();
                arsenis.move();
                arsenis.turnRight();
                arsenis.move();
                arsenis.turnRight();
                arsenis.move();
                arsenis.turnLeft();
            }
            // if he hasn't reached the finish line, move forward
            arsenis.move();
        }
        
        
    }
}
