
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.io.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game extends World
{
    GreenfootImage background = new GreenfootImage("images/game_map08.png");
    
    SimpleTimer time = new SimpleTimer();
    public ArrayList<int[]> pathOne = new ArrayList<int[]>();
    public ArrayList<int[]> pathTwo = new ArrayList<int[]>();
    public ArrayList<int[]> tiles = new ArrayList<int[]>();
    public ArrayList<Enemy> dudeList = new ArrayList<Enemy>();
    //DudeEnemy aa;
    //Inferno bb;
    //Fireball ff;
    Inferno bb;
    /**
     * Constructor for objects of class MyWorld
     * 
     */
    public Game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1050, 700, 1); 
        setBackground(background);
        background.scale(1050, 700);
        System.out.println("--------");
        
        
        readMouseInfo("Tower Defense MousePos1.txt", pathOne);
        readMouseInfo("Tower Defense MousePos2.txt", pathTwo);
        readMouseInfo("tiles_coordinates 2.txt", tiles);
        System.out.println(pathOne.size());
        //aa = new DudeEnemy(1, 10, 10);
        //addObject(aa, pathOne.get(0)[0], pathOne.get(0)[1]);
        //aa.relocate(pathOne.get(0)[0], pathOne.get(0)[1]);
        
        display_tiles(tiles);
        TowerTile tile = new TowerTile(100, 100);
        
        //bb = new Inferno();
        //addObject(bb, 418, 504);
        
        //ff = new Fireball(aa);
        //addObject(ff, 418, 504);
        /*
        for(int[] arr: pathOne)
        {
            System.out.println(arr[0] + " " + arr[1]);
        }
        */
        
        //TitlePage n = new TitlePage();
        //Greenfoot.setWorld(n);
        time.mark();
        addEnemy();
        LightningStrike l = new LightningStrike();
        addObject(l, 500, 500);
    }
    
    public void act()
    {
        
        if(Greenfoot.mouseClicked(null))
        {
            int x = Greenfoot.getMouseInfo().getX();
            int y = Greenfoot.getMouseInfo().getY();
            //System.out.println(x + " " + y);
        }

        //mouseCoords("Tower Defense MousePos1.txt");
        
        if(time.millisElapsed()>2000)
        {
            addEnemy();
        }
        
        
        //ff.shoot(500,100);
        //ff.shoot(aa);
        moveEnemy();
        //ff.checkClosest();
        //System.out.println(dudeList.get(0).existing);

    }


    public void display_tiles(ArrayList<int[]> t)
    {
        for (int[] pos: t)
        {
            TowerTile tile = new TowerTile(pos[0], pos[1]);
            addObject(tile, pos[0], pos[1]);
        }
        
    }
    
    public void addEnemy()
    {
       System.out.println("hii");
       time.mark();
       DudeEnemy e = new DudeEnemy(1.9,10,10,pathOne.get(0)[0], pathOne.get(0)[1]);
       dudeList.add(e); 
       addObject(e, pathOne.get(0)[0], pathOne.get(0)[1]);
       //e.relocate(pathOne.get(0)[0], pathOne.get(0)[1]);
    }

    public void moveEnemy()
    {
        for(int i=0; i<dudeList.size(); i++)
        {
            
           if (!dudeList.get(i).existing)
           {
              this.removeObject(dudeList.get(i));
              dudeList.remove(i);
           }
        }
    }
    public void mouseCoords(String f)
    {
        if(Greenfoot.mouseClicked(null))
        {
            int x = Greenfoot.getMouseInfo().getX();
            int y = Greenfoot.getMouseInfo().getY();
            int[] arr = {x,y};
            //System.out.println(x + " " + y);
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
