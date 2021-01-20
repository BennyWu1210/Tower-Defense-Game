import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is used to create different type of buttons in the game
 * @author (Benny Wu) 
 * Last edited (Jan 20, 2021)
 */
public class Button extends Actor
{

    public SimpleTimer time = new SimpleTimer();
    public GreenfootImage button;
    public double sizeOfButton = 1;
    public boolean increasing = true;
    public int length;
    public int width;
    public Button(GreenfootImage button)
    {
        this.button = button;
        time.mark();
        length = 50;
        width = 50;
        setImage(button);
    }
    
    public void act() 
    {
        checkHover();

    }    
    
    /**
     * Changes the size of button constantly to create an animation
     */
    public void changeSize()
    {
        setImage(this.button);
        if(increasing && time.millisElapsed()>200)
        {
            sizeOfButton += 0.125;
            time.mark();
        }
        else if(!increasing && time.millisElapsed()>200)
        {
            sizeOfButton -= 0.125;
            time.mark();
        }
        
        if(sizeOfButton>1.25)
        {
            increasing = false;
        }
        
        else if(sizeOfButton<1)
        {
            increasing = true;
        }
        
        button.scale((int)(length*sizeOfButton),(int)(width*sizeOfButton));
        
    }
    
    /**
     * Changes the size if mouse hovers over the button
     */
    public void checkHover()
    {
        if(Greenfoot.mouseMoved(this))
        {
            button.scale((int)(length*1.25),(int)(width*1.25));
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            button.scale(length,width);
        }
    }
    
    public void scale(int l, int w)
    {
        button.scale(l, w);
        setImage(button);
        
    }
    
}
