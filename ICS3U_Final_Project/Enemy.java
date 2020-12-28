import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Enemy extends Entity
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    double health;
    int coins;
    
    
    ArrayList<int[]> path = world.pathOne;
    
    int[] destination = {path.get(0)[0], path.get(0)[1]};
    int currentIndex = 0;
    private int xDiff;
    private int yDiff;
    

    public Enemy(double speed, double health, int coins, int x, int y)
    {
       this.speed = speed;
       this.health = health;
       this.coins = coins;
       gif = true;
       pos[0] = x;
       pos[1] = y;
    }
    
    public void act() 
    {
        
        if (distanceFrom(destination[0], destination[1])<19)
        {
            //System.out.println("relocated");
            int x = path.get(currentIndex)[0];
            int y = path.get(currentIndex)[1];
            currentIndex++;
            relocate(x,y);
        }
        
        //System.out.println(currentIndex);
        //System.out.println(path.size());
        
        if (currentIndex >= path.size()) 
        //THIS IS SO WEIRD!!! THE PATH>SIZE() CHANGES EVERY TIME I RUN IT
        {
            //System.out.println("disappeared");
            //getWorld().removeObject(this);
            //return;
            this.existing = false;
        }
        
        //USING THIS AS A SUBSTITUTION LMAO
        if (currentIndex >= 13) 
        //THIS IS SO WEIRD!!! THE PATH>SIZE() CHANGES EVERY TIME I RUN IT
        {
            System.out.println("manually disappeared");
            //getWorld().removeObject(this);
            //return;
            this.existing = false;
        }
        move(destination[0], destination[1]);
        //move();
    }   
    
    public void relocate(int x, int y)
    {
        destination[0] = x;
        destination[1] = y;
        xDiff = destination[0] - getX();
        yDiff = destination[1] - getY();
    }
    
    public void move()
    {

        
        //System.out.println("xx"+getX());
        double d = Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
        double xBlock = xDiff/(d/speed);
        double yBlock = yDiff/(d/speed);
        //System.out.println("xBlock" + xBlock);
        //System.out.println("speed" + speed);
        //System.out.println("xDiff" + xDiff);
        //System.out.println("d" + d);
        setLocation(getX()+(int)(xBlock+0.5), getY()+(int)(yBlock+0.5));
        //System.out.println(getX()+(int)xBlock + " " + getY()+(int)yBlock);
        
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

    
    
    
    
    

