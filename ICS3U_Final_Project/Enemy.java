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
    
    SimpleTimer time = new SimpleTimer();
    
    double health;
    int coins;
    
    
    ArrayList<int[]> path;
    
    int[] destination;
    int currentIndex = 0;
    private int xDiff;
    private int yDiff;
    DisplayBar healthBar;

    public Enemy(double speed, double health, int coins, int x, int y)
    {
       this.speed = speed;
       this.health = health;
       this.coins = coins;
       gif = true;
       pos[0] = x;
       pos[1] = y;
       healthBar = new DisplayBar();
       this.existing = true;
       time.mark();
       
    }
    
    public void addedToWorld(World game)
    {
       world = (Game)game;
       int num = Greenfoot.getRandomNumber(2);
       if(num==0)
       {
           path = world.pathOne;
       }
       else
       {
           path = world.pathTwo;
       }
       destination = new int[]{path.get(0)[0], path.get(0)[1]};
       game.addObject(healthBar, getX(), getY()-20);
    }     
    
    public void act() 
    {
        if (currentIndex == path.size()) 
        //THIS IS SO WEIRD!!! THE PATH>SIZE() CHANGES EVERY TIME I RUN IT
        {
            //System.out.println("disappeared");
            //getWorld().removeObject(this);
            //return;
            this.existing = false;
        }
        
        if (distanceFrom(destination[0], destination[1])<5)
        {
            //System.out.println("relocated");
            //System.out.println(path.size());
            //System.out.println(currentIndex);
            int x = path.get(currentIndex)[0];
            int y = path.get(currentIndex)[1];
            currentIndex++;
            relocate(x,y);
        }
        
        //System.out.println(currentIndex);
        //System.out.println(path.size());
        
        
        
        
        if(this.isTouching(Fireball.class))
        {
            this.health -= 0.1;
        }
        
        if(this.isTouching(LightningStrike.class))
        {
            this.health -= 0.3;
        }
        
       
        if (this.health <= -1)
        {
            world = (Game)getWorld();
            getWorld().removeObject(healthBar);
            this.existing = false;
            world.dudeList.remove(this);
            world.removeObject(this);
            return;
        }
        
        
        move(destination[0], destination[1]);
        healthBar.updatePercentage(this.health);
        healthBar.updatePosition(getX(),getY()-20);
        //healthBar.updatePercentage(0.9);
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
        
        GreenfootImage image = images.get((int)imageIndex);
        imageIndex += 0.25;
        if (imageIndex>=images.size())
        {
            imageIndex = 0;
        }
        time.mark();  
        return image;
    }
    
    public void takeDamage(double ouch)
    {
        if(this.health-ouch<0)
        {
            this.health = -1;
        }
        else
        {
            this.health -= ouch;
        }
    }

    public void remove()
    {
        getWorld().removeObject(healthBar);
        getWorld().removeObject(this);
        return;
    }
}

    
    
    
    
    

