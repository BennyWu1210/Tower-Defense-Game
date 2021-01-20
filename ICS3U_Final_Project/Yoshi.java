import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A type of enemy - yoshi!
 * 
 * @author (Benny Wu) 
 */
public class Yoshi extends Enemy
{

    public GifImage image;
    
    public Yoshi(double speed, double health, int coins, int x, int y)
    {
        super(speed, health, coins, x, y);
        image = new GifImage("Yoshi.gif");
        this.images = image.getImages();
        for(GreenfootImage image: images)
        {
            //image.scale(40, 40);
        }
    }
    
    public void act() 
    {

        
        super.act();
    }    
}
