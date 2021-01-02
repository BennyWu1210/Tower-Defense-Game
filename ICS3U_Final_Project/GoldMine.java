import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoldMine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoldMine extends Actor
{
    /**
     * Act - do whatever the GoldMine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    SimpleTimer time = new SimpleTimer();
    int Miningspeed;
    public GoldMine(int speed)
    {
        this.Miningspeed = speed;
        time.mark();
        
    }
    
    public void act() 
    {
        if(1000/time.millisElapsed()<Miningspeed)
        {
            
        }
    }    
    
    public void showCoin()
    {
        ;
    }
}
