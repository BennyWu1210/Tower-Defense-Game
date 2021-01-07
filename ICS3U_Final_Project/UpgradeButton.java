
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UpgradeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpgradeButton extends Button
{
    /**
     * Act - do whatever the UpgradeButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    boolean enlarged;
    Tower tower;
    
    public UpgradeButton(Tower tower)
    {
        super(new GreenfootImage("upgrade_button02.png"));
        this.length = 25;
        this.width = 25;
        this.tower = tower;
        button.scale(length,width);
        enlarged = false;
        
        
    }
    
    public void act() 
    {
        checkHover();
    }   
    
    public boolean detectClick()
    {
        if(Greenfoot.mouseClicked(this))
        {
            return true;
        }
        return false;
    }
        

}
