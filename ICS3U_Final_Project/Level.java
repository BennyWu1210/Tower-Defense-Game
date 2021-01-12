import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level extends Actor
{
    /**
     * Act - do whatever the Level wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int length;
    int width;
    GreenfootImage background;
    String pathOne;
    String pathTwo;
    String tiles;
    
    public Level(int length, int width, GreenfootImage background, String pathOne, String pathTwo, String tiles)
    {
        this.length = length;
        this.width = width;
        this.background = background;
        this.pathOne = pathOne;
        this.pathTwo = pathTwo;
        this.tiles = tiles;
        
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public GreenfootImage getBackground()
    {
        return background;
    }
    
    public String getPathOne()
    {
        return pathOne;
    }
    
    public String getPathTwo()
    {
        return pathTwo;
    }
    
    public String getTiles()
    {
        return tiles;
    }
}
