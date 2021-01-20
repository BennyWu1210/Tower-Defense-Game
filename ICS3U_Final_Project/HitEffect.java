import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Contain the animation effect of different projectiles
 * 
 * @author (Benny Wu) 
 */

public class HitEffect extends Actor
{

    
    GifImage explosion;
    List<GreenfootImage> images;
    int imageIndex;
    int x;
    int y;
    

    
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
