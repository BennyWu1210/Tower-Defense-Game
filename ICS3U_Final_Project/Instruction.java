import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Instruction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instruction extends World
{

    /**
     * Constructor for objects of class Instruction.
     * 
     */
    GifImage intro = new GifImage("Intro_screen.gif");
    List<GreenfootImage> background = intro.getImages();
    static int length = 960;
    static int width = 483;
    int imageIndex = 0;
    SimpleTimer t = new SimpleTimer();
    /*
    GifImage lightning; //TODO: Put these into a class!!!!!
    GifImage fire;
    GifImage bomb;
    GifImage upgrade;
    GifImage coin;
    List<GreenfootImage> fire_list;
    List<GreenfootImage> lightning_list;
    List<GreenfootImage> bomb_list;
    List<GreenfootImage> upgrade_list;
    List<GreenfootImage> coin_list;
    int lightningIndex = 0;
    int fireIndex = 0;
    int bombIndex = 0;
    int upgradeIndex = 0;
    int coinIndex = 0;
    */
    Gif lightning;
    Gif fire;
    Gif bomb;
    Gif upgrade;
    Gif coin;
    Button return_button;
    public Instruction()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(length, width, 1); 
        /*
        lightning = new GifImage("lightning_ins.gif");
        fire = new GifImage("fire_ins.gif");
        bomb = new GifImage("bomb_ins.gif");
        upgrade = new GifImage("upgrade_ins.gif");
        coin = new GifImage("gold_ins.gif");
        fire_list = fire.getImages();
        lightning_list = lightning.getImages();
        bomb_list = bomb.getImages();
        upgrade_list = upgrade.getImages();
        coin_list = coin.getImages();
        */
        lightning = new Gif(new GifImage("lightning_ins.gif"), 610, 120);
        fire = new Gif(new GifImage("fire_ins.gif"), 170, 120);
        bomb = new Gif(new GifImage("bomb_ins.gif"), 390, 120);
        upgrade = new Gif(new GifImage("upgrade_ins.gif"), 280, 300);
        coin = new Gif(new GifImage("gold_ins.gif"), 500, 300);

        for(GreenfootImage i: background)
        {
            i.scale(length, width);
        }
        setBackground(background.get(imageIndex));
        display();
    }
    
    public void act()
    {
        controlGifs();
        if(Greenfoot.mouseClicked(return_button))
        {
            TitlePage t = new TitlePage();
            Greenfoot.setWorld(t);
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
    
    public void display()
    {
        Label l1 = new Label("Instruction Page", 60);
        l1.setFillColor(Color.WHITE.brighter());
        addObject(l1, length/2, width/8);
        Label l2 = new Label("Deploy your towers to defend", 30);
        l2.setFillColor(Color.YELLOW.brighter());
        addObject(l2, length/2, width/5);
        Label l3 = new Label("Upgrade your towers", 30);
        l3.setFillColor(Color.YELLOW.brighter());
        addObject(l3, 344, 280);
        Label l4 = new Label("Collect coins to be RICH", 30);
        l4.setFillColor(Color.YELLOW.brighter());
        addObject(l4, 654, 280);
        Label l5 = new Label("Don't let the enemies go through. Survive 2 minutes to move on to the next level", 25);
        l5.setFillColor(Color.YELLOW.brighter());
        addObject(l5, length/2, 450);
        return_button = new Button(new GreenfootImage("return_button.png"));
        return_button.scale(70, 70);
        addObject(return_button, 35, 35);
    }
    
    public void controlGifs()
    {
        /*
        if(lightningIndex>=lightning_list.size()-1)
        {
            lightningIndex = 0;
        }
        if(fireIndex>=fire_list.size()-1)
        {
            fireIndex = 0;
        }
        if(bombIndex>=bomb_list.size()-1)
        {
            bombIndex = 0;
        }
        if(upgradeIndex>=upgrade_list.size()-1)
        {
            upgradeIndex = 0;
        }
        if(coinIndex>=coin_list.size()-1)
        {
            coinIndex = 0;
        }
        
        if(t.millisElapsed()%3 == 0)
        {
            lightningIndex ++;
            fireIndex ++;
            bombIndex ++;
            upgradeIndex ++;
            coinIndex ++;
            */
        background.get(imageIndex).drawImage(fire.getImage(70), 170, 120);
        background.get(imageIndex).drawImage(bomb.getImage(70), 390, 120);
        background.get(imageIndex).drawImage(lightning.getImage(70), 610, 120);
        background.get(imageIndex).drawImage(upgrade.getImage(70), 280, 300);
        background.get(imageIndex).drawImage(coin.getImage(70), 500, 300);

        
    }
    
    
}
