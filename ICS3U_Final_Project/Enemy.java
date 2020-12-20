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
    int[] pos = new int[2];
    int[] destination = new int[2];
    int currentIndex = 0;
    
    int xDiff;
    int yDiff;
    List<GreenfootImage> images;
    ArrayList<int[]> path = world.pathOne;
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
        
        if (disDetect())
        {
            Random ran = new Random();
            int x = path.get(currentIndex)[0];
            int y = path.get(currentIndex)[1];
            currentIndex++;
            relocate(x,y);
            System.out.println(x + " xy " + y);
            
        }
        //System.out.println(currentIndex);
        //System.out.println(path.size());
        if (currentIndex >= path.size()-1) 
        //THIS IS SO WEIRD!!! THE PATH>SIZE() CHANGES EVERY TIME I RUN IT
        {
            System.out.println("disappeared");
            getWorld().removeObject(this);
            return;
        }
        //USING THIS AS A SUBSTITUTION LMAO
        if (currentIndex >= 14) 
        //THIS IS SO WEIRD!!! THE PATH>SIZE() CHANGES EVERY TIME I RUN IT
        {
            System.out.println("manually disappeared");
            getWorld().removeObject(this);
            return;
        }
        
        //System.out.println("moving");
        move();
        
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
    
    public void relocate(int x, int y)
    {
        destination[0] = x;
        destination[1] = y;
        xDiff = destination[0] - getX();
        yDiff = destination[1] - getY();
    }
    
    public boolean disDetect()
    {
        /*
        if(Math.abs(destination[0]-getX()) < Math.abs(destination[0]-(getX()+xDiff)) )
        {
            return true;
        }
        */
        
        if(Math.abs(destination[0]-getX()) < 5 || Math.abs(destination[1]-getY()) < 5)
        {
            return true;
        }
        
        return false;
            
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
