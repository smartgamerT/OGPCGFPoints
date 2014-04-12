import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.*;

/**
 * Write a description of class SurpriseBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SurpriseBox extends Actor
{
    PointsBar pointsBar;
    private GreenfootSound soundapp = new GreenfootSound("applause.wav");
    private GreenfootSound soundno = new GreenfootSound("beep1.wav");
    private GreenfootImage open = new GreenfootImage("opened-box.png");
    private GreenfootImage close = new GreenfootImage("closedbox.png");
    private GreenfootImage plus10 = new GreenfootImage("10plus.png");
    int timer;
    int counter;

    public SurpriseBox(PointsBar pb)
    {
        pointsBar = pb;
        setImage(close);
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
            counter++;
            setImage(open);
            //             setImage();
            int delta = getFun();
            pointsBar.updateScore(delta);
            //             setLocation(Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(600));
        }

        if (timer > 0)
            timer++;

        if (counter > 0)
            counter++;    

        if (timer == 50)
        {
            setImage(close);
            //             setLocation(Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(600));
            timer = 0;
        }

    }

    public int getFun()
    {
        int d = Greenfoot.getRandomNumber(2);
        if (d != 0)
        {
            soundno.play ();
            return d = -10;
        }
        else 
        { 
            soundapp.play ();
            setImage(plus10);

            //             if (counter == 50)
            //             {
            //               
            //             removeObject((Actor)this);
            //             }
            return d = 10;
        }

    }

    public boolean foundAvatar()
    {
        Actor Avatar = getOneObjectAtOffset(0, 0, Avatar.class);
      
//         if(isTouching(Avatar.class))
        if (Avatar!= null) 
         {
//             world.removeObject(SurpriseBox);
            setImage(open);
            return true;
        }
        else 
        {
            return false;
        }
     }
}
