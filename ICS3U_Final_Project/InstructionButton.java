import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionButton extends Button
{
    /**
     * Act - do whatever the InstructionButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private String file_name;
    public InstructionButton(String file_name, int l, int w)
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
        checkHover();
        detectClick();
    }  
    
    public void detectClick()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Instruction i = new Instruction();
            Greenfoot.setWorld(i);
            
        }
            
    }
    
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
