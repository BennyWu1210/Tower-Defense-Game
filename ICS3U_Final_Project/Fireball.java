import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * A type of projectile - fireball
 * 
 * @author (Benny Wu) 
 * Last edited (Jan 20, 2021)
 */
public class Fireball extends Projectile
{

    SimpleTimer time = new SimpleTimer();
    GifImage image;
    GifImage explosion;
    Enemy target;
    
    int[] destination = new int[2];
    
    public Fireball(Enemy target, Tower tower)
    {
       

        this.damage = tower.getDamage();
        this.splash_damage = tower.getSplashDamage();
        this.image =  new GifImage("flame02.gif");
        this.target = target;
        this.tower = tower;
        this.images = image.getImages();
        this.gif = true;
        this.sound = new GreenfootSound("Fireball_sound.mp3");
        time.mark();
        this.sound.setVolume(35);
        for(GreenfootImage image: images)
        {
            image.scale(25,25);
        }
        speed = 5;
        this.sound.play();
        setLocation(tower.getX(), tower.getY());
        
    }
    
    /**
     * Throws fireball towards enemy
     */
    public void act() 
    {

        super.act();
        splashDamage();
        if(target.existing)
        {
            
            if(distanceFrom(tower.getX(), tower.getY())>tower.getRadius()
            || distanceFrom(target.getX(), target.getY()) < 7 )
            {
                if(distanceFrom(target.getX(), target.getY()) < 7)
                {
                    target.takeDamage(damage);
                }
                disappear();
                getWorld().removeObject(this);
                return;
            }
            

            destination[0] = target.getX();
            destination[1] = target.getY();
            move(target.getX()+5, target.getY());
        }
        else
        {
            if(distanceFrom(tower.getX(), tower.getY())>tower.getRadius()
               || distanceFrom(destination[0], destination[1]) < 6)
            {
                
                disappear();
                getWorld().removeObject(this);
                return;

            }
            if(destination[0]!=0)
            {
                move(destination[0]+5, destination[1]);
            }
            else
            {
                getWorld().removeObject(this);
            }
        }

    }    

    public void setDamage(int damage)
    {
        this.damage = damage;
    }
    
    public void disappear()
    {
        FireExplosion explosion = new FireExplosion(getX(), getY());
        getWorld().addObject(explosion, getX(), getY());
    }
    
    public GreenfootImage getImage()
    {
        
        GreenfootImage image = images.get((int)imageIndex);
        imageIndex ++;
            
        if (imageIndex>=images.size())
        {
            imageIndex = 0;
        }
            
        return image;
    }
}
