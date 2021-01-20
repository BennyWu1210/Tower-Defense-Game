import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Contains the image of an oval, which shows the fire range of a tower
 * 
 * @author (Benny Wu) 
 */
public class Oval extends Actor
{

    GreenfootImage image = new GreenfootImage("Oval3.png");
    public void act() 
    {
        // Add your action code here.
        setImage(image);
        image.scale(400,400);
    }    
}
