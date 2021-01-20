import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A type of enemy - golem
 * 
 * @author (Benny Wu) 
 */
public class Golem extends Enemy
{

    SimpleTimer time = new SimpleTimer();
    public GifImage image;
    
    public Golem(double speed, double health, int coins, int x, int y)
    {
        super(speed, health, coins, x, y);
        image = new GifImage("Golem.gif");
        this.images = image.getImages();

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
