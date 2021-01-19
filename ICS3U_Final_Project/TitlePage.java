import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Intro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitlePage extends World
{

    /**
     * Constructor for objects of class Intro.
     * 
     */
    SimpleTimer t = new SimpleTimer();
    GifImage intro = new GifImage("Intro_screen.gif");
    List<GreenfootImage> background = intro.getImages();
    int imageIndex = 0;
    static int length = 960;
    static int width = 483;
    public TitlePage()
    {    
        // Create a new world with 960x483 cells with a cell size of 1x1 pixels.
        super(length, width, 1); 
        for(GreenfootImage i: background)
        {
            i.scale(length, width);
        }
        setBackground(background.get(imageIndex));
        t.mark();
        displayTitle();
        createButton();
    }
    
    public void act()
    {
        
        setBackground(background.get(imageIndex));
        
        if(t.millisElapsed()>100)
        {
            getImage();
        }

    }
    
    public GreenfootImage getImage()
    {

        GreenfootImage image = background.get(imageIndex);
        imageIndex ++;
        t.mark();
            
        if (imageIndex>=background.size())
        {
            imageIndex = 0;
        }
            
        return image;

    }
    
    public void createButton()
    {
        StartButton s_button = new StartButton("start_button.png", (int)(242), (int)(88));
        addObject(s_button, length/2, width*5/6);
        InstructionButton i_button = new InstructionButton("menu_button.png", (int)(70), (int)(72));
        addObject(i_button, length/2, width*5/8);
    }
    
    public void displayTitle()
    {
        Label l = new Label("Welcome to Benny's Tower Defense",52);
        l.setFillColor(Color.WHITE.brighter());
        addObject(l, length/2, width/8);
        Label l2 = new Label("Also, Mr. Chan is so cool!", 50);
        l2.setFillColor(Color.RED.darker());
        addObject(l2, length/2, width/4);
    }
}
