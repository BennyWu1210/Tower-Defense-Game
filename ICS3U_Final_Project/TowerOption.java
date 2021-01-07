import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TowerOption here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TowerOption extends Button
{
    /**
     * Act - do whatever the TowerOption wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    static int l = 20;
    static int w = 25;
    
    public TowerOption(GreenfootImage button)
    {
        super(button);
        this.length = l;
        this.width = w;
        button.scale(length,width);
    }
    public void act() 
    {
        checkHover();
    }    
}
