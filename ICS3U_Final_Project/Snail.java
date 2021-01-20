import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A type of enemy - snail
 * 
 * @author (Benny Wu) 
 */
public class Snail extends Enemy
{
    /**
     * Act - do whatever the Snail wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
