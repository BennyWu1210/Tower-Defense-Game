
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    MyWorld world = (MyWorld)getWorld();
    double speed;
    double health;
    int coins;
    
    List<GreenfootImage> images;
    ArrayList<int[]> path = world.pathTwo;
    int[] pos = new int[2];
    int[] destination = {path.get(0)[0], path.get(0)[1]};
    int currentIndex = 0;
    int xDiff;
    int yDiff;
    boolean moving = true;
    
    private int imageIndex = 0;
    
    public Enemy(double speed, double health, int coins)
    {
       this.speed = speed;
       this.health = health;
       this.coins = coins;
       
    }
    
    public void act() 
    {
        
        if (distanceFrom(destination[0], destination[1])<16)
        {
            System.out.println("relocated");
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
            System.out.println("disappeared");
            getWorld().removeObject(this);
            return;
        }
        
        //USING THIS AS A SUBSTITUTION LMAO
        if (currentIndex >= 19) 
        //THIS IS SO WEIRD!!! THE PATH>SIZE() CHANGES EVERY TIME I RUN IT
        {
            System.out.println("manually disappeared");
            getWorld().removeObject(this);
            return;
        }
        
        //move(destination[0], destination[1]);
        move();
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
        boolean moving = true;
        
        //System.out.println("xx"+getX());
        double d = Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
        double xBlock = xDiff/(d/speed);
        double yBlock = yDiff/(d/speed);
        //System.out.println("xBlock" + xBlock);
        //System.out.println("speed" + speed);
        //System.out.println("xDiff" + xDiff);
        //System.out.println("d" + d);
        setLocation(getX()+(int)xBlock, getY()+(int)yBlock);
        //System.out.println(getX()+(int)xBlock + " " + getY()+(int)yBlock);
        
        //return moving;
    }
    
    public void move(int x, int y)
    {
        double d = distanceFrom(x, y);
        double blocks = d/speed;
        double xd = (x - getX())/blocks;
        double yd = (y - getY())/blocks;
        System.out.println((int)(xd+0.5) + " " + getY()+(int)(yd+0.5));
        setLocation(getX()+(int)xd, getY()+(int)(yd+0.5));
    }
    
    public double distanceFrom(int x, int y)
    {
        double distance = Math.sqrt(Math.pow(x-getX(), 2) + Math.pow(y-getY(), 2));
        //System.out.println("dis:" + distance);
        return distance;
            
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
