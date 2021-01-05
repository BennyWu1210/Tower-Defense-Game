import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Oval here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Oval extends Actor
{
    /**
     * Act - do whatever the Oval wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image = new GreenfootImage("Oval3.png");
    public void act() 
    {
        // Add your action code here.
        setImage(image);
        image.scale(400,400);
    }    
}
