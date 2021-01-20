import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * A type of hit effect - fire explosion
 * 
 * @author (Benny Wu) 
 */
public class FireExplosion extends HitEffect
{
    /**
     * Act - do whatever the FireExplosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    public FireExplosion(int x, int y) 
    {
        // Add your action code here.
        this.explosion = new GifImage("explosion01.gif");
        this.images = explosion.getImages();
        this.imageIndex = 0;
        setLocation(x, y);
        for(GreenfootImage image: images)
        {
            image.scale(30,30);
        }

    }  
    
    public void act()
    {
        checkRemove();
    }
    
    
       
    
}
