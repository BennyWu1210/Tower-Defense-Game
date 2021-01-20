import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Contains the properties of GifImage, 
 * with additinal features such as adding the images onto the screen directly without calling it elsewhere
 * 
 * @author (Benny Wu) 
 * Last Edited (Jan 20, 2021)
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
