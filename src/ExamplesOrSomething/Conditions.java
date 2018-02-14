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
 * learning about conditions
 * @author pritb9521
 */
public class Conditions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        City pym = new City();
        
        // create a robot
        RobotSE jeph = new RobotSE(pym, 2, 1, Direction.EAST);
       
        // create walls
        new Wall(pym, 2, 5, Direction.EAST);
        new Wall(pym, 4, 5, Direction.SOUTH);
        new Wall(pym, 4, 0, Direction.WEST);
        new Wall(pym, 2, 0, Direction.NORTH);
        
        // Create things
        new Thing(pym, 2, 2);
        new Thing(pym, 2, 4);
        
        // move until front is not clear, if not clear then turn left
        while(jeph.frontIsClear()){
            jeph.move();
            
            if(jeph.canPickThing()){
                
                jeph.pickAllThings();
            }
            
            if(jeph.countThingsInBackpack() >= 1){
                
                jeph.setColor(Color.ORANGE);
                
                if(jeph.isFacingSouth()){
                    
                    jeph.putThing();
                }
 
            } else {
                
                jeph.setColor(Color.CYAN);
            }
            
            while(!jeph.frontIsClear()){
                // while front is not clear turn right
                jeph.turnRight();
                
            }
        } 
        
 
        
    }
}
