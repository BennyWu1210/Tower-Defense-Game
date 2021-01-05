import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class LightningStrike here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LightningStrike extends Projectile
{
    /**
     * Act - do whatever the LightningStrike wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    SimpleTimer time = new SimpleTimer();
    GifImage image = new GifImage("lightningStrike.gif");
    List<GreenfootImage> images = image.getImages();
    
    Enemy target;
    Tower tower;
    public LightningStrike(Enemy target, Tower tower) 
    {
        // Add your action code here.
        this.target = target;
        this.tower = tower;
        this.damage = 3.5;
        this.splash_damage = 1.2;

        for(GreenfootImage img: images)
        {
            img.scale(100,100);
            img.rotate(130);
        }
        
        time.mark();
    }  
    
    public void act()
    {
        super.act();
        if(imageIndex == images.size()-1)
        {
            getWorld().removeObject(this);
            return;
        }
        if(target.existing)
        {
            if(distanceFrom(tower.getX(), tower.getY())>tower.getRadius()
            || distanceFrom(target.getX(), target.getY()) < 6 )
            {
                if(distanceFrom(target.getX(), target.getY()) < 5)
                {
                    target.takeDamage(damage);
                }

            }
        }


    }
    
    public GreenfootImage getImage()
    {
        
        GreenfootImage image = images.get((int)imageIndex);
        imageIndex += 0.5;
          
        if (imageIndex>=images.size())
        {
            imageIndex = 0;
        }
            
        return image;
    }
    
    public void strike(int[] start, int[] end)
    {
        setLocation(end[0], end[1]);
        int xDiff = end[0] - start[0];
        int yDiff = start[1] - end[1];
        double angle = 0;
        if((xDiff>0 && yDiff>0)) //CAST Rule
        {
            angle = 180-57.3*Math.atan((double)Math.abs(yDiff)/Math.abs(xDiff));
        }
        else if (xDiff<0 && yDiff>0)
        {
            angle = 57.3*Math.atan((double)Math.abs(yDiff)/Math.abs(xDiff));
        }
        
        else if (xDiff<0 && yDiff<0)
        {
            angle = 360-57.3*Math.atan((double)Math.abs(yDiff)/Math.abs(xDiff));
            
        }
        else if((xDiff>0 && yDiff<0) )
        {
            angle = 180+57.3*Math.atan((double)Math.abs(yDiff)/Math.abs(xDiff));
        }
        System.out.println(xDiff + ", " + yDiff + ", " + angle);
        
        for(GreenfootImage img: images)
        {
            img.rotate((int)angle);
        }
        
    }
}
