import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * This is the main screen that is displayed when the player enters the game
 * @author (Benny Wu) 
 * Last edited (Jan 20, 2021)
 */
public class TitlePage extends World
{

    /**
     * Constructor for objects of class Intro.
     */
    static GreenfootSound background_music = new GreenfootSound("Background_music.mp3");
    static int length = 960;
    static int width = 483;
    
    SimpleTimer t = new SimpleTimer();
    SimpleTimer delay;
    
    GifImage intro = new GifImage("Intro_screen.gif");
    List<GreenfootImage> background = intro.getImages();
    int imageIndex = 0;
    
    public TitlePage()
    {    
        super(length, width, 1); 
        for(GreenfootImage i: background)
        {
            i.scale(length, width);
        }
        delay = new SimpleTimer();
        setBackground(background.get(imageIndex));
        t.mark();
        displayTitle();
        createButton();
        background_music.setVolume(21);
        
    }
    
    public void act()
    {
        background_music.playLoop();
        displayTitle();
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
    
    /**
     * Creates two buttons and add it to the world
     */
    public void createButton()
    {
        StartButton s_button = new StartButton("start_button.png", (int)(242.1), (int)(88));
        addObject(s_button, length/2, width*5/6);
        InstructionButton i_button = new InstructionButton("menu_button.png", (int)(70), (int)(72));
        addObject(i_button, length/2, width*5/8);
    }
    
    /**
     * Creates two buttons and add it to the world
     */
    public void displayTitle()
    {
        Label l = new Label("Welcome to Benny's Tower Defense",52);
        l.setFillColor(Color.WHITE.brighter());
        addObject(l, length/2, width/8);

        if(delay.millisElapsed()>2000)
        {
            Label l2 = new Label("Also, Mr. Chan is so cool!", 50);
            l2.setFillColor(Color.RED.darker());
            addObject(l2, length/2, width/4);
        }
        
        if(delay.millisElapsed()>3500)
        {
            Label l3 = new Label("(Gotta get those extra points you know)", 37);
            l3.setFillColor(Color.RED.darker());
            addObject(l3, length/2, width/3);
        }
    }
}
