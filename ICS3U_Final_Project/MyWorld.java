
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.io.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    GreenfootImage background = new GreenfootImage("images/game_map08.png");
    
    
    static ArrayList<int[]> pathOne = new ArrayList<int[]>();
    static ArrayList<int[]> pathTwo = new ArrayList<int[]>();
    static ArrayList<int[]> tiles = new ArrayList<int[]>();
    /**
     * Constructor for objects of class MyWorld
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1050, 700, 1); 
        setBackground(background);
        background.scale(1050, 700);
        System.out.println("--------");
        System.out.println(pathOne.size());
        
        readMouseInfo("Tower Defense MousePos1.txt", pathOne);
        readMouseInfo("Tower Defense MousePos2.txt", pathTwo);
        readMouseInfo("tiles_coordinates.txt", tiles);
        
        DudeEnemy aa = new DudeEnemy(5, 10, 10);
        addObject(aa, pathOne.get(0)[0], pathOne.get(0)[1]);
        aa.relocate(pathOne.get(0)[1],pathOne.get(0)[1]);
        
        display_tiles(tiles);
        TowerTile tile = new TowerTile(100, 100);
        
        
        

        /*
        for(int[] arr: pathOne)
        {
            System.out.println(arr[0] + " " + arr[1]);
        }
        */
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(null))
        {
            int x = Greenfoot.getMouseInfo().getX();
            int y = Greenfoot.getMouseInfo().getY();
            System.out.println(x + " " + y);
        }
        ;
    }

    public void display_tiles(ArrayList<int[]> t)
    {
        for (int[] pos: t)
        {
            TowerTile tile = new TowerTile(pos[0], pos[1]);
            addObject(tile, pos[0], pos[1]);
        }
        
    }
    public void mouseCoords(String f)
    {
        if(Greenfoot.mouseClicked(null))
        {
            int x = Greenfoot.getMouseInfo().getX();
            int y = Greenfoot.getMouseInfo().getY();
            int[] arr = {x,y};
            System.out.println(x + " " + y);
            writeMouseInfo(x,y,f);
        }
    }
    
    public void writeMouseInfo(int x, int y, String f)
    {
        try
        {
            String file = f;
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter myWriter = new BufferedWriter(writer);
            myWriter.write("(" + x + ", " + y + ")");
            myWriter.newLine();
            myWriter.close();
            System.out.println("written!");
        }
        
        catch(IOException e)
        {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
        
    }
    
    public void readMouseInfo(String f, ArrayList<int[]> path)
    {
        try
        {
            
            File file = new File(f);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine())
            {
                String data = sc.nextLine();
                int x = Integer.parseInt(data.substring(1, 4));
                int y = Integer.parseInt(data.substring(6, 9));
                int[] arr = {x, y};
                path.add(arr);
                // TODO: There may be two-digit integers, not the best way!
            }
            
        }
        
        catch(IOException e)
        {
            System.out.print("Cannot read file");
        }
    }
}
