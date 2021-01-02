import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameCoin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameCoin extends Coin
{
    /**
     * Act - do whatever the GameCoin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image;
    Font display;
    public GameCoin()
    {
        image = new GreenfootImage("coin.png");
        display = new Font("0", 30);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void displayCoin()
    {
        ;
    }
    
    public void updateCoin(int coin)
    {
        setImage(image);
    }
}
