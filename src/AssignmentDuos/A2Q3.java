/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentDuos;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;

/**
 * Answering A2Q3
 * @author pritb9521
 */
public class A2Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create a city for the robot
        City pym = new City();
        
        // Put a robot in pym
        RobotSE arsenis = new RobotSE(pym, 10, 10, Direction.EAST);
        
        while(arsenis.getAvenue()!= 0){
            if(arsenis.getAvenue() >= -1 , arsenis.getDirection() != Direction.SOUTH){
            
            
            }
            
            if(arsenis.getAvenue() <= 1 , arsenis.getDirection() != Direction.NORTH){
            
            
            }
            
        }
        
    }
}
