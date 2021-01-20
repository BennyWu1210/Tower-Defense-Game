import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A type of projectile - bomb
 * 
 * @author (Benny Wu) 
 */
public class Bomb extends Projectile
{
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Enemy target;
    int[] destination = new int[2];
    public Bomb(Enemy target, Tower tower)
    {
        this.image =  new GifImage("bomb-4.png");
        this.images = image.getImages();
        this.target = target;
        this.tower = tower;
        this.damage = tower.getDamage();
        this.splash_damage = tower.getSplashDamage();
        this.gif = true;
        speed = 4;

    }
    
    public void act() 
    {
        if(target.existing)
        {
            
            if(distanceFrom(tower.getX(), tower.getY())>tower.getRadius()
            || distanceFrom(target.getX(), target.getY()) < 8 )
            {
                if(distanceFrom(target.getX(), target.getY()) < 8)
                {
                    target.takeDamage(damage);
                }
                disappear();
                getWorld().removeObject(this);
                return;
            }
            

            destination[0] = target.getX();
            destination[1] = target.getY();
            move(target.getX()+8, target.getY());
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
    
    public void disappear()
    {
        BombExplosion explosion = new BombExplosion(getX(), getY(), splash_damage, false);
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