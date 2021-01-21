
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Provides the towers a position to be placed
 * 
 * @author (Benny Wu) 
 * Last Edited (Jan 17, 2021)
 */
public class TowerTile extends Actor
{

    int[] position = new int[2];
    public GreenfootImage block = new GreenfootImage("images/tile01.png");
    static GreenfootImage fire = new GreenfootImage("fire_symbol.png");
    static GreenfootImage lightning = new GreenfootImage("lightning_symbol.png");
    static GreenfootImage bomb = new GreenfootImage("bomb-4.png");
    static boolean clicked = false;

    TowerOption fireButton = new TowerOption(fire, 30);
    TowerOption lightningButton = new TowerOption(lightning, 50);
    TowerOption bombButton = new TowerOption(bomb, 80);
    public TowerTile(int x, int y)
    {
        block.rotate(30);
        position[0] = x;
        position[1] = y;
        block.scale(40,40);
        setImage(block);

    }
    
    public void act() 
    {
        
        detectClick();
        if(Greenfoot.mouseMoved(this))
        {
            block.scale((int)(40*1.25),(int)(40*1.25));
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            block.scale(40,40);
        }
    }    
    
    /**
     * Detects if the mouse clicks on this; if so, displays the three tower options 
     */
    public void detectClick()
    {
        Game world = (Game)getWorld();
        if(Greenfoot.mouseClicked(this) && !clicked)
        {
            clicked = true;
            displayOptions();
        }
        else if(Greenfoot.mouseClicked(null) && !Greenfoot.mouseClicked(this))
        {
            clicked = false;
            displayOptions();

        }
        else if(Greenfoot.mouseClicked(this) && clicked)
        {
            clicked = false;
            
            displayOptions();
            
        }
        
        if(Greenfoot.mouseClicked(lightningButton))
        {
            
            if(world.takeCoins(lightningButton.getCoin()))
            {
                LightningTower l = new LightningTower(this);
                world.addObject(l, position[0], position[1]-20);
                world.updateCoins(0);
                world.removeObject(this);
                
            }
            world.removeObject(lightningButton.cost_label);
            
        }
        
        else if(Greenfoot.mouseClicked(fireButton))
        {
            if (world.takeCoins(fireButton.getCoin()))
            {
                InfernoTower i = new InfernoTower(this);
                world.addObject(i, position[0], position[1]-20);
                world.updateCoins(0);
                world.removeObject(this);
            }
            world.removeObject(fireButton.cost_label);
            
        }
        else if(Greenfoot.mouseClicked(bombButton))
        {
            if (world.takeCoins(bombButton.getCoin()))
            {
                BombTower b = new BombTower(this);
                world.addObject(b, position[0], position[1]-20);
                world.updateCoins(0);
                world.removeObject(this);
            }
            world.removeObject(bombButton.cost_label);
            
        }
        
        
    }
    
    
    public void displayOptions()
    {
        if(clicked)
        {
            getWorld().addObject(fireButton, position[0] - 20, position[1] - 35);
            getWorld().addObject(bombButton, position[0] - 2, position[1] - 40);
            getWorld().addObject(lightningButton, position[0] + 20, position[1] - 35);

        }

        else
        {
            getWorld().removeObject(fireButton);
            getWorld().removeObject(lightningButton);
            getWorld().removeObject(bombButton);
            
            
            
        }
    }
}
