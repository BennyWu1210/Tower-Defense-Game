import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A type of enemy - snail
 * 
 * @author (Benny Wu) 
 * Last edited (Jan 20, 2021)
 */
public class Snail extends Enemy
{

    public GifImage image;
    
    public Snail(double speed, double health, int coins, int x, int y)
    {
        super(speed, health, coins, x, y);
        image = new GifImage("Snail.gif");
        this.images = image.getImages();

    }
    
    public void act() 
    {
        super.act();
    }
}
