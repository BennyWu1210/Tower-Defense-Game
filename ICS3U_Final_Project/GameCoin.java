import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays the player's coins on the top-left corner of the screen
 * 
 * @author (Benny Wu) 
 */
public class GameCoin extends Coin
{

    GreenfootImage image;
    Font display;
    public GameCoin()
    {
        image = new GreenfootImage("coin.png");
        display = new Font("0", 30);
    }
    
    public void updateCoin(int coin)
    {
        setImage(image);
    }
}
