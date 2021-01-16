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
    SimpleTimer time = new SimpleTimer();
    GreenfootImage background = new GreenfootImage("game_over.png");
    Label result;
    Label result1;
    Label result2;
    protected Yoshi yoshi = new Yoshi(2.5,12,10, 0, 300);
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
        result = new Label("Nice job LAO CHEN!", 40);
        result1 = new Label("You made it to Level " + game.level + "!", 30);
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
    
    
    public void walkingYoshi()
    {
        if(yoshi.distanceFrom(1050, 300)<10)
        {
            removeObject(yoshi);
            this.game.changeLevel(game.getLevel()+1);
        }
        else
        {
            yoshi.relocate(1050,300);
        }
    }
    
    
}
