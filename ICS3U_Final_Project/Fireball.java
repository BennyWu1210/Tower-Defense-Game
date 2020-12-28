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
    GifImage fireBall = new GifImage("flame02.gif");
    GifImage explosion = new GifImage("explosion01.gif");
    List<GreenfootImage> images;
    private int imageIndex = 0;
    Enemy target;
    
    public Fireball(Enemy target, int xLoc, int yLoc)
    {
        this.images = fireBall.getImages();
        for(GreenfootImage image: images)
        {
            image.scale(25,25);
        }
        setLocation(xLoc, yLoc);
        time.mark();
        gif = true;
        this.target = target;
        speed = 3;
    }
    
    public void act() 
    {
        // Add your action code here.'
        //Random ran = new Random();
        //setLocation(getX()+2, getY()+2);
        if(!target.existing)
        {
            getWorld().removeObject(this);
            return;
        }

        move(target.getX(), target.getY());
        System.out.println(target.getX() + " fireball " + target.getY());
        System.out.println(target.existing);


    }    

    
    public GreenfootImage getImage()
    {
        
        GreenfootImage image = images.get(imageIndex);
        imageIndex ++;
            
        if (imageIndex>=images.size())
        {
            imageIndex = 0;
        }
            
        return image;
    }
}
