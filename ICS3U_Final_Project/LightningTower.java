import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * A type of tower - Lightning Tower!
 * 
 * @author (Benny Wu) 
 * Last edited (Jan 20, 2021)
 */
public class LightningTower extends Tower
{

    SimpleTimer time = new SimpleTimer();
    ArrayList<int[]> positions;

    public LightningTower(TowerTile tile)
    {
        super(tile);
        this.fire_rate = 1800;
        this.damage = 0.5;
        this.splash_damage = 0.25;
        this.cost = level * 50;

        setRadius(110);
        image = new GreenfootImage("lightning_tower1.png");
        image.scale(55,75);
        setImage(image);
        setLocation(pos[0], pos[1]-20);
        setCost(50);
        time.mark();
        level_label = new Label("Level " + getLevel(), 20);
        level_label.setFillColor(Color.CYAN);
        
    }
    
    public void addedToWorld(World game)
    {
        world = (Game)game;
        positions = world.tiles;
        getWorld().addObject(level_label, this.getX(), this.getY()-36);
    }
    
    public void act() 
    {
        super.act();
        displayLevel();
        if(time.millisElapsed()>this.fire_rate){
            time.mark();
            Enemy target = checkClosest();
            if(target != null)
            {
                LightningStrike f = new LightningStrike(target, this);
                int[] start = {this.getX(), this.getY()-30};
                int[] end = {target.getDestination()[0], target.getDestination()[1]};
                getWorld().addObject(f,end[0],end[1]);              
                f.strike(start, end);
            }
        }
    }    
    
    public void displayLevel()
    {
       level_label.setValue("Level " + getLevel());
    }
}
