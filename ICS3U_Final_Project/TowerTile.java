import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TowerTile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TowerTile extends Actor
{
    /**
     * Act - do whatever the TowerTile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int[] position = new int[2];
    public GreenfootImage block = new GreenfootImage("images/tile01.png");
    
    public TowerTile(int x, int y)
    {
        block.rotate(30);
        position[0] = x;
        position[1] = y;
        block.scale(30,30);
        setImage(block);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
