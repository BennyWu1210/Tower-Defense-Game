import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class HitEffect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class HitEffect extends Actor
{
    /**
     * Act - do whatever the HitEffect wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GifImage explosion;
    List<GreenfootImage> images;
    int imageIndex;
    int x;
    int y;
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void checkRemove()
    {
        if(imageIndex >= images.size())
        {
            getWorld().removeObject(this);
            return;
        }
        
    }
    
    public GreenfootImage getImage()
    {
        imageIndex ++;
        return explosion.getCurrentImage();

    }
}
