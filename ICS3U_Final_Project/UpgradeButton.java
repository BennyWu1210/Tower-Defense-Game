
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
    Label cost_label;
    
    public UpgradeButton(Tower tower)
    {
        super(new GreenfootImage("upgrade_button02.png"));
        this.length = 25;
        this.width = 25;
        this.tower = tower;
        setLabel();
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
        
    public void checkHover()
    {
        if(Greenfoot.mouseMoved(this))
        {
            button.scale((int)(length*1.25),(int)(width*1.25));
            displayCost(true);
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            button.scale(length,width);
            displayCost(false);
        }
        
    }
    
    public void setLabel()
    {
        cost_label = new Label("$" + tower.getCost(), 30);
        cost_label.setFillColor(Color.RED);
    }

    public void displayCost(boolean appear)
    {
        if (appear)
        {
            getWorld().addObject(cost_label, this.getX(), this.getY()-20);
        }
        else
        {
            getWorld().removeObject(cost_label);
        }
    }
    
    public void remove()
    {
        
        if(cost_label != null)
        {
            ((Game)getWorld()).removeObject(cost_label);
        }
        if(this!=null)
        {
            ((Game)getWorld()).removeObject(this);
        }
        
    }
}
