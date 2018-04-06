/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentSeis;

/**
 * Answering A6Q7
 *
 * @author pritb9521
 */
public class A6Q7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // create an array of all numbers between and including  2 and 1000
        int[] sieve = new int[999];
        sieve[0] = 2;
        for (int toInfinity = 1; toInfinity < 999; toInfinity++) {
            sieve[toInfinity] = sieve[toInfinity] + sieve[toInfinity - 1] + 1;
        }

        // creates an array of booleans that are false to go with the sieve
        boolean[] isPrime = new boolean[999];
        for (int toTrue = 0; toTrue < 999; toTrue++) {
            isPrime[toTrue] = true;
        }

        // determine the primes
        for (int prime = 0; prime < 999; prime++) {
            // true indicated a integer is prime
            if (isPrime[prime] == true) {
                System.out.println(sieve[prime] + " is a prime");
            }
            // divide all the numbers in the sequence and turn all to false that have a mod remainer of not 0
            for (int numbers = prime; numbers < 999; numbers++) {
                if (sieve[numbers] % sieve[prime] == 0) {
                    isPrime[numbers] = false;
                }
            }
        }
    }
}
