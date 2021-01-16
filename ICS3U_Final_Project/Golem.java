import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Golem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Golem extends Enemy
{
    /**
     * Act - do whatever the Golem wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    SimpleTimer time = new SimpleTimer();
    public GifImage image;
    
    public Golem(double speed, double health, int coins, int x, int y)
    {
        super(speed, health, coins, x, y);
        image = new GifImage("Golem.gif");
        this.images = image.getImages();
        for(GreenfootImage image: images)
        {
            //image.scale(50, 50);
        }
    }
    
    public void act() 
    {
        super.act();
        if(time.millisElapsed()%3 == 0)
        {
            setSpeed(1.9);
        }
        else
        {
            setSpeed(0);
        }
    }
}
