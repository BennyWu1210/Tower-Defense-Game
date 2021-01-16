import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WalkingSoldier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WalkingSoldier extends Enemy
{
    /**
     * Act - do whatever the WalkingSoldier wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public GifImage image;
    
    public WalkingSoldier(double speed, double health, int coins, int x, int y)
    {
        super(speed, health, coins, x, y);
        image = new GifImage("RunningSoldier.gif");
        this.images = image.getImages();
        for(GreenfootImage image: images)
        {
            //image.scale(50, 50);
        }
    }
    
    public void act() 
    {
        super.act();
    }
    

    
}
