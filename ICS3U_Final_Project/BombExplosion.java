import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * A type of hit effect - bomb explosion
 * 
 * @author (Benny Wu) 
 */
public class BombExplosion extends HitEffect
{

    private boolean large_explosion;
    double splash_damage;
    GreenfootSound sound = new GreenfootSound("bomb_sound.mp3");
    public BombExplosion(int x, int y, double damage, boolean large_explosion) 
    {
        // Add your action code here.
        this.explosion = new GifImage("bomb_explosion.gif");
        this.large_explosion = large_explosion;
        this.images = explosion.getImages();
        this.imageIndex = 0;
        this.splash_damage = damage;
        setLocation(x, y);
        for(GreenfootImage image: images)
        {
            image.scale(70,70);
        }
        sound.setVolume(30);
        sound.play();

    }  
    
    public void act()
    {
        
        checkIntersect();
        checkRemove();
    }
    
    public void checkIntersect()
    {
        if(!large_explosion && this.isTouching(Enemy.class))
        {
            List<Enemy> enemies = getIntersectingObjects(Enemy.class);
            for(Enemy e: enemies)
            {
                e.takeDamage(this.splash_damage);
            }
        }
        else if(large_explosion)
        {
            List<Enemy> enemies = ((Game)getWorld()).enemyList;
            
            for(Enemy e: enemies)
            {
                e.takeDamage(this.splash_damage);
            }
        }
    }
    
    
    

    
    public void changeSize(int x, int y)
    {
        for(GreenfootImage image: images)
        {
            image.scale(x,y);
        }
    }
    
    
    
}
