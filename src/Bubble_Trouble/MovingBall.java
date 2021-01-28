package Bubble_Trouble;

import java.awt.*;

public class MovingBall
{ private int x_pos;  // ball's center x-position
    private int y_pos;  // ball's center y-position
    private int radius; // ball's radius
     private int diferenca;
    private int x_velocity = +2; // horizonal speed; positive is to the right
    private int y_velocity = +5; // vertical speed; positive is downwards

    private Box container;  // the container in which the ball travels
    private Color balls_color;
    private Pengesa p;

    /** Constructor MovingBall constructs the ball.
     * @param x_initial - the center of the ball's starting horizontal position
     * @param y_initial - the center of the ball's starting vertical position
     * @param r - the ball's radius.
     * @param box - the container in which the ball travels */
    public MovingBall(int x_initial, int y_initial, int r,Color c, Box box,Pengesa pengesa)
    { x_pos = x_initial;
        y_pos = y_initial;
        radius = r;
        p=pengesa;
        diferenca=(int)(r*(1-Math.sin(Math.atan((y_velocity*1.0)/x_velocity))));
        container = box;
        balls_color=c;
    }

    public int getDiferenca()
    {
        return diferenca;
    }
    public Color getBalls_color()
    {
        return balls_color;
    }

    /** xPosition returns the ball's current horizontal position */
    public int xPosition()
    { return x_pos; }

    /** yPosition returns the ball's current vertical position */
    public int yPosition()
    { return y_pos; }

    /** radiusOf returns the ball's radius */
    public int radiusOf()
    { return radius; }
    public void setRadius(int i)
    {
        radius=radius-i;
    }

    /** move moves the ball
     * @param time_units - the amount of time since the ball last moved */
    public void move(double time_units)
    { x_pos = x_pos +(int) (x_velocity * time_units);
        if ( container.inHorizontalContact(x_pos,radiusOf()) )
        { x_velocity = -x_velocity; }   // reverse horizontal direction
        y_pos = y_pos + (int) (y_velocity * time_units);
        if ( container.inVerticalContact(y_pos,radiusOf()) )
        { y_velocity = -y_velocity; }   // reverse vertical direction
        if (p.kontrollox(x_pos,y_pos,radius))
        {
            x_velocity=-x_velocity;
        }
        if (p.kontrolloy(x_pos,y_pos,radius))
        {
            y_velocity=-y_velocity;
        }
    }
    public void paint(Graphics g)
    {   Graphics2D g2=(Graphics2D)g;
        g2.setColor(balls_color);
        int radius = radiusOf();
        g2.fillOval(xPosition() - radius, yPosition() - radius, radius * 2, radius * 2);
        g2.setPaint(new Color(255,255,255));
        g2.fillOval(xPosition() - radius/2, yPosition() - radius/2, radius/3, radius/3);
        g2.fillOval(xPosition() +radius/4, yPosition() +radius/4, radius/4, radius/4);


    }
}
