import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The button that leads playes into the instruction page
 * 
 * @author (Benny Wu) 
 * Last edited (Jan 20, 2021)
 */
public class InstructionButton extends Button
{
    /**
     * Act - do whatever the InstructionButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private String file_name;
    SimpleTimer timer = new SimpleTimer(); 
    public InstructionButton(String file_name, int l, int w)
    {
        super(new GreenfootImage(file_name));
        this.length = l;
        this.width = w;
        this.file_name = file_name;
        button.scale(length, width);
        
        
    }

    public void act() 
    {
        checkHover();
        detectClick();
    }  
    
    /**
     * sets world to Game if mouse clicked on this
     */
    public void detectClick()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Instruction i = new Instruction();
            Greenfoot.setWorld(i);
            
        }
            
    }
    
    /**
     * Changes the size if mouse hovers over the button
     */
    public void checkHover()
    {

        if (Greenfoot.mouseMoved(this))
        {
            button.scale(100,100);
        }
        else if(Greenfoot.mouseMoved(null))
        {
            button.scale(70,72);
        }

    }
}
