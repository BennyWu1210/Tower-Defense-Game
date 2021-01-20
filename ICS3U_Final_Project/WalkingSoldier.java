import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A type of enemy - walking soldier
 * 
 * @author (Benny Wu) 
 */
public class WalkingSoldier extends Enemy
{

    public GifImage image;
    
    public WalkingSoldier(double speed, double health, int coins, int x, int y)
    {
        super(speed, health, coins, x, y);
        image = new GifImage("RunningSoldier.gif");
        this.images = image.getImages();

    }
    
    public void act() 
    {
        super.act();
    }
    

    
}
