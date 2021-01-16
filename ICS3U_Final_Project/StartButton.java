import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
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
            /*
            GreenfootImage background = new GreenfootImage("images/game_map11.png");
            Level level = new Level(1050, 700, 1, background, "Tower Defense MousePos1.txt",
            "Tower Defense MousePos2.txt", "tiles_coordinates.txt");
            */
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
