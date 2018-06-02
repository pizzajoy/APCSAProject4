//package randomwalk;

import java.util.Scanner;
/**
 * @author letizia
 */
public class RandomWalkTest
{
     private static int gridSize = 0;
     private static long seed = 0;
     private static Scanner input = new Scanner(System.in);
     /**
      * 
      */
     private static void getInput() 
     {
         do
         {
             System.out.print("Enter grid size (>0): ");
             gridSize = input.nextInt(); //stores number in gridSize
         }
         while(gridSize < 0); // continues to prompt user until a valid value is inputed
         
         do
         {
             System.out.print("Enter random seed (or 0 for no seed): ");
             seed = input.nextLong(); // stores seed from user
         }
         while( seed < 0); // continues to prompt user until a valid value is inputed
     }
     
     
     /**
      * @param args
      */
     public static void main(String[] args)
     {
         // call getInput to process user input
         getInput();
         
         // creates RandomWalk object using the right constructor
         RandomWalk myWalk;
         if(seed == 0)
             myWalk = new RandomWalk(gridSize);
         else
             myWalk = new RandomWalk(gridSize, seed);
         // create the random walk and the print it
         myWalk.createWalk();
         System.out.println(myWalk);
        
     }
}
