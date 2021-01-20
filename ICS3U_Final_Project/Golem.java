import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A type of enemy - golem
 * 
 * @author (Benny Wu) 
 */
public class Golem extends Enemy
{

    SimpleTimer time = new SimpleTimer();
    private double set_speed;
    public GifImage image;
    
    public Golem(double speed, double health, int coins, int x, int y)
    {
        super(speed, health, coins, x, y);
        image = new GifImage("Golem.gif");
        this.set_speed = speed;
        this.images = image.getImages();

    }
    
    public void act() 
    {
        super.act();
        if(time.millisElapsed()%3 == 0)
        {
            setSpeed(set_speed);
        }
        else
        {
            setSpeed(0.1);
        }
    }
}
