import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Displays the a gif when an enemy dies, or when the gold mine spawns a new coin
 * 
 * @author (Benny Wu) 
 */
public class DropCoin extends Coin
{
    SimpleTimer time = new SimpleTimer();
    GifImage image;
    List<GreenfootImage> images;
    private double index;
    public DropCoin()
    {
        image = new GifImage("gain_coin.gif");
        images = image.getImages();
        index = 0;
        for(GreenfootImage img: images)
        {
            img.scale(30,30);
        }
        time.mark();
    }
    
    public void act() 
    {
        if (index>=images.size())
        {
            getWorld().removeObject(this);
            return;
        }

    }  
    
    public GreenfootImage getImage()
    {
        if (index>=images.size())
        {
            index = 0;
        }
        
        GreenfootImage image = images.get((int)index);
        index += 0.25;
        time.mark();  
        return image;
    }
}
