import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class DisplayBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DisplayBar extends Actor
{
    /**
     * Act - do whatever the DisplayBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    Game world;
    //GreenfootImage full;
    //GreenfootImage empty;
    int health = 5;
    int[] pos = new int[2];
    GreenfootImage[] image = new GreenfootImage[6];
    
    public DisplayBar()
    {
        //full = new GreenfootImage("green.png");
        //empty = new GreenfootImage("red.png");
        //setImage(empty);
        //full.scale(25,3);
        //empty.scale(1,3);
        for(int i=0; i<6; i++)
        {
            image[i] = new GreenfootImage("greenBar0" + i + ".png");
            image[i].scale(25,3);
        }
        setImage(image[1]);
        //world.background.drawImage(empty, getX(), getY());
        //empty.drawImage(full, getX(), getY());
    }
    
    public void addedToWorld(World game)
    {
        Game world = (Game)getWorld();
    }
    
    public DisplayBar(GreenfootImage a, GreenfootImage b)
    {

    }
    
    public void act() 
    {
       Game world = (Game)getWorld();
       //world.background.drawImage(empty, getX()-12, getY()-1);
        // Add your action code here.
    }   
    
    public void updatePosition(int x, int y)
    {
        setLocation(x,y);

    }
    
    public void updatePercentage(int health)
    {
        Game world = (Game)getWorld();
        this.health = health;
        setImage(image[health]);
        //empty.scale((int)(25*(1-percentage)), 3);
        //setLocation((int)(getX()-25+(25*(1-percentage)/2)), getY());
    }
}
