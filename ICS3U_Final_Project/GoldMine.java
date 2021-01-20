import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Spawns coins and adds it to the players
 * 
 * @author (Benny Wu) 
 */
public class GoldMine extends Entity
{

    SimpleTimer time = new SimpleTimer();
    double mining_speed;
    int level;
    int productivity;
    int length;
    int width;
    GreenfootImage image;

    public GoldMine(double speed, int level)
    {
        this.mining_speed = speed;
        this.level = level;
        this.length = 100;
        this.width = 70;
        this.clicked = true;
        this.cost = 100;
        productivity = 10;
        time.mark();
        image = new GreenfootImage("gold_mine_level01.png");
        image.scale(100,70);
        level_label = new Label("Level " + this.level, 25);
        level_label.setFillColor(Color.YELLOW.brighter());
        
        setImage(image);
        
    }
    
    public void act() 
    {
        enlarge();
        displayLevel();
        
        
        
        if(u != null && u.detectClick())
        {
            System.out.println("hsjai");
            this.levelUp();
            u.remove();
        }
        
        if(1000/mining_speed<time.millisElapsed())
        {
            time.mark();
            spawnCoin();
        }
        
        displayUpgrade();
    }    
    
    public void spawnCoin()
    {
        Game world = (Game)getWorld();
        DropCoin coin = new DropCoin();
        world.addObject(coin, getX()-10, getY()-25);
        world.updateCoins(10);
    }
    
    public void enlarge()
    {
        if(Greenfoot.mouseMoved(this))
        {
            image.scale((int)(length*1.3),(int)(width*1.3));
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            image.scale(length,width);
        }
    }
    
    public void levelUp()
    {
        
        if(((Game)getWorld()).takeCoins(this.cost))
        {
            this.level ++;
            this.cost *= 2;
            this.mining_speed += 1;
        }
        if(this.level > 1)
        {
            image = new GreenfootImage("gold_mine_level02.png");
            setImage(image);
        }
    }
    
    public void displayLevel()
    {
       level_label.setValue("Level " + this.level);
       getWorld().addObject(level_label, this.getX(), this.getY()-35);
    }
    
}
