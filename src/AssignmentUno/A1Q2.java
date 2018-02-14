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
 * Answering A1Q2
 * @author pritb9521
 */
public class A1Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create a city for karel
        City pym = new City();
        
        // Put karel in pym
        RobotSE karel = new RobotSE(pym, 1, 2, Direction.SOUTH);
        
        // Set karel's colour to black
        karel.setColor(Color.BLACK);
        
        // Create walls in the city
        
        // Walls facing West
        new Wall(pym, 1, 1, Direction.WEST);
        new Wall(pym, 2, 1, Direction.WEST);
        
        // Walls facing North
        new Wall(pym, 1, 1, Direction.NORTH);
        new Wall(pym, 1, 2, Direction.NORTH);
        
        // Wall facing East
        new Wall(pym, 1, 2, Direction.EAST);
        
        // Walls facing South
        new Wall(pym, 1, 2, Direction.SOUTH);
        new Wall(pym, 2, 1, Direction.SOUTH);
        
        // Create a newspaper in the world
        Thing newspaper = new Thing(pym, 2, 2);
        
        // Change the color of the particle to black
        newspaper.setColor(Color.BLACK);
        
        // Navigate karel to the newspaper
        karel.turnRight();
        karel.move();
        karel.turnLeft();
        karel.move();
        karel.turnLeft();
        karel.move();
        
        // Have karel pick up the newspaper
        karel.pickThing();
        
        // Navigate karel back to bed where he was
        karel.turnAround();
        karel.move();
        karel.turnRight();
        karel.move();
        karel.turnRight();
        karel.move();
        karel.turnRight();
        
    }
}
