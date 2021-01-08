import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends Button
{
    /**
     * Act - do whatever the StartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private String file_name;
    public StartButton(String file_name, int l, int w)
    {
        super(new GreenfootImage(file_name));
        this.length = l;
        this.width = w;
        this.file_name = file_name;
        button.scale(length, width);
        
        
    }

    SimpleTimer timer = new SimpleTimer(); 
    public void act() 
    {
        // The pixels of the button becomes TERRIBLE when hovered for too many times
        // Presumably it is caused by calling the scale method too much
        if(timer.millisElapsed()>1000)
        {
            button = new GreenfootImage(file_name); // Refreshing the button fixes the problem
        }
        detectClick();
        checkHover();
    }  
    
    public void detectClick()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Game game = new Game();
            Greenfoot.setWorld(game);
        }
    }
    
    private boolean hovering = true;
    public void checkHover()
    {
        if(Greenfoot.mouseMoved(this))
        {
            hovering = true;
            
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            hovering = false;
        }
        if (hovering)
        {
            sizeOfButton = 1.375;
            increasing = false;
            button.scale(303,110);
        }
        else
        {
            changeSize();
        }

    }
}
