import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Includes all entities in the game, including towers, enemies, and projectiles
 * 
 * @author (Benny Wu) 
 * Last edited (Jan 20, 2021)
 */
public abstract class Entity extends Actor
{

    Game world; 
    SimpleTimer time = new SimpleTimer();
    public double speed = 0; 
    public int[] pos = new int[2];
    public boolean existing = true;
    public List<GreenfootImage> images;
    public int level;
    public double imageIndex = 0; // The index has to be a double to control the speed of image transition
    public boolean gif = false;
    
    protected boolean clicked = false;
    protected UpgradeButton u;
    protected Label level_label;
    protected int cost;
    
    public abstract void act();  
    
    /**
     * returns the distance from this instance to the coordinate (x,y)
     */
    public double distanceFrom(int x, int y)
    {
        double distance = Math.sqrt(Math.pow(x-getX(), 2) + Math.pow(y-getY(), 2));
        return distance;
    }     
    
    /**
     * Gradually moves the instance to the coordinate (x,y)
     */
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

    /**
     * Displays the upgrade button onto the screen when mouse clicks, removes it otherwise
     */
    public void displayUpgrade()
    {
        
        if (clicked)
        {
            u = new UpgradeButton(this);
            getWorld().addObject(u, this.getX()+28, this.getY()+20);
        }
        else if(u!=null)
        {
            u.remove();
        }
    }
    
    
    public int getCost()
    {
        return cost;
    }
    
    
}
