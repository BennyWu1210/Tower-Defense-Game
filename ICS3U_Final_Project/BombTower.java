
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BombTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BombTower extends Tower
{
    /**
     * Act - do whatever the BombTower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    SimpleTimer time = new SimpleTimer();
    public BombTower(TowerTile tile)
    {
        super(tile);
        this.damage = 0;
        this.splash_damage = 2;
        this.fire_rate = 2300;
        this.cost = level * 100;
        image = new GreenfootImage("Bomb_Tower.png");
        image.scale(50,65);
        setRadius(150);
        setImage(image);
        setCost(100);
        level_label = new Label("Level " + getLevel(), 20);
        level_label.setFillColor(Color.BLACK);
        
    }
    
    public void addedToWorld(World game)
    {
        world = (Game)game;
        getWorld().addObject(level_label, this.getX(), this.getY()-36);
    }
    
    public void act() 
    {
        super.act();
        displayLevel();
        if(time.millisElapsed()>this.fire_rate)
        {
            time.mark();
            Enemy target = checkClosest();

            if(target != null)
            {
                Bomb b = new Bomb(target, this);
                getWorld().addObject(b, getX(), getY());
            }
            
        }
    }    
    
    public void displayLevel()
    {
       level_label.setValue("Level " + getLevel());
       //getWorld().addObject(level_label, this.getX(), this.getY()-36);
    }
    
}
