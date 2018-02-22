/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamplesOrSomething;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;

/**
 * Learning about ForLoops
 * @author pritb9521
 */
public class ForLoops {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        City pym = new City();
        RobotSE arsenis = new RobotSE(pym, 1, 1, Direction.EAST);
        
        // ciybted wguke kiio
        int numberOfMoves = 5;
        
        // if there are still moves to do
        while(numberOfMoves > 0){
            arsenis.move();
            numberOfMoves = numberOfMoves - 1;
        }
        
        arsenis.turnAround();
        
        // counting the other way
        numberOfMoves = 0;
        while(numberOfMoves < 5){
            arsenis.move();
            numberOfMoves = numberOfMoves + 1;
        }
        
        arsenis.turnAround();
        // use a for loop to move
        for(int count = 0; count < 5; count++){
            arsenis.move();
                    
        }
        
        if(true && false){
        }
        
        int x = 10;
        x = x + 5; // adds 5
        x += 5; //adds 5
        
        x *= 2; // multiplies
        x = x * 2; // multiplies
        
        x /= 2; // divides
        x = x / 2; // divides
        
        // modulus or module
        int remainder = 5 % 2;
        int quotient = 5 / 2;
        
        
        
    }
}
