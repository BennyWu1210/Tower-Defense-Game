import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * A type of enemy - dude enemy
 * 
 * @author (Benny Wu) 
 */

public class DudeEnemy extends Enemy
{

    
    GifImage image;
   
    public DudeEnemy(double speed, double health, int coins, int x, int y)
    {
        
        super(speed, health, coins, x, y);
        image = new GifImage("dude.gif");
        this.images = image.getImages();
        for(GreenfootImage image: images)
        {
            image.scale(25, 25);
        }
        
        gif = true;
    }
    
    public void act() 
    {

        
        super.act();
        
        
    }    
    

}
