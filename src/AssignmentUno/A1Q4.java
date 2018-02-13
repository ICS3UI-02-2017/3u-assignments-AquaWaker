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
 * Answering A1Q4
 * @author pritb9521
 */
public class A1Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create a city for the robot
        City pym = new City();
        
        // Create scott in pym
        final RobotSE scott = new RobotSE(pym, 0, 0, Direction.SOUTH);
        
        // Set the robot's colour to black
        scott.setColor(Color.BLACK);
        
        // Create lang in pym
        RobotSE lang = new RobotSE(pym, 0, 1, Direction.SOUTH);
        
        // Set the robot's colour to black
        lang.setColor(Color.BLACK);
        
        // Create the walls 
        
        // Walls facing West
        new Wall(pym, 0, 1, Direction.WEST);
        new Wall(pym, 1, 1, Direction.WEST);
        
        // Wall facing South
        new Wall(pym, 1, 1, Direction.SOUTH);
        
        // Create a thread to move the robots at the same time
        new Thread(){
            public void run(){
            scott.move(2);
            scott.turnLeft();
            scott.move();
            scott.turnAround();
            scott.turnAround();
            
        }
       }.start();
        
        // Move lang to scott's position
        lang.move();
        lang.turnLeft();
        lang.move();
        lang.turnRight();
        lang.move();
        lang.turnRight();
        lang.move();
       
    }
}
