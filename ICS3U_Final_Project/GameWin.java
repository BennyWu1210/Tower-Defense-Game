import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWin extends World
{

    /**
     * Constructor for objects of class GameWin.
     * 
     */
    GreenfootImage background = new GreenfootImage("GameWin_test.jpg");
    Game game;
    public GameWin(Game game)
    {    
        super(1050, 700, 1);
        background.scale(1050,700);
        setBackground(background);
        this.game = game;
    }
}
