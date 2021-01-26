import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button of "Mr Chan's Power"
 * @author (Benny Wu) 
 * Last edited (Jan 66, 2077)
 */
public class ExplodeButton extends Button
{

    Label label;
    public ExplodeButton()
    {
        super(new GreenfootImage("nuclear-explosion.png"));
        this.length = 55;
        this.width = 55;
        setLocation(80, 720);
        label = new Label("Mr.Chan's Power($500)", 24);
        label.setFillColor(Color.RED.brighter());
    }
    
    public void act() 
    {
        checkHover();
        if(detectClick() && ((Game)getWorld()).takeCoins(500))
        {
            BombExplosion explosion = new BombExplosion(500, 400, 1.5, true);
            explosion.changeSize(1200,1200);
            getWorld().addObject(explosion, 500, 350);
        }
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
            displayWord(true);
        }

        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            button.scale(length,width);
            displayWord(false);
        }
        
    }
    
    public void displayWord(boolean appear)
    {
        if (appear)
        {
            getWorld().addObject(label, this.getX()+10, this.getY()-40);
        }
        else
        {
            getWorld().removeObject(label);
        }
    }
}
