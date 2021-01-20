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
        this.fire_rate = 2200;
        this.damage = 2;
        this.splash_damage = 0.7;
        this.cost = level * 60;

        setRadius(110);
        image = new GreenfootImage("lightning_tower1.png");
        image.scale(55,75);
        setImage(image);
        setLocation(pos[0], pos[1]-20);
        setCost(60);
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
                int[] end = {target.getX(), target.getY()};
                getWorld().addObject(f,end[0],end[1]);              
                f.strike(start, end);
            }
        }
    }    
    
    public void displayLevel()
    {
       //getWorld().removeObject(lv);
       level_label.setValue("Level " + getLevel());
       //getWorld().addObject(level_label, this.getX(), this.getY()-35);
    }
}
