import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LightningStrike here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LightningStrike extends Projectile
{
    /**
     * Act - do whatever the LightningStrike wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void LightningStrike() 
    {
        // Add your action code here.
        image = new GifImage("lightningStrike.gif");
        images = image.getImages();
        setLocation(100,100);
    }    
}
