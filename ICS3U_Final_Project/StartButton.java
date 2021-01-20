import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
/**
 * It is the button that leads players into the game
 * 
 * @author (Benny Wu) 
 * Last edited (Jan 20, 2021)
 */
public class StartButton extends Button
{
    
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
            File file = new File("level_01.txt");
            Level level = new Level(file);
            Game game = new Game(level);
            
            Greenfoot.setWorld(game);
            
        }
            
    }
    
    private boolean hovering = false;
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
