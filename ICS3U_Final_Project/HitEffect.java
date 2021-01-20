import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Contain the animation effect of different projectiles when it explodes
 * 
 * @author (Benny Wu) 
 * Last Edited (Jan 20, 2021)
 */

public class HitEffect extends Actor
{

    GifImage explosion;
    List<GreenfootImage> images;
    int imageIndex;
    int x;
    int y;
    
    /**
     * Checks if the effect ends and removes it from the world 
     */
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
