import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A type of enemy - bat
 * 
 * @author (Benny Wu) 
 * Last edited (Jan 18, 2021)
 */
public class Bat extends Enemy
{

    GifImage image;
   
    public Bat(double speed, double health, int coins, int x, int y)
    {
        
        super(speed, health, coins, x, y);
        image = new GifImage("Bat.gif");
        this.images = image.getImages();

        
    }
    
    public void act() 
    {
        super.act();

    }    
    
    public void takeDamage(double ouch)
    {
        if(this.health-3*ouch<0)
        {
            this.health = -1;
        }
        else
        {
            this.health -= ouch;
        }
    }
    
    public GreenfootImage getImage()
    {
        
        GreenfootImage image = images.get((int)imageIndex);
        imageIndex += 0.2;
        if (imageIndex>=images.size())
        {
            imageIndex = 0;
        }
        time.mark();  
        return image;
    }
    
    
}
