

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
    //public ArrayList<Integer> enemy_num;

                
    
    GreenfootImage background;
    int total_coins;                        // It represents the total amount of coins the player possesses
    Label coins;                            // The label on the top left corner of the screen
    SimpleTimer time = new SimpleTimer();   // A timer to control the speed of towers/enemies
    SimpleTimer game_time = new SimpleTimer();
    Label counter;
    Label coin_display;
    Label wave_label;
    int lives;
    Heart[] hearts;
    public static int level;
    int wave;
    int enemy_counter;
    Level current_level;
    
    /**
     * Constructor for objects of class Game
     * All variables are constant at the beginning
     */
    public Game(Level l)
    {    
        // Create a new world with 1050 x 700 cells with a cell size of 1x1 pixels.
        
        super(1050, 700, 1); 
        this.current_level = l;
        this.wave = 1;
        this.enemy_counter = 1;
        level = l.getLevel();
        background = l.getBackground();
        //background = new GreenfootImage("game_map202.jpg");
        background.scale(1050, 700);
        setBackground(background);
        
        System.out.println("--------");
        System.out.println("Welcome to Benny's Tower Defense");
        System.out.println("--------");
        
        // It reads the coordinates of the map and store it into certain arrays
        readMouseInfo(l.getPathOne(), pathOne);
        readMouseInfo(l.getPathTwo(), pathTwo);
        readMouseInfo(l.getTiles(), tiles);

        display_tiles(tiles);
        
        // Set the labels and the amount of coins
        total_coins = 10000;
        coins = new Label(total_coins, 50); 
        coins.setFillColor(Color.YELLOW);
        addObject(coins, 260, 70);
        GreenfootImage coin = new GreenfootImage("coin.png");
        coin.scale(60,60);
        background.drawImage(coin, 160, 40);
        
        // Update the status of the gold mine
        updateMine(1, 1); 

        lives = 5;
        hearts = new Heart[lives];
        storeHeath();
        displayHealth(800, 50);
        
        counter = new Label("time: " + game_time.millisElapsed()/1000.0, 30);
        counter.setFillColor(Color.BLACK);
        addObject(counter, 400, 70);
        
        //changeWave();
        wave_label = new Label("Level " + this.level + " - " + this.wave, 30);
        displayWave();
        
        time.mark();
        
        
    }

    public void act()
    {
        /*
        if(Greenfoot.mouseClicked(null))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if(mouse!=null)
            {
                writeMouseInfo(mouse.getX(), mouse.getY(), "Tower Defense MousePos6.txt");
            }
        }
        */
        
        //System.out.println(this.wave);
        if(enemy_counter % 5 == 0 && this.wave < 3)
        {
            //level.changeWave();
            this.wave ++;
            displayWave();
            this.enemy_counter ++;
            
        }
        
        if(game_time.millisElapsed() > 500 && Greenfoot.isKeyDown("ENTER"))
        {
            level++;
            changeLevel((level)%3+1);
            System.out.println(level);
        }
        
        /* 
         * 
         * Add an enemy onto the screen after a certain amount of time
         * TODO: Needs to be change based on the difficulties of different levels
         */
        
        if(wave == 3)
        {
            if(enemyList.size() == 0)
            {
                if(this.level == 3)
                {
                    changeLevel(-1);
                }
                else 
                {
                    changeLevel(this.level + 1);
                }
            }
        }
        else if(time.millisElapsed()>Greenfoot.getRandomNumber(1500)+(4-this.wave)*1500)
        {
            time.mark();
            addEnemy();
        }
        
        if(game_time.millisElapsed()>800000)
        {
            detectCondition(true);
        }
        
        if(game_time.millisElapsed()>10)
        {
            updateTimer();
        }
        detectCondition(false);
        checkEnemyStatus(); // Constantly checks if the enemy is in the world
        
        if (coin_display != null && 2000<no_coin.millisElapsed() && no_coin.millisElapsed()<3000)
        {
            removeObject(coin_display);
        }

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
        //int num = Greenfoot.getRandomNumber(6);
        
        /*
        if(num==0)
        {
        DudeEnemy d = new DudeEnemy(2.1,30,40,pathOne.get(0)[0], pathOne.get(0)[1]);
        createEnemy(d);
        }
        
        else if(num==1){
        Yoshi y = new Yoshi(2.6,22,30,pathOne.get(0)[0], pathOne.get(0)[1]);
        createEnemy(y);
        }
        else if(num==2){
        Bat b = new Bat(4.2,3,15,pathOne.get(0)[0], pathOne.get(0)[1]);
        createEnemy(b);
        }
        
        else if(num==3)
        {
        WalkingSoldier w = new WalkingSoldier(2,45,20,pathOne.get(0)[0], pathOne.get(0)[1]);
        createEnemy(w);
        }
        
        else if(num==4)
        {
        Snail s = new Snail(2.2,45,100,pathOne.get(0)[0], pathOne.get(0)[1]);
        createEnemy(s);
        }
        
        else if(num==5 || num==6)
        {
        Golem g = new Golem(1.9,500,300,pathOne.get(0)[0], pathOne.get(0)[1]);
        createEnemy(g);
        }
        */
       
        //int n = enemy_num.get(Greenfoot.getRandomNumber(enemy_num.size()));
        //System.out.println(current_level.getEnemy());
        int n = current_level.getEnemy().get(Greenfoot.getRandomNumber(current_level.getEnemy().size()));
        switch (n) {
            case 1:
                DudeEnemy d = new DudeEnemy(2.1+wave-1,30+wave*5,40,pathOne.get(0)[0], pathOne.get(0)[1]);
                createEnemy(d);
                break;
            case 2:
                Yoshi y = new Yoshi(2.6+wave-1,22*wave,30,pathOne.get(0)[0], pathOne.get(0)[1]);
                createEnemy(y);
                break;
            case 3:
                Bat b = new Bat(4.2,3,15,pathOne.get(0)[0], pathOne.get(0)[1]);
                createEnemy(b);
                break;
            case 4:
                WalkingSoldier w = new WalkingSoldier(2+wave-1,45+wave,20,pathOne.get(0)[0], pathOne.get(0)[1]);
                createEnemy(w);
                break;
            case 5:
                Snail s = new Snail(1.9,45,100,pathOne.get(0)[0], pathOne.get(0)[1]);
                createEnemy(s);
                break;
            case 6:
                Golem g = new Golem(1.9,500,300,pathOne.get(0)[0], pathOne.get(0)[1]);
                createEnemy(g);
                break;
            default:
                Bat bat = new Bat(4.2,3,15,pathOne.get(0)[0], pathOne.get(0)[1]);
                createEnemy(bat);
                break;
                


      
        }
        
    }
    
    public void createEnemy(Enemy e)
    {
        time.mark();
        enemyList.add(e); 
        addObject(e, pathOne.get(0)[0], pathOne.get(0)[1]);
    }
    
    public void checkEnemyStatus()
    {
        for(int i=0; i<enemyList.size(); i++)
        {
            
           if (!enemyList.get(i).existing)
           {
              enemyList.get(i).remove();
              enemyList.remove(i);
              enemy_counter ++;
              System.out.println(enemy_counter);
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
    
    public void updateTimer()
    {
        if (game_time.millisElapsed()<10000)
        {
            counter.setValue("TIME: " + Double.toString(game_time.millisElapsed()/1000.0).substring(0,3));
        }
        else if(game_time.millisElapsed()<100000)
        {
            counter.setValue("TIME: " + Double.toString(game_time.millisElapsed()/1000.0).substring(0,4));
        }
        else
        {
            counter.setValue("TIME: " + Double.toString(game_time.millisElapsed()/1000.0).substring(0,5));
        }
    }
    
    public void displayWave()
    {

        wave_label.setValue("Level " + this.level + " - " + this.wave);
        wave_label.setFillColor(Color.ORANGE);
        addObject(wave_label, 700, 80);
    }
    
    public void storeHeath()
    {
        for(int i=0; i<lives; i++)
        {
            hearts[i] = new Heart();
        }
    }
    
    public void displayHealth(int x, int y)
    {
        
        for (int i=0; i<lives; i++)
        {
            addObject(hearts[i], x+i*30, y);
        }
        
        for (int i=4; i>lives-1; i--)
        {
            removeObject(hearts[i]);
        }
        
    }
    
    private SimpleTimer no_coin = new SimpleTimer();
    
    public boolean checkCoins(int coin)
    {
        if (this.total_coins - coin >= 0)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    public void takeCoins(int coin)
    {
        if(checkCoins(coin))
        {
            this.total_coins -= coin;
        }
        else
        {
            coin_display = new Label("You do not have enough coins!", 50);
            coin_display.setFillColor(Color.RED);
            addObject(coin_display, 530, 300);
            no_coin.mark(); 
        }
        

    }
    
    public void detectCondition(boolean win)
    {
        if (lives<=0)
        {
            GameOver oo = new GameOver(this);
            Greenfoot.setWorld(oo);
        }
        else if(win)
        {
            GameWin yah = new GameWin(this);
            Greenfoot.setWorld(yah);
        }
    }
    
    public int getLevel()
    {
        return this.level;
    }
    
    /*
    public void changeWave()
    {
        System.out.println(level);
        if(level==1)
        {
            enemy_num = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        }
        else if(level==2)
        {
            enemy_num = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        }
        else if(level==3)
        {
            enemy_num = new ArrayList<Integer>(Arrays.asList(3, 4, 5, 6));
        }
        
        
    }
    */
    
   
    public void changeLevel(int l)
    {
        if(l==1)
        {
            /*
            Level level = new Level(1050, 700, 1, new GreenfootImage("images/game_map11.png"), 
            "Tower Defense MousePos1.txt","Tower Defense MousePos2.txt", "tiles_coordinates.txt");
            */
            File file = new File("Level_01.txt");
            Level level = new Level(file);
            Game game = new Game(level);
            //game.changeWave();
            Greenfoot.setWorld(game);
            
            
        }
        else if (l==2)
        {
            /*
            GreenfootImage background = new GreenfootImage("images/game_map101.jpg");
            Level level = new Level(1050, 700, 2, background, "Tower Defense MousePos3.txt",
            "Tower Defense MousePos4.txt", "tiles_coordinates02.txt");
            */
            File file = new File("Level_02.txt");
            Level level = new Level(file);
            Game game = new Game(level);
            //game.changeWave();
            Greenfoot.setWorld(game);
            
        }
        else if (l==3)
        {
            /*
            GreenfootImage background = new GreenfootImage("images/game_map202.jpg");
            Level level = new Level(1050, 700, 3, background, "Tower Defense MousePos5.txt",
            "Tower Defense MousePos6.txt", "tiles_coordinates03.txt");
            */
            File file = new File("Level_03.txt");
            Level level = new Level(file);
            Game game = new Game(level);
            //game.changeWave();
            Greenfoot.setWorld(game);
            
        }
        else
        {
            GameWin win = new GameWin(this);
            Greenfoot.setWorld(win);
        }
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
                String store_x = "";
                String store_y = "";
                int index = 1;
                while (data.charAt(index) != ',')
                {
                    store_x += data.charAt(index);
                    index ++;
                }
                index += 2;
                while (data.charAt(index) != ')')
                {
                    store_y += data.charAt(index);
                    index ++;
                }
                
                int x = Integer.parseInt(store_x);
                int y = Integer.parseInt(store_y);
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
