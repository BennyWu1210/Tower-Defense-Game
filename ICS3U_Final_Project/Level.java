import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.io.*;
/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level extends Actor
{
    /**
     * Act - do whatever the Level wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int length;
    int width;
    int level;
    int wave;
    GreenfootImage background;
    String pathOne;
    String pathTwo;
    String tiles;
    ArrayList<Integer> enemy_list = new ArrayList<Integer>();
    
    public Level(int length, int width, int level, GreenfootImage background, String pathOne, String pathTwo, String tiles)
    {
        this.length = length;
        this.width = width;
        this.background = background;
        this.pathOne = pathOne;
        this.pathTwo = pathTwo;
        this.tiles = tiles;
        this.level = level;
        this.wave = 0;
        
    }
    
    public Level(File file)
    {
        ArrayList<String> list = new ArrayList<String>();
        try
        {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine())
            {
                list.add(sc.nextLine());
            }
            sc.close();
            this.length = Integer.parseInt(list.get(0));
            this.width = Integer.parseInt(list.get(1));
            this.level = Integer.parseInt(list.get(2));
            this.background = new GreenfootImage(list.get(3));
            this.pathOne = list.get(4);
            this.pathTwo = list.get(5);
            this.tiles = list.get(6);
            for(int i=7; i<list.size(); i++)
            {
                enemy_list.add(Integer.parseInt(list.get(i)));
            }
        }
        catch(IOException e)
        {
            System.out.println("didn't get added");
        }
        
        
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void changeWave(int wave)
    {
        this.wave = wave;
    }
    
    public int getLevel()
    {
        return level;
    }
    
    public GreenfootImage getBackground()
    {
        return background;
    }
    
    public String getPathOne()
    {
        return pathOne;
    }
    
    public String getPathTwo()
    {
        return pathTwo;
    }
    
    public String getTiles()
    {
        return tiles;
    }
    
    public ArrayList<Integer> getEnemy()
    {
        return enemy_list;
    }
    
}
