import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.*;

/**
 * Write a description of class SurpriseBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerUp extends Actor
{
    PointsBar pointsBar;
    PointsBar timeRem;
    int delta = 0;
    int timer;
    private GreenfootSound soundapp = new GreenfootSound("applause.wav");
    //     private Timer timer;

    public PowerUp(PointsBar tr)
    {
        timeRem = tr;
    }

    /**
     * Act - do whatever the SurpriseBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(foundAvatar())
        {
            timer++;
            delta = getFun();
            timeRem.updateTimeRem(delta);
            setLocation(Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(600));
        }

        if (timer > 0)
            timer++;

        if (timer == 160)
        {
            pointsBar.updateTimeRem(delta);
            getWorld().removeObject(this);
            timer = 0;
            delta = 0;

        }         
    }
   

    public int getFun()
    {
        int d = Greenfoot.getRandomNumber(2);
        if (d != 0)
        {
            return d = -10;
        }
        else 
        { 
            return d = 10;
        }

    }

    public boolean foundAvatar()
    {
        //         Actor Avatar = getOneObjectAtOffset(0, 0, Avatar.class);
        if(isTouching(Avatar.class)) 
        {
            soundapp.play ();
            return true;
        }
        else 
        {
            return false;
        }
    }

}