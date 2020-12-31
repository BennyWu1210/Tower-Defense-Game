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
    GifImage explosion = new GifImage("explosion01.gif");
    
    
    Enemy target;
    Tower tower;
    int[] destination = new int[2];
    public Fireball(Enemy target, Tower tower)
    {
       

        time.mark();
        image =  new GifImage("flame02.gif");
        this.target = target;
        this.tower = tower;
        this.images = image.getImages();
        for(GreenfootImage image: images)
        {
            image.scale(25,25);
        }
        speed = 5;
        gif = true;
        setLocation(tower.getX(), tower.getY());
        
    }
    
    public void act() 
    {
        // Add your action code here.'
        //Random ran = new Random();
        //setLocation(getX()+2, getY()+2);
        if(target.existing)
        {
            if(distanceFrom(tower.getX(), tower.getY())>tower.radius 
               || distanceFrom(target.getX(), target.getY()) < 5)
            {
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
            if(distanceFrom(tower.getX(), tower.getY())>tower.radius 
               || distanceFrom(destination[0], destination[1]) < 5)
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
        //System.out.println(target.getX() + " fireball " + target.getY());
        //System.out.println(target.existing);


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
