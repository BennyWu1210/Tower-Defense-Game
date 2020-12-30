import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class LightningStrike here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LightningStrike extends Projectile
{
    /**
     * Act - do whatever the LightningStrike wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GifImage image = new GifImage("lightningStrike.gif");
    List<GreenfootImage> images = image.getImages();
    public LightningStrike() 
    {
        // Add your action code here.
        for(GreenfootImage img: images)
        {
            img.scale(100,100);
            img.rotate(220);
        }
        setLocation(500,500);
        
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
    
    public void strike(double angle)
    {
        for(GreenfootImage img: images)
        {
            img.rotate((int)angle);
        }
    }
}
