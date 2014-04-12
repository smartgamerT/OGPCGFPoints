import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
// class SurpriseBox;

/**
 * Write a description of class Avatar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Avatar extends Actor
{
    private GreenfootImage open = new GreenfootImage("opened-box.png");
    
    /**
     * Act - do whatever the Avatar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        findSurpriseBox();
        
        if (Greenfoot.isKeyDown("right"))
        {
            move (1);
        }

        if (Greenfoot.isKeyDown("left"))
        {
            move (-1);
        }    

        if ( Greenfoot.isKeyDown( "up" ) )
        {
            setLocation( getX(), getY()- 1);
        }

        if ( Greenfoot.isKeyDown( "down" ) )
        {
            setLocation( getX(), getY()+ 1);
        }
    }
    
     public boolean findSurpriseBox()
    {
//         setImage (open);
        removeTouching(SurpriseBox.class);
        return true;
        //Actor sb = getOneObjectAtOffset(0, 0, SurpriseBox.class);
        //if(isTouching(SurpriseBox.class)) 
//         {
//             removeObject(sb);
//             return true;
//         }
        
    }
}
