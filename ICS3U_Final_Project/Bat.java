import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A type of enemy - bat
 * 
 * @author (Benny Wu) 
 */
public class Bat extends Enemy
{
    /**
     * Act - do whatever the Bat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GifImage image;
   
    public Bat(double speed, double health, int coins, int x, int y)
    {
        
        super(speed, health, coins, x, y);
        image = new GifImage("Bat.gif");
        this.images = image.getImages();
        for(GreenfootImage image: images)
        {
            //image.scale(40, 40);
            //image.mirrorHorizontally();
        }
        
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
