import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Yoshi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Yoshi extends Enemy
{
    /**
     * Act - do whatever the Yoshi wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public GifImage image;
    
    public Yoshi(double speed, double health, int coins, int x, int y)
    {
        super(speed, health, coins, x, y);
        image = new GifImage("Yoshi.gif");
        this.images = image.getImages();
        for(GreenfootImage image: images)
        {
            image.scale(40, 40);
        }
    }
    
    public void act() 
    {

        
        super.act();
    }    
}
