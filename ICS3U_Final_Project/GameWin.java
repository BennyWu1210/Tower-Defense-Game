import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the screen that gets to be displayed after the player wins the game
 * @author (Benny Wu) 
 * Last edited (Jan 20, 2021)
 */
public class GameWin extends World
{

    /**
     * Constructor for objects of class GameWin.
     * 
     */
    SimpleTimer time = new SimpleTimer();
    GreenfootImage background = new GreenfootImage("game_win screen.jpg");
    Game game;
    Yoshi yoshi = new Yoshi(2.5,12,10, 0, 300);
    
    Label result;
    Label result1;
    Label result2;
    public GameWin(Game game)
    {    
        super(1050, 700, 1);
        this.game = game;
        background.scale(1050,700);
        setBackground(background);
        result = new Label("Nice job MR. CHEN!", 40);
        result1 = new Label("You made it to Level " + game.level_num + "!", 30);
        result2 = new Label("And lasted for " + game.game_time.millisElapsed()/1000.0 + " seconds!", 30);
        for(GreenfootImage image: yoshi.images)
        {
            image.scale(100, 100);
        }
        time.mark();
        addObject(yoshi, 0, 300);
        
    }
    
    public void act()
    {
        displayResult();
        if(yoshi.getWorld() == this)
        {
            walkingYoshi();
        }
        
    }
    
    /**
     * Displays the three lines of labels indicating the player's stats
     */
    public void displayResult()
    {
        if (time.millisElapsed() < 1500)
        {
            result.setFillColor(Color.RED);
            addObject(result, 535, 500);
        }
        else if(time.millisElapsed() < 3000)
        {
            result.setFillColor(Color.RED);
            addObject(result1, 540, 550);
        }
        else if(time.millisElapsed() < 4500)
        {
            result.setFillColor(Color.RED);
            addObject(result2, 530, 600); 
        }
    }
    
    /**
     * Puts a funny yoshi onto the screen
     */
    public void walkingYoshi()
    {
        if(yoshi.distanceFrom(1050, 300)<10)
        {
            removeObject(yoshi);
            TitlePage t = new TitlePage();
            Greenfoot.setWorld(t);
        }
        else
        {
            yoshi.relocate(1050,300);
        }
    }
    
}
