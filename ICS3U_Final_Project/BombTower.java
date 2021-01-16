
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
        this.splash_damage = 1.5;
        this.fire_rate = 2300;
        image = new GreenfootImage("Bomb_Tower.png");
        image.scale(50,65);
        setRadius(150);
        setImage(image);
        setCost(100);
        lv = new Label("Level " + getLevel(), 20);
        lv.setFillColor(Color.BLACK);
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
       lv.setValue("Level " + getLevel());
       getWorld().addObject(lv, this.getX(), this.getY()-36);
    }
    
}
