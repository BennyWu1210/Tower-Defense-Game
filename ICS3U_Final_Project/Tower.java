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
    private int level;
    private int cost;
    protected double damage;
    protected double splash_damage;
    protected UpgradeButton u;
    protected Label lv;
    protected TowerTile tile;
    protected Oval o;
    protected int fire_rate;
    
    
    public Tower(TowerTile tile)
    {
        setLocation(tile.position[0], tile.position[1]);
        this.tile = tile;
        this.level = 1;
        oval = new GreenfootImage("Oval3.png");
    }
    
    public void act() 
    {
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
            getWorld().addObject(o, tile.getX(), tile.getY());
        }
        else
        {
            getWorld().removeObject(o);
        }
    }
    
    public void levelUp()
    {
        this.level ++;
        this.damage *= 1.2;
        this.splash_damage *= 1.2;
        this.fire_rate *= 0.9;
        this.cost *= 1.2;
        ((Game)getWorld()).takeCoins(this.cost);
    }
    
    public void displayUpgrade()
    {
        if (clicked)
        {
            u = new UpgradeButton(this);
            getWorld().addObject(u, tile.getX()+25, tile.getY()+15);
        }
        else
        {
            if(u != null && u.detectClick())
            {
                System.out.println("hi");
                this.levelUp();
            }
            if(u!=null)
            {
                u.remove();
            }
        }
        
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


