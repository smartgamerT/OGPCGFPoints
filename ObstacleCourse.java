import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ObstacleCourse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ObstacleCourse extends World
{

    /**
     * Constructor for objects of class ObstacleCourse.
     * 
     */
    public ObstacleCourse()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        PointsBar pointsbar = new PointsBar();
        addObject(pointsbar, 33, 29);
        pointsbar.setLocation(112, 18);

        Avatar avatar = new Avatar();
        addObject(avatar, 89, 543);
        
        SurpriseBox surpriseBox = new SurpriseBox(pointsbar);
        addObject (surpriseBox, 400, 543);
        
        PowerUp powerUp = new PowerUp(pointsbar);
        addObject(powerUp, 300, 323);
        
    }
    
    public void act()
    {
        
    }
}
