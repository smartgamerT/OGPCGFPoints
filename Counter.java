import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
//this is to test GitHub
/**
 * A simple counter with graphical representation as an actor on screen.
 * 
 * @author mik
 * @version 1.0
 */
public class Counter extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    public int value;
    public int target;
    private int score;

    /**
     * Create a new counter, initialised to 0.
     */
    
    public Counter()
    {
        background = getImage();  // get image from class
        value = 0;
        target = 50;
        updateImage();
    }
    
    ///**
     //* Animate the display to count up (or down) to the current target value.
     //*/
    public void act() 
    {
        //if (value < target) {
           // value++;
            updateImage();
        //}
       // else if (value > target) {
            //value--;
            //updateImage();
        //}
    }

    /**
     * Add a new score to the current counter value.
     */
    public void add(int score)
    {
        value += score;
    }

    /**
     * Return the current counter value.
     */
    public int getValue()
    {
        return value;
    }

   
    /**
     * Update the image on screen to show the current value.
     */
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text = new GreenfootImage("" + value, 22, Color.BLACK, transparent);
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
}