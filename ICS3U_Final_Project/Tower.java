import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tower extends Entity
{
    /**
     * Act - do whatever the Tower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    

    static GreenfootImage image;
    static GreenfootImage oval;
    private boolean clicked = false;
    private int radius;
    protected TowerTile tile;
    protected Oval o;
    protected int fire_rate;
    
    public Tower(TowerTile tile)
    {
        setLocation(tile.position[0], tile.position[1]);
        this.tile = tile;
        oval = new GreenfootImage("Oval3.png");
    }
    
    public void act() 
    {
        if(Greenfoot.mouseClicked(this) && !clicked)
        {
            clicked = true;
            displayCircle();
        }
        else if(Greenfoot.mouseClicked(null) && !Greenfoot.mouseClicked(this))
        {
            clicked = false;
            displayCircle();

        }
        else if(Greenfoot.mouseClicked(this) && clicked)
        {
            clicked = false;
            displayCircle();
            
        }
        
    }    
    

    public boolean isInRange(Enemy e)
    {

        if(distanceFrom(e.getX(), e.getY()) <= radius)
        {
           return true;
        }
        return false;
    }
    
    public Enemy checkClosest()
    {
        time.mark();
        int a = world.enemyList.size();
        System.out.println(a);
        
        for(Enemy e: world.enemyList)
        {

            if(isInRange(e))
            {
               return e;

            }
        }
        
        return null;
        
    }
    
    public void displayCircle()
    {
        if (clicked)
        {
            o = new Oval();
            getWorld().addObject(o, tile.getX(), tile.getY());
        }
        else
        {
            getWorld().removeObject(o);
        }
    }

    public int getRadius()
    {
        return this.radius;
    }

    public void setRadius(int r)
    {
        this.radius = r;
    }
}


