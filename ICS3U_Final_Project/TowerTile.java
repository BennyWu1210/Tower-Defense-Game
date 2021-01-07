import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TowerTile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TowerTile extends Actor
{
    /**
     * Act - do whatever the TowerTile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int[] position = new int[2];
    public GreenfootImage block = new GreenfootImage("images/tile01.png");
    static GreenfootImage fire = new GreenfootImage("fire_symbol.png");
    static GreenfootImage lightning = new GreenfootImage("lightning_symbol.png");
    static boolean clicked = false;
    
    TowerOption fireButton = new TowerOption(fire);
    TowerOption lightningButton = new TowerOption(lightning);
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
        // Add your action code here.
    }    
    
    public void detectClick()
    {

        
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
            LightningTower l = new LightningTower(this);
            getWorld().addObject(l, position[0], position[1]-20);

        }
        
        else if(Greenfoot.mouseClicked(fireButton))
        {
            InfernoTower i = new InfernoTower(this);
            
            getWorld().addObject(i, position[0], position[1]-20);
        }
        //BombTower i = new BombTower(this);
        
        
    }
    
    public void displayOptions()
    {
        if(clicked)
        {
            getWorld().addObject(fireButton, position[0] - 10, position[1]-30);
            getWorld().addObject(lightningButton, position[0] + 10, position[1]-30);

        }

        else
        {
            getWorld().removeObject(fireButton);
            getWorld().removeObject(lightningButton);
        }
    }
}
