/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamplesOrSomething;

import java.util.Scanner;

/**
 *
 * @author pritb9521
 */
public class Methods {
    
    // The helloWorld method to say hello
    public static void helloWorld(){
        System.out.println("Hello world!");
    }
    
    // say hello to a user
    public static void sayHello(String name){
        System.out.println("Hello " + name);
    }
    
    // calculates the right root of the function
    public static double posQuadForm(double a, double b, double c){
        
        double[] roots = quadForm(a,b,c);
        
        // send back the root
        return roots[0];
    }
    
    // calculates the roots
    public static double[] quadForm(double a, double b, double c){
        double[] roots = new double[2];
        double discrim = b*b - 4*a*c;
        roots[0] = (-b + Math.sqrt(discrim)) / (2*a);
        roots[1] = (-b - Math.sqrt(discrim)) / (2*a);
        
        return roots;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        // call the helloWorld method
        helloWorld();
        
        // call the sayHello method
        System.out.println("What is your name?");
        String user = in.nextLine();
        sayHello(user);
        
        // calculate the + root of 3x^2 + 7x + 1.5
        double pRoot = posQuadForm(1, -5, -50);
    
        System.out.println("The positive root is " + pRoot);
        
        double[] roots = quadForm(1, -5, -50);
        
        System.out.println("The roots are " + roots[0] + " and " + roots[1]);
    }
    
    
}

/**     a = b
 *      a^2 = ab
 *      a^2 - b^2 = ab - b^2
 *      (a+b)(a-b) = b(a-b)
 *      a + b = b
 *      b + b = b
 *      2b = b
 *      2 = 1
 * 
 */