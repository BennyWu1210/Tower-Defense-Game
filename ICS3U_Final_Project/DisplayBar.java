import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class DisplayBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DisplayBar extends Actor
{
    /**
     * Act - do whatever the DisplayBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    Game world;
    int[] pos = new int[2];
    GreenfootImage[] image = new GreenfootImage[6];
    
    public DisplayBar()
    {

        for(int i=0; i<6; i++)
        {
            image[i] = new GreenfootImage("greenBar0" + i + ".png");
            image[i].scale(25,3);
        }
        setImage(image[1]);

    }
    
    public void addedToWorld(World game)
    {
        Game world = (Game)getWorld();
    }
    
    
    public void act() 
    {
       Game world = (Game)getWorld();

    }   
    
    public void updatePosition(int x, int y)
    {
        setLocation(x,y);

    }
    
    public void updatePercentage(double percent)
    {
        world = (Game)getWorld();
        
        if(percent == 1)
        {
            setImage(image[5]);
        }
        else if(percent >= 0.8)
        {
            setImage(image[4]);
        }
        else if(percent >= 0.6)
        {
            setImage(image[3]);
        }
        else if(percent >= 0.4)
        {
            setImage(image[2]);
        }
        else if(percent >= 0.2)
        {
            setImage(image[1]);
        }
        else if(percent >= 0)
        {
            setImage(image[0]);
        }
        

    }
}
