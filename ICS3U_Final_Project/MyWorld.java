import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    GreenfootImage background = new GreenfootImage("images/game_map06.tif");
    GreenfootImage test = new GreenfootImage("images/testingab.png");
    GreenfootImage a = new GreenfootImage("images/inferno_tower1.png");
    GreenfootImage b = new GreenfootImage("images/lightning_tower01.tif");
    /**
     * Constructor for objects of class MyWorld
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1050, 700, 1); 
        setBackground(background);
        background.scale(1050, 700);
        displayTest(350, 100);
        a.scale(80,120);
        background.drawImage(a, 300, 250);
        b.scale(80,120);
        background.drawImage(b, 470, 250);
    }
    
    public void displayTest(int x, int y)
    {
        test.scale(100,100);
        background.drawImage(test, x, y);
    }
    public void add()
    {
        ;
    }
    
}
