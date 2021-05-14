
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A type of tower - Bomb Tower!
 *
 * @author (Benny Wu)
 * Last edited (Jan 20, 2021)
 */
public class BombTower extends Tower
{

    SimpleTimer time = new SimpleTimer();
    // This is edited on Atom
    public BombTower(TowerTile tile)
    {
        super(tile);
        this.damage = 1;
        this.splash_damage = 2;
        this.fire_rate = 2000;
        this.cost = level * 80;
        image = new GreenfootImage("Bomb_Tower.png");
        image.scale(50,65);
        setRadius(150);
        setImage(image);
        setCost(80);
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
    }

}
