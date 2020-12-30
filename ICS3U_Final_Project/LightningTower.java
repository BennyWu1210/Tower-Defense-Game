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
    
    ArrayList<int[]> positions;
    
    public LightningTower(TowerTile tile)
    {
        super(tile);
        image = new GreenfootImage("lightning_tower1.png");
        image.scale(55,75);
        setImage(image);
        setLocation(pos[0], pos[1]-20);

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
    }    
}
