import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Avatar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Avatar extends Actor
{
    boolean touchingSpikyBall2 = false;
    boolean touchingSpikyBall3 = false;
    private Counter counter;
    private boolean haskey = false;
    private int vSpeed = 0;
    private boolean jumping = false;
    private int jumpheight = 16;
    private int fallspeed = 1;
    private int Coinscollected;
    private boolean GhostBelow = false;
    private boolean SpiderBelow = false;
    private boolean SpikyballBelow = false;
    private GreenfootImage run1r = new GreenfootImage("run1r.png");
    private GreenfootImage run2r = new GreenfootImage("run2r.png");
    private GreenfootImage run3r = new GreenfootImage("run3r.png");
    private GreenfootImage run4r = new GreenfootImage("run4r.png");
    private GreenfootImage run1l = new GreenfootImage("run1l.png");
    private GreenfootImage run2l = new GreenfootImage("run2l.png");
    private GreenfootImage run3l = new GreenfootImage("run3l.png");
    private GreenfootImage run4l = new GreenfootImage("run4l.png");
    private GreenfootImage open = new GreenfootImage("opened-box.png");
    private int frame = 1;
    private int animationCounter = 0;

    public Avatar(Counter pointCounter)
    {
        counter = pointCounter;
    }
    
 //Walking Avatar
    public void act() 
    {
       CheckKey();
       CheckFall();
       collectCoin();
       grab();
       exit();
       Collision();
    }
    public void CheckKey()
    {
               
        if(Greenfoot.isKeyDown("right"))
        {
            //direction = 1;
            moveRight();
        }
        if(Greenfoot.isKeyDown("left"))
        {
            //direction = -1;
            moveLeft();
        }
        if(Greenfoot.isKeyDown("up") && jumping == false)
        {
            jump();
        }
    }
    public void jump()
    {
        vSpeed = vSpeed - jumpheight;
        jumping = true;
        fall();   
    }
    public void moveToGround(Actor ground)
    {
        int groundHeight = ground.getImage().getHeight();
        int newY = ground.getY() - (groundHeight + getImage().getHeight())/2;
        setLocation(getX(), newY);
        jumping = false;
    }
     public boolean onGround()
    {
        int spriteHeight = getImage().getHeight();
        int yDistance = (int)(spriteHeight/2) + 5;
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight()/2, Floor.class);
        if(ground == null)
        {
            jumping = true;
            return false;
        }
        else
        {
            moveToGround(ground);
            return true;
        }
    }
    public void fall()
    {
        setLocation(getX(), getY() + vSpeed);
        if(vSpeed <=7)
        {
            vSpeed = vSpeed + fallspeed;
        }
        jumping = true;
    }
    public void CheckFall()
    {
         if(onGround() || FloorAbove())
        {
            vSpeed = 0;
        }
        else
        {
            fall();
        }
    }
    public boolean FloorAbove()
    {
        int spriteHeight = getImage().getHeight();
        int yDistance = (int)(spriteHeight/-2);
        Actor ceiling = getOneObjectAtOffset(0, yDistance, Floor.class);
        if(ceiling != null)
        {
            vSpeed = 1;
            bopHead(ceiling);
            return true;
        }
        else
        {
            return false;
        }
    }
     public void bopHead(Actor ceiling)
    {
        int ceilingHeight = ceiling.getImage().getHeight();
        int newY = ceiling.getY() + (ceilingHeight + getImage().getHeight())/2;
        setLocation(getX(), newY);
    }

    
    public void moveRight()
    {
        setLocation(getX()+ 10, getY());
        if(animationCounter % 4 == 0)
        {
            animateRight();
        }
    }

    public void animateRight()
    {
        if(frame == 1)
        {
            setImage(run1r);
        }
        else if(frame == 2)
        {
            setImage(run2r);
        }
        else if(frame == 3)
        {
            setImage(run3r);
        }
        else if(frame == 4)
        {
            setImage(run4r);
            frame = 1;
            return;
        }
        frame++;
    }

    public void moveLeft()
    {
        setLocation(getX()- 10, getY());
        if(animationCounter %4 == 0)
        {
            animateLeft();
        }
    }

    public void animateLeft()
    {
        if(frame == 1)
        {
            setImage(run1l);
        }
        else if(frame == 2)
        {
            setImage(run2l);
        }
        else if(frame == 3)
        {
            setImage(run3l);
        }
        else if(frame == 4)
        {
            setImage(run4l);
            frame = 1;
            return;
        }
        frame++;
    }
    public void collectCoin()
    {
        if(Coinscollected()) 
        {
            getCoin();
            counter.add(1);
            Greenfoot.playSound("Coin.wav");
        }
    }
    public void getCoin()
    {
        Actor Coin = getOneObjectAtOffset(0, 0, Coin.class);
        if(Coin != null) {
            // eat the coin...
            getWorld().removeObject(Coin);
            Coinscollected = Coinscollected + 1;   
        }
    }

    /**
     * Check whether there is a leaf in the same cell as we are.
     */
    public boolean Coinscollected()
    {
        Actor Coin = getOneObjectAtOffset(0, 0, Coin.class);
        if(Coin != null) {
            return true;
        }
        else {
            return false;
        }
    }
    // Taking the key
     public void grab()
    {
        if (canSee(Key.class) )
        {
            get(Key.class);
            haskey = true;
           // score = score + 10;
            //Greenfoot.playSound("keyfound.wav");
        }
    }

    public void exit() // If Player has the key, they can open the door.
    {
        if (canSee(Door.class) && haskey == true) ((background)getWorld()).nextLevel();
    }
      public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }
    public void get(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        if(actor != null) {
            getWorld().removeObject(actor);
        }
    }   

    //Shefali 
   
    public void Collision()
    {
        Actor collision1 = getOneIntersectingObject(Spikyball2.class); 
        Actor collision2 = getOneIntersectingObject(Spikyball3.class);
        Actor collision3 = getOneIntersectingObject(Ghost.class);
    
        if(collision1 != null)//if you have not run into it 
        {
            if(SpikyballBelow == false)
            {
                counter.add(-1);
                Greenfoot.playSound("explosion.wav");
                SpikyballBelow = true;
            }
        }
        else
        {
            SpikyballBelow = false;
        }
    
        if(collision2 != null)//if you have not run into it 
        {
            if(SpiderBelow == false)
            {
                counter.add(-1);
                Greenfoot.playSound("explosion.wav");
               SpiderBelow = true;
            }
        }
        else
        {
            SpiderBelow = false;
        }
        if(collision3 != null)//if you have not run into it 
        {
           if(GhostBelow == false)
           {
               counter.add(-1);
               Greenfoot.playSound("Ghosthit.wav");
               GhostBelow = true;
           }
        }
        else
        {
            GhostBelow = false;
        }
    
    }  

}

