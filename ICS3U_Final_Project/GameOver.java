import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    Game game;
    GreenfootImage background = new GreenfootImage("game_over.png");
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver(Game game)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1050, 700, 1);
        background.scale(1050,700);
        setBackground(background);
        this.game = game;
    }
    
    
}
