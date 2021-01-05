import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Fireball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fireball extends Projectile
{
    /**
     * Act - do whatever the Fireball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    SimpleTimer time = new SimpleTimer();
    GifImage image;
    GifImage explosion;
    Enemy target;
    Tower tower;
    int[] destination = new int[2];
    public Fireball(Enemy target, Tower tower)
    {
       

        
        image =  new GifImage("flame02.gif");
        explosion = new GifImage("explosion01.gif");
        this.target = target;
        this.tower = tower;
        this.images = image.getImages();
        this.damage = 2.2;
        this.splash_damage = 1;
        this.gif = true;
        time.mark();
        
        for(GreenfootImage image: images)
        {
            image.scale(25,25);
        }
        speed = 5;
        
        setLocation(tower.getX(), tower.getY());
        
    }
    
    public void act() 
    {

        super.act();
        
        if(target.existing)
        {
            
            if(distanceFrom(tower.getX(), tower.getY())>tower.getRadius()
            || distanceFrom(target.getX(), target.getY()) < 7 )
            {
                if(distanceFrom(target.getX(), target.getY()) < 7)
                {
                    target.takeDamage(damage);
                }
                disappear();
                getWorld().removeObject(this);
                return;
            }
            

            destination[0] = target.getX();
            destination[1] = target.getY();
            move(target.getX()+5, target.getY());
        }
        else
        {
            if(distanceFrom(tower.getX(), tower.getY())>tower.getRadius()
               || distanceFrom(destination[0], destination[1]) < 6)
            {
                
                disappear();
                getWorld().removeObject(this);
                return;

            }
            if(destination[0]!=0)
            {
                move(destination[0]+5, destination[1]);
            }
            else
            {
                getWorld().removeObject(this);
            }
        }

    }    

    public void disappear()
    {
        FireExplosion explosion = new FireExplosion(getX(), getY());
        getWorld().addObject(explosion, getX(), getY());
    }
    
    public GreenfootImage getImage()
    {
        
        GreenfootImage image = images.get((int)imageIndex);
        imageIndex ++;
            
        if (imageIndex>=images.size())
        {
            imageIndex = 0;
        }
            
        return image;
    }
}
