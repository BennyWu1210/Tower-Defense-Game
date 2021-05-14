import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Contains all weapons/projectiles that towers possess
 * 
 * @author (Benny Wu) 
 * * Last edited (Jan 20, 2021)
 */
public class Projectile extends Entity
{


    List<GreenfootImage> images;
    public double imageIndex = 0;
    GifImage image;
    double damage;
    double splash_damage;
    GreenfootSound sound;
    Tower tower;
    
    
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

    public void setDamage(double increase)
    {
        damage *= increase;
        splash_damage *= increase;
    }
    
    public void act() 
    {
        // Has to exist to override the entity
    }  
    
    


    
    
    
    
    

}
