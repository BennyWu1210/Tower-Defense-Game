import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class BombExplosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BombExplosion extends HitEffect
{
    /**
     * Act - do whatever the BombExplosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    double splash_damage;
    public BombExplosion(int x, int y, double damage) 
    {
        // Add your action code here.
        this.explosion = new GifImage("bomb_explosion.gif");
        this.images = explosion.getImages();
        this.imageIndex = 0;
        this.splash_damage = damage;
        setLocation(x, y);
        for(GreenfootImage image: images)
        {
            image.scale(60,60);
        }

    }  
    
    public void act()
    {
        
        checkIntersect();
        checkRemove();
    }
    
    public void checkIntersect()
    {
        if(this.isTouching(Enemy.class))
        {
            List<Enemy> enemies = getIntersectingObjects(Enemy.class);
            for(Enemy e: enemies)
            {
                e.takeDamage(this.splash_damage);
            }
        }
    }
    
    
    
}
