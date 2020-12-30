import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class FireExplosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireExplosion extends HitEffect
{
    /**
     * Act - do whatever the FireExplosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GifImage explosion;
    List<GreenfootImage> images;
    int imageIndex;
    
    public FireExplosion(int x, int y) 
    {
        // Add your action code here.
        explosion = new GifImage("explosion01.gif");
        images = explosion.getImages();
        setLocation(x, y);
        imageIndex = 0;
        for(GreenfootImage image: images)
        {
            image.scale(25,25);
        }

    }  
    
    public void act()
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
