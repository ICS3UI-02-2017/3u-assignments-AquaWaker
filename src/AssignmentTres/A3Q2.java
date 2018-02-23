/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentTres;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;

/**
 * Answering A3Q2
 * @author pritb9521
 */
public class A3Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        // Create a city
        City pym = new City();
        
        // Create a robot in the city
        RobotSE arsenis = new RobotSE(pym, 1, 1, Direction.EAST);
        
        // Create 10 Things in the same spot for arsenis to move
        new Thing(pym, 1, 1);
        new Thing(pym, 1, 1);
        new Thing(pym, 1, 1);
        new Thing(pym, 1, 1);
        new Thing(pym, 1, 1);
        new Thing(pym, 1, 1);
        new Thing(pym, 1, 1);
        new Thing(pym, 1, 1);
        new Thing(pym, 1, 1);
        new Thing(pym, 1, 1);
        
        // Have arsenis move the Things one at a time to the spot infront of him
        for (int thingsMoved = 0; thingsMoved < 10; thingsMoved++) {
            arsenis.pickThing();
            arsenis.move();
            arsenis.pickAllThings();
            if(arsenis.countThingsInBackpack()!= 10){
            arsenis.putAllThings();
            arsenis.turnAround();
            arsenis.move();
            arsenis.turnAround();
            } else {
                arsenis.putAllThings();
            }
        }
        
    }
}
