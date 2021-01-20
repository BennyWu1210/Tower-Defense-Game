import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This type of button allows players to upgrade towers and gold mines
 * @author (Benny Wu) 
 * Last edited (Jan 20, 2021)
 */
public class UpgradeButton extends Button
{


    boolean enlarged;
    Entity entity;
    Label cost_label;
    
    public UpgradeButton(Entity entity)
    {
        super(new GreenfootImage("upgrade_button02.png"));
        this.length = 25;
        this.width = 25;
        this.entity = entity;
        setLabel();
        button.scale(length,width);
        enlarged = false;
        
        
    }

    public void act() 
    {
        checkHover();
        
    }   
    
    /**
     * returns true if mouse click on this object, false otherwise
     */
    public boolean detectClick()
    {
        if(Greenfoot.mouseClicked(this))
        {
            return true;
        }
        return false;
    }
        
    /**
     * Changes the size if mouse hovers over the button
     */
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
        cost_label = new Label("$" + entity.getCost(), 30);
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
        
        if(cost_label.getWorld() != null)
        {
            
            ((Game)getWorld()).removeObject(cost_label);
        }
        if(this.getWorld() != null && this!=null)
        {
            ((Game)getWorld()).removeObject(this);
        }
        
    }
    
    
}
