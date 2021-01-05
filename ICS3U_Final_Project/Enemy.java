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
    
    
    protected double max_health;
    protected double health;
    protected int coins;
    protected int[] destination;
    protected DisplayBar healthBar;
    
    private ArrayList<int[]> path;
    private int currentIndex = 0;
    private int xDiff;
    private int yDiff;
    

    public Enemy(double speed, double max_health, int coins, int x, int y)
    {
       this.speed = speed;
       this.max_health = max_health;
       this.health = max_health;
       
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
       // Randomly chooses between the two paths
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
        {
            this.existing = false;
        }
        
        if (distanceFrom(destination[0], destination[1])<5)
        {
            int x = path.get(currentIndex)[0];
            int y = path.get(currentIndex)[1];
            currentIndex++;
            relocate(x,y);
        }
        
        /*
        if(this.isTouching(Fireball.class))
        {
            this.health -= 0.3;
        }
        
        if(this.isTouching(LightningStrike.class))
        {
            
            this.health -= 0.2;
        }
        */


        if (this.health <= -1)
        {
            world = (Game)getWorld();
            getWorld().removeObject(healthBar);
            this.existing = false;
            return;
        }
        
        
        move(destination[0], destination[1]);
        healthBar.updatePercentage(this.health/this.max_health);
        healthBar.updatePosition(getX(),getY()-20);

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

        double d = Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
        double xBlock = xDiff/(d/speed);
        double yBlock = yDiff/(d/speed);
        setLocation(getX()+(int)(xBlock+0.5), getY()+(int)(yBlock+0.5));
        
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

    public int getCoins()
    {
        return this.coins;
    }
    
    public double getHealth()
    {
        return this.health;
    }

    public void remove()
    {
        world = (Game)getWorld();
        world.updateCoins(973);
        DropCoin drop = new DropCoin();
        getWorld().addObject(drop, this.getX(), this.getY());
        getWorld().removeObject(healthBar);
        getWorld().removeObject(this);
        return;
    }
}

    
    
    
    
    

