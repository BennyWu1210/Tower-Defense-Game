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
    public double imageIndex = 0;
    GifImage image;
    double damage;
    double splash_damage;
    
    public void act() 
    {
        splashDamage();
    }  
    
    public void splashDamage()
    {
        if(this.isTouching(Enemy.class))
        {
            List<Enemy> enemies = getIntersectingObjects(Enemy.class);
            for(Enemy e: enemies)
            {
                e.takeDamage(splash_damage);
            }
                
        }
        
    }
    


    
    
    
    
    

}
