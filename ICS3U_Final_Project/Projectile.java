import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Entity
{
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    List<GreenfootImage> images;
    private int imageIndex = 0;
    GifImage image;
    public void act() 
    {
        
    }  
    
    public GreenfootImage getImage()
    {
        
        GreenfootImage image = images.get(imageIndex);
        imageIndex ++;
            
        if (imageIndex>=images.size())
        {
            imageIndex = 0;
        }
            
        return image;
    }

    
    
    
    
    

}
