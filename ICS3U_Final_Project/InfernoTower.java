import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * A type of tower - Inferno Tower!
 * 
 * @author (Benny Wu) 
 * Last edited (Jan 20, 2021)
 */
public class InfernoTower extends Tower
{


    ArrayList<int[]> positions;
    
    public InfernoTower(TowerTile tile)
    {
        super(tile);
        this.fire_rate = 900;
        this.damage = 2.1;
        this.splash_damage = 0.9;
        this.cost = level * 30;
        image = new GreenfootImage("inferno_tower1.png");
        image.scale(40,60);
        setImage(image);
        setRadius(150);
        setCost(30);
        level_label = new Label("Level " + 1, 20);
        level_label.setFillColor(Color.RED);
        
        
    }
    
    public void addedToWorld(World game)
    {
        world = (Game)game;
        positions = world.tiles;
        world.addObject(level_label, this.getX(), this.getY()-36);
    }
    
    public void act() 
    {
        super.act();
        displayLevel();
        if(time.millisElapsed()>this.fire_rate)
        {
            time.mark();
            Enemy target = checkClosest();

            if(target != null)
            {
                Fireball f = new Fireball(target, this);
                getWorld().addObject(f, getX(), getY());
            }
            
        }
    }    
    
    public void displayLevel()
    {
       level_label.setValue("Level " + getLevel());
    }
    
    
}
