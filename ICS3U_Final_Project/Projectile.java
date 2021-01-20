import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Contains all weapons/projectiles that towers possess
 * 
 * @author (Benny Wu) 
 */
public class Projectile extends Entity
{


    List<GreenfootImage> images;
    public double imageIndex = 0;
    GifImage image;
    double damage;
    double splash_damage;
    GreenfootSound sound = new GreenfootSound("Fireball_sound.mp3");
    Tower tower;
    public void act() 
    {
        // Overrides the act in entity
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

    public void setDamage(double increase)
    {
        damage *= increase;
        splash_damage *= increase;
    }
    
    


    
    
    
    
    

}
