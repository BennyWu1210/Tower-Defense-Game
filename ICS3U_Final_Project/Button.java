import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SimpleTimer time = new SimpleTimer();
    public GreenfootImage button;
    public double sizeOfButton = 1;
    public boolean increasing = true;
    public int length;
    public int width;
    public Button(GreenfootImage button)
    {
        this.button = button;
        setImage(this.button);
        time.mark();
    }
    public void act() 
    {
        
        // Add your action code here.
    }    
    
    public void changeSize()
    {
        setImage(this.button);
        if(increasing && time.millisElapsed()>200)
        {
            setImage(this.button);
            sizeOfButton += 0.125;
            time.mark();
        }
        else if(!increasing && time.millisElapsed()>200)
        {
            setImage(this.button);
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
}
