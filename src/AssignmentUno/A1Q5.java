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
 *
 * @author pritb9521
 */
public class A1Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create a city for the robot
        City stark = new City();
        
        // Create maria in stark
        final RobotSE maria = new RobotSE(stark, 0, 1, Direction.WEST);
        
        // Set maria's colour to black and set a label
        maria.setColor(Color.MAGENTA);
        maria.setLabel("M");
        
        // Create karel in stark
        RobotSE karel = new RobotSE(stark, 3, 3, Direction.EAST);
        
        // Set karel's colour to black and give it a label
        karel.setColor(Color.MAGENTA);
        karel.setLabel("K");
        
        // Create karel's house
        new Wall(stark, 2, 3, Direction.WEST);
        new Wall(stark, 2, 3, Direction.NORTH);
        new Wall(stark, 2, 3, Direction.EAST);
        new Wall(stark, 3, 3, Direction.EAST);
        new Wall(stark, 3, 3, Direction.SOUTH);
                
        
        // Create expensive things in the world
        Thing ring = new Thing(stark, 0, 0);
        Thing food = new Thing(stark, 1, 0);
        Thing ball = new Thing(stark, 1, 1);
        Thing gold = new Thing(stark, 1, 2);
        Thing something = new Thing(stark, 2, 2);
        
        // Make the flag black
        ring.setColor(Color.CYAN);
        food.setColor(Color.GREEN);
        ball.setColor(Color.RED);
        gold.setColor(Color.yellow);
        something.setColor(Color.BLACK);
        
        // Create a thread to move the maria at the same time as karel
        new Thread(){
            public void run(){
                // Have Maria move and pick up the
                maria.move();
            
            
        }
       }.start();
        
    }
}
