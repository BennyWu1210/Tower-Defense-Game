import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class LIghtningTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LightningTower extends Tower
{
    /**
     * Act - do whatever the LIghtningTower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    SimpleTimer time = new SimpleTimer();
    ArrayList<int[]> positions;
    
    public LightningTower(TowerTile tile)
    {
        super(tile);
        radius = 150;
        image = new GreenfootImage("lightning_tower1.png");
        image.scale(55,75);
        setImage(image);
        setLocation(pos[0], pos[1]-20);
        time.mark();
    }
    
    public void addedToWorld(World game)
    {
        world = (Game)game;
        positions = world.tiles;
    }
    
    public void act() 
    {
        // Add your action code here.
        super.act();
        if(time.millisElapsed()>900){
            
            time.mark();
            Enemy target = checkClosest();
            if(target != null)
            {
                //System.out.println("checked");
                LightningStrike f = new LightningStrike();
                int x = target.getX() - this.getX();
                int y = target.getY() - this.getY();
                double degree = Math.atan(y/x);
                getWorld().addObject(f,getX(),getY());
                //System.out.println(getX()+" "+getY()+" "+ " "+target.getX()+" "+target.getY());
                //System.out.println(degree);
                f.strike(degree*57.3*2);
            }
        }
    }    
}
