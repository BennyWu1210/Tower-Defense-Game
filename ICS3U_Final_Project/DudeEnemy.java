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
    
    GifImage image = new GifImage("dude.gif");
    boolean moving = true;
    public DudeEnemy(double speed, double health, int coins)
    {
        
        super(speed, health, coins);
        this.images = image.getImages();
        for(GreenfootImage image: images)
        {
            image.scale(25, 25);
        }
        
        
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
