import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Allows the players to place different towers using different options
 * 
 * @author (Benny Wu)  
 * Last edited (Jan 20, 2021)
 */
public class TowerOption extends Button
{


    Label cost_label;
    int cost;
    public TowerOption(GreenfootImage button, int cost)
    {
        super(button);
        this.length = 20;
        this.width = 25;
        this.cost = cost;
        button.scale(length,width);
        setLabel();
    }
    
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {
            getWorld().removeObject(cost_label);
        }
        checkHover();
        
        
    }    
    
    /**
     * Displays cost beside an object
     */
    public void displayCost(boolean appear)
    {
        if (appear)
        {
            getWorld().addObject(cost_label, this.getX(), this.getY()-20);
        }
        else if(!appear && cost_label!=null)
        {
            getWorld().removeObject(cost_label);
        }
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
    
    public int getCoin()
    {
        return cost;
    }
    
    public void setCost(int cost)
    {
        this.cost = cost;
    }
    
    public void setLabel()
    {
        cost_label = new Label("$" + cost, 30);
        cost_label.setFillColor(Color.RED);
    }
}
