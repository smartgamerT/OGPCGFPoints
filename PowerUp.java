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
<<<<<<< HEAD
    PointsBar pointsBar;
    PointsBar timeRem;
    int delta = 0;
    int timer;
=======
    HealthBar timeRem;
>>>>>>> 010433972edb5def32064cfe6c53035fea3f6f0a
    private GreenfootSound soundapp = new GreenfootSound("applause.wav");
    //     private Timer timer;

    public PowerUp(HealthBar tr)
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
<<<<<<< HEAD
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
=======
            int delta = getFun();
            timeRem.addTime(delta);
            setLocation(Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(600));
        }

>>>>>>> 010433972edb5def32064cfe6c53035fea3f6f0a
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
<<<<<<< HEAD
        //         Actor Avatar = getOneObjectAtOffset(0, 0, Avatar.class);
=======
     //  Actor Avatar = getOneObjectAtOffset(0, 0, Avatar.class);
>>>>>>> 010433972edb5def32064cfe6c53035fea3f6f0a
        if(isTouching(Avatar.class)) 
        {
            soundapp.play ();
            timeRem.addTime(10);
            return true;
        }
        else 
        {
            return false;
        }
    }

}