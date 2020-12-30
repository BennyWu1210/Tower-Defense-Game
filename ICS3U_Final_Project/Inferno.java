import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class inferno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inferno extends Tower
{
    /**
     * Act - do whatever the inferno wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    ArrayList<int[]> positions;
     
    public Inferno(TowerTile tile)
    {
        super(tile);
        image = new GreenfootImage("inferno_tower1.png");
        image.scale(40,60);
        setImage(image);
        //setLocation(pos[0], pos[1]-20);
        radius = 150;

    }
    
    public void addedToWorld(World game)
    {
        world = (Game)game;
        positions = world.tiles;
    }
    
    public void act() 
    {
        super.act();

        if(time.millisElapsed()>900)
        {
            
            time.mark();
            Enemy target = checkClosest();

            if(target != null)
            {
                Fireball f = new Fireball(target, this);
                getWorld().addObject(f, getX(), getY());
            }
            
            //System.out.println(target);
        }
    }    
    
    
}
