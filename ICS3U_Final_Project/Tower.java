import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * An entity that locates enemies and deals damage towards them
 * 
 * @author (Benny Wu) 
 * Last edited (Jan 20, 2021)
 */
public class Tower extends Entity
{

    static GreenfootImage image;
    static GreenfootImage oval;
    
    private int radius;
    protected int level;
    protected double damage;
    protected double splash_damage;
    protected Oval o;
    protected int fire_rate;

    
    public Tower(TowerTile tile)
    {
        setLocation(tile.position[0], tile.position[1]);
        this.level = 1;
        oval = new GreenfootImage("Oval3.png");
        
    }
    
    public void act() 
    {

        if(u != null && u.detectClick())
        {
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

    /**
     * returns true if Enemy e is in the fire range of this tower, false otherwise
     */
    public boolean isInRange(Enemy e)
    {

        if(distanceFrom(e.getX(), e.getY()) <= radius)
        {
           return true;
        }
        return false;
    }
    
    /**
     * returns the closest enemy from the tower
     */
    public Enemy checkClosest()
    {
        time.mark();
        
        for(Enemy e: ((Game)getWorld()).enemyList)
        {

            if(isInRange(e))
            {
               return e;

            }
        }
        
        return null;
        
    }
    
    /**
     * Displays the fire range of the tower
     */
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
    
    /**
     * Upgrades the tower to the next level
     */
    public void levelUp()
    {
        
        if(((Game)getWorld()).takeCoins(this.cost))
        {
            ((Game)getWorld()).updateCoins(0);
            this.level ++;
            this.damage *= 1.2;
            this.splash_damage *= 1.4;
            if(this.getClass() == LightningTower.class)
            {
                this.fire_rate *= 0.76;
            }
            else
            {
                this.fire_rate *= 0.82;
            }
            this.cost *= 2;
        }
    }

    /**
     * Displays the upgrade button
     */
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


