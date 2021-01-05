
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.io.*;

/**
 * This is the main world where the game page of the tower defense runs on. 
 * It consists of the statuses of all existing objects
 * @Benny Wu
 * @1000
 */

/**
 * Optimize the shooting of towers
 * Add lighning strikes and adjust the angle issue
 * change the image of the mouse
 */
public class Game extends World
{

    
    // These arraylists store the set position of the paths, and the current status of the enemies
    public ArrayList<int[]> pathOne = new ArrayList<int[]>(); 
    public ArrayList<int[]> pathTwo = new ArrayList<int[]>();
    public ArrayList<int[]> tiles = new ArrayList<int[]>();
    public ArrayList<Enemy> enemyList = new ArrayList<Enemy>();

    GreenfootImage background = new GreenfootImage("images/game_map11.png");
    int total_coins;                        // It represents the total amount of coins the player possesses
    Label coins;                            // The label on the top left corner of the screen
    SimpleTimer time = new SimpleTimer();   // A timer to control the speed of towers/enemies
    
    
    /**
     * Constructor for objects of class Game
     * All variables are constant at the beginning
     */
    public Game()
    {    
        // Create a new world with 1050 x 700 cells with a cell size of 1x1 pixels.
        super(1050, 700, 1); 
        setBackground(background);
        background.scale(1050, 700);
        System.out.println("--------");
        System.out.println("Welcome to Benny's Tower Defense");
        System.out.println("--------");
        
        // It reads the coordinates of the map and store it into certain arrays
        readMouseInfo("Tower Defense MousePos1.txt", pathOne);
        readMouseInfo("Tower Defense MousePos2.txt", pathTwo);
        readMouseInfo("tiles_coordinates.txt", tiles);

        display_tiles(tiles);
        
        // Set the labels and the amount of coins
        total_coins = 999;
        coins = new Label(total_coins, 50); 
        coins.setFillColor(Color.YELLOW);
        addObject(coins, 260, 70);
        GreenfootImage coin = new GreenfootImage("coin.png");
        coin.scale(60,60);
        background.drawImage(coin, 150, 40);
        
        // Update the status of the gold mine
        updateMine(1, 1); 

        
        time.mark();
        
    }
    
    public void act()
    {

        /* 
         * Add an enemy onto the screen after a certain amount of time
         * TODO: Needs to be change based on the difficulties of different levels
         */
        
        if(time.millisElapsed()>Greenfoot.getRandomNumber(400)+800)
        {
            addEnemy();
        }
        
        checkEnemyStatus(); // Constantly checks if the enemy is in the world

    }

    /**
     * Displays the images of tiles onto the screen
     */
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
       int num = Greenfoot.getRandomNumber(3);
       if(num==0)
       {
           DudeEnemy e = new DudeEnemy(1.9,20,10,pathOne.get(0)[0], pathOne.get(0)[1]);

           time.mark();
           enemyList.add(e); 
           addObject(e, pathOne.get(0)[0], pathOne.get(0)[1]);
       }
       
       else if(num==1){
           Yoshi e = new Yoshi(2.5,12,10,pathOne.get(0)[0], pathOne.get(0)[1]);
           time.mark();
           enemyList.add(e); 
           addObject(e, pathOne.get(0)[0], pathOne.get(0)[1]);
       }
       else{
           Bat e = new Bat(4,3,10,pathOne.get(0)[0], pathOne.get(0)[1]);
           time.mark();
           enemyList.add(e); 
           addObject(e, pathOne.get(0)[0], pathOne.get(0)[1]);
       }
       

    }

    public void checkEnemyStatus()
    {
        for(int i=0; i<enemyList.size(); i++)
        {
            
           if (!enemyList.get(i).existing)
           {
              enemyList.get(i).remove();
              enemyList.remove(i);
           }
        }
    }
    
    public void updateMine(int speed, int level)
    {
        GoldMine mine = new GoldMine(speed, level);
        addObject(mine, 550, 440);
    }
    
    public void updateCoins(int coin)
    {
        total_coins += coin;
        coins.setValue(total_coins);
    }
    
    public void mouseCoords(String f)
    {
        if(Greenfoot.mouseClicked(null))
        {
            int x = Greenfoot.getMouseInfo().getX();
            int y = Greenfoot.getMouseInfo().getY();
            int[] arr = {x,y};
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
