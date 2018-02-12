/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentUno;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;

/**
 * Completing first assignment 
 * @author pritb9521
 */
public class RobotFirstAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create a city for the robot
        City pym = new City();
        
        // Put a robot in lav
        RobotSE ultron = new RobotSE(pym, 2, 1, Direction.EAST);
        
    }
}
