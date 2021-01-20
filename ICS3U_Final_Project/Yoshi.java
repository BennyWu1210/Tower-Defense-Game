import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A type of enemy - yoshi!
 * 
 * @author (Benny Wu) 
 * Last edited (Jan 18, 2021)
 */
public class Yoshi extends Enemy
{

    public GifImage image;
    
    public Yoshi(double speed, double health, int coins, int x, int y)
    {
        super(speed, health, coins, x, y);
        image = new GifImage("Yoshi.gif");
        this.images = image.getImages();

    }
    
    public void act() 
    {
        super.act();
    }    
}
