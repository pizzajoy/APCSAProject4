/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package randomwalk;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author letizia
 */
public class RandomWalk implements RandomWalkInterface{
    
    
    ArrayList<Point> path; //Empty ArrayList object called path
    private boolean isDone = false, next = false;
    private long seed;
    private int gridSize;
    private int x = 0;
    private int y = 0;
    private int newX = 0;
    private int newY = 0;
    Random random;
    int failCount = 0; //keeps track of amount of trials that failed
    
   
    public RandomWalk(int gridSize){
        
        this.gridSize = gridSize;
        path = new ArrayList<Point>();//assign path to the new Array List
        Point start = new Point(0,0);// make a new point 0,0 called start
        path.add(start); //add new point to path
        random = new Random();//creates a random number
        
    }

    public RandomWalk(int gridSize, long seed){
        
        this(gridSize); // 'this' refers to this class
        random = new Random(seed); // creates a new random seed
    }
        
    
    @Override
    public void step() {
        int direction;
        newX = x;
        newY = y;           
        direction = random.nextInt(6); // checks the direction: 0 and 1 is East, 2 and 3 is South, 4 is West, 5 is North
        //System.out.println(direction);
             switch(direction){
                   case 0: //adds more probability
                   case 1:// if East
                        newX = x+1; //new X is the 'next' point
                        break;
                        
                   case 2:
                   case 3:// if South
                        newY = y+1;
                        break;
                        
                   case 4:// if West
                        newX = x-1;
                        break;  
                                       
                   case 5: // if North
                        newY = y-1;
                        break;
                        
               }
              if(failCount > 10){ // if the line is stuck then the path is cleared and a new point is added
                   path.clear();
                   path.add(new Point(0,0));
                   x = 0;
                   y = 0;
                   System.out.println("RESTARTING: " + path);
                   failCount = 0; //fail count has to be reset or else the point is always at zero 
                   return;
              }
              // System.out.println(newX);
              // System.out.println(newY);
               if (hasNext() == true){ //if the path works, then new points are added
                   x = newX;
                   y = newY;
                   failCount = 0;
                   path.add(new Point(x,y));
                   System.out.println(path);
                  
                   
               }
               if(hasNext() == false){
                   failCount++; //if path fails, updates fail count
                   //System.out.println(failCount);
               }
                   //path.add(new Point(0,0));
                                
        //path.add(new Point(random.nextInt(gridSize),random.nextInt(gridSize))); //adds a random point to the path ArrayList
    }

    @Override
    public void createWalk() {
        step(); //starts walking through grid
    }

    @Override
    public boolean hasNext() { // makes sure that point gets closer to goal each step
        if(newX < 0||newY < 0 ||newX >= gridSize|| newY >= gridSize)  return false; // checks all the negative conditions of the coordinate points
        if( path.contains(new Point(newX,newY))) return false;
        
        //if (newDist >= currentDist) return false;
        //currentDist = newDist; //updates the distance
       return true;
    }

    @Override
    public boolean isDone() {
       // System.out.println((newX - gridSize)+ " " + (newY - gridSize));
        //System.out.println("GRIDSIZE" + gridSize + "POINT" + x + y);
        if((x - (gridSize-1) == 0)&&(y - (gridSize-1) == 0)){ //checks if the line is at the goal (lower right)
            System.out.println("REACHED!");
            System.exit(0);
            
        }
        return isDone;
    }

    @Override
    public ArrayList<Point> getPath() {
        return path;
    }
    
    @Override
    public String toString(){ //displays the ArrayList of points
        String j = "";
        
        for(int i =0; i <path.size(); i++){
                Point p = path.get(i);
                
                j += "[" + p.x + "," + p.y + "]";
        }
        return j;
    }

    /**
     * @param args the command line arguments
     */ 
}
