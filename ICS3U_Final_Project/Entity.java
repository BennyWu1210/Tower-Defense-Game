import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Entity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Entity extends Actor
{
    /**
     * Act - do whatever the Entity wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    SimpleTimer time = new SimpleTimer();
    Game world; //DELETE THIS
    public double speed = 0;
    public int[] pos = new int[2];
    public boolean existing = true;
    List<GreenfootImage> images;
    //public int imageIndex = 0;
    public double imageIndex = 0; //This is to control the speed of the transition between images
                                  // It requires a double to do so.
    public boolean gif = false;
    
    public abstract void act();  
    
    public double distanceFrom(int x, int y)
    {
        double distance = Math.sqrt(Math.pow(x-getX(), 2) + Math.pow(y-getY(), 2));
        //system.out.println("dis:" + distance);
        return distance;
    }     
    
    public void move(int x, int y)
    {
        double d = distanceFrom(x, y);
        double blocks = d/speed;
        double xd = (x - getX())/blocks;
        double yd = (y - getY())/blocks;
        setLocation(getX()+(int)xd, getY()+(int)(yd+0.5));
    }
    
    public GreenfootImage getImage()
    {
        if (gif)
        {
            GreenfootImage image = images.get((int)imageIndex);
            imageIndex += 0.1;
            
            if (imageIndex>=images.size())
            {
                imageIndex = 0;
            }
            
            return image;
        }
        else
        {
            return super.getImage();
        }
    }
    
    
}
