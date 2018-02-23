/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Quizzes;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 * Completing Quiz 1
 * @author pritb9521
 */
public class Quiz1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create a city
        City pym = new City();
        
        // Create a robot in the city
        RobotSE arsenis = new RobotSE(pym, 4, 0, Direction.EAST);
        
        // Create the staircase
        new Wall(pym, 4, 2, Direction.WEST);
        new Wall(pym, 4, 2, Direction.NORTH);
        new Wall(pym, 3, 3, Direction.WEST);
        new Wall(pym, 3, 3, Direction.NORTH);
        new Wall(pym, 2, 4, Direction.WEST);
        new Wall(pym, 2, 4, Direction.NORTH);
        new Wall(pym, 2, 5, Direction.NORTH);
        new Wall(pym, 2, 5, Direction.EAST);
        new Wall(pym, 3, 6, Direction.NORTH);
        new Wall(pym, 3, 6, Direction.EAST);
        new Wall(pym, 4, 7, Direction.NORTH);
        new Wall(pym, 4, 7, Direction.EAST);
        
        // Create the lightbulbs to pick up
        new Thing(pym, 4, 1);
        new Thing(pym, 3, 2);
        new Thing(pym, 2, 3);
        new Thing(pym, 1, 4);
        
        /** Have arsenis move to the top of the staircase, picking up the 
         *  lights on the way
         */
        
        arsenis.move();
        arsenis.pickThing();
        arsenis.turnLeft();
        arsenis.move();
        arsenis.turnRight();
        arsenis.move();
        arsenis.pickThing();
        arsenis.turnLeft();
        arsenis.move();
        arsenis.turnRight();
        arsenis.move();
        arsenis.pickThing();
        arsenis.turnLeft();
        arsenis.move();
        arsenis.turnRight();
        arsenis.move();
        arsenis.pickThing();
        
        /** Have arsenis place the lights on the other side of the staircase and 
         *  reach the bottom
         */
        arsenis.move();
        arsenis.putThing();
        arsenis.move();
        arsenis.turnRight();
        arsenis.move();
        arsenis.turnLeft();
        arsenis.putThing();
        arsenis.move();
        arsenis.turnRight();
        arsenis.move();
        arsenis.turnLeft();
        arsenis.putThing();
        arsenis.move();
        arsenis.turnRight();
        arsenis.move();
        arsenis.turnLeft();
        arsenis.putThing();
        arsenis.move();
    }
}
