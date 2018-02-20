/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentUno;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Wall;
import java.awt.Color;

/**
 *
 * @author pritb9521
 */
public class A1Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create a city for the robot
        City pym = new City();
        
        // Put a robot in pym
        RobotSE ultron = new RobotSE(pym, 0, 2, Direction.WEST);
        
        // Set the robot's colour to black
        ultron.setColor(Color.BLACK);
        
        // Create the walls 
        
        // Walls facing West
        new Wall(pym, 1, 1, Direction.WEST);
        new Wall(pym, 2, 1, Direction.WEST);
        
        // Walls facing North
        new Wall(pym, 1, 1, Direction.NORTH);
        new Wall(pym, 1, 2, Direction.NORTH);
        
        // Walls facing East
        new Wall(pym, 1, 2, Direction.EAST);
        new Wall(pym, 2, 2, Direction.EAST);
        
        // Walls facing South
        new Wall(pym, 2, 1, Direction.SOUTH);
        new Wall(pym, 2, 2, Direction.SOUTH);
        
        // ultron moves forward two spaces
        ultron.move(2);
        
        ultron.turnLeft();
        
        // ultron moves down three spaces 
        ultron.move(3);
        
        ultron.turnLeft();
        
        // ultron moves right three spaces
        ultron.move(3);
        
        ultron.turnLeft();
        
        // ultron moves up three spaces
        ultron.move(3);
        
        ultron.turnLeft();
        
        // ultron returns to the starting position
        ultron.move();
        
    }
}
