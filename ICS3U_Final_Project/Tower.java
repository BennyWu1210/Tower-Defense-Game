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
    protected int level;
    protected int cost;
    protected double damage;
    protected double splash_damage;
    protected UpgradeButton u;
    protected Label lv;
    //protected TowerTile tile;
    protected Oval o;
    protected int fire_rate;
    
    
    public Tower(TowerTile tile)
    {
        setLocation(tile.position[0], tile.position[1]);
        //this.tile = tile;
        this.level = 1;
        
        oval = new GreenfootImage("Oval3.png");
        //displayButton();
        
    }
    
    public void act() 
    {

        if(u != null && u.detectClick())
        {
            System.out.println("hi");
            this.levelUp();
            u.remove();
        }
        
        if(Greenfoot.mouseClicked(this) && !clicked)
        {
            clicked = true;
            displayCircle();
            displayUpgrade();
            
            
        }
        else if((Greenfoot.mouseClicked(null) && !Greenfoot.mouseClicked(this))
        || (Greenfoot.mouseClicked(this) && clicked))
        {
            clicked = false;
            displayCircle();
            displayUpgrade();
        }
        
        
        
    }    
    
    /*
    public void addedToWorld(World game)
    {
        u = new UpgradeButton(this);
        ((Game)game).addObject(u, this.getX()+25, this.getY()+15);
    }
    */

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
        int a = ((Game)getWorld()).enemyList.size();
        System.out.println(a);
        
        for(Enemy e: ((Game)getWorld()).enemyList)
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
            getWorld().addObject(o, getX(), getY());
        }
        else
        {
            getWorld().removeObject(o);
        }
    }
    
    public void levelUp()
    {
        ((Game)getWorld()).takeCoins(this.cost);
        if(((Game)getWorld()).checkCoins(this.cost))
        {
            this.level ++;
            this.damage *= 1.2;
            this.splash_damage *= 1.2;
            this.fire_rate *= 0.9;
            this.cost *= 2;
        }
    }
    
    public void displayUpgrade()
    {
        
        if (clicked)
        {
            /*
            if(u != null)
            {
               
                getWorld().removeObject(u);
                u = null;
            }
            else
            {
                u = new UpgradeButton(this);
                getWorld().addObject(u, this.getX()+25, this.getY()+15);
            }
            */
            u = new UpgradeButton(this);
            getWorld().addObject(u, this.getX()+25, this.getY()+15);
        }
        else
        {
            getWorld().removeObject(u);
        }
        
        
        
        
       
        
    }
    
    public void displayButton()
    {
        u = new UpgradeButton(this);
        getWorld().addObject(u, this.getX()+25, this.getY()+15);
    }
    
    public double getDamage()
    {
        return this.damage;
        
    }
    
    public double getSplashDamage()
    {
        return this.splash_damage;
    }
    
    public int getLevel()
    {
        return this.level;
    }
    
    public int getRadius()
    {
        return this.radius;
    }

    public int getCost()
    {
        return this.cost;
    }
    
    public void setRadius(int r)
    {
        this.radius = r;
    }
    
    public void setCost(int c)
    {
        this.cost = cost;
    }
    

}


