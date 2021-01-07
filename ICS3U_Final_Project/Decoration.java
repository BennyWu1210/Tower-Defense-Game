import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Decorations here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Decoration extends Actor
{
    /**
     * Act - do whatever the Decorations wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int length;
    public int width;
    public GreenfootImage image;
    
    public abstract void act();
    
    public abstract void enlarge();

}
