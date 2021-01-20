import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the screen that gets to be displayed after the player wins the game
 * 
 * @author (Benny Wu) 
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
