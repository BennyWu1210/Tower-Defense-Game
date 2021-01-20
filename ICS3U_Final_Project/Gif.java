
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Contains the properties of GifImage, with a bit more function, such as adding the images onto the screen directly
 * 
 * @author (Benny Wu) 
 */
public class Gif extends Actor
{

    SimpleTimer time = new SimpleTimer();
    List<GreenfootImage> list;
    int index = 0;
    public Gif(GifImage i, int x, int y)
    {
        list = i.getImages();
        setLocation(x, y);
    }
    
    public void act() 
    {
    }    
    
    public GreenfootImage getImage(int delay)
    {
        if(time.millisElapsed()>delay)
        {
            time.mark();
            index ++;
            if(index>list.size()-1)
            {
                index = 0;
            }
            
        }
        return list.get(index);

    }
    

    
    
}
