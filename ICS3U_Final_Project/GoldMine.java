import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoldMine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoldMine extends Actor
{
    /**
     * Act - do whatever the GoldMine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    SimpleTimer time = new SimpleTimer();
    int Miningspeed;
    int level;
    int productivity;
    GreenfootImage image;
    public GoldMine(int speed, int level)
    {
        this.Miningspeed = speed;
        this.level = level;
        productivity = 10;
        time.mark();
        image = new GreenfootImage("gold_mine_level01.png");
        image.scale(100,70);
        setImage(image);
    }
    
    public void act() 
    {
        if(1000/Miningspeed<time.millisElapsed())
        {
            System.out.println("yo");
            time.mark();
            spawnCoin();
        }
    }    
    
    public void spawnCoin()
    {
        Game world = (Game)getWorld();
        DropCoin coin = new DropCoin();
        world.addObject(coin, getX()-10, getY()-25);
        world.updateCoins(10);
    }
}
