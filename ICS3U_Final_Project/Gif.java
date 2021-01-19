
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Gif here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gif extends Actor
{
    /**
     * Act - do whatever the Gif wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
        // Add your action code here.
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
