/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentUno;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;
import java.awt.Color;

/**
 * Answering A1Q3
 * @author pritb9521
 */
public class A1Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create a city for the robot
        City nepal = new City();
        
        // Put a robot in nepal
        RobotSE drake = new RobotSE(nepal, 3, 0, Direction.EAST);
        
        // Set the robot's colour to black
        drake.setColor(Color.BLACK);
        
        // Create walls in the city
        
        // Walls facing West
        new Wall(nepal, 3, 2, Direction.WEST);
        new Wall(nepal, 2, 3, Direction.WEST);
        new Wall(nepal, 1, 3, Direction.WEST);
        
        // Walls facing North
        new Wall(nepal, 3, 2, Direction.NORTH);
        new Wall(nepal, 1, 3, Direction.NORTH);
        new Wall(nepal, 2, 4, Direction.NORTH);
        
        // Wall facing East
        new Wall(nepal, 1, 3, Direction.EAST);
        new Wall(nepal, 2, 4, Direction.EAST);
        new Wall(nepal, 3, 4, Direction.EAST);
        
        // Create a flag in the world
        Thing flag = new Thing(nepal, 3, 1);
        
        // Make the flag black
        flag.setColor(Color.BLACK);
        
        // Move drake to the flag and pick it up
        drake.move();
        drake.pickAllThings();
        
        // Make drake climb to the top of the mountain
        drake.turnLeft();
        drake.move();
        drake.turnRight();
        drake.move();
        drake.turnLeft();
        drake.move(2);
        drake.turnRight();
        drake.move();
        
        // Plant the flag at the top of the mountain
        drake.putAllThings();
        
        // Have drake climb back down the mountain
        drake.move();
        drake.turnRight();
        drake.move();
        drake.turnLeft();
        drake.move();
        drake.turnRight();
        drake.move(2);
        drake.turnLeft();
        
    }
}
