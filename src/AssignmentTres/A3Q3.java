/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentTres;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;

/**
 * Answering A3Q3
 * @author pritb9521
 */
public class A3Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create a city
        City pym = new City();
        
        // Tell how many things start in the backpack
        int thingsInBackpack = 20;
        
        // Create a robot in the city
        RobotSE arsenis = new RobotSE(pym, 1, 1, Direction.EAST, thingsInBackpack);
        
        for (;thingsInBackpack <= 20;) {
            
        }
    }
}
