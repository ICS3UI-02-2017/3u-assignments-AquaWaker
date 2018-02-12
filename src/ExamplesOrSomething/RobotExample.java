/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamplesOrSomething;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;
import java.awt.Color;

/**
 * Learning how to use the robots
 * @author Brayden
 */
public class RobotExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create a city for the robot
        City lav = new City();
        
        // Put a robot in lav
        RobotSE arsenis = new RobotSE(lav, 2, 1, Direction.EAST);
        
        // Create a wall
        new Wall(lav, 2, 5, Direction.WEST);
        
        // Create a thing!
        new Thing(lav, 2, 4);
        new Thing(lav, 2, 4);
        new Thing(lav, 2, 4);
        new Thing(lav, 2, 4);
        new Thing(lav, 2, 4);
        new Thing(lav, 2, 4);
        new Thing(lav, 2, 4);
        new Thing(lav, 2, 4);
        new Thing(lav, 2, 4);
        new Thing(lav, 2, 4);
        new Thing(lav, 2, 4);
        
        
        // Change the colour
        arsenis.setColor(Color.CYAN);
        
        // Move the robot forward 2 spaces
        arsenis.move(2);
        
        // Gives arsenis a label of Oi
        arsenis.setLabel("Oi");
        
        // Move the robot forward 1 space
        arsenis.move(1);
        
        // Pick up all the thing
        arsenis.pickAllThings();
        
        // Count the things
        arsenis.countThingsInBackpack();
        
        // Turn the robot
        arsenis.turnRight();
        
        // Move the robot down 3
        arsenis.move(3);
        
        // Put down the thing
        arsenis.putThing();
        
        // Turn to the left
        arsenis.turnLeft();
        
        // Move away 
        arsenis.move(2);
        
                
    }
}
