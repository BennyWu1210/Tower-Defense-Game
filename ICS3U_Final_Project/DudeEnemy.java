import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class dude here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class DudeEnemy extends Enemy
{
    /**
     * Act - do whatever the dude wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GifImage image;
   
    public DudeEnemy(double speed, double health, int coins, int x, int y)
    {
        
        super(speed, health, coins, x, y);
        image = new GifImage("dude.gif");
        this.images = image.getImages();
        for(GreenfootImage image: images)
        {
            image.scale(25, 25);
        }
        
        gif = true;
    }
    
    public void act() 
    {
        super.act();

        
        
        
    }    
    
    
    public void remove()
    {
        ;
    }
}
