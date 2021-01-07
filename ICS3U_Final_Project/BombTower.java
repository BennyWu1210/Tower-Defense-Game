import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BombTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BombTower extends Tower
{
    /**
     * Act - do whatever the BombTower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public BombTower(TowerTile tile)
    {
        super(tile);
        image = new GreenfootImage("Bomb_Tower.png");
        image.scale(60,75);
        setImage(image);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
