import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tower extends Entity
{
    /**
     * Act - do whatever the Tower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    Game world = (Game)getWorld();
    GreenfootImage image;
    int[] pos = new int[2];
    int radius;
    
    
    public Tower(TowerTile tile)
    {
        pos[0] = tile.position[0];
        pos[1] = tile.position[1];
    }
    
    public void act() 
    {
        
    }    
    
    
    public boolean isInRange(Enemy e)
    {

        if(distanceFrom(e.getX(), e.getY()) <= radius)
        {
           return true;
        }
        return false;
    }
    
    public Enemy checkClosest()
    {
        //double closest = Integer.MAX_VALUE;
        time.mark();
        //setLocation(pos[0], pos[1]-20);
        for(Enemy e: world.dudeList)
        {
            
            if(isInRange(e))
            {
               //closest = distanceFrom(e.getX(), e.getY());
               return e;

            }
        }
        return null;
        
    }
    

}


