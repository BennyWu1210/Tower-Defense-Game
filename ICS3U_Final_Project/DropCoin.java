import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class DropCoin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DropCoin extends Coin
{
    /**
     * Act - do whatever the DropCoin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
        GreenfootImage image = images.get((int)index);
        if (index>=images.size())
        {
            index = 0;
        }
        index += 0.25;
        time.mark();  
        return image;
    }
}
