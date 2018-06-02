/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package randomwalk;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author pluska
 */
public interface RandomWalkInterface {
    /**
     * Makes the walk go one more step. 
     * To add this step to your path, you will add the new Point to your ArrayList. 
     * A new step should be added to your path every time the method is called.
     */
    public void step();
    
    /**
     * Creates the entire walk in one call by internally using the step() method.
     */
    public void createWalk();
	
    /**
    * Checks to see if the next move is a valid move.  
    */    
    public boolean hasNext();
    
    /**
     * Returns the current value of the done variable.
     * @return true or false
     */
    public boolean isDone();
    
    /**
     * Getter to get reference to the random walk path.
     * @return the path
     */
    public ArrayList<Point> getPath();
    
    public String toString();
    
}
